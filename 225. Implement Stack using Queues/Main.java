// using single queue
class MyStack {
    Queue<Integer> q;
    public MyStack() {
        q = new LinkedList<>();
    }
    
    public void push(int x) {
        // get size of previous queue
        int qSize = q.size();
        // add current value in queue
        q.offer(x);
        // remove previous elements and add them after current value
        for(int i=0; i<qSize; i++){
            int temp = q.poll();
            q.offer(temp);
        }
    }
    
    public int pop() {
        if(q.isEmpty()){
            return -1;
        }
        return q.poll();
    }
    
    public int top() {
        if(q.isEmpty()){
            return -1;
        }
        return q.peek();
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
// using two queue
class MyStack {
    Queue<Integer> q1, q2;
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    public void push(int x) {
        // shift q1 -> q2
        while(!q1.isEmpty()){
            q2.offer(q1.poll());
        }

        // push val in q1
        q1.offer(x);

        // shift q2 -> q1
        while(!q2.isEmpty()){
            q1.offer(q2.poll());
        }
    }
    
    public int pop() {
        return q1.poll();
    }
    
    public int top() {
        return q1.peek();
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */