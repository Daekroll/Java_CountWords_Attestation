import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class CountWords {
    public static void main(String[] args) {
        ArrayList<String> words = openFile();
        System.out.println("Количество слов: " + words.size());
        maxLengthWord(words);
        System.out.println("Частота встречающихся слов.");
        countWords(words);

    }

    static ArrayList<String> openFile(){
        String[] words;
        ArrayList<String> words2 = new ArrayList<>();
        try {
            String file = Files.readString(Path.of("input.txt"));
            words = file.split(" ");
            for (String string : words) {
                if (string.length()>3){
                    words2.addLast(string);
                }
            }
        } catch (IOException e) {
            words2 = null;
            e.printStackTrace();
        }
        return words2;
    }

    static void maxLengthWord(ArrayList<String> words){
        String temp = words.get(0);
        for (String string : words) {
            if(string.length()>temp.length()){
                temp = string;
            }
        }
        System.out.println("Самое длинное слово: " + temp);
    }

    static void countWords(ArrayList<String> words){
        HashMap<String, Integer> count = new HashMap<>();
        for (String string : words) {
            if(count.containsKey(string)){
                int temp = count.get(string);
                count.put(string, temp+1);
            }else{
                count.put(string, 1);
            }
        }
        count.entrySet().stream()
        .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
        .forEach(System.out::println); 
    }
}


