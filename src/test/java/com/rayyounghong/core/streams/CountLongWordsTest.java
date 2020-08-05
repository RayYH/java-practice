package com.rayyounghong.core.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * <a href="https://docs.oracle.com/javase/8/docs/api/java/util/regex/Pattern.html">Class Pattern</a>
 *
 * @author ray
 */
public class CountLongWordsTest {
    @Test
    void testLongWords() throws IOException {
        String userDirectory = System.getProperty("user.dir");
        String testResourceDir = userDirectory + "/src/test/resources/streams";
        String path = testResourceDir + "/java.txt";
        String contents = Files.readString(Paths.get(path));
        List<String> words = Arrays.asList(contents.split("\\PL+"));
        long count = words.stream().filter(w -> w.length() > 12).count();
        assertEquals(2, count);
    }
}
