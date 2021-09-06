package com.fijasypicas.utils.AI;

import java.util.ArrayList;
import java.util.Scanner;

import com.fijasypicas.utils.ClearConsole;
import com.fijasypicas.utils.Colors;

public class Start {
	static Scanner sc = new Scanner(System.in);
	public static boolean Exit = false;

	private static void YouVsAI(int n) {
		Basic ai = new Basic(n);
		while (ai.fijas < n) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < n; i++) {
				if (list.size() > 0) {
					String num = "";
					ai.showHistory();
					for (Integer integer : list)
						num += integer < 10 ? Colors.GREEN(integer) : Colors.RED(integer);
					System.out.println(num);
				}
				System.out.println("Enter " + Colors.CYAN((i + 1)) + " digit: ");
				int v = sc.nextInt();
				if (v == 9501) {
					System.out.println(ai.getNumberGuess() + " " + Colors.GREEN("is the number"));
					i--;
				} else if (v >= 10) {
					i--;
					System.out.println(
							Colors.RED_BACKGROUND("The input ") + Colors.RED_BACKGROUND(Colors.BLUE(" " + v + " "))
									+ Colors.RED_BACKGROUND(" is'n valid!!"));
					new ClearConsole(500);
				} else {
					list.add(v);
					new ClearConsole();
				}
			}
			ai.updateData(list);
		}
	}

	private static void YouVsFriend(int n) {
		System.out.println("How many " + Colors.PURPLE("persons") + " want play");
		int p = sc.nextInt();
		if (p == 2) {
			new Humans(n);
		} else {
			System.out.println(Colors.RED("The number of persons must be 2"));
			new ClearConsole(500);
			YouVsFriend(n);
		}
	}

	private static void managerType(int type, int n) {
		switch (type) {
			case 0:
				// Screen.YouVsAI();
				YouVsAI(n);
				break;
			case 1:
				// Screen.YouVsFriend();
				YouVsFriend(n);
				break;
			case 2:
				System.out.println(Colors.GREEN_BACKGROUND(Colors.BLACK("Not implemented yet")));
				break;
			default:
				System.out.println(Colors.RED("Invalid option"));
				break;
		}
	}

	public Start(int type) {
		System.out.println("How many " + Colors.PURPLE("digits") + " is the number");
		int n = sc.nextInt();
		if (n >= 2 && n <= 8) {
			managerType(type, n);
		} else {
			System.out.println(Colors.RED("Remember that the accepted values are N (2 ≤ N ≤ 8)"));
			new ClearConsole(500);
		}
		Exit = true;
	}

}
