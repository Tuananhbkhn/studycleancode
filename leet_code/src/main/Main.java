package main;

import array.ArrayExercises;
import intnum.IntExercises;
import string.StringExercises;

public class Main {
	public static void main(String[] args) {
		StringExercises stringExercises = new StringExercises();
		String s = "ckilbkd";
		System.out.println(stringExercises.lengthOfLongestSubstring(s));
		
		IntExercises intExercises = new IntExercises();
		int num = 10;
		System.out.println(intExercises.intToRoman(num));
		
		ArrayExercises arrayExercises = new ArrayExercises();
		int[] nums = { 1, 3, 5, 6, 7 };
		int target = 3;
		System.out.println(arrayExercises.searchInsert(nums, target));
	}
}

