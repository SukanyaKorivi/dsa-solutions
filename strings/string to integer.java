class Solution {
    public int myAtoi(String s) {
 
        char sign='\0';
        long digit=0;
        
        s=s.trim();


        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            
            
            if(Character.isDigit(ch)){
                digit=(digit*10)+(ch - '0');
                if(digit>Integer.MAX_VALUE){
                    return (sign == '-')? Integer.MIN_VALUE:Integer.MAX_VALUE;               
                }
            }

            else if(ch == '+' || ch == '-'){
                if(i==0) { 
                    sign = ch;
                    continue;
                }
                break;
            }
            
            else{
                break;
            }
        
    }
     

    if(digit != 0)
     {
       return sign == '-'? -(int)digit:(int)digit;
     }
    
    return 0;
}
}