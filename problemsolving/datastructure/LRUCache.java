package datastructure;

import java.util.HashMap;
import java.util.Map;

/**
    Least Recently Used Cache where the initial size is specified. Once created, it will maintain size
    If the size exceeds, the least used will be removed.
    Access, Removal, creation  needs to be o(1)
 */
public class LRUCache {

    private class Node {
        int key;
        int value;
        Node next;
        Node prev;
        private Node(int key , int value) {
            this.key = key;
            this.value = value;
            prev = null;
            next = null;
        }
        public String toString() {
            return key+","+value;
        }
    }
    private Node head = new Node(-1,-1);
    private Node tail = new Node(-1,-1);
    Map<Integer , Node> hm = new HashMap<>(); // To make O(1) time complexity
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        head.prev = null;
        tail.prev = head;
        tail.next = null;
    }
    private void insertAtBeginning(Node node) {
        Node temp = head.next;

        node.next = temp;
        temp.prev = node;
        head.next = node;
        node.prev = head;
    }
    private void deleteNode(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
    public int get(int key) {
        if(!hm.containsKey(key)) {
            return -1;
        }
        Node data = hm.get(key);
        deleteNode(data);
        insertAtBeginning(data);
        return data.value;
    }

    public void put(int key , int value) {
        if(hm.containsKey(key)) {
            Node data = hm.get(key);
            deleteNode(data);
            data.value= value;

            insertAtBeginning(data);
        } else {
            if(hm.size() == capacity) {
                System.out.println("Size reached. Removing the least used element : "+tail.prev);
                hm.remove(tail.prev.key);
                deleteNode(tail.prev);
            }
            Node newNode = new Node(key,value);
            insertAtBeginning(newNode);
            hm.put(key , newNode);
        }
    }
    public void printMap() {
        Node temp = head.next;
        while(temp.next!=null) {
            System.out.print(temp+"::");
            temp = temp.next;
        }
        System.out.println();
    }

    static void main() {
        LRUCache cache = new LRUCache(4);
        System.out.println("1 : "+cache.get(1)); // -1
        cache.put(1,2);
        cache.put(2,3);
        cache.put(3,4);
        cache.printMap();

        cache.put(5,2);
        cache.put(1,7); // updated
        cache.printMap(); // 1,7 :: 5,2 :: 3,4 :: 2,3

        cache.put(8,9); // 2,3 needs to be removed
        cache.printMap();
    }
}
