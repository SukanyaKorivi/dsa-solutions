
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> unique = new HashSet<>();
        int maxLength = 0;
        int left = 0;
        
      
        for (int right = 0; right < s.length(); right++) {
            
  
            while (unique.contains(s.charAt(right))) {
                unique.remove(s.charAt(left));
                left++; 
            }
            
          
            unique.add(s.charAt(right));
            
        
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}