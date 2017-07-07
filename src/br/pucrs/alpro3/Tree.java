package br.pucrs.alpro3;

public class Tree {
	private Node root, lastEntry;
	private Node[] arNode;
	private int leaf = 0; // 0-> Lateral, 1-> Central

	public Tree() {
		root = null;
		arNode = new Node[6];
		arNode[1] = new Node();
		arNode[1].value = 1;
		arNode[2] = new Node();
		arNode[2].value = 2;
		arNode[3] = new Node();
		arNode[3].value = 3;
		arNode[4] = new Node();
		arNode[4].value = 4;
		arNode[5] = new Node();
		arNode[5].value = 5;

		addTupla(arNode[1], arNode[2], arNode[3]);
		addTupla(arNode[2], arNode[4], arNode[5]);
		//inorderHelper(root);
		System.out.println("\n");
	}

	public void addTupla(Node pai, Node filhoLateral, Node filhoCentral) {
		root = pai;
		root.center = filhoCentral;
		root.side = filhoLateral;
		root = arNode[1];
	}

	public void add(int value) {
		root = add0(root, value);
	}

	private Node add0(Node node, int value) {
		if (node == null) {
			Node n = new Node();
			n.value = value;
			n.center = null;
			n.side = null;
			return n;
		}
		if (leaf == 0) {
			node.center = add0(node.center, value);
			leaf = 1;
		} else {
			node.side = add0(node.side, value);
			leaf = 0;
		}
		return node;
	}

	public int size() {
		return size0(root);
	}

	private int size0(Node node) {
		if (node == null)
			return 0;

		return 1 + size0(node.center) + size0(node.side);
	}

	public void reportHeight() {
		reportHeight0(root);
	}

	private int reportHeight0(Node node) {
		if (node == null) {
			return -1;
		}
		int hl = reportHeight0(node.side);
		int hr = reportHeight0(node.center);
		int height = Math.max(hl, hr) + 1;
		System.out.printf("Key=%d Height=%d!\n", node.value, height);
		return height;
	}

	public String toString() {
		return toString0(root);
	}

	private String toString0(Node node) {
		if (node == null)
			return " # ";
		return toString0(node.side) + String.format(" %d ", node.value) + toString0(node.center);
	}
	/* Caminhamento central livro "Java - Como Programar, Deitel" */
	private void inorderHelper(Node node) {
		if (node == null)
			return;
		inorderHelper(node.side); // percorre subárvore esquerda
		System.out.printf("%s ", node.value); // gera saída de dados do nó
		inorderHelper(node.center); // percorre subárvore direita
	}

}
