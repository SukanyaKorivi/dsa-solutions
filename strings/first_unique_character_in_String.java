class Solution {
    public int firstUniqChar(String s) {
        char[] arr=s.toCharArray();
        HashMap<Character, Integer> freq = new HashMap<>();
        for (char n : arr) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }
        for (int i = 0; i < arr.length; i++) {
           
            if (freq.get(arr[i]) == 1) {
                return i; 
            }
        }
        
        return -1; 
    }
}