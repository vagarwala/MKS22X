public class Quick{
  public static int quickselect(int[] array, int n) {
    return selective(array, 0, array.length - 1, n);
  }
  
  private static int selective(int[] array, int left, int right, int n) {
    if(left == right) {
      return array[left];
    }
    
    for(;;) {
      int pivotIndex = randomPivot(left, right);
      pivotIndex = partition(array, left, right, pivotIndex);
      if(n == pivotIndex) {
        return array[n];
      } else if(n < pivotIndex) {
        right = pivotIndex - 1;
      } else {
        left = pivotIndex + 1;
      }
    }
  }
  private static int partition(int[] array, int left, int right, int pivotIndex) {
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
    return left + (int) Math.floor(Math.random() * (right - left + 1));
  }
/*
  public static void main(String[] args) {
    int[] array = new int[args.length];
    for (int i = 0; i < args.length; i++){
      array[i] = Integer.parseInt(args[i]);
    }
      
    for(int i = 0; i < array.length; i++) {
      System.out.println(quickselect(array, i));
    }
  }
  */
}