import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author diaopx
 * @date 2022/3/24 21:09
 */
public class dpx146LRUCache {

    int capacity;
    LinkedHashMap<Integer, Integer> map;

    public void LRUCache(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return map.size() > capacity;
            }
        };
    }

    public int get(int key) {
        return map.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        map.put(key, value);
    }



    /*class Node {
        int key, value;
        Node pre, next;

        public Node() {
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    //用来记录该key对应的节点
    private Map<Integer, Node> map = new HashMap<>();
    private Node head, tail;
    private int capacity;
    private int size;

    //初始化
    public dpx146LRUCache(int capacity) {
        // 头结点和尾结点，构建双链表
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
        this.capacity = capacity;
        size = 0;
    }

    *//**
     * 如果不存在返回-1，存在则返回对应值，并将该节点移动到头部，更新序列位置
     *//*
    public int get(int key) {
        Node node = map.getOrDefault(key, null);
        if (node == null) {
            return -1;
        }
        //key存在，并且该键值对才使用，需要移到头结点
        moveToHead(node);
        return node.value;
    }

    *//**
     * put操作，需要先判断map中是否存在键值对，不存在则新建一个newNode加到头结点之后，并且关注size是否会大于capacity，大于则删除尾结点
     * 存在，则更新键值对的访问时间，将该键值对更改到头结点之后
     *
     * @param key
     * @param value
     *//*
    public void put(int key, int value) {
        Node node = map.get(key);
        if (node == null) {
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            size++;
            addToHead(newNode);
            if (size > capacity) {
                //删除map中的对应
                map.remove(tail.pre.key);
                // 如果超出容量，删除双向链表的尾部节点
                removeNode(tail.pre);
                size--;
            }
        } else {
            // 如果 key 存在，先修改 value，并移到头部
            node.value = value;
            moveToHead(node);
        }
    }

    *//**
     * 先删除该节点，然后插入到头结点之后
     *//*
    private void moveToHead(Node node) {
        removeNode(node);
        //add到头结点之后
        addToHead(node);
    }

    *//**
     * 将节点添加到头结点，表示键值对是最近使用的，近尾部的键值对是最久未使用的。
     *//*
    private void addToHead(Node node) {
        node.next = head.next;
        node.pre = head;
        head.next.pre = node;
        head.next = node;
    }

    private void removeNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }*/
}
