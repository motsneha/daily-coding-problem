public class PigeonHole {

    int findDuplicate(int[] arr){
        int n = arr.length;
        for(int i = 0; i < n; i++){
            if(arr[arr[i] - 1] < 0){
                return arr[i];
            }
            arr[arr[i] -1] *= -1;
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,5,11,10,9,7,6,8};
        int[] arr3 = {1,1,3,4,2,5};
        PigeonHole pigeonHole = new PigeonHole();
        System.out.println(pigeonHole.findDuplicate(arr));
        System.out.println(pigeonHole.findDuplicate(arr3));
    }
}
