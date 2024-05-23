


public class MaximumSubarrayProblem {

    public static void main(String[] args) {
        // leetcode test cases
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println((maxSubArray(nums)));

        int[] nums2 = new int[]{1};
        System.out.println((maxSubArray(nums2)));

        int[] nums3 = new int[]{5,4,-1,7,8};
        System.out.println((maxSubArray(nums3)));
        

    }

    public static int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            maxSum = Math.max(maxSum, currSum);

            if (currSum < 0) {
                currSum = 0;
            }
        }

        return maxSum;
    }
}
