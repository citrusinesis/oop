import java.util.Arrays;
import java.util.Scanner;

public class Assign03_12 {
    static class Seats {
        String grade;
        String[] seats;

        Seats(String grade, int size) {
            this.grade = grade;
            this.seats = new String[size];

            for (int i = 0; i < this.seats.length; i++)
                seats[i] = "---";
        }

        String read() {
            StringBuilder stringBuilder = new StringBuilder();
            for (String seat: this.seats)
                stringBuilder.append(seat).append(" ");
            return stringBuilder.toString();
        }

        boolean update(int num, String name) {
            if (!this.seats[num].equals("---"))
                return false;

            this.seats[num] = name;
            return true;
        }

        boolean delete(String name) {
            for (int i = 0; i < this.seats.length; i++) {
                if (this.seats[i].equals(name)) {
                    this.seats[i] = "---";
                    return true;
                }
            }

            return false;
        }

        @Override
        public String toString() {
            return this.grade + ">> " + this.read();
        }
    }

    static class Show {
        static Seats[] seats = {
                new Seats("S", 10),
                new Seats("A", 10),
                new Seats("B", 10)
        };

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("명품콘서트홀 예약 시스템입니다.");
            while (true) {
                System.out.print("예약:1, 조회:2, 취소:3, 끝내기:4 >> ");
                switch (scanner.nextInt()) {
                    case 1 -> {
                        System.out.print("좌석구분 S(1), A(2), B(3) >> ");
                        int row = scanner.nextInt();
                        if (row < 0 || row-- > 3) {
                            System.out.println("<<<잘못된 좌석구분 입니다.>>>");
                            continue;
                        }
                        System.out.println(seats[row]);

                        System.out.print("이름 >> ");
                        String name = scanner.next();

                        System.out.print("번호 >> ");
                        int num = scanner.nextInt();
                        if (num < 0 || num-- > seats[row].seats.length) {
                            System.out.println("<<<잘못된 좌석번호 입니다.>>>");
                            continue;
                        }

                        if (!seats[row].update(num, name))
                            System.out.println("<<<이미 존재하는 ㅊ좌석입니다.>>>");
                    }
                    case 2 -> {
                        Arrays.stream(seats).forEach(System.out::println);
                        System.out.println("<<<조회를 완료하였습니다.>>>");
                    }
                    case 3 -> {
                        System.out.print("좌석구분 S(1), A(2), B(3) >> ");
                        int row = scanner.nextInt();
                        if (row < 0 || row-- > 3) {
                            System.out.println("<<<잘못된 좌석구분 입니다.>>>");
                            continue;
                        }
                        System.out.println(seats[row]);

                        System.out.print("이름 >> ");
                        if (!seats[row].delete(scanner.next()))
                            System.out.println("<<<검색하신 이름이 존재하지 않습니다.>>>");
                    }
                    case 4 -> System.exit(0);
                }
            }
        }
    }
}
