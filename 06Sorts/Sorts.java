import java.util.Random;
import java.lang.*;
public class Sorts{
	public static void printArray(int[] data){
		String res = "[";
		for (int i = 0; i < data.length; i++){
			res += data[i] + ", ";
		}
		System.out.println(res.substring(0, res.length() - 2) + "]");
	}
	public static void insertionSort(int[] data){
		int n = data.length;
        for (int j = 1; j < n; j++) {
            int key = data[j];
            int i = j-1;
            while ( (i > -1) && ( data [i] > key ) ) {
                data [i+1] = data [i];
                i--;
            }
            data[i+1] = key;
        }
    }

    public static void selectionSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++){
            int index = i;
            for (int j = i + 1; j < arr.length; j++){
                if (arr[j] < arr[index]){
                    index = j;
                }
            }
            int smallerNumber = arr[index];  
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }
    }

    public void bubbleSort(int[] arr) {
        boolean swapped = true;
        int j = 0;
        int tmp;
        while (swapped) {
            swapped = false;
            j++;
            for (int i = 0; i < arr.length - j; i++) {                                       
                if (arr[i] > arr[i + 1]) {                          
                    tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                    swapped = true;
                }
            }
        }
    }

    public static void mergeSort(int [] list) {
        if (list.length > 1) {
        int[] first = new int[list.length / 2];
        int[] second = new int[list.length - first.length];
        System.arraycopy(list, 0, first, 0, first.length);
        System.arraycopy(list, first.length, second, 0, second.length);

        mergeSort(first);
        mergeSort(second);

        merge(first, second, list);
    }
    }
    
    private static void merge(int[] first, int[] second, int [] result) {
        int i1 = 0;
        int i2 = 0;
        
        int j = 0;
        while (i1 < first.length && i2 < second.length) {
            if (first[i1] < second[i2]) {
                result[j] = first[i1];
                i1++;
                } else {
                result[j] = second[i2];
                i2++;
            }
            j++;
        }
        System.arraycopy(first, i1, result, j, first.length - i1);
        System.arraycopy(second, i2, result, j, second.length - i2);
    }

    public static void fillRandom(int[] data){
        Random rand = new Random();
        for(int i = 0; i < data.length; i++){
            data[i] = rand.nextInt();
        }
    }
}