class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> unique=new HashMap<>();
    
        int l=strs.length;

        for(String str:strs){
            char[] ch=str.toCharArray();
            Arrays.sort(ch);
            String s=new String(ch);

            if(! unique.containsKey(s)){
                unique.put(s, new ArrayList<>(List.of(str)));
            }
            else{
                unique.get(s).add(str);
            }
        }
        return new ArrayList(unique.values());
         
    }
}