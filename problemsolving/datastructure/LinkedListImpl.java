package datastructure;

public class LinkedListImpl<T> {

    class Node {
        T data;
        Node next;
        Node(T data) {
            this.data = data;
            next = null;
        }
    }

    Node head = null;

    void add(T data) {
        if(head == null) {
            head = new Node(data);
            return;
        }
        Node temp = head;
        while(temp.next!=null) {
            temp = temp.next;
        }
        temp.next = new Node(data);
    }
    void addFirst(T data) {
        if(head == null) {
            head = new Node(data);
            return;
        }
        Node temp = new Node(data);
        temp.next = head;
        head = temp;
    }
    void display() {
        if(head == null) {
            System.out.println("No data found");
        } else {
            Node temp = head;
            while(temp != null) {
                System.out.print(temp.data+"->");
                temp = temp.next;
            }
            System.out.println("null");
        }
    }
    void delete(T data) {
        Node current = head;

        while(current.next!=null && !current.next.data.equals(data)) {
            current = current.next;
        }
        if (current.next != null) {
            System.out.println("Going to delete data : "+ data);
            current.next = current.next.next;
        }
    }

    void reverseLL() {
        Node prev = null;
        Node curr = head;
        Node next = curr;
        while(curr!=null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public static void main() {
        LinkedListImpl<String> strLL = new LinkedListImpl<>();
        strLL.display();

        strLL.add("Karthick");
        strLL.add("Suriya");
        strLL.add("Krishna");
        strLL.display();
        strLL.add("Vicky");
        strLL.add("Saran");
        strLL.display();

        strLL.addFirst("FirstData");
        strLL.delete("Suriya");
        strLL.display();
        System.out.println("Going to reverse LinkedList");
        strLL.reverseLL();
        strLL.display();
    }
}
