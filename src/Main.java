public class Main {
    public static int Sum12(int n) {
        if (n==1) {
            return 1;
        }
        return n*n+Sum12(n-1);
    }
    public static void main(String[] args) {
        int n = 4;
        int result = Sum12(n);
        System.out.println("Sum of squares of first " + n + " numbers = " + result);
    }
}