package datastructure;

public class StackImpl<T> {
    private int top;
    private Object[] data;
    public StackImpl() {
        top = -1;
        data = new Object[16]; // Initial Capacity this will grow once data added is > 16
    }
    boolean isFull() {
        return data.length <= top + 1;
    }
    boolean isEmpty() {
        return top == -1;
    }
    public void push(T data) {
        if(isFull()) {
            System.out.println("Stack overflow");
        } else {
            this.data[++top] = data;
        }
    }
    public T pop() {
        if(isEmpty()) {
            System.out.println("Stack underflow");
            // just doing this to skip throwing custom exception. Actually we need to throw exception here
            return null;
        } else {
            return (T) this.data[top--];
        }
    }
    public T peek() {
        if(isEmpty()) {
            System.out.println("No data");
        }
        return (T) this.data[top];
    }
    public void display() {
        for(int i=0;i<=top;i++) {
            System.out.print(this.data[i]+" ");
        }
        System.out.println();
    }

    static void main() {
        StackImpl<String> stringStack = new StackImpl<>();
        stringStack.pop();

        stringStack.push("Karthick");
        stringStack.push("Suriya");
        stringStack.push("Krishna");

        stringStack.display();

        System.out.println("peek elem : "+stringStack.peek());
        System.out.println("Popped elem : "+stringStack.pop());

        stringStack.display();
    }

}