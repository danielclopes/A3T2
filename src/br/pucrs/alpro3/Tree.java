/**
 * @author Daniel Lopes
 * @author Eurico Neto
 * Trabalho 2 de Algoritmos e Programação III: Fundindo Árvores
 */

package br.pucrs.alpro3;

public class Tree {
	private Node root;
	private Node[] left, right;
	private int leaf = 0; // 0-> Lateral, 1-> Central
	private int d, e, d1, e1;

	public Tree() {
		root = null;
	}

	public Tree(int[] entry) {
		left = new Node[entry[0] + 1];
		e1 = entry[0];
		
		for (int i = 1; i < left.length; i++) {
			left[i] = new Node();
			left[i].value = i;
		}
		for (int i = 0; i < (left.length - 1) * 3; i += 3) {
			addTupla(left[entry[i + 1]], left[entry[i + 2]], left[entry[i + 3]]);
		}
	}

	public void addTupla(Node parent, Node sideLeaf, Node centerLeaf) {
		root = parent;
		root.center = centerLeaf;
		root.side = sideLeaf;
		root = left[1];
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
