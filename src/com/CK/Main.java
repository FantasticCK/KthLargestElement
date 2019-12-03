package com.CK;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;

        Solution solution = new Solution();
        System.out.println(solution.findKthLargest(nums, k));
    }
}

class Solution3 {
    public int findKthLargest(int[] nums, int k) {
        int N = nums.length;
        Arrays.sort(nums);
        return nums[N - k];
    }
}

class Solution2 {
    public int findKthLargest(int[] nums, int k) {

        final PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int val : nums) {
            pq.offer(val);

            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}


class Solution {
    public int findKthLargest(int[] nums, int k) {
        int start = 0, end = nums.length - 1, index = nums.length - k;
        while (start < end) {
            int pivot = partion(nums, start, end);
            if (pivot < index)
                start = pivot + 1;
            else if (pivot > index)
                end = pivot - 1;
            else
                return nums[pivot];
        }
        return nums[start];
    }

    private int partion(int[] nums, int start, int end) {
        int pivot = start;
        while (start <= end) {
            while (start <= end && nums[start] <= nums[pivot])
                start++;
            while (start <= end && nums[end] > nums[pivot])
                end--;
            if (start > end)
                break;

            swap(nums, start, end);
        }
        swap(nums, pivot, end);
        return end;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

class Solution {
    public int findKthLargest(int[] nums, int k) {
        int st = 0, ed = nums.length - 1, toFind = nums.length - k;
        int index = partition(nums, st, ed);
        while (index != toFind) {
            if (index < toFind) {
                index = partition(nums, index + 1, ed);
            } else {
                index = partition(nums, st, index - 1);
            }
        }
        return nums[index];
    }

    private int partition(int[] nums, int st, int ed) {
        int pivot = nums[ed], l = st;
        for (int i = st; i < ed; i++) {
            if (nums[i] <= pivot) {
                swap(nums, i, l++);
            }
        }
        swap(nums, l, ed);
        return l;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
