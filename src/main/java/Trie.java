
import java.util.HashMap;
import java.util.Map;

class TrieNode{
    char c;
    Map<Character, TrieNode> children;
    boolean isEnd;
    int frequency;

    public TrieNode() {
        children = new HashMap<>();
        isEnd = false;
        frequency = 0;
    }

    public TrieNode(char c) {
        this.c = c;
        children = new HashMap<>();
        isEnd = false;
        frequency = 0;
    }

    @Override
    public String toString() {
        return  " " +  c ;
    }
}


public class Trie {

    public TrieNode root = new TrieNode();

    public void insert(String word){
       Map<Character, TrieNode> children = root.children;


       for(int i =0 ; i< word.length();i++){
           char c = word.charAt(i);
           TrieNode t;
           if(children.containsKey(c)) {
               t = children.get(c);

           }else{
               t = new TrieNode(c);
               children.put(c, t);
           }
           t.frequency++;
           children = t.children;
           if(i == word.length() - 1){
               t.isEnd = true;
               System.out.println("Inserted " + word + " end leaf is" + t);
           }

       }
    }

    public boolean search(String word){
        Map<Character, TrieNode> children = root.children;
        TrieNode t = null;
        for(int i =0 ; i< word.length();i++) {
            char c = word.charAt(i);

            if(children.containsKey(c)) {
                t = children.get(c);
                children = t.children;

            }else{
                return false;
            }

        }
        if(t.isEnd){
            return true;
        }
        return false;
    }

    public void prefix(TrieNode trieNode, String prefix){
        if(trieNode.frequency == 1){
            System.out.println(prefix + trieNode.c);
            return;
        }
        if(trieNode.isEnd){
            System.out.println(prefix + trieNode.c);
        }
        for(char c : trieNode.children.keySet()){

                prefix(trieNode.children.get(c),prefix + trieNode.c);

        }

    }


    public static void main(String args[]){
        Trie trie = new Trie();
        trie.insert("dog");
        trie.insert("apple");
        trie.insert("apricot");
        trie.insert("fish");
        trie.insert("fi");

        trie.prefix(trie.root, "");
    }
}
