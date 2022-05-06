import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ScannerException {
        Scanner in = new Scanner(System.in);
        String str1 = in.nextLine();
        String[] str2 = str1.split(" ");
        if (str2.length != 3 ){
            throw new ScannerException("Формат математической операции не удовлетворяет заданию - " +
                    "два операнда и один оператор (+, -, /, *)");
        }
        try {
            int num1 = Integer.parseInt(str2[0]);
            int num2 = Integer.parseInt(str2[2]);
            if ( num1 <= 0 | num1 > 10 | num2 <= 0 | num2 > 10){
                throw new ScannerException("Можно использовать числа от 1 до 10");
            }
            String operator = str2[1];
            int result = calc(num1, num2, operator);
            System.out.println(result);
        } catch (NumberFormatException e) {
            int num1 = romanToNumber(str2[0]);
            int num2 = romanToNumber(str2[2]);
            if (num1 < 0 || num2 < 0){
                throw new ScannerException("Неверный формат данных:Нужно использовать числа из одной системы " +
                        "счисления, от 1 до 10 включительно");
            }
            String operator = str2[1];
            int result = calc(num1, num2, operator);
            RomNum[] romNum = RomNum.values();
            for (RomNum n: romNum){
                if (result == n.getValue()){
                    System.out.println(n.getKey());
                    break;
                }
            }
        }
    }

    private static int romanToNumber (String roman) {
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
            }
        return -1;
    }
    public static int calc( int num1, int num2, String operator){
        int result = 0;
        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                    result = num1 / num2;
                break;
            default:
                throw new IllegalArgumentException("Не верный знак операции");
        }
        return result;
    }
}