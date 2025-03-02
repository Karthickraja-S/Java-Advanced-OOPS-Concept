
public class GameValidator {
    public static boolean validateRow(char [][]matrix , char ch , int rowChosen) {
        int ctr=0;
        for(int c=0; c<matrix.length; c++) {
            if(matrix[rowChosen][c]==ch){
                ctr++;
            }
        }
        return ctr == matrix.length;
    }

    public static boolean validateCol(char[][] matrix, char ch,int colChosen) {
        int ctr=0;
        for(int row=0; row<matrix.length;row++) {
            if(matrix[row][colChosen]==ch){
                ctr++;
            }
        }
        return ctr == matrix.length;
    }

    public static boolean validateCross(char[][] matrix, char ch) {
        // Diagonal
        int ctr=0;
        for(int row=0;row<matrix.length;row++) {
            if(matrix[row][row] == ch) {
                ctr++;
            }
        }
        if(ctr==matrix.length){
            return true;
        }
        // Anti Diagonal
        ctr=0;
        for(int row=0;row<matrix.length;row++) {
            if(matrix[row][matrix.length - row - 1] == ch) {
                ctr++;
            }
        }
        return ctr == matrix.length;
    }
}
