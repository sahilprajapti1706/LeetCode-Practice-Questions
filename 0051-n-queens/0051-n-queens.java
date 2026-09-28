class Solution {

    static boolean isSafeToPlace(int rowIdx, int colIdx, int n, char[][] board){
        int row = rowIdx;
        int col = colIdx;
        while(col>=0){
            if(board[row][col] == 'Q'){
                return false;
            }
            col--;
        }

        row = rowIdx;
        col = colIdx;
        while(row>=0 && col>=0){
            if(board[row][col]=='Q'){
                return false;
            }
            row--;
            col--;
        }

        row = rowIdx;
        col = colIdx;
        while(row<n && col>=0){
            if(board[row][col]=='Q'){
                return false;
            }
            row++;
            col--;
        }

        return true;
    }

    static void solve(char[][] board,int n, int colIdx, List<List<String>> ans){
        if(colIdx>=n){
            List<String> temp = new ArrayList<>();
            for(int i=0;i<n;i++){
                temp.add(new String(board[i]));
            }
            ans.add(temp);
            return;
        }
        

        for(int rowIdx=0; rowIdx<n; rowIdx++){
            if(isSafeToPlace(rowIdx,colIdx, n, board)){
                board[rowIdx][colIdx] = 'Q';
                solve(board,n ,colIdx+1,ans);
                board[rowIdx][colIdx] = '.';
            }
        }
    }
    
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i =0; i<n;i++){
            Arrays.fill(board[i],'.');
        }

        int colIdx = 0;
        List<List<String>> ans = new ArrayList<>();
        
        solve(board,n,colIdx,ans);
        return ans;

    }
}