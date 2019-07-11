/**
 * Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.
 *
 * For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].
 *
 * Follow-up: what if you can't use division?
 */
public class ProductArray {

    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 9, 2 , 8};

        int n = arr.length;
        int product[] = new int[n];
        int previous = arr[0];
        int next = arr[n - 1];

        for(int k =0; k<= n - 1; k++){
            product[k] = 1;
        }
        for(int i = 1 ; i < n ; i++){
            product[i] = product[i] * previous;
            previous = previous * arr[i];
        }
        for(int j = n - 2; j >= 0 ; j--){
            product[j] = product[j] * next;
            next = next * arr[j];
        }

        System.out.println(" ");
        for(int p =0; p <= n - 1; p++){
            System.out.println(arr[p] + " > " + product[p]);

        }

    }
}
