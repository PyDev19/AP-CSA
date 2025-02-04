//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Atharva Mishra
//Class - Patterson 3B
//Description - RomanNumeral class that implements the Comparable interface and converts Roman numerals to integers and vice versa

public class RomanNumeral implements Comparable<RomanNumeral> {
	private Integer number;
	private String roman;

	private final static int[] NUMBERS = { 1000, 900, 500, 400, 100, 90,
			50, 40, 10, 9, 5, 4, 1 };

	private final static String[] LETTERS = { "M", "CM", "D", "CD", "C", "XC",
			"L", "XL", "X", "IX", "V", "IV", "I" };

	public RomanNumeral(String str) {
		roman = str;
	}

	public RomanNumeral(Integer orig) {
		number = orig;
	}

	public void setNumber(int num) {
		number = num;
	}

	public void setRoman(String rom) {
		roman = rom;
	}

	public int getNumber() {
		int num = 0;
		String str = roman;

		for (int i = 0; i < NUMBERS.length; i++) {
			while (str.indexOf(LETTERS[i]) == 0) {
				num += NUMBERS[i];
				str = str.substring(LETTERS[i].length());
			}
		}

		return num;
	}

	public String toString() {
		if (number != null) {
			int num = number;
			String roman = "";

			for (int i = 0; i < NUMBERS.length; i++) {
				while (num >= NUMBERS[i]) {
					roman += LETTERS[i];
					num -= NUMBERS[i];
				}
			}

			return roman;
		} else {
			return roman;
		}
	}

	public int compareTo(RomanNumeral r) {
		int num = getNumber();
		int r_num = r.getNumber();

		return num - r_num;
	}
}