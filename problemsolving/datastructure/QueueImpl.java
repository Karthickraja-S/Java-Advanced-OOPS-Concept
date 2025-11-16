package datastructure;

public class QueueImpl<T> {
    int front;
    int rear;
    Object[] data;
    int size;
    public QueueImpl() {
        front = 0;
        rear = -1;
        data = new Object[4]; // when the size is full, we need to extend the array size and make a copy
        size = 0;
    }
    public boolean isFull() {
        return data.length == size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public void enqueue(T data) {
        // for circular queue, then just need to do
        // rear = (rear + 1 ) % arr.length
        // by checking it is full or not.
        if(isFull()) {
            System.out.println("Queue full. TODO : Need to extend array & copy the data");
            return;
        }
        rear++;
        this.data[rear] = data;
        size++;
    }
    public T deQueue() {
        if(isEmpty()) {
            System.out.println("Empty Queue");
            return null;
        }
        // for circular queue, then just need to do
        // front = (front + 1 ) % arr.length ( after getting the data of arr[length]
        // by checking it is full or not.
        size--;
        return (T) data[front++];
    }
    public T peek() {
        return (T) data[front];
    }
     void display() {
        for(int i=front; i<size ; i++) {
            System.out.print(this.data[i]+" ");
        }
         System.out.println();
    }

    static void main() {
        QueueImpl<String> queue = new QueueImpl<>();
        queue.deQueue();

        queue.enqueue("Karthick");
        queue.enqueue("Suriya");
        queue.enqueue("Saran");
        queue.enqueue("Vicky");

        queue.enqueue("Krishna");

        System.out.println(queue.peek());
        System.out.println(queue.deQueue());

        queue.display();
    }
}
