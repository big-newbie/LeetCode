package com.tf.alg.leetcode;

/**
 * Created by tingfang
 * 2018-11-06
 */
public class Q146 {//FIXME

    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */
    class LRUCache {
        private Node head;
        private Node tail;
        private int size;
        private int capacity;
        private Node[] holder;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            holder = new Node[capacity];
        }

        public int get(int key) {
            if (head == null) {
                return -1;
            }
            Node node = holder[hash(key)];
            while (node != null && node.key != key) {
                node = node.after;
            }
            if (node == null) {
                return -1;
            } else if (head != node) {
                node.prev.next = node.next;
                if (node.next != null) {
                    node.next.prev = node.prev;
                } else {
                    tail = node.prev;
                }
                node.prev = null;
                node.next = head;
                head.prev = node;
                head = node;
            }
            return node.val;
        }

        public void put(int key, int value) {
            int hash = hash(key);
            Node node = new Node(key, value);
            if (size == capacity) {
                Node remove = tail;
                tail = tail.prev;
                if (tail != null) {
                    tail.next = null;
                } else {
                    head = null;
                }
                int removeHash = hash(remove.key);
                Node cur = holder[removeHash];
                if (cur.key == remove.key) {
                    holder[removeHash] = cur.after;
                } else {
                    while (cur.after.key != remove.key) {
                        cur = cur.after;
                    }
                    cur.after = cur.after.after;
                }
            } else {
                size++;
            }
            if (head == null) {
                head = node;
                tail = node;
                holder[hash] = node;
                return;
            }
            Node cur = holder[hash];
            if (cur == null) {
                holder[hash] = node;
            } else {
                while (cur.after != null) {
                    cur = cur.after;
                }
                cur.after = node;
            }
            head.prev = node;
            node.next = head;
            head = node;
        }

        private int hash(int key) {
            return key % capacity;
        }

        class Node {
            private int key;
            private int val;
            private Node prev;
            private Node next;
            private Node after;

            public Node(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new Q146().new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        System.out.println(cache.get(2));       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        System.out.println(cache.get(1));// 返回 -1 (未找到)
        System.out.println(cache.get(3));       // 返回  3
        System.out.println(cache.get(4));       // 返回  4

        System.out.println();
//        ["LRUCache","put","get","put","get","get"]
//[[1],[2,1],[2],[3,2],[2],[3]]
        LRUCache lru = new Q146().new LRUCache(1);
        lru.put(2, 1);
        System.out.println(lru.get(2));
        lru.put(3, 2);
        lru.put(3, 4);
        System.out.println(lru.get(2));
        System.out.println(lru.get(3));

//        ["LRUCache","put","put","put","put","put","get","put","get","get","put","get","put","put","put","get","put","get","get","get","get","put","put","get","get","get","put","put","get","put","get","put","get","get","get","put","put","put","get","put","get","get","put","put","get","put","put","put","put","get","put","put","get","put","put","get","put","put","put","put","put","get","put","put","get","put","get","get","get","put","get","get","put","put","put","put","get","put","put","put","put","get","get","get","put","put","put","get","put","put","put","get","put","put","put","get","get","get","put","put","put","put","get","put","put","put","put","put","put","put"]
//[[10],[10,13],[3,17],[6,11],[10,5],[9,10],[13],[2,19],[2],[3],[5,25],[8],[9,22],[5,5],[1,30],[11],[9,12],[7],[5],[8],[9],[4,30],[9,3],[9],[10],[10],[6,14],[3,1],[3],[10,11],[8],[2,14],[1],[5],[4],[11,4],[12,24],[5,18],[13],[7,23],[8],[12],[3,27],[2,12],[5],[2,9],[13,4],[8,18],[1,7],[6],[9,29],[8,21],[5],[6,30],[1,12],[10],[4,15],[7,22],[11,26],[8,17],[9,29],[5],[3,4],[11,30],[12],[4,29],[3],[9],[6],[3,4],[1],[10],[3,29],[10,28],[1,20],[11,13],[3],[3,12],[3,8],[10,9],[3,26],[8],[7],[5],[13,17],[2,27],[11,15],[12],[9,19],[2,15],[3,16],[1],[12,17],[9,1],[6,19],[4],[5],[5],[8,1],[11,7],[5,2],[9,28],[1],[2,2],[7,4],[4,22],[7,24],[9,26],[13,28],[11,26]]
    }
}