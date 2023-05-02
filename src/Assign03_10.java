import java.util.Scanner;

public class Assign03_10 {
    static class Dictionary {
        private static String[] kor = {"사랑", "아기", "돈", "미래", "희망"};
        private static String[] eng = {"love", "baby", "money", "future", "hope"};

        public static String kor2eng(String word) {
            for (int i = 0; i < kor.length; i++)
                if (word.equals(kor[i])) return eng[i];

            return null;
        }
    }

    static class DicApp {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("한영 단어 검색 프로그램입니다.");

            while (true) {
                System.out.print("한글 단어? ");
                String kor = scanner.next();
                String eng = Dictionary.kor2eng(kor);

                if (kor.equals("그만"))
                    System.exit(0);

                if (eng == null) {
                    System.out.println(kor + "는 저의 사전에 없습니다.");
                    continue;
                }

                System.out.println(kor + "는 " + eng);
            }
        }
    }
}
