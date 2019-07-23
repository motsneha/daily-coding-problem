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
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class SecureChannel {



    // Complete the secureChannel function below.
    static String secureChannel(int operation, String message, String key) {
        if(operation != 1 && operation != 2){
            return "-1";
        }
        if(message == null || message.isEmpty()){
            return "-1";
        }

        StringBuilder result = new StringBuilder();
        if(operation == 1){


            int i =0;
            for(; i < key.length(); i++){
                if(i < message.length()){
                    for(int j = 1; j<= Character.getNumericValue(key.charAt(i));j++){
                        result.append(message.charAt(i));
                    }
                }

            }
            if(i == 0 || i < message.length() - 1){
                result.append(message.substring(i));
            }
        }else if(operation == 2){

            int p = 0;
            int k = 0;
            for(; k < key.length();k++){
                int keyNumber = Character.getNumericValue(key.charAt(k));
                if(p >= message.length()){
                    break;
                }
                result = result.append(message.charAt(p));
                p = p + keyNumber;

            }
            if(p == 0 || p < message.length() - 1){
                result.append(message.substring(p));
            }
        }

        return result.toString();

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int operation = Integer.parseInt(bufferedReader.readLine().trim());

        String message = bufferedReader.readLine();

        String key = bufferedReader.readLine();

        String res = secureChannel(operation, message, key);

        bufferedWriter.write(res);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
