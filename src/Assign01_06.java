import java.util.Scanner;

public class Assign01_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("1부터 99사이의 정수를 입력하시오 >> ");
        String input = scanner.next();
        int result = input.length() - input.replaceAll("[369]", "").length();

        switch (result) {
            case 2 -> System.out.println("박수짝짝");
            case 1 -> System.out.println("박수짝");
        }
    }
}
