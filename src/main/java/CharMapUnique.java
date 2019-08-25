

/*
Determine whether there exists a one-to-one character mapping from one string s1 to another s2.

 */
public class CharMapUnique {

    boolean charMappingExist(String s1, String s2){
        char[] arr1 = new char[26];
        char[] arr2 = new char[26];
        for(int i = 0; i < 26; i++){
            arr1[i] = '\u0000';
            arr2[i] = '\u0000';
        }
        if(s1.length() == 0 || s2.length() == 0 || s1.length() != s2.length()){
            return false;
        }
        for(int i = 0; i < s1.length(); i++){
            int s1CharIndex = s1.charAt(i) - 97;
            int s2CharIndex = s2.charAt(i) - 97;
            if(arr1[s1CharIndex] == '\u0000' ){
                if(arr2[s2CharIndex] == '\u0000'){
                    arr1[s1CharIndex] = s2.charAt(i);
                    arr2[s2CharIndex] = s1.charAt(i);
                }else{
                    return false;
                }
            }else{
                if(arr1[s1CharIndex] == s2.charAt(i)){
                    if(arr2[s2CharIndex] == s1.charAt(i)){
                        continue;
                    }else{
                        return false;
                    }
                }else {
                    return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        CharMapUnique charMapUnique  = new CharMapUnique();
        System.out.println(charMapUnique.charMappingExist("foo", "bar"));
        System.out.println(charMapUnique.charMappingExist("foo", ""));
        System.out.println(charMapUnique.charMappingExist("", ""));
        System.out.println(charMapUnique.charMappingExist("abc", "bcd"));
    }
}
