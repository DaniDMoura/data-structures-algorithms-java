package dev.algorithms;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args){
        int[] array = {1,4,8,7,2,3,1,2,3,9};

        bubbleSort(array);

        System.out.println(Arrays.toString(array));
    }

    private static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array.length - 1; j++){
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    }
}
