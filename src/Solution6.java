import java.util.*;

public class Solution6 {
    public static int[] findKWeakestRows(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        PriorityQueue <int[]> pq = new PriorityQueue<>((a,b) -> b[0] != a[0] ? b[0] - a[0] : b[1] - a[1]);
        for (int i = 0; i < m; i++) {
            int strength = binarySearch(matrix[i], n);
            pq.offer(new int[] {strength, i});
            if(pq.size() > k) pq.poll();
        }
        int[] indexes = new int[k];
        for (int i = k - 1; i>=0; i--) {
            indexes[i] = pq.poll()[1];
        }
        return indexes;
    }
    private static int binarySearch(int[] row, int n) {
        int low = 0;
        int high = n;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (row[mid] == 1) low = mid + 1;
            else high = mid;
        }
        return low;
    }
    public static void main(String[] args) {
        int[][][] matrixList = {
                {{1, 1, 0, 0, 0}, {1, 1, 1, 1, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 0, 0}, {1, 1, 1, 1, 1}},
                {{1, 1, 0, 0}, {1, 0, 0, 0}, {1, 1, 1, 1}, {1, 1, 0, 0}},
                {{1, 1}, {1, 1}, {0, 0}, {1, 0}, {1, 1}},
                {{1, 0, 0, 0}, {1, 1, 0, 0}, {1, 1, 1, 1}, {1, 0, 0, 0}},
                {{1, 0, 0}, {0, 0, 0}, {1, 1, 1}, {1, 1, 0}}
        };
        int[] kValues = {2, 3, 3, 2, 1};

        for (int i = 0; i < matrixList.length; i++) {
            System.out.println((i + 1) + ".\tInput matrix: \n\tmatrix = " + Arrays.deepToString(matrixList[i]) + "\n\tk = " + kValues[i]);
            int[] weakestRows = new Solution6().findKWeakestRows(matrixList[i], kValues[i]);
            System.out.println("\n\tIndexes of the " + kValues[i] + " weakest rows: " + Arrays.toString(weakestRows));
            System.out.println(new String(new char[100]).replace("\0", "-"));
        }
    }
}