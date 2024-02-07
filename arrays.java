import java.util.*;

public class arrays {
    // public static void main(String args[]) {

    // // datatype arrayName[] = new dataType[size] (syntax)
    // System.out.println("Enter marks: ");
    // int marks[] = new int[100];
    // Scanner sc = new Scanner(System.in);
    // marks[0] = sc.nextInt(); // phy
    // marks[1] = sc.nextInt(); // chem
    // marks[2] = sc.nextInt(); // maths
    // System.out.println("Physics: " + marks[0]);
    // System.out.println("Chemistry: " + marks[1]);
    // System.out.println("Maths: " + marks[2]);

    // marks[2] = 100; // updation
    // marks[1] = marks[1] + 1; // updation
    // marks[0] = marks[0] / 2;

    // System.out.println("Updated Physics: " + marks[0]);
    // System.out.println("Updated Chemistry: " + marks[1]);
    // System.out.println("Updated Maths: " + marks[2]);

    // int percentage = (marks[0] + marks[1] + marks[2]) / 3;
    // System.out.println("percentage =" + percentage + "%");
    // System.out.println("length of array =" + marks.length);

    // }
    // }

    public static void update(int marks[], int nonChangable) {
        nonChangable = 10;
        for (int i = 0; i < marks.length; i++) {
            marks[i] = marks[i] + 1;
        }
    }

    // public static void main(String args[]) {
    // int marks[] = { 97, 98, 99 };
    // int nonChangable = 5;
    // update(marks, nonChangable);
    // System.out.println(nonChangable);

    // // print our marks
    // for (int i = 0; i < marks.length; i++) {
    // System.out.println(marks[i] + "");
    // }
    // System.out.println();

    // }

    public static int linearSearch(int numbers[], int key) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == key) {
                return i;
            }
        }
        return -1;
    }

    // public static void main(String args[]) {
    // int numbers[] = { 2, 4, 6, 8, 10, 12, 16, 18 };
    // int key = 10;

    // int index = linearSearch(numbers, key);
    // if (index == -1) {
    // System.out.print("Element Not Present in the array");
    // } else {
    // System.out.print("Key is found at index: " + index);
    // }
    // }

    // largest no in array
    public static int getLargest(int numbers[]) {
        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;

        for (int i = 0; i < numbers.length; i++) {
            if (largest < numbers[i]) {
                largest = numbers[i];
            }
            if (smallest > numbers[i]) {
                smallest = numbers[i];
            }
        }
        System.out.println("Smallest Value is : " + smallest);
        return largest;
    }

    // Binary Search

    public static int binarySearch(int numbers[], int key) {
        int start = 0, end = numbers.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            // comparisons
            if (numbers[mid] == key) {
                return mid; // key found
            }
            if (numbers[mid] > key) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    // public static void main(String args[]) {
    // // int numbers[] = { 1, 2, 6, 3, 5 };
    // // System.out.println("Largest value is: " + getLargest(numbers));
    // int numbers[] = { 2, 4, 6, 8, 10, 12, 14, 16 };
    // int key = 10;
    // System.out.println(" Index for key is: " + binarySearch(numbers, key));
    // }

    public static void reverseArray(int numbers[]) {
        int first = 0, last = numbers.length - 1;
        while (first < last) {
            // swap
            int temp = numbers[last];
            numbers[last] = numbers[first];
            numbers[first] = temp;

            first++;
            last--;
        }
    }

    // public static void main(String args[]) {
    // int numbers[] = { 2, 3, 4, 5, 6, 7, 8, 9 };
    // reverseArray(numbers);

    // for (int i = 0; i < numbers.length; i++) {
    // System.out.print(numbers[i] + " ");
    // }
    // System.out.println();
    // }

    // pairs in an array
    public static void printPairs(int numbers[]) {
        for (int i = 0; i < numbers.length; i++) {
            int curr = numbers[i];
            for (int j = i + 1; j < numbers.length; j++) {
                System.out.print("(" + curr + "," + numbers[j] + ")");
            }
            System.out.println();
        }
    }

    // subarrays - a continuous part of array

    public static void printSubArrays(int numbers[]) {
        int ts = 0; // total subarrays
        for (int i = 0; i < numbers.length; i++) {
            int start = i;
            for (int j = i; j < numbers.length; j++) {
                int end = j;
                for (int k = start; k <= end; k++) {
                    System.out.print(numbers[k] + " ");
                }
                ts++;
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("Total Subarrays = " + ts);
    }

    // public static void main(String[] args) {
    // int numbers[] = { 2, 4, 6, 8, 10 };
    // // printPairs(numbers);
    // printSubArrays(numbers);
    // }

    // max subarray sum (Brute Force)

    public static void maxSubarraySum1(int numbers[]) {
        int arrSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < numbers.length; i++) {
            int start = i;
            for (int j = i; j < numbers.length; j++) {
                int end = j;
                int currSum = 0;
                for (int k = start; k <= end; k++) {
                    // print subarray sum
                    currSum += numbers[k];
                }
                System.out.println(currSum);
                // updating maxSum
                if (maxSum < currSum) {
                    maxSum = currSum;
                }
            }
        }
        System.out.println("maxSum is :" + maxSum);
    }
    // max subarray sum 2 - prefix sum

    public static void maxSubarraySum2(int numbers[]) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int prefix[] = new int[numbers.length];

        // finding prefix array
        prefix[0] = numbers[0];
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + numbers[i];
        }

        // now finding maxSum
        for (int i = 0; i < numbers.length; i++) {
            int start = i;
            for (int j = i; j < numbers.length; j++) {
                int end = j;
                currSum = start == 0 ? prefix[end] : prefix[end] - prefix[start - 1];
                if (maxSum < currSum) {
                    maxSum = currSum;
                }
            }
        }
        System.out.println("maxSum is:" + maxSum);
    }

    // maxSubarray Sum3 - Kadane's Algorithm

    public static void kadanes(int numbers[]) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < numbers.length; i++) {
            currSum = currSum + numbers[i];
            if (currSum < 0) {
                currSum = 0;
            }
            maxSum = Math.max(currSum, maxSum);
        }
        System.out.println("Our max Subarray Sum is: " + maxSum);
    }

    // public static void main(String args[]) {
    // // int numbers[] = { 2, 4, 6, 8, 10 };
    // // maxSubarraySum1(numbers);
    // int numbers[] = { 1, -2, 3, -4, -5, 7, 8 };
    // // maxSubarraySum2(numbers);
    // kadanes(numbers);
    // }

    // trapped rainwater problem
    public static int trappedRainwater(int height[]) {

        int n = height.length;
        // calculate left-max boundary array
        int leftMax[] = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }

        // calculate right max boundary array
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

    // public static void main(String args[]) {
    // int height[] = { 4, 2, 0, 6, 3, 2, 5 };
    // System.out.println(trappedRainwater(height));
    // }

    // arrays problem: Best time to Buy and Sell Stock
    public static int buyAndSellStocks(int prices[]) {
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (buyPrice < prices[i]) {
                // profit
                int profit = prices[i] - buyPrice;
                maxProfit = Math.max(maxProfit, profit);
            } else {
                // buyPrice>prices[i]
                buyPrice = prices[i];
            }
        }
        return maxProfit;
    }

    public static void main(String args[]) {
        int prices[] = { 7, 1, 5, 3, 6, 4 };
        System.out.println("Max Profit is: " + buyAndSellStocks(prices));
    }
}