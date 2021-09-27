
import java.io.IOException;
import java.util.*;

public class VowelProcessor {

    public static String process(List<String> words) {
        List<VowelOutput> vowelsToOutput = new ArrayList<>();
        words.removeIf(str -> str.isEmpty());
        words.forEach(str -> {
            str = Word.removePunctuation(str).toLowerCase();
            VowelOutput vowelToOutput = new VowelOutput(str);
            if (vowelToOutput.getKey() != null) {
                if (vowelsToOutput.contains(vowelToOutput)) {
                    vowelsToOutput.get(vowelsToOutput.indexOf(vowelToOutput)).addWord(str);
                } else {
                    vowelsToOutput.add(vowelToOutput);
                }
            }
        });
        vowelsToOutput.sort(Comparator.comparing(VowelOutput::getAverage)
                .thenComparing(VowelOutput::getWordSize).reversed());

        StringBuilder outputStr = new StringBuilder();
        vowelsToOutput.forEach(i -> outputStr.append(i.toString()).append(System.lineSeparator()));

        return outputStr.toString();
    }

    public static void main(String[] args) throws IOException {
        List<String> allStringsInFile = FileUtils.readAllStrings("src/main/resources/INPUT.TXT", " ");
        String outputStr = VowelProcessor.process(allStringsInFile);

        FileUtils.write("src/main/resources/OUTPUT.TXT", outputStr.toString());

    }
}
