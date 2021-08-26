package com.fijasypicas.utils.AI;

import java.util.ArrayList;

import com.fijasypicas.utils.Colors;

public class Basic {
	private int numberMain;
	private static ArrayList<Integer> number = new ArrayList<Integer>();
	private ArrayList<ArrayList<Object>> arrayComplex = new ArrayList<ArrayList<Object>>();
	private ArrayList<Integer> arrayOfValues = new ArrayList<Integer>();
	public static ArrayList<String> history = new ArrayList<String>();
	public int fijas = 0;
	private int picas = 0;

	public String getNumberGuess() {
		return number.toString();
	}

	private void init(int val) {
		ArrayList<Integer> numer = new ArrayList<Integer>();
		for (int i = 0; i < val; i++) {
			int r = (int) ((Math.random() * (10 - 1) + 1));
			if (!numer.contains(r)) {
				numer.add(r);
			} else {
				i--;
			}
		}
		Basic.number = numer;
	}

	private boolean comprobar() {
		boolean prueba = true;
		// comprobar si hay un elemento repetido en arrayOfValues
		for (int i = 0; i < arrayOfValues.size(); i++) {
			for (int j = 0; j < arrayOfValues.size(); j++) {
				if (i != j && arrayOfValues.get(i) == arrayOfValues.get(j)) {
					prueba = false;
				}
			}
		}
		return prueba;
	};

	private void miniAI() {
		boolean numberR = comprobar();
		for (int i = 0; i < arrayComplex.size(); i++) {
			ArrayList<Object> val = arrayComplex.get(i);
			if (!numberR) {
				if (i == numberMain - 1) {
					String listString = "";
					for (Integer s : arrayOfValues) {
						listString += s;
					}
					history.add(listString);
					System.out.println("Recuerda ninguna cifra se repite");
				}
			} else {
				if (val.get(0) == number.get(i)) {
					fijas++;
					val.set(1, true);
				}
				if (number.contains(val.get(0)) && Boolean.parseBoolean(val.get(1) + "") == false) {
					picas++;
				}
				if (i == numberMain - 1) {
					String listString = "";
					for (Integer s : arrayOfValues) {
						listString += s;
					}
					history.add(listString);
					if (fijas == numberMain) {
						System.out.println("¡¡¡GANASTE!!! 🚀");
					} else {
						System.out.println(Colors
								.GREEN_BACKGROUND(Colors.BLACK("  Hay " + fijas + " fijas y " + picas + " picas  ")));
					}
				}
			}
		}
		System.out.println(Colors.RED("history"));
		for (int j = 0; j < history.size(); j++)
			System.out.println(Colors.YELLOW((j + 1) + ") ") + history.get(j));
	};

	public Basic(int nPrincipal) {
		this.numberMain = nPrincipal;
		init(numberMain);
	}

	public void updateData(ArrayList<Integer> eval) {
		fijas = 0;
		picas = 0;
		arrayComplex.clear();
		arrayOfValues.clear();
		for (int i = 0; i < eval.size(); i++) {
			ArrayList<Object> val = new ArrayList<Object>(2);
			val.add(eval.get(i));
			val.add(false);
			arrayComplex.add(val);
			arrayOfValues.add(eval.get(i));
		}
		miniAI();
	}
}
