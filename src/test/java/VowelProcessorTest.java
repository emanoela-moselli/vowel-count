import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class VowelProcessorTest {

    @Test
    public void testProcessOK() throws IOException {
        List<String> words = FileUtils.readAllStrings("src/test/resources/INPUT_OK.TXT"," ");
        String vowelOutputs = VowelProcessor.process(words);
        StringBuilder vowelOutputsExpected = new StringBuilder();
        vowelOutputsExpected.append("({a, o}, 6) -> 2,5").append(System.lineSeparator());
        vowelOutputsExpected.append("({a, o}, 5) -> 2").append(System.lineSeparator());
        vowelOutputsExpected.append("({a, e}, 4) -> 2").append(System.lineSeparator());
        Assert.assertEquals(vowelOutputsExpected.toString(),vowelOutputs);
    }
}
