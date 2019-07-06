public class SortSqaures {

    public static void main(String[] args) {
        int[] arr = {9, 12, 91};
        int n = arr.length;
        int zeroIndex = 0;
        int cp = 0;
        int cn = 0;
        int i = 1;
        while(zeroIndex < n && arr[zeroIndex] != 0){
            zeroIndex++;

        }
        if(zeroIndex == n){
            i = 0;
            while(cp < n && arr[cp] < 0 ){
                cp++;
            }
            cn = cp - 1;
        }else{
            cn = zeroIndex -1;
            cp = zeroIndex + 1;
            System.out.print(arr[zeroIndex] + " ");
        }
        while(i < n){
            if(cp == n){
                System.out.print(arr[cn] * arr[cn] + " ");
                cn--;
                i++;

            } else if(cn == -1){
                System.out.print(arr[cp] * arr[cp] + " ");
                cp++;
                i++;

            }
            else if( Math.abs(arr[cn]) < arr[cp]){

                System.out.print(arr[cn] * arr[cn] + " ");
                cn--;
                i++;

            } else{


                System.out.print(arr[cp] * arr[cp] + " ");
                cp++;
                i++;
            }
        }

    }
}
