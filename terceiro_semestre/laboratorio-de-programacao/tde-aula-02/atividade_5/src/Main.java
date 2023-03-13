public class Main {
    public static void main(String[] args) {
        checkDateValidity(30, 02, 2020);
    }
    public static void checkDateValidity(int day, int month, int year) {
        boolean dateIsValid = true;
        boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;

        dateIsValid = checkMonth(month);

        switch(month) {
            case 2:
                dateIsValid = checkFebruaryDaysInLeapYears(day, isLeapYear);
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                dateIsValid = checkNovemberDays(day);
                break;
            default:
                dateIsValid = checkDecemberDays(day);
                break;
        }

        if (dateIsValid) {
            System.out.println("A data " + day + "/" + month + "/" + year + " é válida.");
        }
        else {
            System.out.println("A data " + day + "/" + month + "/" + year + " é inválida.");
        }
    }

    public static boolean checkFebruaryDaysInLeapYears(int day, boolean year) {
        if (year && day > 29 || !year && day > 28 ) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean checkNovemberDays(int day) {
        if (day > 30 ) {
            return false;
        }
        return true;
    }

    public static boolean checkDecemberDays(int day) {
        if (day > 31 ) {
            return false;
        }
        return true;
    }
    public static boolean checkDay(int day, boolean year) {
        if (year && day > 29 || !year && day > 28 || day > 30 || day > 31) {
            return false;
        }
        return true;
    }

    public static boolean checkMonth(int month) {
        if (month < 1 || month > 12) {
            return  false;
        }
        return true;
    }
}