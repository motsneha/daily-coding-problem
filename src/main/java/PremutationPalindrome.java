/**
 * Given a string, determine whether any permutation of it is a palindrome.
 * For example, carrace should return true, since it can be rearranged to form racecar, which is a palindrome. daily should return false,
 * since there's no rearrangement that can form a palindrome.
 */

public class PremutationPalindrome {
    public static void main(String[] args) {
        int [] frequency = new int[128];
        String input = "asdodsa";
        int n = input.length();
        if(n == 0){
            System.out.println(false);
            return;
        }

        for(int p = 0; p < 128; p++){
            frequency[p] = 0;
        }

        for(int i = 0; i < n;i++){
            char c = input.charAt(i);
            frequency[c]++;
        }
        int oddCharCount = 0;
        for(int j=0; j< frequency.length; j++){
            if(frequency[j] % 2 != 0){
                oddCharCount++;
            }
        }
        if(oddCharCount > 1){
            System.out.println(false);
        }else{
            System.out.println(true);
        }

    }
}
