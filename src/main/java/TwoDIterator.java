

public class TwoDIterator {
    int m, n;

    int[][] array ;

    public TwoDIterator(int size){
        this.array = new int[size][];
        m = 0;
        n = -1;
    }

    int next() throws Exception{
        if(m == this.array.length){
            throw new Exception("no more elements");
        }
        n++;
        if(n <= array[m].length - 1){
            return array[m][n];
        }
        n = -1;
        m++;
        return next();



    }

    boolean hasNext(){
        if(m == array.length){
            return false;
        }
        n++;
        if(n <= array[m].length - 1){
            n--;
            return true;
        }
        int tempN = n;
        int tempM = m;
        n = -1;
        m++;
        boolean hasNext = hasNext();
        if(hasNext){
          m = tempM;
          n = tempN - 1;
        }
        return hasNext;

    }


    public static void main(String[] args) throws Exception {
        TwoDIterator twoDArray = new TwoDIterator(4);

        twoDArray.array[0] = new int[]{1, 2};
        twoDArray.array[1] = new int[]{3};
        twoDArray.array[2] = new int[]{};
        twoDArray.array[3] = new int[]{4, 5};


            while(twoDArray.hasNext()){
                System.out.println(twoDArray.next());
            }

    }

}
