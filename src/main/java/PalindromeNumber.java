public class PalindromeNumber {


    int reverse(int n){
        int rev = 0;
        while(n > 0){
            rev = rev * 10 + n % 10;
            n = n / 10;
        }
        return rev;
    }

    boolean isPalindrome(int n){
        int rev = reverse(n);
        return rev == n;
    }
    public static void main(String[] args) {
            int n = 670;
            PalindromeNumber palindromeNumber = new PalindromeNumber();
            System.out.println(palindromeNumber.isPalindrome(n));
    }
}
