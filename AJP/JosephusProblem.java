public class JosephusProblem {

    public static int findSafePosition(int n) {
        int largestPowerOf2 = 1;
        while (largestPowerOf2 * 2 <= n) {
            largestPowerOf2 *= 2;
        }

        int l = n - largestPowerOf2; 
        int safePosition = 2 * l + 1;

        return safePosition;
    }

    public static void main(String[] args) {
        int n = 10;
        int safePosition = findSafePosition(n);
        System.out.println("The safe position for " + n + " soldiers is: " + safePosition);
    }
}