class BrowserHistory {
    Deque<String> backward;
    Deque<String> forward;
    String homepage;

    public BrowserHistory(String homepage) {
      this.backward=new ArrayDeque<>();
      this.forward=new ArrayDeque<>();
      backward.push(homepage);   
    }
    
    public void visit(String url) {
        backward.push(url);
        forward.clear();
        
    }
    
    public String back(int steps) {
       
       while(steps > 0 && backward.size() >1 ){
        forward.push(backward.pop());
        steps--;
       }
        return backward.peek();
    }
    
    public String forward(int steps) {

         while(steps > 0 && !forward.isEmpty() ){
        backward.push(forward.pop());
        steps--;
       }
        
        return backward.peek();
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */