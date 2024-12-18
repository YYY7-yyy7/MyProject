import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        String input = a.nextLine();
        try {
            String result = calc(input);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static String calc(String input) throws Exception {
        input = input.replaceAll("\\s+", "");
        String[] array = input.split("[+\\-*/]");
        if (array.length != 2) {
            throw new Exception("throws Exception");
        }
        char z = input.charAt(array[0].length());
        boolean romX = rom(array[0]);
        boolean romY = rom(array[1]);
        if (romX != romY) {
            throw new Exception("throws Exception");
        }
        int x;
        if (romX) {
            x = romAra(array[0]);
        } else {
            x = Integer.parseInt(array[0]);
        }
        int y;
        if (romY) {
            y = romAra(array[1]);
        } else {
            y = Integer.parseInt(array[1]);
        }
        if (x < 1 || x > 10 || y < 1 || y > 10) {
            throw new Exception("throws Exception");
        }
        int result = 0;
        switch (z) {
            case '+':
                result = x + y;
                break;
            case '-':
                result = x - y;
                break;
            case '*':
                result = x * y;
                break;
            case '/':
                if (y == 0) {
                    throw new Exception("throws Exception");
                }
                result = x / y;
                break;
            default:
                throw new Exception("throws Exception");
        }
        if (romX) {
            if (result < 1) {
                throw new Exception("throws Exception");
            }
            return araRom(result);
        } else {
            return String.valueOf(result);
        }
    }

    static boolean rom(String str) {
        return str.matches("I|II|III|IV|V|VI|VII|VIII|IX|X");
    }

    static int romAra(String roman) {
        switch (roman) {
            case "I":
                return 1;
            case "II":
                return 2;
            case "III":
                return 3;
            case "IV":
                return 4;
            case "V":
                return 5;
            case "VI":
                return 6;
            case "VII":
                return 7;
            case "VIII":
                return 8;
            case "IX":
                return 9;
            case "X":
                return 10;
            default:
                throw new IllegalArgumentException("throws Exception");
        }
    }

    static String araRom(int b) {
        if (b < 1 || b > 100) {
            throw new IllegalArgumentException("throws Exception");
        }
        String[] edenichy = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String[] desyatki = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        int edenichy1 = b % 10;
        int desyatki1 = b / 10;
        if (b == 100) {
            return "C";
        }
        String p1 = desyatki[desyatki1];
        String p2 = edenichy[edenichy1];

        return p1 + p2;
    }
}