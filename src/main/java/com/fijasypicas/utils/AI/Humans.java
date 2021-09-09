package com.fijasypicas.utils.AI;

import java.util.ArrayList;
import java.util.Scanner;

import com.fijasypicas.utils.ClearConsole;
import com.fijasypicas.utils.Colors;

public class Humans {
	static Scanner sc = new Scanner(System.in);
	private int numberMain;
	private ArrayList<Integer> arrayOfValues = new ArrayList<Integer>();
	private static ArrayList<ArrayList<Object>> history = new ArrayList<ArrayList<Object>>();
	private boolean isWinner = false;
	private String playerOne = "give";
	private String playerTwo = "";
	private int fijas = 0;
	private int picas = 0;
	private int currentNumber = 0;

	private boolean testRepeated() {
		boolean prueba = true;
		// Check if there is a repeating element in arrayOfValues
		for (int i = 0; i < arrayOfValues.size(); i++) {
			for (int j = 0; j < arrayOfValues.size(); j++) {
				if (i != j && arrayOfValues.get(i) == arrayOfValues.get(j)) {
					prueba = false;
				}
			}
		}
		return prueba;
	};

	private void updateHistory(int player) {
		String listString = "", emojiFijas = "", emojiPicas = "";
		for (Integer s : arrayOfValues)
			listString += s;
		if (fijas != 0)
			for (int i = 0; i < fijas; i++)
				emojiFijas += " 🎯";
		if (picas != 0)
			for (int i = 0; i < picas; i++)
				emojiPicas += " 🤡";
		if (listString != "") {
			ArrayList<Object> array = new ArrayList<Object>(2);
			array.add(listString + emojiFijas + "  " + emojiPicas);
			array.add(player);
			history.add(array);
		}
	}

	private void nextTurn() {
		boolean numberR = testRepeated();
		for (int i = 0; i < arrayOfValues.size(); i++) {
			int t = Integer.parseInt(arrayOfValues.toString().replaceAll("\\[|\\]", "").replaceAll(", ", ""));
			if (!numberR) {
				if (i == numberMain - 1) {
					new ClearConsole();
					System.out
							.println(Colors.PURPLE_BACKGROUND(Colors.BLACK(" 💀💀 Remember no figure repeats 🚫🚫 ")));
					new ClearConsole(600);
					if (playerOne == "give") {
						playerOne = "wait";
						playerTwo = "clue";
						System.out.println("Player 2 pass the 'fijas' and 'picas' to Player 1");
						currentNumber = t;
					} else if (playerTwo == "give") {
						playerOne = "clue";
						playerTwo = "wait";
						System.out.println("Player 1 pass the 'fijas' and 'picas' to Player 2");
						currentNumber = t;
					}
				}
			} else {
				new ClearConsole();
				if (i == numberMain - 1) {
					if (playerOne == "give") {
						playerOne = "wait";
						playerTwo = "clue";
						System.out.println("Player 2 pass the 'fijas' and 'picas' to Player 1");
						currentNumber = t;
					} else if (playerTwo == "give") {
						playerOne = "clue";
						playerTwo = "wait";
						System.out.println("Player 1 pass the 'fijas' and 'picas' to Player 2");
						currentNumber = t;
					}
				}
			}
		}

	};

	private void finishTurn() {
		boolean ok = false;
		while (!ok) {
			System.out.println(Colors.YELLOW_BACKGROUND(" " + Colors.BLACK(currentNumber + " ")));
			System.out.println("Enter " + Colors.CYAN("fijas") + ": ");
			fijas = sc.nextInt();
			System.out.println("Enter " + Colors.CYAN("picas") + ": ");
			picas = sc.nextInt();
			if (picas + fijas > numberMain) {
				System.out
						.println("The sum of the tracks cannot be greater than the number of digits that were chosen");
			} else if (fijas == numberMain) {
				new ClearConsole();
				if (playerOne == "wait") {
					System.out.println("Player 1 are winner");
					isWinner = true;
				}
				if (playerTwo == "wait") {
					System.out.println("Player 2 are winner");
					isWinner = true;
				}
				ok = true;
			} else {
				new ClearConsole();
				if (playerOne == "wait") {
					updateHistory(0);
					playerOne = "";
					playerTwo = "give";
					System.out.println("Try to guess the number of Player 1");
				} else if (playerTwo == "clue") {
					playerOne = "give";
					playerTwo = "";
					System.out.println("Try to guess the number of Player 2");
				} else if (playerTwo == "wait") {
					updateHistory(1);
					playerOne = "give";
					playerTwo = "";
					System.out.println("Try to guess the number of Player 2");
				}
				ok = true;
			}
		}
	};

	public void showHistory(int player) {
		if (history.size() > 0) {
			String head = "🦖 History 🦴";
			if (player == 0)
				System.out.println(Colors.YELLOW(head));
			else if (player == 1)
				System.out.println(Colors.PURPLE(head));
		}
		for (int i = 0; i < history.size(); i++) {
			ArrayList<Object> array = history.get(i);
			if (Integer.parseInt(array.get(1) + "") == player) {
				System.out.println(Colors.YELLOW((i + 1) + ") ") + array.get(0));
			}
		}
		if (history.size() > 0)
			System.out.println("\n 🚧🚧🚧🚧🚧🚧🚧🚧🚧🚧🚧🚧 \n");
	}

	private void drawTurn() {
		String state1 = "", state2 = "";
		if (playerOne == "") {
			state1 = "😐";
		} else if (playerTwo == "") {
			state2 = "😐";
		}
		if (playerOne == "give") {
			showHistory(0);
			state1 = "🟢";
		} else if (playerTwo == "give") {
			showHistory(1);
			state2 = "🟢";
		}
		if (playerOne == "wait") {
			state1 = "⏲️";
		} else if (playerTwo == "wait") {
			state2 = "⏲️";
		}
		if (playerOne == "clue") {
			state1 = "ℹ️";
		} else if (playerTwo == "clue") {
			state2 = "ℹ️";
		}
		System.out.println(Colors.YELLOW("Player 1: ") + state1 + Colors.PURPLE("  Player 2: ") + state2);
	}

	public Humans(int nPrincipal) {
		this.numberMain = nPrincipal;
		while (!isWinner) {
			arrayOfValues.clear();
			ArrayList<Integer> numberStake = new ArrayList<Integer>();
			drawTurn();
			System.out.println("Enter " + numberMain + " digit: ");
			int v = sc.nextInt();
			int valid = String.valueOf(v).length();
			if (valid < numberMain || valid > numberMain) {
				System.out.println(Colors.RED_BACKGROUND("The number is bad"));
			} else {
				// split the int v in array
				for (int i = 0; i < numberMain; i++) {
					numberStake.add(v % 10);
					arrayOfValues.add(v % 10);
					v /= 10;
				}
				// invert the array
				for (int i = 0; i < numberStake.size() / 2; i++) {
					int temp = numberStake.get(i);
					int temp2 = arrayOfValues.get(i);
					numberStake.set(i, numberStake.get(numberStake.size() - i - 1));
					arrayOfValues.set(i, arrayOfValues.get(arrayOfValues.size() - i - 1));

					numberStake.set(numberStake.size() - i - 1, temp);
					arrayOfValues.set(arrayOfValues.size() - i - 1, temp2);
				}
				nextTurn();
				drawTurn();
				finishTurn();
			}
		}
	}
}
