class Solution {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        int l=s.length();

       String maxstr=s.substring(0,1);

       for(int i=0;i<l-1;i++){

        String odd=expandFromCenter(s,i,i);
        String even=expandFromCenter(s,i,i+1);

        if(maxstr.length()<odd.length()) maxstr=odd;

        if(maxstr.length() < even.length()) maxstr=even;
       } 
       return maxstr;
        
    }
    public String expandFromCenter(String s,int left,int right){

        while(left>=0 && right <s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return s.substring(left+1,right);
    }
}