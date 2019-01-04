import java.util.Arrays;

//Pascal Triangle using 2-d arrays
// Array created through looping -- saves memory
public class PascalTriangle {

  public static int[][] PascalTriangle(int n) {
    int[][] pt = new int[n][];

    for( int i = 0; i < n; i++) {
      pt[i] = new int[i+1];
      pt[i][0] = 1;
      pt[i][i] = 1;

      for(int j = 1; j <= i-1 ; j++) {
        pt[i][j] =  pt[i-1][j-1] + pt[i-1][j];
      }
    }
    return(pt);
  }

  public static void main(String[] args) {
     int [][] pascal = PascalTriangle(10);
            System.out.print(Arrays.deepToString(pascal));
  }

}
