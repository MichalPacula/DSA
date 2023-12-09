public class LinearSearch {
    public static int linearSearch(int[] array, int num){
        for(int i = 0; i < array.length; i++){
            if(array[i] == num){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int[] array = new int[1000000];
        for(int i = 0; i < 1000000; i++){
            array[i] = i;
        }
        long startTime = System.currentTimeMillis();
        System.out.println(linearSearch(array, 1000000));
        long endTime = System.currentTimeMillis();
        System.out.println("The execution of the algorithm took: " + (endTime - startTime) + " milliseconds");
    }
}
