public class Assign03_04 {
    static class Rectangle {
        int x, y, width, height;

        Rectangle(int x, int y, int width, int height) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }

        int square() {
            return this.x * this.y;
        }

        void show() {
            System.out.printf(
                    "(%d, %d)에서 크기가 %dx%d인 사각형\n",
                    this.x, this.y, this.width, this.height
            );
        }

        boolean contains(Rectangle r) {
            return this.x < r.x && r.x < this.x + this.width
                    && this.y < r.y && r.y < this.y + this.height
                    && r.x + r.width < this.x + this.width
                    && r.y + r.height < this.y + this.height;
        }
    }

    public static void main(String[] args) {
        Rectangle r = new Rectangle(2, 2, 8, 7);
        Rectangle s = new Rectangle(5, 5, 6, 6);
        Rectangle t = new Rectangle(1, 1, 10, 10);
        r.show();

        System.out.println("s의 면적은 " + s.square());
        if (t.contains(r)) System.out.println("t는 r을 포함합니다.");
        if (t.contains(s)) System.out.println("t는 S를 포함합니다.");
    }
}
