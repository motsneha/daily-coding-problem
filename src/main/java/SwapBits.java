public class SwapBits {

/*    Given an unsigned 8-bit integer, swap its even and odd bits. The 1st and 2nd bit should be swapped, the 3rd and 4th bit should be swapped, and so on.

    For example, 10101010 should be 01010101. 11100010 should be 11010001.

*/

    public static void main(String[] args) {

        System.out.println(swapBits(23));
    }

    static int swapBits(int n){
        int result =0;

        int even = n & 0xAAAAAAAA;
        int odds = n & 0x55555555;
        even = even >> 1;
        odds = odds << 1;
        result = even | odds;
        return result;
    }

}
