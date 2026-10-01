class Solution {

    static boolean findEmptyCell(char[][] board, int[] empty){
    
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j] == '.'){
                    empty[0] = i;
                    empty[1] = j;
                    return true;
                }
            }
        }
        return false;
    }

    static boolean safeToPlace(char[][] board, char charValue, int rowIdx, int colIdx){

        for(int i=0;i<9;i++){
            if(board[rowIdx][i] == charValue){
                return false;
            }
        }

        for(int j=0;j<9;j++){
            if(board[j][colIdx] == charValue){
                return false;
            }
        }

        int startRow = rowIdx/3 * 3;
        int startCol = colIdx/3 * 3;

        for(int i=startRow;i<startRow+3;i++){
            for(int j=startCol; j<startCol+3;j++){
                if(board[i][j]==charValue){
                    return false;
                }
            }
        }

        return true;
        
    }

    static boolean solveSudokoSolver(char[][] board){

        int[] emptyCell = new int[2];
        if(!findEmptyCell(board, emptyCell)){
            return true;
        }

        int rowIdx = emptyCell[0];
        int colIdx = emptyCell[1];

        for(int i=1;i<=9;i++){
            char charValue = (char) (i + '0');
            if(safeToPlace(board,charValue, rowIdx,colIdx)){
                board[rowIdx][colIdx] = charValue;
                if(solveSudokoSolver(board) == true){
                    return true;
                }
                board[rowIdx][colIdx] = '.';
            }

        }
        return false;

    }
    
    public void solveSudoku(char[][] board) {
        solveSudokoSolver(board);
    }
}