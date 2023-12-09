public class TwoCrystalBalls {
    public static int twoCrystalBalls(boolean[] array){
        int jumpNumber = (int) Math.floor(Math.sqrt(array.length));
        int i = jumpNumber;
        for(; i < array.length; i += jumpNumber){
            if(array[i]){
                break;
            }
        }
        i -= jumpNumber;
        for(; i < array.length; i++){
            if(array[i]){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        boolean[] array = new boolean[]{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true};
        long startTime = System.currentTimeMillis();
        System.out.println(twoCrystalBalls(array));
        long endTime = System.currentTimeMillis();
        System.out.println("The execution of the algorithm took: " + (endTime - startTime) + " milliseconds");
    }

}
