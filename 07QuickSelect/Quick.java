import java.util.*;
public class Quick{
  public static String name(){
      return "6,Agarwala,Vandana";
  }
  public static int quickselectOld(int[] array, int n) {
    return selectiveOld(array, 0, array.length - 1, n);
  }
  
  private static int selectiveOld(int[] array, int left, int right, int n) {
    if(left == right) {
      return array[left];
    }
    
    for(;;) {
      int pivotIndex = randomPivot(left, right);
      pivotIndex = partitionOld(array, left, right, pivotIndex);
      if(n == pivotIndex) {
        return array[n];
      } else if(n < pivotIndex) {
        right = pivotIndex - 1;
      } else {
        left = pivotIndex + 1;
      }
    }
  }
  private static int partitionOld(int[] array, int left, int right, int pivotIndex) {
    int pivotValue = array[pivotIndex];
    swap(array, pivotIndex, right); // move pivot to end
    int storeIndex = left;
    for(int i = left; i < right; i++) {
      if(array[i] > pivotValue) {
        swap(array, storeIndex, i);
        storeIndex++;
      }
    }
    swap(array, right, storeIndex); // Move pivot to its final place
    return storeIndex;
  }
  
  private static void swap(int[] array, int a, int b) {
    int tmp = array[a];
    array[a] = array[b];
    array[b] = tmp;
  }
  private static int randomPivot(int left, int right) {
    return left + (int)(Math.random() * (right - left + 1));
  }

  public static void quickSortOld(int[] array){
    quicksortOld(array, 0, array.length -1);
  }

  public static void quicksortOld(int[] array, int left, int right){
    if (left< right){
      int pivotIndex = randomPivot(left, right);
      int index = partitionOld(array, left, right, pivotIndex);
      quicksortOld(array, left, index -1);
      quicksortOld(array, index + 1, right);
    }
  }

  private static void quickSort(int[] a){
    quickSort(a, 0, a.length - 1);
  }

  private static void quickSort(int[] a, int lo, int hi)
  {
    if (hi <= lo) return;
    int lt = lo, gt = hi;
    int v = a[lo];
    int i = lo;
    while (i <= gt)
    {
    if (a[i] < v) swap(a, lt++, i++);
    else if (a[i] > v) swap(a, i, gt--);
    else i++;
    }
    quickSort(a, lo, lt - 1);
    quickSort(a, gt + 1, hi);
  } 

  public static void main(String[] args) {
    int[] a = new int[4000000];
    int[] a2 = new int[4000000];
    int[] a3 = new int[4000000];
    int[] b = new int[4000000];
    int[] b2 = new int[4000000];
    int[] b3 = new int[4000000];
    for (int i = 0; i < a.length; i++){
      a[i] = (int)(Math.random() * Integer.MAX_VALUE);
      a2[i] = a[i];
      a3[i] = a[i];
      b[i] = (int)(Math.random() * 4);
      b2[i] = b[i];
      b3[i] = b[i];
    }
     /* 
    for(int i = 0; i < array.length; i++) {
      System.out.print(quickselect(array, i));
    }
    */
/*
    quickSort(array);
    for(int i = 0; i < array.length; i++) {
      System.out.print(array[i] + ' ');
    }
    */
    /*
    int[] c = new int[40000];
    for (int i = 0; i < c.length; i++){
      c[i] = (int)(Math.random() * 4);
    }
    long startTime = System.currentTimeMillis();
    quickSort(c);
    long endTime = System.currentTimeMillis();
    System.out.println("c took " + (endTime - startTime) + " milliseconds");
  */
    
    long startTime = System.currentTimeMillis();
    Arrays.sort(a);
    long endTime = System.currentTimeMillis();
    System.out.println("a1 took " + (endTime - startTime) + " milliseconds");

    startTime = System.currentTimeMillis();
    quickSort(a2);
    endTime = System.currentTimeMillis();
    System.out.println("a2 took " + (endTime - startTime) + " milliseconds");

    startTime = System.currentTimeMillis();
    quickSort(a3);
    endTime = System.currentTimeMillis();
    System.out.println("a3 took " + (endTime - startTime) + " milliseconds");

    startTime = System.currentTimeMillis();
    Arrays.sort(b);
    endTime = System.currentTimeMillis();
    System.out.println("b1 took " + (endTime - startTime) + " milliseconds");
    /*
    startTime = System.currentTimeMillis();
    quickSort(b2);
    endTime = System.currentTimeMillis();
    System.out.println("b2 took " + (endTime - startTime) + " milliseconds");
    */
    startTime = System.currentTimeMillis();
    quickSort(b3);
    endTime = System.currentTimeMillis();
    System.out.println("b3 took " + (endTime - startTime) + " milliseconds");
    

  }
  
}