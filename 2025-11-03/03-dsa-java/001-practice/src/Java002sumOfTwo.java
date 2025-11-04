import java.util.Arrays;

public class Java002sumOfTwo {
    static int[] arr01 = {2,7,11,15};
    static int[] arr02 = {3,2,4};
    static int[] arr03 = {3,2,4,8,9,17};

    static int[] sumOfTwo(int[] arr, int target){
        for(int i = 0; i < arr.length; i++){
            for(int j = i + 1; j < arr.length; j++){
                if(arr[i] + arr[j] == target){
                    return new int[] {i, j};
                }
            }
        }
        return new int[0];
    }



    static int[] pricePerDay1 = {7,1,5,6,4};
    static int[] pricePerDay2 = {7,6,4,3,1};

    static int findMaxProfit(int[] arr){
        int profit = 0;
        for(int i = 0; i < arr.length; i++){
            for(int j = i + 1; j < arr.length; j++){
                if(arr[j] - arr[i] > profit){
                    profit = arr[j] - arr[i];
                }
            }
        }
        return profit;
    }
    public static void main(String[] args){
        System.out.println(Arrays.toString(sumOfTwo(arr01, 26)));
        System.out.println(Arrays.toString(sumOfTwo(arr02, 6)));
        System.out.println(Arrays.toString(sumOfTwo(arr03, 20)));
        
        System.out.println(findMaxProfit(pricePerDay1));
        System.out.println(findMaxProfit(pricePerDay2));
    }
}
