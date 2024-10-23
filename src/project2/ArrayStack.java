package project2;

public class ArrayStack implements Stack {
    private int top;
    private int[] values;
    private int maxSize;

    public ArrayStack(int size){
        top = 0;
        maxSize = size;
        values = new int[size];
    }
    public int size(){
        return maxSize;
    }
    public boolean isEmpty(){
        return top == 0;
        // if top == 0 that means no item in the stack
        // top == 0 will return a boolean value
    }

    public int top() {
        return top;
    }

    public void push(int data){
        // because of the array limitation, need set the max size of array
        if (top < maxSize){
            values[top] = data;
            top++;
        } else {
            // when the array is full, can't ues push method
            System.err.println("Error to push");
            System.exit(1);
        }
        System.out.println(data + " is pushed ont the stack");
    }

    public int pop(){
        if (isEmpty()){
            System.err.println("Error to pop");
            System.exit(1);
        }
        int i = values[top - 1];
        top--;
        System.out.println(i + " is popped off of the stack");
        return i;
    }
    public void printArray(int number){
        if (number == size()){
            return;
        }
        printArray(number + 1);
        System.out.print(values[number] + " ");
    }

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(7);
        int[] testExample = new int[]{4,5,6,7,12,23,45};
        // push all items into the array
        for (int i = 0; i < testExample.length; i++){
            arrayStack.push(testExample[i]);
        }

        System.out.print("Traversal in forward Direction: ");
        arrayStack.printArray(0);
        System.out.println();
        // pop three times
        for (int i = 0; i < 3; i++){
            arrayStack.pop();
        }
        // push 65
        arrayStack.push(65);
        // pop seven times
        for (int i = 0; i < 7; i++) {
            arrayStack.pop();
        }
    }
}
