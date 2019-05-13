public class MaxHeap {
  private int size;
  private int capacity;
  private int[] heap ;

  private static int ROOT_INDEX = 1;

  public MaxHeap(int capacity){
    this.capacity = capacity;
    size = 0;
    heap = new int[capacity + 1];
    heap[0] = Integer.MAX_VALUE;
  }


  private static void bubleUp(int pos){
  }

  private static void bubleDown(int pos){
  }

  public void insert(int i){
    heap[size + 1 ] = i;
    bubleUp(size + 1);
    size++;
  }

  public int remove(){
    //Replace Root with last element
    int root = heap[ROOT_INDEX];
    heap[ROOT_INDEX] = heap[size];
    heap[size] = 0;
    bubleDown(ROOT_INDEX);
    size--;
    return root;
  }


  private void maxHeapify(){

  }



}
