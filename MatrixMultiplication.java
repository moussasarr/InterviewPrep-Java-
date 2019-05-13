public class MatrixMultiplication {
  // Dumb brute-force matrix multiplication
  // Goes in cubic time---Extremely slow
  public static int[][] bruteForceMultiply( int[][] matrix1, int[][] matrix2){
        // first row of Matrix 1
        int[] row0 = matrix1[0];
        // Number of columns in Matrix 1
        int numColums1 = row0.length;
        //number of rows in second matrix
        int numRows2 = matrix2.length;
        if (numColums1 != numRows2){
           int[][] emptyArray = new int[0][0];
           return emptyArray;
        }

        int numRows1 = matrix1.length;
        int[] firstRowMatrix2 = matrix2[0];
        int numColumns2 = firstRowMatrix2.length;
        int[][] result = new int[numRows1][numColumns2];
        //Loop through all the rows of Matrix 1
        for(int i = 0; i < numRows1; i++){
          for(int j = 0; j < numColumns2; j++){
            result[i][j] = 0;
            for(int k = 0; k < numColums1; k++){
              result[i][j] += matrix1[i][k] * matrix2[k][j];
            }
          }
        }
        return result;
  }

   public static void main(String[] args){
     int[][] A = new int[][]{{2, 5, 8}, {3, 6 , 8}};
     int[][] B = new int[][]{{4, 5}, {-3, 1}, {4, 2}};
     int[][] C = bruteForceMultiply(A, B);

     for(int i = 0 ; i < C.length; i ++){
       int[] row = C[i];
       for(int j = 0; j < row.length; j++){
         System.out.print(" " + row[j] + " ");
       }
        System.out.println("");
     }
   }




}
