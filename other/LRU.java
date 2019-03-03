class LRU<K, V> implements Iterable<K>{

    //  双向链表 + HashMap

    private Node head;
    private Node tail;
    private Map<K, Node> map;
    private int size;

    private class Node{
        Node prev;
        Node next;
        K k;
        V v;

        Node(K k, V v){
            this.k = k;
            this.v = v;
        }
    }

    public LRU(int size){
        this.size = size;
        this.map = new HashMap<>(size / 4 * 3);

        head = new Node(null, null);
        tail = new Node(null, null);

        head.next = tail;
        tail.prev = head;
    }

    public V get(K key){
        if(!map.containsKey(key)) return null;
        Node node = map.get(key);
        unlink(node);
        appendHead(node);

        return node.v;
    }

    public void put(K key, V val){
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.v = val;
            return;
        }
        Node node = new Node(key, val);
        map.put(key, node);
        appendHead(node);

        if(map.size() > size){
            Node toRemove = removeTail();
            map.remove(toRemove.k);
        }
    }

    private void unlink(Node node){
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;

        node.prev = null;
        node.next = null;
    }

    private void appendHead(Node node){
        Node next = head.next;
        head.next = node;
        node.next = next;
        node.prev = head;
        next.prev = node;
    }

    private Node removeTail(){
        Node node = tail.prev;

        Node prev = node.prev;
        tail.prev = prev;
        prev.next = tail;

        node.prev = null;
        node.next = null;

        return node;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {

            private Node cur = head.next;

            @Override
            public boolean hasNext() {
                return cur != tail;
            }

            @Override
            public K next() {
                Node node = cur;
                cur = cur.next;
                return node.k;
            }
        };
    }

    public static void main(String[] args) {
        LRU lru = new LRU(5);

        for(int i = 0; i < 10; i++){
            lru.put(i, "a" + i);
        }

        Iterator<Integer> it = lru.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

    }

    a: ..., query
    b: ..., query
    c: ..., query

    select * from c  
}
