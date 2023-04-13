import java.util.Arrays;
import java.util.Scanner;

public class Assign02_16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] candidate = {"가위", "바위", "보"};

        String input;
        int computer, user;


        System.out.println("컴퓨터와 가위바위보 게임을 합니다.");
        while (true) {
            System.out.print("가위 바위 보! >> ");
            input = scanner.next();
            if (input.equals("그만")) {
                System.out.println("게임을 종료합니다...");
                break;
            }

            computer = (int) (Math.random() * 3);
            user = Arrays.asList(candidate).indexOf(input);

            switch (computer - user) {
                case 1, -2 -> System.out.printf(
                        "사용자 = %s , 컴퓨터 = %s , 컴퓨터가 이겼습니다.\n",
                        candidate[user], candidate[computer]
                );
                case -1, 2 -> System.out.printf(
                        "사용자 = %s , 컴퓨터 = %s , 사용자가 이겼습니다.\n",
                        candidate[user], candidate[computer]
                );
                case 0 -> System.out.printf(
                        "사용자 = %s , 컴퓨터 = %s , 비겼습니다.\n",
                        candidate[user], candidate[computer]
                );
            }
        }
    }
}