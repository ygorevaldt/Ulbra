public class activit {
    public static void main(String[] args) {
        checkDateValidity(10, 06, 1985);
    }
    public static void checkDateValidity(int day, int month, int year) {
        boolean dateIsValid = true;

        // Check if year is a leap year
        boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;

        // Check if month is valid
        if (month < 1 || month > 12) {
            dateIsValid = false;
        }

        // Check if day is valid
        else {
            switch(month) {
                case 2:
                    if (isLeapYear && day > 29) {
                        dateIsValid = false;
                    }
                    else if (!isLeapYear && day > 28) {
                        dateIsValid = false;
                    }
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    if (day > 30) {
                        dateIsValid = false;
                    }
                    break;
                default:
                    if (day > 31) {
                        dateIsValid = false;
                    }
                    break;
            }
        }

        // Display message on screen
        if (dateIsValid) {
            System.out.println("A data " + month + "/" + day + "/" + year + " é válida.");
        }
        else {
            System.out.println("A data " + month + "/" + day + "/" + year + " é inválida.");
        }
    }



}
