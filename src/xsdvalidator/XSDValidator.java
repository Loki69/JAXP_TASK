package xsdvalidator;

public class XSDValidator {

    public static void main(String[] args) {
        if (checkInputData(args)) {
        }
    }

    private static boolean checkInputData(String[] arvg) {
        return arvg.length > 1;
    }
}
