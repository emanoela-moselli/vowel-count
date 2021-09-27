import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.ArrayList;
import java.util.List;

public class FileUtilsTest {


    @Test
    public void testFileExists() throws IOException {
        List<String> words = FileUtils.readAllStrings("src/test/resources/INPUT_OK.TXT"," ");
        List<String> wordsExpecteds = new ArrayList<>();
        wordsExpecteds.add("Platon");
        wordsExpecteds.add("made");
        wordsExpecteds.add("bamboo");
        wordsExpecteds.add("boats.");
        Assert.assertEquals(wordsExpecteds,words);
    }

    @Test(expected = IOException.class)
    public void testNotExists() throws IOException {
        List<String> words = FileUtils.readAllStrings("src/test/resources/INPUT_NOT_EXISTS.TXT"," ");
    }

}
