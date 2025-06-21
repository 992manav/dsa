class LRUCache {
// Access at any y-position in O(1) time joiye — etle key thi directly node ni address/index mali jaye 
// ==> mate HashMap jaruri chhe (key through node no address mali shake)
// 
// Insert operation O(1) ma joye chhe — etle last ma insert karvu hoy to 
// ArrayList, LinkedList with tail pointer, Stack, Queue — badha support kare chhe
// 
// Delete operation pan O(1) ma joye chhe — koi specific node hataaviye to 
// ArrayList, Stack, Queue ma O(n) lage chhe (shift karvu padse), 
// pan LinkedList ma node ni reference hoy to O(1) ma kari shake
//Single LiskList nahi joiye ,Double link list joiye 
//
// ==> A badha criteria fulfill karva mate 
//      HashMap + Doubly LinkedList best combination chhe 
//      (HashMap thi fast lookup & LinkedList thi fast insert/delete)
  
    public class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    // Doubly Linked List
    public class List {
        Node head = null;
        Node tail = null;

        void append(Node temp) {
            if (head == null && tail == null) {
                head = tail = temp;
            } else {
                tail.next = temp;
                temp.prev = tail;
                tail = temp;
            }
        }

        void remove(Node temp) {
            if (temp == head && temp == tail) {
                head = tail = null;
            } else if (temp == head) {
                head = head.next;
                if (head != null) head.prev = null;
            } else if (temp == tail) {
                tail = tail.prev;
                if (tail != null) tail.next = null;
            } else {
                if (temp.prev != null) temp.prev.next = temp.next;
                if (temp.next != null) temp.next.prev = temp.prev;
            }
        }
    }

    int capacity;
    int count = 0;
    HashMap<Integer, Node> map = new HashMap<>();
    List lst = new List();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node temp = map.get(key);
            lst.remove(temp);
            lst.append(temp);  // move to most recently used
            return temp.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node temp = map.get(key);
            lst.remove(temp);
            temp.value = value;
            lst.append(temp);
        } else {
            if (count >= capacity) {
                // remove least recently used node from head
                Node lru = lst.head;
                lst.remove(lru);
                map.remove(lru.key);
                count--;
            }
            Node temp = new Node(key, value);
            map.put(key, temp);
            lst.append(temp);
            count++;
        }
    }
}