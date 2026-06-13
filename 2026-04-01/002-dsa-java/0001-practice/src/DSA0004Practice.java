class Utils0004 {
    public int countDigitInANumber(int num){

        if(num == 0){
            return 1;
        }

        num = Math.abs(num);

        int count = 0;

        while(num > 0){
            count++;
            num = num / 10;
        }

        return count;
    }

    public String isPalindrome(int num){
        int tempNum = num;
        int revNum = 0;

        while(tempNum > 0){
            revNum = revNum * 10 + tempNum % 10;
            tempNum = tempNum / 10;
        }

        return num == revNum ? "yes" : "no";
    }

    public int reverseInteger(int num){
        int tempNum = Math.abs(num);
        int revNum = 0;
        

        while(tempNum > 0){
            revNum = revNum * 10 + tempNum % 10;
            tempNum = tempNum / 10;
        }

        return num < 0 ? -revNum : revNum;
    }
}

public class DSA0004Practice {
    public static void main(String[] args){
        Utils0004 utils = new Utils0004();



        /**
         * write a functuon that returns the count of digits in a number
         */
        System.out.println(utils.countDigitInANumber(28960)); // 5
        System.out.println(utils.countDigitInANumber(-280)); // 3
        System.out.println(utils.countDigitInANumber(0)); // 1



        /**
         * check palindrome
         * 
         * palindrome is a positive integer number which can be read backward and forward same.
         */
        System.out.println(utils.isPalindrome(121)); // yes
        System.out.println(utils.isPalindrome(-121)); // no
        System.out.println(utils.isPalindrome(21)); // no



        /**
         * reverse an integer
         */
        System.out.println(utils.reverseInteger(123)); // 321
        System.out.println(utils.reverseInteger(-123)); // -321
        System.out.println(utils.reverseInteger(120)); // 21
    }
}
