import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Assign06_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Character> list = new ArrayList<>();

        System.out.print("6개의 학점을 빈 칸으로 분리 입력(A/B/C/D/F)>> ");
        for (int i = 0; i < 6; i++)
            list.add(scanner.next().charAt(0));

        System.out.println(list.stream()
                .mapToDouble(
                        el -> switch (el) {
                            case 'A' -> 4.0;
                            case 'B' -> 3.0;
                            case 'C' -> 2.0;
                            case 'D' -> 1.0;
                            default -> 0.0;
                        }
                ).average()
                .orElse(0.0));
    }
}
