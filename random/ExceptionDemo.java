public class ExceptionDemo {
    public static void main(String[] args) {
    try {
    int[] numbers = {1, 2, 3};
    System.out.println(numbers[2]); // Accessing an invalid index
    int result = 10 / 0; // Division by zero
    } catch (ArithmeticException e) {
    System.out.println("Arithmetic Exception: " +
    e.getMessage());
    } catch (ArrayIndexOutOfBoundsException e) {
    System.out.println("Array Index Out of Bounds: " +
    e.getMessage());
    } finally {
    System.out.println("Execution completed.");
    }
    }
    }