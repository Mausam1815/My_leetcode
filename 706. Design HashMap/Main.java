class MyHashMap {

    private final int SIZE = 10007; // A prime number to reduce collisions
    private Node[] buckets;

    public MyHashMap() {
        buckets = new Node[SIZE];
    }

    public void put(int key, int value) {
        int index = key % SIZE;
        Node current = buckets[index];
        Node prev = null;

        while (current != null) {
            if (current.key == key) {
                current.value = value; // Update the existing key
                return;
            }
            prev = current;
            current = current.next;
        }

        Node newNode = new Node(key, value);
        if (prev == null) {
            buckets[index] = newNode; // Insert at the beginning of the list
        } else {
            prev.next = newNode; // Insert at the end of the list
        }
    }

    public int get(int key) {
        int index = key % SIZE;
        Node current = buckets[index];

        while (current != null) {
            if (current.key == key) {
                return current.value;
            }
            current = current.next;
        }

        return -1; // Key not found
    }

    public void remove(int key) {
        int index = key % SIZE;
        Node current = buckets[index];
        Node prev = null;

        while (current != null) {
            if (current.key == key) {
                if (prev == null) {
                    buckets[index] = current.next; // Remove the first node
                } else {
                    prev.next = current.next; // Remove a node in the middle or end
                }
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    private static class Node {
        int key;
        int value;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}


/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */