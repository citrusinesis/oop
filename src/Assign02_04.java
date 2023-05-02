import java.util.Scanner;

public class Assign02_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("소문자 알파벳 하나를 입력하시오>> ");
        for (char i = scanner.next().charAt(0); i >= 'a'; i--) {
            for (char j = 'a'; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
}
