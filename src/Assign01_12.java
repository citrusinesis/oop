import java.util.Scanner;

public class Assign01_12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("연산>> ");
        String[] expression = scanner.nextLine().split(" ");

        String operator = expression[1];
        int[] operand = new int[] {
                Integer.parseInt(expression[0]),
                Integer.parseInt(expression[2])
        };

        switch (operator) {
            case "+" -> System.out.printf(
                    "%d %s %d의 연산 결과는 %d\n",
                    operand[0], operator, operand[1], operand[0] + operand[1])
            ;
            case "-" -> System.out.printf(
                    "%d %s %d의 연산 결과는 %d\n",
                    operand[0], operator, operand[1], operand[0] - operand[1]
            );
            case "*" -> System.out.printf(
                    "%d %s %d의 연산 결과는 %d\n",
                    operand[0], operator, operand[1], operand[0] * operand[1]
            );
            case "/" -> {
                if (operand[1] == 0) {
                    System.out.println("0으로 나눌 수 없습니다.");
                    System.exit(1);
                }
                System.out.printf(
                        "%d %s %d의 연산 결과는 %d\n",
                        operand[0], operator, operand[1], operand[0] / operand[1]
                );
            }
        }
    }
}
