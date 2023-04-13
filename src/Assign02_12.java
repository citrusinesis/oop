public class Assign02_12 {
    public static void main(String[] args) {
        int result = 0;

        for (String input : args) {
            try {
                result += Integer.parseInt(input);
            } catch (NumberFormatException ignored) {}
        }

        System.out.println(result);
    }
}
