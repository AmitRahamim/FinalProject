package algorithms;
import java.util.ArrayList;
import java.util.List;

public class RabinIAlgo implements IAlgoForStrings {
    private static final int PRIME = 101; // Prime number to calculate hash
    //private static final int CHAR_SET = 256; // Number of characters in the character set
    @Override
    public void search(String text, String pattern) {
        List<Integer> occurrences = new ArrayList<>();
        int patternLength = pattern.length();
        int textLength = text.length();
        int patternHash = calculateHash(pattern, patternLength);
        int textHash = calculateHash(text, patternLength);

        for (int i = 0; i <= textLength - patternLength; i++) {
            if (patternHash == textHash && checkEquals(text, i, i + patternLength - 1, pattern)) {
                occurrences.add(i);
            }
            if (i < textLength - patternLength) {
                textHash = recalculateHash(text, i, i + patternLength, textHash, patternLength);
            }
        }
        if (!occurrences.isEmpty()) {
            System.out.println("Pattern found at index/indices: " + occurrences);
        } else {
            System.out.println("Pattern not found in the text.");
        }
    }

    private int calculateHash(String str, int length) {
        int hash = 0;
        for (int i = 0; i < length; i++) {
            hash += str.charAt(i) * Math.pow(PRIME, i);
        }
        return hash;
    }

    private int recalculateHash(String str, int oldIndex, int newIndex, int oldHash, int patternLength) {
        int newHash = oldHash - str.charAt(oldIndex);
        newHash = newHash / PRIME;
        newHash += str.charAt(newIndex) * Math.pow(PRIME, patternLength - 1);
        return newHash;
    }

    private boolean checkEquals(String text, int start1, int end1, String pattern) {
        int len = end1 - start1 + 1;
        for (int i = 0; i < len; i++) {
            if (text.charAt(start1 + i) != pattern.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    // Example us
}

