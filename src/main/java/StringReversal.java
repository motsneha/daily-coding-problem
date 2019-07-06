
public class StringReversal {

    public static void main(String[] args) {
      String text = "Hello World Here";

      String[] words = text.split(" ");
      String reversedText  = new String();
      for(int i = words.length - 1;  i >= 0; i--){
          reversedText = reversedText + " " +  words[i];
      }

        System.out.println(reversedText);

      String[] textMutable = {"Here", "World"};
      int n = textMutable.length;

      for(int i = 0;  i < (textMutable.length -1) / 2; i++){
          String temp  = textMutable[i];
          textMutable[i] = textMutable[(n - 1) - i];
          textMutable[(n - 1) - i] = temp;
      }

        for(int i = 0; i< n; i++){
            System.out.println(textMutable[i]);
        }

        StringBuffer str = new StringBuffer("hello");
        str.deleteCharAt(1);
        str.insert(1, 'w');
        str.replace(1,1,"w");
        System.out.println(str);
    }
}

