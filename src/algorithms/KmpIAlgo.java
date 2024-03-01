package algorithms;

public class KmpIAlgo implements IAlgoForStrings {

    public int[] computeLPSArray(String pattern) {
        int m_patternLengthKmp = pattern.length();
        int[] m_Kmplps = new int[m_patternLengthKmp];
        int m_Kmplen = 0;
        int i = 1;
        m_Kmplps[0] = 0; // lps[0] is always 0

        while (i < m_patternLengthKmp) {
            if (pattern.charAt(i) == pattern.charAt(m_Kmplen)) {
                m_Kmplen++;
                m_Kmplps[i] = m_Kmplen;
                i++;
            } else {
                if (m_Kmplen != 0) {
                    m_Kmplen = m_Kmplps[m_Kmplen - 1];
                } else {
                    m_Kmplps[i] = 0;
                    i++;
                }
            }
        }
        return m_Kmplps;
    }

    @Override
    // Search for pattern in text using KMP algorithm
    public void search(String text, String pattern) {
        int textLength = text.length();
        int KmpPatternLength = pattern.length();

        int[] lps = computeLPSArray(pattern);
        int i = 0; // Index for text[]
        int j = 0; // Index for pattern[]

        while (i < textLength) {
            if (pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            }
            if (j == KmpPatternLength) {
                System.out.println("Pattern found at index " + (i - j));
                j = lps[j - 1];
            } else if (i < textLength && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
    }
}
