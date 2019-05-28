public class PerfectNumber {
    public static void main(String[] args) {
        Integer n = 10;



        int nthElement = 19 + (n - 1) * 9;
        int outliersCount = (int)Math.log10(nthElement) - 1;

        // find the nth perfect number
        nthElement += 9 * outliersCount;
        System.out.println(nthElement);

        int sum = 0;
        int m = n;
        int a = 0;
        while(m >0){
            a = m %10;
            m = m /10;
            sum = sum + a;
        }

        System.out.println(a);

        System.out.println(n + "" + (10 - sum));

    }
}
