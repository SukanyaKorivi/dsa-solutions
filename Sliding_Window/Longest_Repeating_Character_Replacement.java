class Solution {
    public int characterReplacement(String s, int k) {
       Map<Character,Integer> freq=new HashMap<>();

       int left=0;
       int maxfreq=0;
       int right=0;
    
       while(right<s.length()){
        freq.put(s.charAt(right),freq.getOrDefault(s.charAt(right),0)+1);
        maxfreq=Math.max(maxfreq,freq.get(s.charAt(right)));


         if((right - left + 1) - maxfreq > k) {
               freq.put(s.charAt(left), freq.get(s.charAt(left)) - 1);
               left++;
             }

              right++;

       } 
       return right-left;
    }
}