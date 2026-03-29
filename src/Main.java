/*public class Main {
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
}*/



/*public class Main {
    public static int sumArray(int[] arr, int n) {
        if (n == 0) {
            return 0;
        }
        return arr[n - 1] + sumArray(arr, n - 1);
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 1, 5};
        int result = sumArray(arr, arr.length);
        System.out.println("Sum of first " + arr.length + " elements = " + result);
    }
}*/



/*public class Main {
    public static long sumPowers(int b, int n) {
        if (n == 0) {
            return 1;
        }
        return (long) Math.pow(b, n) + sumPowers(b, n - 1);
    }

    public static void main(String[] args) {
        int b = 4;
        int n = 3;
        long result = sumPowers(b, n);
        System.out.println("Sum of first " + n + " powers of " + b + " = " + result);
    }
}*/


/*import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void reverseRead(int n) {
        if (n == 0) {
            return;
        }
        int value = sc.nextInt();
        reverseRead(n - 1);
        System.out.print(value + " ");
    }

    public static void main(String[] args) {
        int n = sc.nextInt();
        reverseRead(n);
    }
}*/