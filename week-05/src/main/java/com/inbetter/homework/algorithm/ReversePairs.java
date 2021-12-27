package com.inbetter.homework.algorithm;

public class ReversePairs {

    int ans;

    public int reversePairs(int[] nums) {
        ans = 0;
        mergeSort(nums, 0, nums.length - 1);
        return ans;
    }

    private void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (right + left) >> 1;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        calculate(arr, left, mid, right);
        merge(arr, left, mid, right);
    }

    private void calculate(int[] arr, int left, int mid, int right) {
        int j = mid;
        for (int i = left; i <= mid; i++) {
            while (j < right && arr[i] > 2L * arr[j + 1]) {
                j++;
            }
            ans += j - mid;
        }
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1;
        for (int k = 0; k < temp.length; k++) {
            if (j > right || (i <= mid) && arr[i] <= arr[j]) {
                temp[k] = arr[i++];
            } else {
                temp[k] = arr[j++];
            }
        }

        for (int k = 0; k < temp.length; k++) {
            arr[k + left] = temp[k];
        }
    }

    public static void main(String[] args) {
        int[] ints = {1, 3, 2, 3, 1};
        new ReversePairs().reversePairs(ints);
    }

}
