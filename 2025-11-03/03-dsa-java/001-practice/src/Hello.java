import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hello {
    static int[] array001 = {};
    static int[] array002 = {105, 43, 92, 7, 67, 18, 222, 56, 88, 13};

    // Bubble Sort Implementation
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    public static int[] sortAnArray001(int[] arr){
        if(arr.length < 2){
            return arr;
        }

        for(int i = 0; i < arr.length - 1; i++){
            for(int j = 0; j < arr.length - 1 - i; j++){
                if(arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }



    static List<Integer> array003 = new ArrayList<>();
    static List<Integer> array04 = new ArrayList<>(Arrays.asList(105, 43, 92, 7, 67, 18, 222, 56, 88, 13));

    // Quick Sort Implementation
    // Time Complexity: O(n log n) on average
    // Space Complexity: O(n)
    static List<Integer> sortAnArray002(List<Integer> arr){
        if(arr.size() < 2){
            return arr;
        }

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        int pivot = arr.get(arr.size() - 1);

        for(int i = 0; i < arr.size() -1; i++){
            if(arr.get(i) < pivot){
                left.add(arr.get(i));
            } else {
                right.add(arr.get(i));
            }
        }

        List<Integer> sortedArr = new ArrayList<>();
        sortedArr.addAll(left);
        sortedArr.add(pivot);
        sortedArr.addAll(right);

        return sortedArr;
    }
    public static void main(String[] args) {
        //System.out.println("bubble sort: " + Arrays.toString(sortAnArray001(array001)));
        //System.out.println("bubble sort: " + Arrays.toString(sortAnArray001(array002)));

        System.out.println("quick sort: " + sortAnArray002(array003));
        System.out.println("quick sort: " + sortAnArray002(array04));
    }
}
