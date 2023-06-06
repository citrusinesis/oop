import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Assign06_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Point> pointMap = new HashMap<>();

        System.out.println("** 포인트 관리 프로그램입니다 **");
        while (true) {
            System.out.print("이름과 포인트 입력>> ");

            String name = scanner.next();
            int point = scanner.nextInt();
            if (name.equals("그만")) break;

            if (pointMap.containsKey(name)) {
                Point old = pointMap.get(name);
                old.setPoint(old.getPoint() + point);
            } else {
                pointMap.put(name, new Point(name, point));
            }

            pointMap.keySet()
                    .stream()
                    .map(pointMap::get)
                    .forEach(System.out::print);
            System.out.println();
        }
    }

    static class Point {
        private final String name;
        private int point;

        public Point(String name, int point) {
            this.name = name;
            this.point = point;
        }

        @Override
        public String toString() {
            return "(" + name + "," + point + ")";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Point point1 = (Point) o;
            return point == point1.point
                    && Objects.equals(name, point1.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, point);
        }

        public int getPoint() {
            return point;
        }

        public void setPoint(int point) {
            this.point = point;
        }
    }
}
