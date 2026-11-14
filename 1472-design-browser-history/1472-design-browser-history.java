class BrowserHistory {

    private Deque<String> forwardHistroy;
    private Deque<String> currHistory;

    public BrowserHistory(String homepage) {
        forwardHistroy = new ArrayDeque<>();
        currHistory = new ArrayDeque<>();

        currHistory.push(homepage);
    }
    
    public void visit(String url) {
        currHistory.push(url);

        forwardHistroy.clear();
        
    }
    
    public String back(int steps) {
        for(int i=1;i<=steps && currHistory.size()>1;i++){
            forwardHistroy.push(currHistory.pop());
        }
        return currHistory.peek();
    }
    
    public String forward(int steps) {
        for(int i=1;i<=steps && !forwardHistroy.isEmpty() ;i++){
            currHistory.push(forwardHistroy.pop());
        }
        return currHistory.peek();
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna