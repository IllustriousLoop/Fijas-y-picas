package com.fijasypicas.utils;

import java.util.*;

public class ChoiseMenu {
	private static int choice = 0;
	private static Scanner sc = new Scanner(System.in); // ? System.in is a standard input stream
	private static String[] options;
	private static String msg;

	public static int getChoice() {
		return choice;
	}

	// method of choise in the console
	private static int menu() {
		new ClearConsole();
		System.out.println(msg);
		for (int i = 0; i < options.length; i++) {
			if (i == choice)
				System.out.println(Colors.BLUE("> ") + Colors.CYAN(options[i]));
			else
				System.out.println("  " + options[i]);
		}
		String view = sc.nextLine();
		switch (view) {
			case "s":
				if (choice + 1 == options.length)
					choice = 0;
				else
					choice++;
				return menu();
			case "S":
				if (choice + 1 == options.length)
					choice = 0;
				else
					choice++;
				return menu();
			case "w":
				if (choice > 0)
					choice--;
				else
					choice = 0;
				return menu();
			case "W":
				if (choice > 0)
					choice--;
				else
					choice = 0;
				return menu();
			default:
				return choice;
		}
	}

	public ChoiseMenu(String[] options, String msg) {
		ChoiseMenu.options = options;
		ChoiseMenu.msg = msg;
		menu();
	}

	public ChoiseMenu() {
	}
}
