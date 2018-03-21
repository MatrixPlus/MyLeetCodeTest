package leetCode;

/**
 * Created by IntelliJ IDEA.
 * Author: Gu Jindong
 * Date: 2018/3/16
 * Time: 10:01
 **/

/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

        You may assume that each input would have exactly one solution, and you may not use the same element twice.

        Example:
        Given nums = [2, 7, 11, 15], target = 9,

        Because nums[0] + nums[1] = 2 + 7 = 9,
        return [0, 1].
*/

public class Test1TwoSum {
    public int[] twoSum(int[] nums, int target){
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++){
            for (int j = i + 1; j <= nums.length - 1; j++){//注意是j = i + 1
                if (nums[i] + nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }

        return result;
    }

    public static void main(String[] args){
        Test1TwoSum test = new Test1TwoSum();
        int[] nums= {3,3};
        int target = 6;
        int[] res = new int[2];
        res = test.twoSum(nums,target);
        System.out.println("res[0] = " + res[0] + ", res[1] = " + res[1]);

    }
}
