import java.util.Scanner;

public class Ads {

    public static void bubbleSortAscending(String[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    String temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void bubbleSortAscendingInt(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static boolean checkAnagram(String first, String second) {
        if (first.length() != second.length()) return false;
        String[] arr1 = first.split("");
        String[] arr2 = second.split("");
        bubbleSortAscending(arr1);
        bubbleSortAscending(arr2);
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) return false;
        }
        return true;
    }

    public static int findKthSmallest(int[] arr, int k) {
        bubbleSortAscendingInt(arr);
        return arr[k - 1];
    }

    public static int findMedian(int[] arr) {
        bubbleSortAscendingInt(arr);
        int mid = arr.length / 2;
        if (arr.length % 2 == 0) {
            return (arr[mid - 1] + arr[mid]) / 2;
        } else {
            return arr[mid];
        }
    }

    public static int minimumCapacity(int[] weights, int days) {
        int left = 0, right = 0;
        for (int w : weights) {
            left = Math.max(left, w);
            right += w;
        }
        while (left < right) {
            int mid = (left + right) / 2;
            int neededDays = 1, current = 0;
            for (int w : weights) {
                if (current + w > mid) {
                    neededDays++;
                    current = 0;
                }
                current += w;
            }
            if (neededDays > days) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String first = scan.nextLine();
        String second = scan.nextLine();
        System.out.println(checkAnagram(first, second) ? "YES" : "NO");

        int n = scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = scan.nextInt();
        int k = scan.nextInt();
        System.out.println(findKthSmallest(arr, k));

        int m = scan.nextInt();
        int[] arrMedian = new int[m];
        for (int i = 0; i < m; i++) arrMedian[i] = scan.nextInt();
        System.out.println(findMedian(arrMedian));

        int size = scan.nextInt();
        int[] weights = new int[size];
        for (int i = 0; i < size; i++) weights[i] = scan.nextInt();
        int days = scan.nextInt();
        System.out.println(minimumCapacity(weights, days));
    }
}

