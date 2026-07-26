class Solution {
    public List<String> fizzBuzz(int n) {
        // Pre-allocate memory capacity immediately
        List<String> arr = new ArrayList<>(n); 
        
        int fizz = 0;
        int buzz = 0;
        
        for (int i = 1; i <= n; i++) {
            fizz++;
            buzz++;
            
            if (fizz == 3 && buzz == 5) {
                arr.add("FizzBuzz");
                fizz = 0; // Reset counters
                buzz = 0;
            } else if (fizz == 3) {
                arr.add("Fizz");
                fizz = 0; // Reset fizz counter
            } else if (buzz == 5) {
                arr.add("Buzz");
                buzz = 0; // Reset buzz counter
            } else {
                arr.add(Integer.toString(i));
            }
        }
        
        return arr;
    }
}