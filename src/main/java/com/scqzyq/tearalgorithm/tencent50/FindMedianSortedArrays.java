package com.scqzyq.tearalgorithm.tencent50;

public class FindMedianSortedArrays {

    public static void main(String[] args) {
        double medianSortedArrays = findMedianSortedArrays(new int[]{1, 2}, new int[]{-1, 3});
        System.out.println(medianSortedArrays);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] tmp;
        if (nums1.length == 0 || nums2.length == 0) {
            tmp = simpleSum(nums1, nums2);
        } else if (nums1[nums1.length - 1] < nums2[0]) {
            tmp = simpleSum(nums1, nums2);
        } else if (nums2[nums2.length - 1] < nums1[0]) {
            tmp = simpleSum(nums2, nums1);
        } else {
            tmp = simpleSum(nums1, nums2);
            for (int i = nums1.length; i < tmp.length; i++) {
                int j = i - 1;
                int value = tmp[i];
                for (; j >= 0; j--) {
                    if (value < tmp[j]) {
                        tmp[j + 1] = tmp[j];
                    } else {
                        break;
                    }
                }
                tmp[j + 1] = value;
            }
        }
        if (tmp.length % 2 == 1) {
            return tmp[tmp.length / 2];
        } else {
            return (tmp[tmp.length / 2] + tmp[tmp.length / 2 - 1]) / 2.0;
        }
    }

    private static int[] simpleSum(int[] nums1, int[] nums2) {
        int[] tmp = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, tmp, 0, nums1.length);
        System.arraycopy(nums2, 0, tmp, nums1.length, nums2.length);
        return tmp;
    }
}
