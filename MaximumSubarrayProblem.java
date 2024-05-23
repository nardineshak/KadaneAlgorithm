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

    // Solution 1
    public static int maxSubArray(int[] nums) {
        int localMax = 0;
        int globalMax = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            // the local max will be nums[i] or nums[i] + localMax 
            // (since we already know the max of the previous subarray)
            // no need to recompute it 
            localMax = Math.max(nums[i], localMax + nums[i]);
            globalMax = Math.max(globalMax, localMax); // keeps track of the max of the whole array 
        }

        return globalMax;
    }

    // Solution 2
    public static int maxSubArray2(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            maxSum = Math.max(maxSum, currSum); // same idea as global_max in solution1
            
            // if the sum becomes negative means the 
            // previous subarrays don't result in max so set currSum to 0 to restart in essence 
            if (currSum < 0) {
                currSum = 0;
            }
        }

        return maxSum;
    }
}
