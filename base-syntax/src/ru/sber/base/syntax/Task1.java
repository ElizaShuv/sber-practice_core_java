package ru.sber.base.syntax;

import java.util.ArrayList;

public class Task1 {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 2, 9, 6, 3, 1, 8, 0, 7, 4};
        int temp;
        ArrayList arraylist = new ArrayList();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i]+ " ");
            }
        }
    }

