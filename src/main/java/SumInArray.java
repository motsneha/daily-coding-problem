public class SumInArray {
    public static void main(String[] args) {
        int[] arr = {  };


        int sum = 20;
        findelements(arr, sum);

    }

    static void findelements(int[] arr, int sum){
        int n = arr.length;
       if(n >= 1) {
           int front = arr[0];
           int back = arr[n - 1];
           while (front <= back) {
               if (front + back < sum) {
                   front++;
               } else if (sum == front + back) {
                   System.out.println("" + front + " " + back);
                   return;
               } else {
                   back--;
               }
           }
       }
    }
}
