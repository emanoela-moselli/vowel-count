import java.text.DecimalFormat;
import java.util.*;

public class VowelOutput {

    String key;
    Integer wordSize;
    List<String> words;
    Double average;

    public VowelOutput(String word) {
        key = Word.generateKeyFromVowelsAndSize(word);
        words = new ArrayList<>();
        words.add(word);
        average = calculateAverage();
        wordSize = word.length();
    }

    public void addWord(String word) {
        words.add(word);
    }

    public String getKey() {
        return key;
    }

    public Double getAverage() {
        return average;
    }

    public Integer getWordSize(){
        return wordSize;
    }
    private Double calculateAverage() {
        return words.size() == 0 ? 0 :((double)countVowelsInWords(words))/words.size();
    }

    private long countVowelsInWords(List<String> words) {
        long count = 0;
        for (String word : words) {
            count += Word.countVowels(word);
        }
        return count;
    }

    @Override
    public String toString() {
        DecimalFormat formatter = new DecimalFormat("#.##");
        return getKey() + " -> " + formatter.format(calculateAverage());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VowelOutput that = (VowelOutput) o;
        return Objects.equals(key, that.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }
}

