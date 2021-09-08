package com.fijasypicas.utils.AI;

import java.util.ArrayList;
import java.util.Scanner;

import com.fijasypicas.utils.ClearConsole;
import com.fijasypicas.utils.Colors;

public class Start {
	static Scanner sc = new Scanner(System.in);

	private static void YouVsAI(int n) {
		Basic ai = new Basic(n);
		ArrayList<Integer> list = new ArrayList<Integer>();
		while (ai.fijas < n) {
			list.clear();
			System.out.println("Enter " + n + " digit: ");
			int v = sc.nextInt();
			int valid = String.valueOf(v).length();

			if (v == 9501) {
				System.out.println(ai.getNumberGuess() + " " + Colors.GREEN("is the number"));
			}
			if (valid < n || valid > n) {
				System.out.println(Colors.RED_BACKGROUND("The number is bad"));
			} else {
				// split the int v in array
				for (int i = 0; i < n; i++) {
					list.add(v % 10);
					v /= 10;
				}
				// invert the array
				for (int i = 0; i < list.size() / 2; i++) {
					int temp = list.get(i);
					list.set(i, list.get(list.size() - i - 1));
					list.set(list.size() - i - 1, temp);
				}
				new ClearConsole();
				ai.updateData(list);
			}
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
	}

}
