package ru.sber.base.syntax;

public class Task2 {
    public static void quickSort(int[] arr, int left, int right) {
        int middle = left + (right - left) / 2;
        int midElem = arr[middle];

        int i = left, j = right;
        while (i <= j) {
            while (arr[i] < midElem) {
                i++;
            }
            while (arr[j] > midElem) {
                j--;
            }
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        if (left < j)
            quickSort(arr, left, j);
        if (right > i)
            quickSort(arr, i, right);
    }
    public static void main(String[] args) {
        int[] arr = { 2, -5, 5, 7, -3, 10, 0, 11, 1 };
        System.out.print("Исходный массив: ");

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        int leftElem = 0;
        int rightElem = arr.length - 1;

        quickSort(arr, leftElem, rightElem);

        System.out.print("\nОтсортированный массив: ");

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}


