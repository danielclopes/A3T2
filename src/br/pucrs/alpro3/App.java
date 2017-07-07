/**
 * @author Daniel Lopes
 * @author Eurico Neto
 * Trabalho 2 de Algoritmos e Programação III: Fundindo Árvores
 */

package br.pucrs.alpro3;

public class App {

	public static void main(String[] args) {
		// Tree t1 = new Tree();
		int[] fileC = { 5, 1, 2, 3, 2, 4, 5, 3, 0, 0, 4, 0, 0, 5, 0, 0 };
		int[] fileD = { 3, 1, 2, 3, 2, 0, 0, 3, 0, 0 };
		Tree t1 = new Tree(fileC);
		Tree t2 = new Tree(fileD);

		t1.reportHeight();
		System.out.println(t1);

		t2.reportHeight();
		System.out.println(t2);
	}

}
