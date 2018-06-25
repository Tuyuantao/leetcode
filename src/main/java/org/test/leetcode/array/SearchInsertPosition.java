package org.test.leetcode.array;

/**
 * Created by tuyuantao on 2018/6/24.
 */
public class SearchInsertPosition {

    /**
     * 时间复杂度是 O(n),因为是有序的，所以可以从中开始判断
     * @param nums
     * @param target
     * @return
     */
    public static Integer searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if(nums[0] >= target) {
            return 0;
        }

        if(nums[nums.length-1]< target) {
            return nums.length;
        }

        if(nums[nums.length-1]== target) {
            return nums.length -1;
        }

        int low = 0, high = nums.length-1;
        while (low<=high) {
            int mid = (low+high)/2;

            if(nums[mid]==target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1,3,5,6,7}, 3));
    }
}
