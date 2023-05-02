import java.util.Scanner;

public class Assign03_08 {
    static class Phone {
        String name, tel;

        Phone(String name, String tel) {
            this.name = name;
            this.tel = tel;
        }
    }

    static class PhoneBook {
        Phone[] book;

        PhoneBook(int size) {
            this.book = new Phone[size];
        }

        String search(String name) {
            for (Phone phone: book) {
                if (phone.name.equals(name))
                    return phone.tel;
            }

            return null;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("인원수 >> ");
        PhoneBook phoneBook = new PhoneBook(scanner.nextInt());

        for (int i = 0; i < phoneBook.book.length; i++) {
            System.out.print("이름과 전화번호(이름과 번호는 빈칸없이 입력) >> ");
            phoneBook.book[i] = new Phone(scanner.next(), scanner.next());
        }
        System.out.println("저장되었습니다...");

        while (true) {
            System.out.print("검색할 이름 >> ");
            String name = scanner.next();

            if (name.equals("그만"))
                System.exit(0);

            String tel = phoneBook.search(name);
            if (tel == null) {
                System.out.println(name + "이 없습니다.");
                continue;
            }

            System.out.println(name + "의 번호는 " + tel + "입니다.");
        }
    }
}