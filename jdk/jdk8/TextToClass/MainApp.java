package TextToClass;

import javax.tools.*;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

import static java.util.Objects.requireNonNull;

/**
 *
 * <a href="https://www.baeldung.com/java-string-compile-execute-code">Visit baeldung:java-string-compile-execute-code</a>
 */
public class MainApp {
    public static void main(String[] args) throws Exception {
        new MainApp().whenStringIsCompiled_ThenCodeShouldExecute("com.baeldung.inmemorycompilation.TestClass");
    }

    public void whenStringIsCompiled_ThenCodeShouldExecute(String qualifiedClassName) throws Exception {

        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<>();
        InMemoryFileManager manager = new InMemoryFileManager(compiler.getStandardFileManager(null, null, null));

        List<JavaFileObject> sourceFiles = Collections.singletonList(new JavaSourceFromString(qualifiedClassName, sourceCode));

        JavaCompiler.CompilationTask task = compiler.getTask(null, manager, diagnostics, null, null, sourceFiles);

        boolean result = task.call();

        if (result) {
            ClassLoader classLoader = manager.getClassLoader(null);
            Class<?> clazz = classLoader.loadClass(qualifiedClassName);
            Object instanceOfClass = clazz.newInstance();
            //这里用反射调用
            //可以注册一个接口,实现接口text类可以通过接口直接调用;
            Method method = clazz.getMethod("calculate",int.class,int.class);
            method.invoke(instanceOfClass,22,33);
            Method runcode = clazz.getMethod("runCode");
            runcode.invoke(instanceOfClass);
        } else {
            diagnostics.getDiagnostics()
                    .forEach(d -> System.err.println(d));
        }
    }

    static String sourceCode =
            "package com.baeldung.inmemorycompilation;\n"
                    + "public class TestClass{\n"
                    + "//@Override\n"
                    + "    public void runCode() {\n"
                    + "        System.out.println(\"henry code is running...\");\n"
                    + "    }\n"
                    + "    public int calculate(int a, int b) {\n"
                    + "        System.out.println(\"adding result=\"+(a+b));\n"
                    + "        return a+b;\n"
                    + "    }\n"
                    + "}\n";
}

