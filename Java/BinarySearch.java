public class BinarySearch {
    public static int binarySearch(int[] array, int number){
        int low = 0;
        int high = array.length;
        do{
            int mid = (int) Math.floor((low + (high - low) / 2));
            int value = array[mid];
            if(value == number){
                return mid;
            } else if (value < number) {
                low = mid + 1;
            } else {
                high = mid;
            }
        } while (low < high);

        return -1;
    }

    public static void main(String[] args){
        long startTimeCreatingArray = System.currentTimeMillis();
        int[] array = new int[1000000000];
        for(int i = 0; i < 1000000000; i++){
            array[i] = i;
        }
        long endTimeCreatingArray = System.currentTimeMillis();
        System.out.println("Creating the array took: " + (endTimeCreatingArray - startTimeCreatingArray) + " milliseconds");
        long startTime = System.currentTimeMillis();
        System.out.println(binarySearch(array, -1));
        long endTime = System.currentTimeMillis();
        System.out.println("The execution of the algorithm took: " + (endTime - startTime) + " milliseconds");
    }
}
