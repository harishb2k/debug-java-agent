package org.example;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;

/**
 * Hello world!
 */
public class App implements ClassFileTransformer {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public static void premain(String agentArgs, Instrumentation inst) {
        System.out.println("[Agent] In premain method");
        String className = "com.baeldung.instrumentation.application.MyAtm";
        inst.addTransformer(new App(),true);
    }

    public static void agentmain(String agentArgs, Instrumentation inst) {
        System.out.println("[Agent] In agentmain method");
        String className = "com.baeldung.instrumentation.application.MyAtm";
    }

    public byte[] transform(ClassLoader loader,
                            String className,
                            Class<?> classBeingRedefined,
                            ProtectionDomain protectionDomain,
                            byte[] classfileBuffer)
            throws IllegalClassFormatException {
        System.out.println("Got class -> " + className);
        return classfileBuffer;
    }
}
