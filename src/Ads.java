/*import java.util.*;

public class Ads {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int d = sc.nextInt();
            ArrayList<Integer> row = new ArrayList<>();

            for (int j = 0; j < d; j++) {
                row.add(sc.nextInt());
            }

            list.add(row);
        }

        int q = sc.nextInt();

        for (int i = 0; i < q; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            if (x - 1 < list.size() && y - 1 < list.get(x - 1).size()) {
                System.out.println(list.get(x - 1).get(y - 1));
            } else {
                System.out.println("ERROR!");
            }
        }
    }
}8*/

/*import java.util.*;

public class Ads {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int d = sc.nextInt();
            ArrayList<Integer> row = new ArrayList<>();

            for (int j = 0; j < d; j++) {
                row.add(sc.nextInt());
            }

            list.add(row);
        }

        int q = sc.nextInt();

        for (int i = 0; i < q; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            if (x - 1 < list.size() && y - 1 < list.get(x - 1).size()) {
                System.out.println(list.get(x - 1).get(y - 1));
            } else {
                System.out.println("ERROR!");
            }
        }
    }
}*/

/*import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Ads {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Deque<Integer> shelf = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            int op = sc.nextInt();
            if (op == 1) {
                int disk = sc.nextInt();
                shelf.addFirst(disk);
            } else if (op == 2) {
                int disk = sc.nextInt();
                shelf.addLast(disk);
            } else if (op == 3) {
                System.out.println(shelf.removeFirst());
            } else if (op == 4) {
                System.out.println(shelf.removeLast());
            }
        }
    }
}*/

/*import java.util.Stack;

public class Ads {
    public static void insertAtBottom(Stack<Integer> stack, int item) {
        if (stack.isEmpty()) {
            stack.push(item);
            return;
        }
        int top = stack.pop();
        insertAtBottom(stack, item);
        stack.push(top);
    }

    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int top = stack.pop();
        reverse(stack);
        insertAtBottom(stack, top);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(9);
        stack.push(1);
        stack.push(3);
        stack.push(5);
        stack.push(7);

        reverse(stack);

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}*/

/*import java.util.LinkedList;
import java.util.Queue;

public class Ads {
    public static int countUnableToEat(int[] students, int[] samsas) {
        Queue<Integer> queue = new LinkedList<>();
        for (int s : students) {
            queue.add(s);
        }
        int index = 0;
        int rotations = 0;
        while (!queue.isEmpty() && rotations < queue.size()) {
            if (queue.peek() == samsas[index]) {
                queue.poll();
                index++;
                rotations = 0;
            } else {
                queue.add(queue.poll());
                rotations++;
            }
        }
        return queue.size();
    }

    public static void main(String[] args) {
        int[] students1 = {1,1,0,0};
        int[] samsas1 = {0,1,0,1};
        System.out.println(countUnableToEat(students1, samsas1));

        int[] students2 = {1,1,1,0,0,1};
        int[] samsas2 = {1,0,0,0,1,1};
        System.out.println(countUnableToEat(students2, samsas2));
    }
}*/

/*import java.util.Scanner;

public class Ads {
    public static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(arr, n, largest);
        }
    }

    public static void buildHeap(int[] arr, int n) {
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        buildHeap(arr, n);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}*/



