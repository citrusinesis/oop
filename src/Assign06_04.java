import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class Assign06_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new Vector<>();

        while (true) {
            System.out.print("강수량 입력 (0 입력시 종료)>> ");

            int input = scanner.nextInt();
            if (input == 0) break;

            list.add(input);
            for (int el : list)
                System.out.print(el + " ");
            System.out.println();
            System.out.println("현재 평균 " + (int) list.stream()
                    .mapToInt(Integer::intValue)
                    .average()
                    .orElse(0));
        }
    }
}
