import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Solution {

	public static void main(String[] args) {
		
		Solution s = new Solution();
		
		// Solution #1
		System.out.println(s.uShouldDateJava(4, 7, 1776, 4, 5, 2011));
		
		// Solution #2 (algorithmic)
		System.out.println(s.uShouldDate(4, 7, 1776, 4, 5, 2011));
		
		

	}

	int uShouldDate(int day1, int month1, int year1, int day2, int month2, int year2) {

		// if dates are in the same year
		if (year1 == year2) {

			// same year same month
			if (month1 == month2) {
				return day2 - day1;

				// same year different month
			} else {
				return getDaysOfYear(year2, month2, day2) - getDaysOfYear(year1, month1, day1);

			}

		}

		// if years are different

		int totalDays = 0;

		// calculate remaining days of first year
		int daysInYear1 = 365;
		if (isLeapYear(year1)) {
			daysInYear1++;
		}

		totalDays += (daysInYear1 - getDaysOfYear(year1, month1, day1));

		// calculate the days of the full years in between year1 and year 2 (if
		// any)
		for (int i = year1 + 1; i < year2; i++) {
			if (isLeapYear(i)) {
				totalDays += 366;
			} else {
				totalDays += 365;
			}
		}

		// calculate the days of year2
		totalDays += getDaysOfYear(year2, month2, day2);

		return totalDays;

	}

	int getDaysOfYear(int year, int month, int day) {

		int totalDays = 0;
		int[] daysInMonths = new int[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		for (int i = 1; i < month; i++) {

			totalDays += daysInMonths[i - 1];
		}

		totalDays += day - 1;

		if ((month > 2 || month == 2 && day < 28) && (isLeapYear(year))) {
			totalDays++;
		}

		return totalDays;
	}

	boolean isLeapYear(int year) {

		if (year % 4 != 0) {
			return false;
		} else if (year % 100 != 0) {
			return true;
		} else if (year % 400 != 0) {
			return false;
		} else {
			return true;
		}

	}
	
	int uShouldDateJava(int day1, int month1, int year1, int day2, int month2, int year2) {

		LocalDateTime from = LocalDateTime.of(year1, month1, day1, 0, 0);
		LocalDateTime to = LocalDateTime.of(year2, month2, day2, 0, 0);

		long days = from.until(to, ChronoUnit.DAYS);

		return (int) days;
	}


}


