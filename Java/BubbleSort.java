import java.util.Arrays;

public class BubbleSort {
    public static void bubbleSort(int[] array){
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array.length - 1 - i; j++){
                if(array[j] > array[j + 1]){
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args){
        int[] array = new int[]{3, 2, 1, 6, 4, 2, 10, 123, 5};
        long startTime = System.currentTimeMillis();
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
        long endTime = System.currentTimeMillis();
        System.out.println("The execution of the algorithm took: " + (endTime - startTime) + " milliseconds");
    }

}
