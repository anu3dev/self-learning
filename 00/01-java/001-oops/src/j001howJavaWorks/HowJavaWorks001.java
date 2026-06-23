package j001howJavaWorks;

/**
 * How Java Executes Code (High Level)
 * 1. You write Java code (.java file) in English-like syntax.
 * 2. The Java Compiler (javac) converts it into Bytecode (.class file).
 * 3. Bytecode is platform-independent ("Write Once, Run Anywhere").
 * 4. The JVM (Java Virtual Machine) loads the bytecode into memory.
 * 5. The Class Loader loads required classes.
 * 6. JVM verifies the bytecode for security and correctness.
 * 7. The Execution Engine converts bytecode into machine code (using Interpreter + JIT Compiler).
 * 8. Objects are created in Heap Memory, while references and method calls use Stack Memory.
 * 9. CPU executes the machine code instructions.
 * 10. Garbage Collector (GC) automatically removes unused objects from memory.
 * 
 * 
 * 
 * Java Code -> Compiler (javac) -> Bytecode (.class) -> JVM -> Class Loader -> Execution Engine (JIT) -> Machine Code -> CPU Executes -> Garbage Collector cleans memory
 */

public class HowJavaWorks001 {
	public static void main(String[] args) {
		
	}
}
