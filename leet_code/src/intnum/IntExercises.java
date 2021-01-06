package intnum;

public class IntExercises {
	public int reverse(int x) {
		int r = 0;
		String numStr = x + "";
		StringBuilder numStrBld = new StringBuilder();
		numStrBld.append(numStr);
		try {
			if (x > 0 || x == 0) {
				r = Integer.parseInt((numStrBld.reverse().toString()));
			} else {
				numStrBld.deleteCharAt(0);
				r = Integer.parseInt("-" + (numStrBld.reverse().toString()));
			}
		} catch (NumberFormatException e) {
			r = 0;
		}
		return r;
	}

	public boolean isPalindrome(int x) {
		boolean check = false;
		String numStr = x + "";
		StringBuilder numStrBld = new StringBuilder();
		numStrBld.append(numStr);
		try {
			int r = Integer.parseInt((numStrBld.reverse().toString()));
			if (r == x) {
				check = true;
			}
		} catch (NumberFormatException e) {
			check = false;
		}
		return check;
	}

	public int romanToInt(String s) {
		int r = 0;
		int flag = 0;
		if (s.length() == 1) {
			switch (s.charAt(0)) {
			case 'M':
				r += 1000;
				break;
			case 'D':
				r += 500;
				break;
			case 'C':
				r += 100;
				break;
			case 'L':
				r += 50;
				break;
			case 'X':
				r += 10;
				break;
			case 'V':
				r += 5;
				break;
			case 'I':
				r += 1;
				break;
			default:
				break;
			}
		} else {
			for (int j = 0; j < s.length() - 1; j++) {
				switch (s.charAt(j)) {
				case 'M':
					r += 1000;
					break;
				case 'D':
					r += 500;
					break;
				case 'C':
					if (s.charAt(j + 1) == 'D') {
						r += 400;
						j++;
					} else if (s.charAt(j + 1) == 'M') {
						r += 900;
						j++;
					} else {
						r += 100;
					}
					break;
				case 'L':
					r += 50;
					break;
				case 'X':
					if (s.charAt(j + 1) == 'L') {
						r += 40;
						j++;
					} else if (s.charAt(j + 1) == 'C') {
						r += 90;
						j++;
					} else {
						r += 10;
					}
					break;
				case 'V':
					r += 5;
					break;
				case 'I':
					if (s.charAt(j + 1) == 'V') {
						r += 4;
						j++;
					} else if (s.charAt(j + 1) == 'X') {
						r += 9;
						j++;
					} else {
						r += 1;
					}
					break;
				default:
					break;
				}
				flag = j;
			}
			if (flag == s.length() - 2) {
				r += 1;
			}
		}
		return r;
	}

	public String intToRoman(int num) {
		String res = "";
		int m, c, x = 0;
		m = num / 1000;
		if (m > 0) {
			for (int i = 0; i < m; i++) {
				res += "M";
			}
			num -= m * 1000;
		}
		c = num / 100;
		if (c > 0 && c < 4) {
			for (int i = 0; i < c; i++) {
				res += "C";
			}
		} else if (c == 4) {
			res += "CD";
		} else if (c == 5) {
			res += "D";
		} else if (c == 9) {
			res += "CM";
		} else if (c > 5 && c < 9) {
			res += "D";
			for (int i = 5; i < c; i++) {
				res += "C";
			}
		}
		num -= c * 100;
		x = num / 10;
		if (x > 0 && x < 4) {
			for (int i = 0; i < x; i++) {
				res += "X";
			}
		} else if (x == 4) {
			res += "XL";
		} else if (x == 5) {
			res += "L";
		} else if (x == 9) {
			res += "XC";
		} else if (x > 5 && x < 9) {
			res += "L";
			for (int i = 5; i < x; i++) {
				res += "X";
			}
		}
		num -= x * 10;
		if (num > 0 && num < 4) {
			for (int i = 0; i < num; i++) {
				res += "I";
			}
		} else if (num == 4) {
			res += "IV";
		} else if (num == 5) {
			res += "V";
		} else if (num == 9) {
			res += "IX";
		} else if (num > 5 && num < 9){
			res += "V";
			for (int i = 5; i < num; i++) {
				res += "I";
			}
		} 
		return res;
	}
}
