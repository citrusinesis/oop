import java.util.Scanner;

public class Assign04_12 {

    static abstract class Shape {
        private Shape next;

        public Shape() {
            next = null;
        }

        public Shape getNext() {
            return next;
        }

        public void setNext(Shape obj) {
            next = obj;
        } // 링크 연결

        public abstract void draw();
    }

    static class Line extends Shape {
        public void draw() {
            System.out.println("Line");
        }
    }

    static class Rect extends Shape {
        public void draw() {
            System.out.println("Rect");
        }
    }

    static class Circle extends Shape {
        public void draw() {
            System.out.println("Circle");
        }
    }

    static public class GraphicEditor {
        private final Scanner scanner;
        private Shape head, tail;

        public GraphicEditor() {
            head = null;  // 시작 노드
            tail = null; // 끝 노드
            scanner = new Scanner(System.in);
        }

        public void run() {
            System.out.println("그래픽 에디터 beauty를 실행합니다.");
            while (true) {
                System.out.print("삽입(1), 삭제(2), 모두 보기(3), 종료(4) >> ");
                int num = scanner.nextInt();
                switch (num) {
                    case 1 -> {
                        System.out.print("Line(1), Rect(2), Circle(3) >> ");
                        num = scanner.nextInt();
                        insert(num);
                    }
                    case 2 -> {
                        System.out.print("삭제할 도형의 위치 >> ");
                        num = scanner.nextInt();
                        delete(num);
                    }
                    case 3 -> print();
                    case 4 -> {
                        System.out.println("beauty을 종료합니다.");
                        scanner.close();
                        return;
                    }
                }
            }
        }

        public void insert(int draw) { // 노드 삽입
            Shape grapic;
            switch (draw) {
                case 1 -> grapic = new Line();
                case 2 -> grapic = new Rect();
                case 3 -> grapic = new Circle();
                default -> {
                    System.out.println("다시 입력해 주세요.");
                    return;
                }
            }

            if (head == null) {
                head = grapic;
            } else {
                tail.setNext(grapic);
            }
            tail = grapic;
        }

        public void print() {
            Shape s = head;
            while (s != null) {
                s.draw();
                s = s.getNext();
            }
        }

        public void delete(int num) {
            Shape cur = head;
            Shape tmp = head;
            int i;

            if (num == 1) {
                if (head == tail) {
                    head = null;
                    tail = null;
                } else { // 노드가 두개 이상
                    head = head.getNext();
                }
                return;
            }

            for (i = 1; i < num; i++) {
                tmp = cur;
                cur = cur.getNext();
                if (cur == null) {
                    System.out.println("삭제할 수 없습니다.");
                    return;
                }
            }

            if (i == num) {
                tmp.setNext(cur.getNext());
                tail = tmp;
            } else {
                tmp.setNext(cur.getNext());
            }
        }

        public static void main(String[] args) {
            GraphicEditor editor = new GraphicEditor();
            editor.run();
        }
    }
}
