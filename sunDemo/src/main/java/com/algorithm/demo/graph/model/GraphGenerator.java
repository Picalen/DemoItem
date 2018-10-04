package com.algorithm.demo.graph.model;

public class GraphGenerator {

	public static Graph createGraph(Integer[][] matrix) {
		/**
		 *  matrix[i][0],matrix[i][1],matrix[i][2] 分表代表起始点，终点，权重
		 *
		 * */
		Graph graph = new Graph();
		for (int i = 0; i < matrix.length; i++) {
			Integer from = matrix[i][0];
			Integer to = matrix[i][1];
			Integer weight = matrix[i][2];
			if (!graph.nodes.containsKey(from)) {
				graph.nodes.put(from, new Node(from));
			}
			if (!graph.nodes.containsKey(to)) {
				graph.nodes.put(to, new Node(to));
			}
			Node fromNode = graph.nodes.get(from);
			Node toNode = graph.nodes.get(to);
			Edge newEdge = new Edge(weight, fromNode, toNode);
			fromNode.nexts.add(toNode);
			fromNode.out++;
			toNode.in++;
			fromNode.edges.add(newEdge);
			graph.edges.add(newEdge);
		}
		return graph;
	}

}
