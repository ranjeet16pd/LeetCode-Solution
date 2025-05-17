// Last updated: 17/05/2025, 13:55:28
class Solution {
    public boolean areOccurrencesEqual(String s) {
        Map<Character,Integer>mp=new HashMap<>();
        for(Character ch : s.toCharArray()){
            mp.put(ch,mp.getOrDefault(ch, 0) + 1);
        }
        int cnt = mp.get(s.charAt(0));
        for(int value : mp.values()){
            if(cnt!=value) return false;
        }
        return true;
    }
}