class Utils0001{
    public int findIndexOfItemInAnArray(int[] arr, int num){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == num){
                return i;
            }
        }

        return -1;
    }

    public int countNegativeNumbersInAnArray(int[] arr){
        int count = 0;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] < 0){
                count++;
            }
        }
        
        return count;
    }

    public int largestNumberInAnArray(int[] arr){
        int largestNum = 0;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] > largestNum){
                largestNum = arr[i];
            }
        }
        
        return largestNum;
    }

    public int largestNumberInAnArrayWithNumbers(int[] arr){
        int largestNum = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] > largestNum){
                largestNum = arr[i];
            }
        }
        
        return largestNum;
    }

    public int findSecondLargetNumberInAnArray(int[] arr){
        int largestNum = Integer.MIN_VALUE;
        int secondLargestNum = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] > largestNum){
                secondLargestNum = largestNum;
                largestNum = arr[i];
            } else if (arr[i] > secondLargestNum && arr[i] != largestNum){
                secondLargestNum = arr[i];
            }
        }
        
        return secondLargestNum;
    }
}

class DSA0001ForLoop{
    public static void main(String[] args){
        Utils0001 utils = new Utils0001();

        /**
         * Write a function that searches for an element in an array and returns the index, 
         * if the element is not present then return -1.
         */
        int[] array1 = {4, 2, 0, 10, 8, 30};

        System.out.println(utils.findIndexOfItemInAnArray(array1, 10));;
        System.out.println(utils.findIndexOfItemInAnArray(array1, 7));;



        /**
         * write a function that returns the number of negative numbers in an array
         */
        int[] array2 = {2, -9, 17, 0, 1, -10, -4, 8};

        System.out.println(utils.countNegativeNumbersInAnArray(array2));



        /**
         * write a function that returns the largest number in an array
         */
        int[] array3 = {5, 0, 7, 10, 8, 17, 1};

        System.out.println(utils.largestNumberInAnArray(array3));



        /**
         * write a function that returns the largest number in an array, array can have negative numbers
         */
        int[] array4 = {-13, -17, -5, -347, -5, -234444, -1};

        System.out.println(utils.largestNumberInAnArrayWithNumbers(array4));



        /**
         * Find second largest number in an array
         */
        int[] array5 = {4, 9, 0, 2, 8, 9, 7, 1};

        System.out.println(utils.findSecondLargetNumberInAnArray(array5));



        /**
         * Always ask interviewer for negative cases like -
         * what if array is empty.
         * what if array has only one element.
         * what if array has duplicates.
         * what if array has negative numbers.
         */ 
    }
}