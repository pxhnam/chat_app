package validation;

public class DateValidator {

    public static boolean isValidDate(int day, int month, int year) {
        if (day < 1 || day > 31) {
            return false;
        }
        if (month < 1 || month > 12) {
            return false;
        }
        if (year < 1) {
            return false;
        }
        if (month == 2) {
            if (isLeapYear(year)) {
                if (day > 29) {
                    return false;
                }
            } else {
                if (day > 28) {
                    return false;
                }
            }
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            if (day > 30) {
                return false;
            }
        }
        return true;
    }

    private static boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return true;
            }
        } else {
            return false;
        }
    }
}
