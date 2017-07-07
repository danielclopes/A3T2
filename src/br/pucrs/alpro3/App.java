package br.pucrs.alpro3;

public class App {

	public static void main(String[] args) {
		Tree t1 = new Tree();
		// Tree t2 = new Tree();
		int[] arvC = { 1, 2, 3, 2, 4, 5, 3, 0, 0, 4, 0, 0, 5, 0, 0 };
		// int[] arvD = { 1, 2, 3, 2, 0, 0, 3, 0, 0 };

		/*
		 * for (int i = 0; i < arvC.length; i += 3) { t1.add(arvC[i]);
		 * System.out.println(i+";"+t1.getCont()); t1.addLateral(arvC[i + 1]);
		 * System.out.println(i+";"+t1.getCont()); t1.addCentral(arvC[i + 2]);
		 * System.out.println(i+";"+t1.getCont()); }
		 */

		/*t1.add(1);
		t1.add(2);
		t1.add(3);
		t1.add(4);
		t1.add(5);*/

		//System.out.println("Altura: " + t1.size());

		t1.reportHeight();

		System.out.println(t1);
	}

}
