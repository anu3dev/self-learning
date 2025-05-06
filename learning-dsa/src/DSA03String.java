class DSA03StringEx1 {
	public void checkPalindromeStatus(String str) {
		char[] strArr = str.toCharArray();
		int start = 0;
		int end = str.length() - 1;
		
		String status = "";
		
		while(start < end) {
			if(strArr[start] != strArr[end]) {
				status = " not";
			}
			start++;
			end--;
		}
		System.out.println("Given string is" + status +" palindrome.");
	}
}

public class DSA03String {
	public static void main(String[] args) {
		DSA03StringEx1 exp1 = new DSA03StringEx1();
		
		System.out.println("Given string is palindrome or not:-");
		exp1.checkPalindromeStatus("madam");
		exp1.checkPalindromeStatus("that");
	}
}
