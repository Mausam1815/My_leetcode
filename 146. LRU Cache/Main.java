class LRUCache {
    class Node {
        int key;
        int value;
        Node prev;
        Node next;
    }

    HashMap<Integer, Node> cache;
    int limit;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        cache = new HashMap<>()    ;
        limit = capacity;

        head = new Node();
        tail = new Node();

        head.next = tail;
        tail.prev = head;
    }
    public void addNode(Node node){
        Node nbr = head.next;
        node.next = nbr;
        node.prev = head;
        head.next = node;
        nbr.prev = node;
    }
    public void removeNode(Node node){
        Node prevNbr = node.prev;
        Node nextNbr = node.next;
        prevNbr.next = nextNbr;
        nextNbr.prev = prevNbr;
        node.next = node.prev = null;
    }
    public void moveToFront(Node node){
        removeNode(node);
        addNode(node);
    }
    public int get(int key) {
        Node node = cache.get(key);
        if(node == null){
            return -1;
        }else {
            int nodeVal = node.value;
            moveToFront(node);
            return nodeVal;
        }
    }
    
    public void put(int key, int value) {
        Node node = cache.get(key);
        if(node == null){
            Node newNode = new Node();
            newNode.key = key;
            newNode.value = value;

            if(cache.size() == limit){
                Node LRUNode = tail.prev;
                cache.remove(LRUNode.key);
                removeNode(LRUNode);
            }
            cache.put(key, newNode);
            addNode(newNode);
        }else {
            node.value = value;
            moveToFront(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */