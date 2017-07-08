/**
 * @author Daniel Lopes e Eurico Neto
 * Trabalho 2 de Algoritmos e Programação III: Fundindo Árvores
 */

package br.pucrs.alpro3;

public class App {

	public static void main(String[] args) {

		InputFileReader ifr = new InputFileReader("/home/daniel/F/input/F_14");

		Tree t1 = new Tree(ifr.lTree());
		Tree t2 = new Tree(ifr.rTree(), 0);

		System.out.println("Total de nodos: " + t1.size());
		System.out.println();

		System.out.println("Total de nodos: " + t2.size());

		int total = Integer.max(Integer.min(t1.size(), t2.centralSize()), Integer.min(t2.size(), t1.centralSize()));
		total = t1.size() + t2.size() - total;
		System.out.println("\nTotal de nodos da fusão: " + total);

		System.out.println("\n\nTotal de nodos: " + (t1.size() + t2.size()));
		System.out.println("Total de operações: " + (t1.getZ() + t2.getZ()));
	}

}
