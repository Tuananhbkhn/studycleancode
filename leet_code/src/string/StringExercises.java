package string;

public class StringExercises {
	public String longestCommonPrefix(String[] strs) {
		String res = "";
		if (strs.length > 0) {
			int minLength = strs[0].length();
			int strLength = 0;
			for (int i = 1; i < strs.length; i++) {
				strLength = strs[i].length();
				if (minLength > strLength) {
					minLength = strLength;
				}
			}
			for (int i = 0; i < minLength; i++) {
				String pre = strs[0].charAt(i) + "";
				for (int j = 1; j < strs.length; j++) {
					if (!pre.equals(strs[j].charAt(i) + "")) {
						pre = "";
						i = minLength - 1;
						break;
					}
				}
				res += pre;
			}
		}
		return res;
	}

	public boolean isValid(String s) {
		boolean res = true;
		int strlength = s.length();
		if (strlength % 2 != 0) {
			res = false;
		} else {
			StringBuilder strBld = new StringBuilder();
			strBld.append(s);
			for (int i = 0; i < strBld.length() - 1; i++) {
				char c = strBld.charAt(i);
				char nextc = strBld.charAt(i + 1);
				switch (c) {
				case '{':
					if (nextc == '}') {
						strBld.delete(i, i + 2);
						i = -1;
					}
					break;
				case '[':
					if (nextc == ']') {
						strBld.delete(i, i + 2);
						i = -1;
					}
					break;
				case '(':
					if (nextc == ')') {
						strBld.delete(i, i + 2);
						i = -1;
					}
					break;
				default:
					res = false;
					break;
				}
			}
			if (strBld.length() != 0) {
				res = false;
			}
		}
		return res;
	}

	public int strStr(String haystack, String needle) {
		int ind = -1;
		if ("".equals(needle)) {
			ind = 0;
		} else {
			boolean check = haystack.contains(needle);
			if (check) {
				ind = haystack.indexOf(needle);
			}
		}
		return ind;
	}

	public int lengthOfLastWord(String s) {
		int len = 0;
		s = s.trim();
		if (s.length() > 0) {
			StringBuilder strB = new StringBuilder();
			strB.append(s);
			s = strB.reverse().toString();
			String[] listOfWords = s.split(" ");
			if (listOfWords.length > 0) {
				len = listOfWords[0].length();
			}
		}
		return len;
	}

	public int lengthOfLongestSubstring(String s) {
		if (s.length() == 1)
			return 1;
		int len = 0;
		int maxLen = 0;
		String subStr = "";
		for (int i = 0; i < s.length() - 1; i++) {
			subStr += s.charAt(i);
			len = subStr.length();
			if (subStr.contains(s.charAt(i + 1) + "")) {
				subStr = subStr.substring(subStr.indexOf(s.charAt(i + 1)) + 1);
			} else if (i == s.length() - 2) {
				subStr += s.charAt(i + 1);
				len = subStr.length();
			}
			if (len > maxLen) {
				maxLen = len;
			}
		}
		return maxLen;
	}

	public String longestPalindrome(String s) {
		String res = "";

		return res;
	}

	public String convert(String s, int numRows) {
		String row1 = "";
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < numRows; j++) {
				
				if (i % (2 * (numRows - 1)) == 0) {
					row1 += s.charAt(i);
				}
			}
		}
		char[] charArray= s.toCharArray();
		return row1;
	}
}
