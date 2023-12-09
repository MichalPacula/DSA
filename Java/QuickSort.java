import java.util.Arrays;

public class QuickSort {

    public static void qs(int[] array, int low, int high){
        if(low >= high){
            return;
        }

        int pivotIndex = partition(array, low, high);
        qs(array, low, pivotIndex - 1);
        qs(array, pivotIndex + 1, high);

    }

    public static int partition(int[] array, int low, int high){
        int pivot = array[high];

        int index = low - 1;

        for(int i = low; i < high; i++){
            if(array[i] <= pivot){
                index++;
                int tmp = array[i];
                array[i] = array[index];
                array[index] = tmp;
            }
        }

        index++;
        array[high] = array[index];
        array[index] = pivot;
        return index;
    }

    public static void quickSort(int[] array){
        qs(array, 0, array.length - 1);
    }

    public static void main(String[] args){
        int[] array = new int[]{9, 3, 7, 4, 69, 420, 42};
        System.out.println("Array before quick sort: " + Arrays.toString(array));
        quickSort(array);
        System.out.println("Array after quick sort: " + Arrays.toString(array));
    }

}
