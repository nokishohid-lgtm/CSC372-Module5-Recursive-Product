import java.util.Scanner;

/**
 * CSC372 Module 7 Portfolio Milestone
 * Improved version of the Module 5 Recursive Product Calculator.
 * Original approach: multiply one array element per recursive call.
 * Improved approach: divide the array range into two halves recursively.
 */
public class RecursiveProduct {
    private static final int NUMBER_COUNT = 5;

    public static void main(String[] args) {
        System.out.println("Recursive Product Calculator - Module 7 Improvement");
        System.out.println("---------------------------------------------------");

        try (Scanner scanner = new Scanner(System.in)) {
            // MODULE 7 IMPROVEMENT: input and output are handled by separate methods.
            int[] numbers = readNumbers(scanner);
            long product = calculateProduct(numbers, 0, numbers.length - 1);
            displayResult(product);
        }
    }

    // MODULE 7 IMPROVEMENT START: separated and validated input handling.
    private static int[] readNumbers(Scanner scanner) {
        int[] numbers = new int[NUMBER_COUNT];

        for (int i = 0; i < numbers.length; i++) {
            while (true) {
                System.out.print("Enter number " + (i + 1) + ": ");
                if (scanner.hasNextInt()) {
                    numbers[i] = scanner.nextInt();
                    break;
                }

                String invalidValue = scanner.next();
                System.out.println("Invalid input: " + invalidValue
                        + ". Please enter a whole number.");
            }
        }
        return numbers;
    }
    // MODULE 7 IMPROVEMENT END

    // MODULE 7 IMPROVEMENT START: divide-and-conquer recursion replaces
    // the original one-element-at-a-time recursive calculation.
    public static long calculateProduct(int[] numbers, int start, int end) {
        // Base case: a range containing exactly one number.
        if (start == end) {
            return numbers[start];
        }

        // Recursive case: calculate products for the left and right halves.
        int middle = start + (end - start) / 2;
        long leftProduct = calculateProduct(numbers, start, middle);
        long rightProduct = calculateProduct(numbers, middle + 1, end);
        return leftProduct * rightProduct;
    }
    // MODULE 7 IMPROVEMENT END

    // MODULE 7 IMPROVEMENT: output is handled separately from recursion.
    private static void displayResult(long product) {
        System.out.println();
        System.out.println("The product of the five numbers is: " + product);
    }
}
