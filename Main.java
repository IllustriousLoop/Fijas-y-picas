import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	private static int numberMain;
	private static ArrayList<Integer> arrayOfValues = new ArrayList<Integer>();
	private static ArrayList<ArrayList<Object>> history = new ArrayList<ArrayList<Object>>();
	private static boolean isWinner = false;
	private static String playerOne = "give";
	private static String playerTwo = "";
	private static int fijas = 0;
	private static int picas = 0;
	private static int currentNumber = 0;

	private static int choice = 0;
	private static Scanner sc = new Scanner(System.in);
	private static String[] options = { "You VS AI", "You VS Friend", "Exit" };
	private static String msg = "Choose your game mode:  ";

	private static int menu() {
		System.out.println(msg);
		for (int i = 0; i < options.length; i++)
			if (i == choice)
				System.out.println("> "+ options[i]);
			else
				System.out.println("  " + options[i]);
		String view = sc.nextLine();
		if (view.equals("s") || view.equals("S")) {
			if (choice + 1 == options.length)
				choice = 0;
			else
				choice++;
			return menu();
		} else if (view.equals("w") || view.equals("W")) {
			if (choice > 0)
				choice--;
			else
				choice = 0;
			return menu();
		} else
			return choice;
	}

	private static boolean isRepeated() {
		boolean prueba = true;
		for (int i = 0; i < arrayOfValues.size(); i++)
			for (int j = 0; j < arrayOfValues.size(); j++)
				if (i != j && arrayOfValues.get(i) == arrayOfValues.get(j))
					prueba = false;
		return prueba;
	};

	private static void updateHistory(int player) {
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

	private static void nextTurn() {
		boolean numberR = isRepeated();
		for (int i = 0; i < arrayOfValues.size(); i++) {
			int t = Integer.parseInt(arrayOfValues.toString().replaceAll("\\[|\\]", "").replaceAll(", ", ""));
			if (!numberR) {
				if (i == numberMain - 1) {
					System.out.println(" 💀💀 Remember no figure repeats 🚫🚫 ");
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

	private static void finishTurn() {
		boolean ok = false;
		while (!ok) {
			System.out.println(" " + currentNumber + " ");
			System.out.println("Enter fijas: ");
			fijas = sc.nextInt();
			System.out.println("Enter picas: ");
			picas = sc.nextInt();
			if (picas + fijas > numberMain) {
				System.out
						.println("The sum of the tracks cannot be greater than the number of digits that were chosen");
			} else if (fijas == numberMain) {
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

	public static void showHistory(int player) {
		if (history.size() > 0) {
			String head = "🦖 History 🦴";
			if (player == 0)
				System.out.println(head);
			else if (player == 1)
				System.out.println(head);
		}
		for (int i = 0; i < history.size(); i++) {
			ArrayList<Object> array = history.get(i);
			if (Integer.parseInt(array.get(1) + "") == player) {
				System.out.println(i + 1 + ") " + array.get(0));
			}
		}
		if (history.size() > 0)
			System.out.println("\n 🚧🚧🚧🚧🚧🚧🚧🚧🚧🚧🚧🚧 \n");
	}

	private static void drawTurn() {
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
		System.out.println("Player 1: "+ state1 + "  Player 2: " + state2);
	}

	public static void Humans() {
		while (!isWinner) {
			arrayOfValues.clear();
			ArrayList<Integer> numberStake = new ArrayList<Integer>();
			drawTurn();
			System.out.println("Enter " + numberMain + " digit: ");
			int v = sc.nextInt();
			int valid = String.valueOf(v).length();
			if (valid < numberMain || valid > numberMain)
				System.out.println("The number is bad");
			else {
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

	private static void YouVsFriend(int n) {
		numberMain = n;
		System.out.println("How many persons want play");
		int p = sc.nextInt();
		if (p == 2)
			Humans();
		else {
			System.out.println("The number of persons must be 2");
			YouVsFriend(n);
		}
	}

	private static boolean managerType(int type, int n) {
		if (type == 0) {
			System.out.println("Not implemented yet");
			return false;
		} else if (type == 1) {
			YouVsFriend(n);
			return false;
		} else if (type == 2) {
			System.out.println("Not implemented yet");
			return false;
		} else {
			System.out.println("Invalid option");
			return false;
		}
	}

	public static void main(String[] args) {
		boolean exit = false;
		while (!exit) {
			menu();
			if (choice == 3) {
				exit = true;
				break;
			} else {
				System.out.println("How many digits is the number");
				int n = sc.nextInt();
				if (n >= 2 && n <= 8) {
					boolean ex = managerType(choice, n);
					if (ex) {
						exit = true;
						break;
					} else {
						menu();
					}
				} else
					System.out.println("The number of digits must be between 2 and 8");
			}
		}
	}
}