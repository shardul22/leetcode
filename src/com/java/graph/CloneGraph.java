package com.java.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*
 * https://leetcode.com/problems/clone-graph/
 * */
public class CloneGraph {

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		
		if(node == null)
			return node;
		
		Map<UndirectedGraphNode, UndirectedGraphNode> nodeMap = new HashMap<>();
		UndirectedGraphNode clonnedRoot = new UndirectedGraphNode(node.label);
		nodeMap.put(node, clonnedRoot);
		Queue<UndirectedGraphNode> nodeQueue = new LinkedList<>();
		nodeQueue.offer(node);
		while(!nodeQueue.isEmpty()) {
			UndirectedGraphNode currentNode = nodeQueue.poll();
			UndirectedGraphNode currentClonnedNode = nodeMap.get(currentNode);
			for(UndirectedGraphNode neighbourNode : currentNode.neighbors) {
				if(nodeMap.containsKey(neighbourNode)) {
					currentClonnedNode.neighbors.add(nodeMap.get(neighbourNode));
				} else {
					nodeQueue.offer(neighbourNode);
					UndirectedGraphNode clonnedNeighbourNode = new UndirectedGraphNode(neighbourNode.label);
					nodeMap.put(neighbourNode, clonnedNeighbourNode);
					currentClonnedNode.neighbors.add(clonnedNeighbourNode);
				}
			}
		}
		return clonnedRoot;
	}

}

class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;
	UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }	
}