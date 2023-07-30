import java.util.Random;

public class HomeWork002 {
    public static void main(String[] args) {
        int[] array = new int[10];
        fillArray(array);
        printArray(array);
        sort(array);
        System.out.println("Сортированный массив:");
        printArray(array);

    }

    public static void fillArray(int array[]) {
        Random random = new Random();
        int n = array.length;
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(10);
        }
    }

    public static void printArray(int array[]) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void sort(int array[]) {
        int n = array.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }
        for (int i = n - 1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapify(array, i, 0);
        }

    }

    public static void heapify(int array[], int n, int i) {
        int max = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && array[left] > array[max]) max = left;
        if (right < n && array[right] > array[max]) max = right;
        if (max != i) {
            int temp = array[i];
            array[i] = array[max];
            array[max] = temp;
            heapify(array, n, max);
        }
    }
}
