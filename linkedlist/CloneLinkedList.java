public class CloneLinkedList{

    public RandomListNode clone(RandomListNode phead) {
        if(phead == null ) return null;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode nhead = new RandomListNode(0);
        RandomListNode p = phead;
        RandomListNode pn = nhead;
        RandomListNode node = null;
        while(p != null){
            node = new RandomListNode(p.label);
            map.put(p, node);
            pn.next = node;
            pn = pn.next;
            p = p.next;
        }
        p = phead;
        while(p != null){
            node = map.get(p);
            node.random = map.get(p.random);
            p = p.next;
        }
        return nhead.next;
    }
}