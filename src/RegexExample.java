import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExample {

    public static void main(String[] args) {

        boolean test = test("Step");
        System.out.println(test);

        boolean test2 = test2("Step");
        System.out.println(test2);

        boolean test3 = test3("step");
        System.out.println(test3);

        boolean test4 = test4("john");
        System.out.println(test4);

        boolean test5 = test5("a3$%^");
        System.out.println(test5);

        boolean test6 = test6("example.com");
        System.out.println(test6);

        boolean test7 = test7("step");
        System.out.println(test7);

        boolean test8 = test8("12345");
        System.out.println(test8);

        boolean test9 = test9("Asda");
        System.out.println(test9);
    }

    public static boolean test(String text) {
        Pattern pattern = Pattern.compile("Step");
        Matcher matcher = pattern.matcher(text);
        return matcher.matches();
    }

    public static boolean test2(String text) {
        return text.matches("Step");
    }

    public static boolean test3(String text) {
        Pattern pattern = Pattern.compile("[Ss]tep");
        Matcher matcher = pattern.matcher(text);
        return matcher.matches();
    }

    public static boolean test4(String text) {
        Pattern pattern = Pattern.compile("[A-z0-9 ]+");
        Matcher matcher = pattern.matcher(text);
        return matcher.matches();
    }

    public static boolean test5(String text) {
        Pattern pattern = Pattern.compile(".+");
        Matcher matcher = pattern.matcher(text);
        return matcher.matches();
    }

    public static boolean test6(String text) {
        Pattern pattern = Pattern.compile(".+\\.(com|az|ru)");
        Matcher matcher = pattern.matcher(text);
        return matcher.matches();
    }

    public static boolean test7(String text) {
        Pattern pattern = Pattern.compile("^step$");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            int start = matcher.start();
            String group = matcher.group();

            System.out.println(start + " " + group);
        }
        return matcher.matches();
    }

    public static boolean test8(String text) {
        Pattern pattern = Pattern.compile("[0-9]{3,5}");
        Matcher matcher = pattern.matcher(text);
        return matcher.matches();
    }

    public static boolean test9(String text) {
//        Pattern pattern = Pattern.compile("^[A-Z]{1}.+");
        Pattern pattern = Pattern.compile("^([A-Z][a-z]+)+$");

        Matcher matcher = pattern.matcher(text);
        return matcher.matches();
    }

    public static boolean test10(String text) {
        Pattern pattern = Pattern.compile("[^0-9]");
        Matcher matcher = pattern.matcher(text);
        return matcher.matches();
    }

}
