package TextToClass;

import javax.tools.*;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.net.URI;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import static java.util.Objects.requireNonNull;

public class JavaSourceCodeToClass {
    public static void main(String[] args) throws Exception {
        new JavaSourceCodeToClass().whenStringIsCompiled_ThenCodeShouldExecute("com.baeldung.inmemorycompilation.TestClass");
    }

    public void whenStringIsCompiled_ThenCodeShouldExecute(String qualifiedClassName) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<>();
        InMemoryFileManager manager = new InMemoryFileManager(compiler.getStandardFileManager(null, null, null));

        List<JavaFileObject> sourceFiles = Collections.singletonList(new JavaSourceFromString(qualifiedClassName, sourceCode));

        JavaCompiler.CompilationTask task = compiler.getTask(null, manager, diagnostics, null, null, sourceFiles);

        boolean result = task.call();

        if (result) {
            diagnostics.getDiagnostics()
                    .forEach(d -> System.err.println(d));
        } else {
            ClassLoader classLoader = manager.getClassLoader(null);
            Class<?> clazz = classLoader.loadClass(qualifiedClassName);
            InMemoryClass instanceOfClass = (InMemoryClass) clazz.newInstance();

            instanceOfClass.runCode();

        }
    }

    static String sourceCode =
            "package com.baeldung.inmemorycompilation;\n"
                    + "public class TestClass implements TextToClass.InMemoryClass {\n"
                    + "@Override\n"
                    + "    public void runCode() {\n"
                    + "        System.out.println(\"henry code is running...\");\n"
                    + "    }\n"
                    + "}\n";
}

