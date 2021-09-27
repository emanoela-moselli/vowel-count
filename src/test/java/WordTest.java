import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class WordTest {

    @Test
    public void testCountVowels() {
        Long count = Word.countVowels("ball");
        Assert.assertSame(1L,count);
    }

    @Test
    public void testGenerateKeyFromVowelsAndSize() {
        String key = Word.generateKeyFromVowelsAndSize("Platon");
        Assert.assertEquals("({a, o}, 6)", key);
    }

    @Test
    public void testGenerateKeyFromVowelsAndSizeNullKey() {
        String key = Word.generateKeyFromVowelsAndSize("BCD");
        Assert.assertNull(key);
    }

    @Test
    public void testGetDistinctVowelsFromWord() {
        List<Character> vowels = Word.getDistinctVowelsOrder("house");
        List<Character> vowelsExpecteds = new ArrayList<>();
        vowelsExpecteds.add('e');
        vowelsExpecteds.add('o');
        vowelsExpecteds.add('u');
        Assert.assertEquals(vowels, vowelsExpecteds);
    }

    @Test
    public void testGetDistinctVowelsFromWordRepeat() {
        List<Character> vowels = Word.getDistinctVowelsOrder("bamboo");
        List<Character> vowelsExpecteds = new ArrayList<>();
        vowelsExpecteds.add('a');
        vowelsExpecteds.add('o');
        vowelsExpecteds.add('o');
        Assert.assertNotEquals(vowels, vowelsExpecteds);
    }
}
