# Kadane Algorithm
Leetcode Problems using Kadane's Algorithm

Sure, here's a more explanatory version:

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
