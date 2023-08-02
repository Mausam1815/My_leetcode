class StockSpanner {
    Stack<Pair> st;
    public StockSpanner() {
        st = new Stack<>();
    }
    
    public int next(int price) {
        int span = 1;
        while(!st.isEmpty() && st.peek().prices <= price) {
            span += st.pop().spans;
        }
        st.push(new Pair(price, span));
        return span;
    }
}
class Pair {
    int prices;
    int spans;
    Pair(int prices, int spans) {
        this.prices = prices;
        this.spans = spans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */