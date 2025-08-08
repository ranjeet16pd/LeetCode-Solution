// Last updated: 08/08/2025, 19:20:14
import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) return result;
        
        int wordLen = words[0].length();
        int wordCount = words.length;
        int windowSize = wordLen * wordCount;
        
        // Build frequency map of words
        Map<String, Integer> wordFreq = new HashMap<>();
        for (String w : words) {
            wordFreq.put(w, wordFreq.getOrDefault(w, 0) + 1);
        }
        
        // Try every possible starting point within wordLen range
        for (int i = 0; i < wordLen; i++) {
            int left = i, right = i;
            Map<String, Integer> seen = new HashMap<>();
            int count = 0; // matched words count
            
            while (right + wordLen <= s.length()) {
                String word = s.substring(right, right + wordLen);
                right += wordLen;
                
                if (wordFreq.containsKey(word)) {
                    seen.put(word, seen.getOrDefault(word, 0) + 1);
                    count++;
                    
                    // If frequency exceeds, shrink from left
                    while (seen.get(word) > wordFreq.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        seen.put(leftWord, seen.get(leftWord) - 1);
                        count--;
                        left += wordLen;
                    }
                    
                    // If matched all words, store start index
                    if (count == wordCount) {
                        result.add(left);
                    }
                } else {
                    // Reset window if word not found
                    seen.clear();
                    count = 0;
                    left = right;
                }
            }
        }
        
        return result;
    }
}
