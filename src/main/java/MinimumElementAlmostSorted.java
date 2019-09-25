/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
Find the minimum element in O(log N) time. You may assume the array does not contain duplicates.

 */
public class MinimumElementAlmostSorted {

    int minimum(int[] arr){
        int start = 0;
        int end = arr.length - 1;
        int mid;
        while(start != end){
            mid = (start + end) / 2;
            if(arr[end] < arr[mid]){
                start = mid + 1;
            }else{
                end  = mid;
            }

        }
        return arr[start];
    }

    public static void main(String[] args) {
        int[] arr = {5, 7, 10, 3, 4};
        int[] arr2 = {1,2,3,4,5};
        MinimumElementAlmostSorted minimumElementAlmostSorted = new MinimumElementAlmostSorted();

        System.out.println(minimumElementAlmostSorted.minimum(arr2));
    }

}
