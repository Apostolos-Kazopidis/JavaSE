package com.kazopidis.app;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void swap(Data<Integer>[] array, int i, int j) {
        Data<Integer> temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }

    public static void swap(int[] array, int i, int j) throws IllegalArgumentException{
        if (i>=array.length || i<0 || j>=array.length || j<0)
            throw new IllegalArgumentException();

        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }

    public static void selectionSort(int[] array) {
        for (int i=0; i<array.length-1; i++) {
            int min = Integer.MAX_VALUE;
            int pos = i;
            for (int j=i; j<array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    pos = j;
                }
            }
            swap(array, i, pos);
        }
    }

    public static boolean checkSorted(int[] array) {
        for (int i=0; i<array.length-2; i++)
            if (array[i] > array[i+1])
                return false;
            return true;
    }

    public static void main(String[] args) {
        int[] array = new int[10];
        Random r = new Random();
        Arrays.setAll(array, n->r.nextInt(100));
        System.out.println("Initial: " + Arrays.toString(array));
        selectionSort(array);
        System.out.println("Final: " + Arrays.toString(array));
    }
}

