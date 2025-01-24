import java.util.HashMap;
import java.util.Map;
import java.util.Set;
public class Main {
    public static void main (String args []) {
        String [] words = {
                "Петрушка","Укропчик","Огурчик","Морковь","Салат","Помидорка",
                "Укропчик","Укропчик","Горошек","Лучок","Перчик","Тыковка","Тыковка"};
        Map<String,Integer> wordCount = new HashMap<>();
        for (String word: words) {
            wordCount.put(word,wordCount.getOrDefault(word,0)+1);
        }
        Set<String> uniqueWords = wordCount.keySet();
        System.out.println();
        for (String uniqueWord: uniqueWords) {
            System.out.println( uniqueWord + ": " + wordCount.get(uniqueWord));
        }
    }
    }
