package project2;

public interface Stack {
    /**
     * get the stack size
     * @return the size of the stack
     */
    int size();
    boolean isEmpty();
    int top();
    void push(int n);
    int pop();
}
