public class MinHeap {
   private int size;
   private int capacity;
   private int[] heap;

   public static final int ROOT_POSITION = 1;

   public MinHeap(int capacity) {
     this.capacity = capacity;
     heap = new int[capacity + 1];
     heap[0] = Integer.MIN_VALUE;
     size = 0;
   }

   private boolean isLeaf(int pos){
     return ((2*pos > size) && (2*pos + 1 > size));
   }

   private void bubleDown(int position){
     if(position <= 0 || isLeaf(position)){
       return;
     }
     int leftChildPosition = 2*position;
     int rightChildPosition = 2*position + 1;
     int currentNode = heap[position];
     int leftChild = heap[leftChildPosition];
     int rightChild = heap[rightChildPosition];
     int minIndex;

     if( leftChildPosition > size){
       minIndex = rightChildPosition;
     } else if (rightChildPosition > size){
       minIndex = leftChildPosition;
     } else {
       minIndex = leftChild > rightChild ? rightChildPosition : leftChildPosition;
     }

     int min = heap[minIndex];

     if ((currentNode > min)&& !isLeaf(position)) {
        heap[position] = min;
        heap[minIndex] = currentNode;
        bubleDown(minIndex);
      }
   }

   private void bubleUp(int position){
      if (position <= 1) {
        return;
      }
      int current = heap[position];
      int parent = heap[position/2];
      if (current < parent) {
          heap[position] = parent;
          heap[position/2] = current;
          bubleUp(position/2);
      }
   }

   public void insert(int i) {
     if(size == capacity) {
       System.out.println(
       "Heap is full. Create a new heap of double the current size and copy the elements into the new heap"
       );
     } else {
       int pos = size + 1;
       heap[pos] = i;
       bubleUp(pos);
       size++;
     }
   }

   public int remove() {
     //remove root element
     int toRemove = heap[ROOT_POSITION];
     //replace it with last element
     heap[ROOT_POSITION] = heap[size];
     size--;
     //then buble down new root
     bubleDown(ROOT_POSITION);
     heap[size + 1] = 0;
     return toRemove;
   }

    public static MinHeap heapify(int[] a) {
      //Creating a new empty heap Data Structure
      //Of capacity twice the length of the array
      int aLength = a.length;
      int newCap = 2*aLength;
      MinHeap newHeap = new MinHeap(newCap);
      int[] heapArray = newHeap.heap;


      //Copy Array elements in the heap data structure
      for(int i= 0; i < aLength; i++) {
        heapArray[i+1] = a[i];
        newHeap.size = aLength;
      }
      //Apply the heapify process
      int currentNode = newHeap.size / 2;
      System.out.println(heapArray[currentNode]);
      while(currentNode > 0){
        newHeap.bubleDown(currentNode);
        currentNode--;
      }

      return newHeap;
    }

    public static void main(String[] args){
      System.out.println("Compiled and running ...");
      int[] j = new int[]{ 87, 32, 24, 54, 61, 70, 6, 34, 44, 23, 84, 32, 32, 45, 13, 12, 84, 78, 67,54 };
      System.out.println(j.length);
      heapify(j);


      MinHeap myHeap = heapify(j);
      for(int k : myHeap.heap){
       System.out.println(k);
     }
      myHeap.insert(50);
      myHeap.insert(30);
      myHeap.insert(20);
      myHeap.insert(15);
      myHeap.insert(10);
      myHeap.insert(8);
      myHeap.insert(16);
      myHeap.insert(60);
      myHeap.insert(2);
      myHeap.insert(9);
      for(int i : myHeap.heap){
        System.out.println(i);
      }
       System.out.println("Removed ...");
       System.out.println(myHeap.remove());
       System.out.println(myHeap.remove());
       System.out.println(myHeap.remove());

      for(int i : myHeap.heap){
        System.out.println(i);
      }

      System.out.println(myHeap.size);
    }
   }
