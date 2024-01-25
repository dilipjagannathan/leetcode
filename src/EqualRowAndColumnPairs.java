import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class EqualRowAndColumnPairs {
    public int equalPairs(int[][] grid) {
        int result = 0;
        int n = grid.length;

        Map<String, Integer> rowCounter = new HashMap<>();
        for (int[] row : grid) {
            String rowString = Arrays.toString(row);
            rowCounter.put(rowString, 1 + rowCounter.getOrDefault(rowString, 0));
        }

        for (int c = 0; c < n; c++) {
            int[] colArray = new int[n];
            for (int r = 0; r < n; r++) {
                colArray[r] = grid[r][c];
            }

            result += rowCounter.getOrDefault(Arrays.toString(colArray), 0);
        }

        return result;

    }
}
