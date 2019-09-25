/**
 * Daily Coding Problem: Problem #197
 * This problem was asked by Amazon.
 * Given an array and a number k that's smaller than the length of the array, rotate the array to the right k elements in-place.
 */
public class ArrayRotation {


    public void rotateArrayToRight(int[] arr, int k){
        int n = arr.length;
        reverseArray(arr, 0, n - 1);
        reverseArray(arr, 0 , k - 1);
        reverseArray(arr, k , n - 1);

    }

    void reverseArray(int[] arr, int start, int end){
       while(start < end){
           int temp = arr[start];
           arr[start] = arr[end];
           arr[end] = temp;
           start++;
           end--;
       }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ArrayRotation arrayRotation = new ArrayRotation();

        arrayRotation.rotateArrayToRight(arr, 6);

        for(int i = 0; i < arr.length; i++){
            System.out.print(" "  + arr[i]);
        }
        System.out.println("");
    }

}
