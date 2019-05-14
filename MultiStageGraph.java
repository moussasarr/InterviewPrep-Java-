//Solving the multi-stage graph problem
// using dynamic programming
import java.util.Arrays;

public class MultiStageGraph {

  public static int[] shortestPath(int[][] costAdjacencyMatrix){
    int len = costAdjacencyMatrix.length;
    int numVertices = len - 1;

    //Shortest path Vertex
    int[] path = new int[numVertices];
    //Cost for each vertex
    int[] cost = new int[len];

    //Optimal direction vertex from each vertex
    int[] d = new int[len];

    //Initializing for (joint) or last vertex in path
    cost[numVertices] = 0;
    d[numVertices] =  numVertices;

    //Finding costs array and optimal direction vertex array
    for(int i = numVertices - 1; i >= 1; i--){
      cost[i] = Integer.MAX_VALUE;
      for(int j = i + 1; j <= numVertices; j++){
        if(costAdjacencyMatrix[i][j] != 0) {
           int min = Math.min(cost[i], costAdjacencyMatrix[i][j] + cost[j]);
           if(min < cost[i]){
             d[i] = j;
           }
           cost[i] = min;
        }
      }
    }


    //Computing optimal optimalPath
    int k = 1;
    int l = 1;
    path[0] = 1;
    while(k < numVertices){
      path[l] = d[k];
      k= d[k]; l++;
    }
    return path;
  }

  public int MinimumDistance(int[][] costAdjacencyMatrix){
    int[] optimalPath = shortestPath(costAdjacencyMatrix);
    int minDist = 0;
    return minDist;
  }

 public static void main(String[] args){
   int[][] am = new int[][]{
                    { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 0, 0, 2, 1, 3, 0, 0, 0, 0 },
                    { 0, 0, 0, 0, 0, 2, 3, 0, 0 },
                    { 0, 0, 0, 0, 0, 6, 7, 0, 0 },
                    { 0, 0, 0, 0, 0, 6, 8, 9, 0 },
                    { 0, 0, 0, 0, 0, 0, 0, 0, 6 },
                    { 0, 0, 0, 0, 0, 0, 0, 0, 4 },
                    { 0, 0, 0, 0, 0, 0, 0, 0, 5 },
                    { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                  };
int[] cost = shortestPath(am);
System.out.println("Shortest path is:");
System.out.println(Arrays.toString(cost));


 }

}
