/**
 * @author Daniel Lopes e Eurico Neto
 * Trabalho 2 de Algoritmos e Programação III: Fundindo Árvores
 */

package br.pucrs.alpro3;

public class Tree {
	private Node root;
	private Node[] tree;
	private static int z;

	public Tree() {
		root = null;
	}

	public Tree(int[] entry) {
		z = 0;
		tree = new Node[entry[0] + 1];

		for (int i = 1; i < tree.length; i++) {
			tree[i] = new Node();
			tree[i].value = i;
			z++;
		}
		for (int i = 0; i < (tree.length - 1) * 3; i += 3) {
			addTuple(tree[entry[i + 1]], tree[entry[i + 2]], tree[entry[i + 3]]);
			z++;
		}
	}

	/*
	 * Esse construtor serve apenas para a árvore direita pois nesse arranjo
	 * haverá diferença se os nodes forem inseridos invertidos.
	 */
	public Tree(int[] entry, int d) {
		z = 0;
		tree = new Node[entry[0] + 1];

		for (int i = 1; i < tree.length; i++) {
			tree[i] = new Node();
			tree[i].value = i;
			z++;
		}
		for (int i = 0; i < (tree.length - 1) * 3; i += 3) {
			addTuple(tree[entry[i + 1]], tree[entry[i + 3]], tree[entry[i + 2]]);
			z++;
		}
	}

	/*
	 * Adiciona os nodos na sequencia pai, filho lateral e filho central.
	 */
	private void addTuple(Node parent, Node sideLeaf, Node centerLeaf) {
		root = parent;
		root.center = centerLeaf;
		root.side = sideLeaf;
		root = tree[1];
	}

	public int centralSize() {
		int a = centralSize0(root), b = centralSize0(root.side);
		if (a > b)
			return a;
		return b;
	}

	private int centralSize0(Node n) {
		if (n == null)
			return 0;
		return 1 + centralSize0(n.center);
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

	public int getZ() {
		return z;
	}

	public String toString() {
		return toString0(root);
	}

	private String toString0(Node node) {
		if (node == null)
			return " # ";
		return toString0(node.side) + String.format(" %d ", node.value) + toString0(node.center);
	}
}
