package basicsInJava;
import java.util.Scanner;

public class ScannerUtilsExample {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("enter your age");
            int age = scan.nextInt();
            System.out.println("entered values: " + age);
        }
    }
}