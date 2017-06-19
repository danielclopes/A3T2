package br.pucrs.alpro3;

public class Tree {
	private Node root;

	public Tree() {
		root = null;
	}

	public void add(int value) {
		root = addCentro(root, value);
	}

	private Node addCentro(Node node, int value) {
		if (node == null) {
			Node n = new Node();
			n.valor = value;
			n.central = null;
			n.lateral = null;
			return n;
		}
		return node.central = addCentro(node, value);
	}

	private Node addLateral(Node node, int value) {
		if (node == null) {
			Node n = new Node();
			n.valor = value;
			n.central = null;
			n.lateral = null;
			return n;
		}
		return node.lateral = addLateral(node, value);
	}
}
