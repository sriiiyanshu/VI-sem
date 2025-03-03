
public class CustomExceptionExample {
    static void validate(int age) throws CustomException {
        if (age < 18) {
            throw new CustomException("Age must be 18 or above.");
        } else {
            System.out.println("Valid age.");
        }
    }

    public static void main(String[] args) {
        try {
            validate(16);
        } catch (CustomException e) {
            System.out.println("Caught: " + e.getMessage());
        }
    }
}
