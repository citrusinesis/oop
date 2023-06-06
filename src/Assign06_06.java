import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Assign06_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Location> cityMap = new HashMap<>();

        System.out.println("도시, 경도, 위도를 입력하세요.");
        for (int i = 0; i < 4; i++) {
            System.out.print(">> ");
            Location city = new Location(scanner.nextLine().split(", "));
            cityMap.put(city.name, city);
        }

        System.out.println("------------------------------");

        cityMap.keySet()
                .stream()
                .map(cityMap::get)
                .forEach(System.out::println);

        System.out.println("------------------------------");

        while (true) {
            System.out.print("도시 이름 >> ");

            String query = scanner.next();
            if (query.equals("그만")) break;

            if (!cityMap.containsKey(query)) {
                System.out.println(query + "는 없습니다.");
                continue;
            }

            System.out.println(cityMap.get(query));
        }
    }

    static class Location {
        private final String name;
        private final int longitude;
        private final int latitiude;

        Location(String[] params) {
            if (params.length != 3)
                throw new IllegalStateException("Number of Location params should be 3.");

            this.name = params[0];
            this.longitude = Integer.parseInt(params[1]);
            this.latitiude = Integer.parseInt(params[2]);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Location location = (Location) o;

            return longitude == location.longitude
                    && latitiude == location.latitiude
                    && Objects.equals(name, location.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, longitude, latitiude);
        }

        @Override
        public String toString() {
            return name + '\t' + longitude + '\t' + latitiude;
        }
    }
}
