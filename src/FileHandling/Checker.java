package FileHandling;


import static java.lang.Double.parseDouble;

public class Checker {

    public static boolean doubleChecker(String toCheck) {
        boolean bool;
        try {
            parseDouble(toCheck);
            bool = true;
        } catch (NumberFormatException e) {
            bool = false;
        }
        return bool;
    }
}
