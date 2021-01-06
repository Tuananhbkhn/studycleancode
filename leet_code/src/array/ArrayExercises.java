package array;

public class ArrayExercises {
	public int removeDuplicates(int[] nums) {
		if (nums.length == 0)
			return 0;
		int i = 0;
		for (int j = 1; j < nums.length; j++) {
			if (nums[j] != nums[i]) {
				i++;
				nums[i] = nums[j];
			}
		}
		return i + 1;
	}

	public int removeElement(int[] nums, int val) {
		if (nums.length == 0)
			return 0;
		int i = nums.length - 1;
		for (int j = 0; j < nums.length; j++) {
			if (j >= i)
				break;
			if (nums[j] == val) {
				if (nums[i] != val) {
					nums[j] = nums[i];
					nums[i] = val;
				} else {
					j--;
				}
				i--;
			}
		}
		if (nums[i] == val) {
			i--;
		}
		return i + 1;
	}

	public int searchInsert(int[] nums, int target) {
		int insert = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			if (i == 0 && nums[i] >= target) {
				insert = 0;
			} else if (nums[i] < target && nums[i + 1] >= target) {
				insert = i + 1;
			}
		}
		if (nums[nums.length - 1] < target) {
			insert = nums.length;
		}
		return insert;
	}

	public int maxSubArray(int[] nums) {
		int res = 0;
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (sum > res) {
				res = sum;
			}
		}
		return res;
	}
}
