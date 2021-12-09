package util;

import java.util.Random;
import org.apache.commons.lang.RandomStringUtils;

public class RandomStringGenerator {

    public static String generateString() {
        Random random = new Random();
        int length = random.ints(1, 100)
                .findFirst()
                .getAsInt();
        boolean useLetters = true;
        boolean useNumbers = true;
        return RandomStringUtils.random(length, useLetters, useNumbers);
    }
}
