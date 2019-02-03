class CloneGraph{

    // Given the head of a graph, return a deep copy (clone) of the graph

    /**
    * Definition for undirected graph.
    * class UndirectedGraphNode {
    *     int label;
    *     List<UndirectedGraphNode> neighbors;
    *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
    * };
    */
    private Map<Integer, UndirectedGraphNode> map = new HashMap<>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return clone(node);
    }
    
    private UndirectedGraphNode clone(UndirectedGraphNode node){
        if(node == null) return null;
        if(map.containsKey(node.label)) return map.get(node.label);
        
        UndirectedGraphNode cloneNode = new UndirectedGraphNode(node.label);
        map.put(node.label, cloneNode);
        for(UndirectedGraphNode adj: node.neighbors){
            cloneNode.neighbors.add(clone(adj)); // crucial
        }
        return cloneNode;
    }
}