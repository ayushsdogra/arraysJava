public class arraysPractice {

    // Monotonic array- means either consecutively increasing or consecutively
    // decreasing no's in an array
    public static boolean monotonicInc(int numbers[]) {
        int n = numbers.length;
        for (int i = 0; i < n - 1; i++) {
            if (numbers[i] > numbers[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static boolean monotonicDec(int numbers[]) {
        int n = numbers.length;
        for (int i = 0; i < n - 1; i++) {
            if (numbers[i] < numbers[i + 1]) {
                return false;
            }
        }
        return true;
    }

    // public static void main(String args[]) {
    // int numbers[] = { 2, 4, 6, 8 };
    // boolean monotonicInc = monotonicInc(numbers);
    // boolean monotonicDec = monotonicDec(numbers);
    // System.out.println("Is Array Monotonically Increasing: " +
    // monotonicInc(numbers));
    // System.out.println("Is Array Monotonically Decreasing: " +
    // monotonicDec(numbers));
    // }

    // Lonely no in an Array
    public static void printLonelyNumbers(int numbers[]) {
        for (int i = 0; i < numbers.length - 1; i++) {
            if (i == 0) {
                if (numbers[i + 1] - numbers[i] > 1) {
                    System.out.print(numbers[i] + " ");
                }
            } else if (i == numbers.length - 1) {
                if (numbers[i] - numbers[i - 1] > 1) {
                    System.out.print(numbers[i] + " ");
                }
            } else {
                if (numbers[i + 1] - numbers[i] > 1 && numbers[i] - numbers[i - 1] > 1) {
                    System.out.print(numbers[i] + " ");
                }
            }
        }
    }

    // public static void main(String args[]) {
    // int numbers[] = { 2, 2, 3, 5, 7, 9, 13, 14, 16, 18 };
    // printLonelyNumbers(numbers);
    // }

    // return true if repeated no exists in an array
    public static boolean isRepeatedNumberExists(int arr[], int n) {
        n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                if (arr[i] == arr[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    // public static void main(String args[]) {
    // int arr[] = { 1, 2, 1, 4 };
    // System.out.println("Is Repeated no exists in an array? " +
    // isRepeatedNumberExists(arr, n));
    // }

    // There is an integer array nums sorted in ascending order (with distinct
    // values).Prior to being passed to your function, nums is possibly rotated at
    // an unknown pivot index k (1 <= k < nums.length) such that the resulting array
    // is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]
    // (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3
    // and become [4,5,6,7,0,1,2].Given the array nums after the possible rotation
    // and an integer target, returnthe index oftarget if it is in nums, or -1 if it
    // is not in nums.You must write an algorithm with O(log n) runtime complexity.

    public static int findIndex(int[] num, int target) {
        int l = 0, h = num.length - 1, m = 0;
        // applying binary search
        while (l <= h) {
            m = (l + h) / 2;
            if (target == num[m]) {
                return m;
            } // left sorted portion
            else if (num[l] <= num[m]) {
                if (target >= num[l] && target <= num[m]) {
                    h = m - 1;
                } else {
                    l = m + 1;
                }
            }
            // right sorted portion
            else {
                if (target > num[m] && target < num[h]) {
                    l = m + 1;
                } else {
                    h = m - 1;
                }
            }
        }
        return -1;
    }

    // public static void main(String args[]) {
    // int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
    // System.out.println("Index is: " + findIndex(nums, 7));
    // }

    // You are given an array prices where prices[i] is the price of a given stock
    // on the ith day.Return the maximum profit you can achieve from this
    // transaction. If you cannot achieve any profit, return 0.

    public static int buyAndSellStock(int[] prices) {
        int maxProfit = 0;
        int buyPrice = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            if (buyPrice < prices[i]) {
                // profit
                int profit = prices[i] - buyPrice;
                maxProfit = Math.max(profit, maxProfit);
            } else {
                buyPrice = prices[i];
            }
        }
        return maxProfit;
    }

    // Given n non-negative integers representing an elevation map where the width
    // of each bar is 1, compute how much water it can trap after raining.
    // Input:height = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]

    public static int trappedRainwater(int[] height) {
        int n = height.length;

        // Base case: if the height array is empty or has only one element, no water can
        // be trapped
        if (n <= 1)
            return 0;

        // left-max
        int leftMax[] = new int[n];
        leftMax[0] = height[0];

        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }

        // right-max
        int rightMax[] = new int[n];
        rightMax[n - 1] = height[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }

        int trappedWater = 0;

        for (int i = 0; i < n; i++) {
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            trappedWater += waterLevel - height[i];
        }

        return trappedWater;
    }

    public static void main(String args[]) {
        // int[] prices = { 7, 1, 5, 3, 6, 4 };
        // System.out.println("Max profit is: " + buyAndSellStock(prices));

        int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println(trappedRainwater(height));
    }

}
