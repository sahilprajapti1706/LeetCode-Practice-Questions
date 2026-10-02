class Solution {

    static int[] findCordinates(int value, int n) {
        int[] cor = new int[2];

        value--;

        int row = n - 1 - value / n;
        int col = value % n;

        if ((n - 1 - row) % 2 == 1) {
            col = n - 1 - col;
        }

        cor[0] = row;
        cor[1] = col;

        return cor;
    }

    public int snakesAndLadders(int[][] board) {

        int n = board.length;

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n * n + 1];

        q.add(1);
        visited[1] = true;

        int steps = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            while (size > 0) {

                int currValue = q.remove();

                if (currValue == n * n) {
                    return steps;
                }

                for (int dice = 1; dice <= 6; dice++) {

                    int next = currValue + dice;

                    if (next > n * n) {
                        continue;
                    }

                    int[] cord = findCordinates(next, n);

                    int row = cord[0];
                    int col = cord[1];

                    // Snake or ladder
                    if (board[row][col] != -1) {
                        next = board[row][col];
                    }

                    if (!visited[next]) {
                        visited[next] = true;
                        q.add(next);
                    }
                }

                size--;
            }

            steps++;
        }

        return -1;
    }
}