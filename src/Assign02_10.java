public class Assign02_10 {
    public static void main(String[] args) {
        int[][] result = new int[4][4];
        int count = 0, row, col;

        while (count < 10) {
            row = (int) (Math.random() * 4);
            col = (int) (Math.random() * 4);

            if (result[row][col] == 0) {
                result[row][col] = (int) (Math.random() * 10 + 1);
                count++;
            }
        }

        for (int[] resultRow : result) {
            for (int resultElement : resultRow) {
                System.out.printf("%d\t", resultElement);
            }
            System.out.println();
        }
    }
}
