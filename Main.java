import java.util.Scanner;
public class Main {
    static String[] roman = {null, "I", "II", "III", "IV", "V", "VI", "VII",
            "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI",
            "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV",
            "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII",
            "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX",
            "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII",
            "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI",
            "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV",
            "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII",
            "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX",
            "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI",
            "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII",
            "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(calc(scanner.nextLine()));
        }
    }
    public static String calc(String input) {
        String[] action = input.split(" ");
        String result = "";
        try {
            if (action.length != 3) throw new Exception();
            int first=Integer.parseInt(action[0]);
            int second=Integer.parseInt(action[2]);
            result = String.valueOf(calculate(first,action[1],second));
        } catch (Exception e) {
            try {
                result = romanCalc(action[0], action[1], action[2]);
                if (result==null) throw new Exception();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
        return result;
    }
    static String romanCalc(String first, String action, String second) throws Exception {
        int num1 = 0;
        int num2 = 0;
        for (int i = 1; i <= 10; i++) {
            if (first.equals(roman[i])) num1 = i;
            if (second.equals(roman[i])) num2 = i;
        }
        return roman[calculate(num1, action, num2)];
    }
    static int calculate(int first, String action, int second) throws Exception {
        if (first <= 0 || first > 10 || second <= 0 || second > 10) throw new Exception();
        switch (action) {
            case "+":
                return first + second;
            case "-":
                return first - second;
            case "*":
                return first * second;
            case "/":
                return first / second;
            default:
                throw new Exception();
        }
    }
}