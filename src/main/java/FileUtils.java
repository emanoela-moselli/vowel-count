import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileUtils {

    public static List<String> readAllStrings(String path, String characterToSplit) throws IOException {
        List<String> strsToReturn = new ArrayList<>();
        try {
            List<String> fileContent = Files.readAllLines(Paths.get(path));
            fileContent.forEach(fileLine -> strsToReturn.addAll(Arrays.asList(fileLine.split(characterToSplit))));
            return strsToReturn;
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static void write(String path, String content) {
        try {
            Files.write(Paths.get(path), content.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
