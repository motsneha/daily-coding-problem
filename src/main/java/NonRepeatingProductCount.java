/*
Persons A and B uses an encryption based system for their conversation.
Each conversation message is encoded from the source and decoded in the destination using a shared private positive number key known to each other.

The algorithm is illustrated with an example.

Input Format with explanation:
1. Operation (1 for Encoding and 2 for Decoding)
2. Input message
3. Input private key

Output Format with explanation:
1. Output message

Example 1:

Input:
1
Open
123

Output:
Oppeeen

Here, the input message characters are duplicated based on each digit in the key.

Example 2:

Input:
2
Oppeeen
123

Output:
Open

Here, the input message characters are compressed based on each digit in the key.

The conversation message and the private key need NOT be in equal length and the encoding / decoding takes place till the end is reached in either the conversation message or private key, while retaining the rest of the conversation message.

Returns -1 in all exception scenarios

 */

import java.io.*;


public class NonRepeatingProductCount {



    // Complete the nonRepeatingDigitProductCount function below.
    static int nonRepeatingDigitProductCount(int x, int y, int z) {
        int count = 0;
        for(int i = y; i <= z; i++){

            long nd = digitFrequency(String.valueOf(i));
            long product =  i * x;
            long pd = digitFrequency(Long.toString(product));
            //System.out.println(i + " " + pd + " " + nd);
            if((pd & nd) == 0){

                count++;
            }
        }
        return count;
    }
    static long digitFrequency(String product){
        //System.out.println(product);
        long result = 0;
        for(int s = 0; s < product.length(); s++){
            int digit = Character.getNumericValue(product.charAt(s));
            //System.out.println(digit);
            long temp = 1;
            for(int i = 0; i < digit ; i++){
                temp = temp << 1;
            }
            result = result | temp;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int x = Integer.parseInt(bufferedReader.readLine().trim());

        int y = Integer.parseInt(bufferedReader.readLine().trim());

        int z = Integer.parseInt(bufferedReader.readLine().trim());

        int res = nonRepeatingDigitProductCount(x, y, z);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
