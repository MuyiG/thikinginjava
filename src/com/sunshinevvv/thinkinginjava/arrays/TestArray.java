package com.sunshinevvv.thinkinginjava.arrays;

import java.util.Arrays;

public class TestArray {
    public static void main(String[] args) {
        double[] arr = {30.14, 29.58, 26.36, 32.56, 32.82};
        System.out.println(Arrays.toString(getDiff(arr)));

        int[][] arrs = {{3, 1, 3}, {6, 4, 6}, {9, 7}};
        int[][] newArr = buildNewArr(arrs);
        for (int[] temp : newArr) {
            System.out.println(Arrays.toString(temp));
        }
    }

    private static double[] getDiff(double[] arr) {
        double[] diffs = new double[arr.length - 1];
        for (int i = 0; i < arr.length - 1; i++) {
            diffs[i] = arr[i + 1] - arr[i];
        }
        return diffs;
    }

    private static int[][] buildNewArr(int[][] arr) {
        int maxLength = 0;
        for (int[] temp : arr) {
            if (temp.length > maxLength) {
                maxLength = temp.length;
            }
        }
        int[][] newArr = new int[maxLength][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                newArr[j][i] = arr[i][j];
            }
        }
        return newArr;
    }
}
