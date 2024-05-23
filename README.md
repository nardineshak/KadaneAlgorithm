# Kadane Algorithm
Leetcode Problems using Kadane's Algorithm

### Kadane’s Algorithm (Maximum Subarray Problem & Maximum Product Subarray Problem)

**What is Dynamic Programming?**

Dynamic programming is a method for solving complex problems by breaking them down into simpler subproblems. It involves solving each subproblem once and storing the solutions for future use, which makes the overall problem more efficient to solve.

For a clear and relatable explanation, Jonathan Paulson provides an excellent example in his answer to "How should I explain dynamic programming to a 4-year-old?" on Quora. You can read it [here](https://www.quora.com/How-should-I-explain-dynamic-programming-to-a-4-year-old/answer/Jonathan-Paulson).

### The Maximum Subarray Problem

**Problem Statement:**

Given an integer array `nums`, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

**Brute Force Solution:**

The brute force approach involves examining every possible subarray. Starting from each index, you would calculate the sum of every subarray that begins at that index, keeping track of the maximum sum found. This process is repeated for each element in the array, resulting in a time complexity of O(n^2).

**Kadane’s Algorithm:**

Kadane’s algorithm optimizes the solution by keeping track of the maximum sum subarray ending at each position, thus reducing the time complexity to O(n).

Here's how it works:

1. Initialize two variables:
   - `local_max` to store the maximum sum of the subarray ending at the current position.
   - `global_max` to store the maximum sum found so far across all subarrays.

2. As you iterate through the array, update `local_max` at each position to be the maximum of:
   - The current element itself (`nums[i]`).
   - The current element plus the `local_max` of the previous position (`nums[i] + local_max[i-1]`).

3. Update `global_max` to be the maximum of the current `global_max` and the updated `local_max`.

The formula can be expressed as:
``` 
local_max[i] = max(nums[i], nums[i] + local_max[i - 1])
global_max = max(global_max, local_max[i])
```

Here's a visual representation of the algorithm:

![image](https://github.com/nardineshak/KadaneAlgorithm/assets/57229979/6fd966dd-3064-4e77-be98-7b6af08382bf)


In the diagram above, you can see how `local_max` is updated at each step. By the time you reach `local_max[5]`, there is no need to recompute the sums for all subarrays ending at that position because the maximum sum up to `ARR[4]` has already been determined.

This way, Kadane’s algorithm efficiently finds the maximum subarray sum in linear time.

### Maximum Product Subarray Problem

**Problem Statement:**

Given an integer array `nums`, find the contiguous subarray (containing at least one number) that has the largest product, and return that product.

**Solution Explanation:**

This problem can be approached using a variation of Kadane’s algorithm. Given the presence of both positive and negative numbers in the array, it's crucial to keep track of both the maximum and minimum products at each iteration. This is because multiplying two negative numbers can result in a positive number, which could potentially be the maximum product.

To solve this, we need to maintain three variables during iteration:
1. `local_max`: The maximum product subarray ending at the current position.
2. `local_min`: The minimum product subarray ending at the current position.
3. `global_max`: The maximum product found so far across all subarrays.

At each iteration, we update these variables as follows:

1. The maximum product at the current position (`local_max`) is the maximum of:
   - The current number itself (`nums[i]`).
   - The product of the current number and the previous `local_max`.
   - The product of the current number and the previous `local_min`.

2. Similarly, the minimum product at the current position (`local_min`) is the minimum of:
   - The current number itself (`nums[i]`).
   - The product of the current number and the previous `local_max`.
   - The product of the current number and the previous `local_min`.

3. Update `global_max` to be the maximum of the current `global_max` and the new `local_max`.

The formulas are:
```
local_max = max(nums[i], nums[i] * local_max, nums[i] * local_min)
local_min = min(nums[i], nums[i] * previous_local_max, nums[i] * local_min)  # Note: Use the previous value of local_max here
global_max = max(global_max, local_max)
```

By iterating through the array and updating these variables, we can determine the maximum product subarray.

Here’s a step-by-step breakdown:
1. Initialize `local_max`, `local_min`, and `global_max` with the first element of the array.
2. Iterate through the array, updating `local_max`, `local_min`, and `global_max` as described.
3. After the iteration, `global_max` will contain the largest product of any subarray.

This method ensures an efficient solution with a time complexity of O(n).
