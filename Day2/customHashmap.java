package Day2;

import java.util.Objects;

public class customHashmap<K, V> {

    private static final int INITIAL_CAPACITY = 16;
    private Node<K, V>[] buckets;
    private int size = 0;

    // Node class for linked list
    static class Node<K, V> {
        final K key;
        V value;
        Node<K, V> next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    @SuppressWarnings("unchecked")
    public customHashmap() {
        // Suppress warning for generic array creation
        buckets = (Node<K, V>[]) new Node[INITIAL_CAPACITY];
    }

    // Hash function
    private int getBucketIndex(K key) {
        return Math.abs(Objects.hashCode(key)) % buckets.length;
    }

    // Insert or update a key-value pair
    public void put(K key, V value) {
        int index = getBucketIndex(key);
        Node<K, V> head = buckets[index];

        // Update existing key
        while (head != null) {
            if (Objects.equals(head.key, key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        // Insert new key-value pair
        Node<K, V> newNode = new Node<>(key, value);
        newNode.next = buckets[index];
        buckets[index] = newNode;
        size++;
    }

    // Retrieve value by key
    public V get(K key) {
        int index = getBucketIndex(key);
        Node<K, V> head = buckets[index];

        while (head != null) {
            if (Objects.equals(head.key, key)) {
                return head.value;
            }
            head = head.next;
        }
        return null; // Key not found
    }

    // Remove a key-value pair
    public void remove(K key) {
        int index = getBucketIndex(key);
        Node<K, V> head = buckets[index];
        Node<K, V> prev = null;

        while (head != null) {
            if (Objects.equals(head.key, key)) {
                if (prev == null) {
                    buckets[index] = head.next;
                } else {
                    prev.next = head.next;
                }
                size--;
                return;
            }
            prev = head;
            head = head.next;
        }
    }

    // Return the number of key-value pairs
    public int size() {
        return size;
    }

    // Main method for testing
    public static void main(String[] args) {
        customHashmap<String, Integer> map = new customHashmap<>();

        map.put("apple", 1);
        map.put("banana", 2);
        map.put("orange", 3);

        System.out.println("apple: " + map.get("apple"));    // 1
        System.out.println("banana: " + map.get("banana"));  // 2

        map.put("apple", 10); // Update value
        System.out.println("apple (updated): " + map.get("apple"));  // 10

        map.remove("banana");
        System.out.println("banana (after removal): " + map.get("banana"));  // null

        System.out.println("Current size: " + map.size());  // 2
    }
}