public class StockBuySellKTimes {


    public static void main(String[] args) {
        int[] arr = {10,8,3,4,6,5,3,12,14};

        StockBuySellKTimes stockBuySellKTimes = new StockBuySellKTimes();
        int[] profit = stockBuySellKTimes.maximizeProfit(arr, 3);
        System.out.println(profit[0]  + " " +  (profit[0] - profit[1]));

    }
    int[] maximizeProfit(int[] arr, int k){
        int [] output = new int[2];
        int fee = 0;
        int i = 0;
        int n = arr.length;
        int profit = 0;
        int buy = arr[0];
        int sell;
        while(i <= n - 1){
            while(arr[i] <= buy && i < n){
                buy = arr[i];
                i++;
            }

            if(i <= n - 1){
                sell = arr[i];
                while(i <= n - 1 && arr[i] >= sell) {
                    sell = arr[i];
                    i++;
                }

                profit  = profit + ( sell - buy );
                fee = fee + k;

                if(i <= n-1)
                {
                    buy = arr[i];

                }
            }
            else{
                break;
            }

        }
        output[0]= profit;
        output[1] = fee;
        return output;




    }
}
