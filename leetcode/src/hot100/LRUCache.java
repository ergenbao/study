package hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName LRUCache
 * @Description LRU缓存机制
 * @Author JH
 * @Date 2019/9/19 11:35
 */
public class LRUCache {

    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
    }

    //总是把节点放在head的后面
    private void addNode(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
    //移除一个节点
    private void removeNode(DLinkedNode node) {
        DLinkedNode prev = node.prev;
        DLinkedNode next = node.next;
        prev.next = next;
        next.prev = prev;
    }
    //把节点移动到head节点的后边
    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addNode(node);
    }
    //移除尾部节点
    private DLinkedNode popTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }

    private Map<Integer,DLinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkedNode head,tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }
    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if(node == null) {
            return -1;
        }
        //命中之后移动到头部
        moveToHead(node);
        return node.value;
    }
    public void put(int key,int value) {
        DLinkedNode node = cache.get(key);
        if(node == null) {
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;
            cache.put(key,newNode);
            addNode(newNode);
            ++size;
            if(size > capacity) {
                //移除尾部元素
                DLinkedNode tail = popTail();
                cache.remove(tail.key);
                --size;
            }
        } else  {
            //节点存在,修改节点的值
            node.value = value;
            moveToHead(node);
        }
    }

}
