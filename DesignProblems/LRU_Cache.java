class LRUCache {
    Map<Integer, Node> map;
    int capacity;
    Node head;
    Node tail;

   class Node {
    int key;
    int value;
    Node prev;
    Node next;

        public Node(int key,int n) {
            this.key=key;
            this.value=n;
            this.next = null;
            this.prev = null;
        }
    }

 

    public LRUCache(int capacity) {
        map=new HashMap<>();
        this.capacity=capacity;
         head = new Node(-1, -1);  
    tail = new Node(-1, -1); 
   head.next = tail;
   tail.prev = head;
        
    }


    private void removeNode(Node n) {
    n.prev.next = n.next;
    n.next.prev = n.prev;
    }

    private void addToFront(Node n) {
    n.next = head.next;
    n.prev = head;
    head.next.prev = n;
    head.next = n;
    }
    
    
      
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
    
         Node n = map.get(key);   
         removeNode(n);           
         addToFront(n);             
         return n.value;
        }

        
    
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node n=map.get(key);
            n.value = value;
            removeNode(n);
            addToFront(n);
        }
        else {
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            addToFront(newNode);
    
            if (map.size() > capacity) {
                Node lru = tail.prev;
                removeNode(lru);
                map.remove(lru.key);
            }
        }

    }
}




    

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */