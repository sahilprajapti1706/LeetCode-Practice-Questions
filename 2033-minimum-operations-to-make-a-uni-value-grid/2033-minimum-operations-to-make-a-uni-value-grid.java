class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;

        int[] arr = new int[m * n];
        int idx = 0;

        // Flatten the grid into a 1D array
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[idx++] = grid[i][j];
            }
        }

        // Check if all elements have the same remainder
        int rem = arr[0] % x;
        for (int num : arr) {
            if (num % x != rem) {
                return -1;
            }
        }

        // Sort and choose the median
        Arrays.sort(arr);
        int median = arr[arr.length / 2];

        // Calculate minimum operations
        int operations = 0;
        for (int num : arr) {
            operations += Math.abs(num - median) / x;
        }

        return operations;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna