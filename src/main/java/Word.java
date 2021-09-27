import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Word {

    private static final String VOWEL = "a e i o u";

    public static long countVowels(String word) {
        long count = 0;
        count += word.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> VOWEL.contains(c.toString()))
                .count();

        return count;
    }

    public static List<Character> getDistinctVowelsOrder(String word){
        return word.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> VOWEL.contains(c.toString()))
                .distinct()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
    }

    public static String generateKeyFromVowelsAndSize(String word) {
        List<Character> vowels = getDistinctVowelsOrder(word);
        if (vowels != null && !vowels.isEmpty()) {
            String keyVowel = vowels.stream()
                    .map(n -> String.valueOf(n))
                    .collect(Collectors.joining(", ", "{", "}"));
            return "(" + keyVowel + ", " + word.length() + ")";
        }
        return null;
    }

    public static String removePunctuation(String word) {
        return word.replaceAll("[^a-zA-Z ]", "");
    }
}
