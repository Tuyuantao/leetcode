package org.test.leetcode.dynamicprogramming;

/**
 * Created by tuyuantao on 2018/6/24.
 */
public class HouseRobber {

    /**
     * 偷一排房子，其中房子不是环形的
     * @param num
     * @param startIndex
     * @param endIndex
     * @return
     */
    public static int rob(int[] num, int startIndex, int endIndex) {
        int prevNo = 0;
        int prevYes = 0;
        for (int i = startIndex; i <= endIndex; i++) {
            int temp = prevNo;
            prevNo = Math.max(prevNo, prevYes);
            prevYes = num[i] + temp;
        }
        return Math.max(prevNo, prevYes);
    }

    public static int rob(int[] num) {
        return rob(num, 0, num.length - 1);
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{2, 1, 1, 2}));
    }
}
