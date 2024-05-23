
/**
 *
 * @author nardineshak
 */
public class MaximumProductSubarrayProblem {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        // leetcode test cases
        int[] nums = new int[]{2,3,-2,4};
        System.out.println((maxProduct(nums)));

        int[] nums2 = new int[]{-2, 0, -1};
        System.out.println((maxProduct(nums2)));
        
    }

    public static int maxProduct(int[] nums) {
        int localMax = nums[0];
        int localMin = nums[0];
        int globalMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int n = nums[i];
            // we are taking the max of the current num, n * localMax,
            // or n * localMin incase both are negative which can be big positive number
            localMax = Math.max(n, Math.max(n * localMax, n * localMin));
            // we're keeping track of localMin since we have negative numbers
            localMin = Math.min(n, Math.min(n * localMax, n * localMin));
            // global max stores the max throughout the whole array
            globalMax = Math.max(globalMax, localMax);
        }

        return globalMax;
    }

    
}
