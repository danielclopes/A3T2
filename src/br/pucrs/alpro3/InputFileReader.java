/**
 * @author Daniel Lopes e Eurico Neto
 * Trabalho 2 de Algoritmos e Programação III: Fundindo Árvores
 */

package br.pucrs.alpro3;

import java.io.BufferedReader;
import java.io.*;
import java.io.IOException;

public class InputFileReader {
	private String linha = "";
	private String[] tr;
	private int[] arvE, arvD;
	private int tam, pos = 1;

	public InputFileReader(String path) {
		try {
			BufferedReader buff = new BufferedReader(new FileReader(path));
			try {
				linha = buff.readLine();
				tr = linha.split(" ");
				tam = (Integer.parseInt(tr[0]) * 3) + 1;
				arvE = new int[tam];
				arvE[0] = Integer.parseInt(tr[0]);
				while ((linha = buff.readLine()) != null && pos < tam - 1) {
					tr = linha.split(" ");
					arvE[pos] = Integer.parseInt(tr[0]);
					arvE[pos + 1] = Integer.parseInt(tr[1]);
					arvE[pos + 2] = Integer.parseInt(tr[2]);
					pos += 3;
				}

				tr = linha.split(" ");
				tam = (Integer.parseInt(tr[0]) * 3) + 1;
				arvD = new int[tam];
				arvD[0] = Integer.parseInt(tr[0]);
				pos = 1;
				while ((linha = buff.readLine()) != null && pos < tam) {
					tr = linha.split(" ");
					arvD[pos] = Integer.parseInt(tr[0]);
					arvD[pos + 1] = Integer.parseInt(tr[1]);
					arvD[pos + 2] = Integer.parseInt(tr[2]);
					pos += 3;
				}

			} finally {
				buff.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int[] lTree() {
		return arvE;
	}

	public int[] rTree() {
		return arvD;
	}

}
