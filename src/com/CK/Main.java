package com.CK;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;

        Solution solution = new Solution();
        System.out.println(solution.findKthLargest(nums, k));
    }
}

class Solution {
    public int findKthLargest(int[] nums, int k) {
        int N = nums.length;
        Arrays.sort(nums);
        return nums[N - k];
    }
}