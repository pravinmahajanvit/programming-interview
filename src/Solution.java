class Solution {
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] { i, j };
                }
            }
        }
        // In case there is no solution, we'll just return null
        return null;
    }
    
    public static void main(String[] args) {
		int[] abc= {2,5,6,3};
		int[] twoSum = twoSum(abc, 2);
		System.err.println();
	}
}