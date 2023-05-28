import java.util.Scanner;

public class Assign05_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] result = scanner.nextLine().split("");
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result.length; j++) {
                System.out.print(result[(i+j+1) % result.length]);
            }
            System.out.println();
        }
    }
}
