/**
 * @author Daniel Lopes e Eurico Neto
 * Trabalho 2 de Algoritmos e Programação III: Fundindo Árvores
 */

package br.pucrs.alpro3;

import static org.junit.Assert.*;

import org.junit.Test;

public class AppTreeTest {

	@Test
	public void test() {
		int[] canhota2 = { 5, 1, 2, 3, 2, 4, 5, 3, 0, 0, 4, 0, 0, 5, 0, 0 };
		Tree t1 = new Tree(canhota2);
		
		int expected = 5;
		int actual = t1.size();
		assertEquals(expected, actual);
	}

}
