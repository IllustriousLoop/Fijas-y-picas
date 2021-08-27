package com.fijasypicas.utils;

import lombok.Getter;

public class Colors {
	//  Letra
	@Getter
	private static final String BLACK = "\u001B[30m";
	@Getter
	private static final String RED = "\u001B[31m";
	@Getter
	private static final String GREEN = "\u001B[32m";
	@Getter
	private static final String YELLOW = "\u001B[33m";
	@Getter
	private static final String BLUE = "\u001B[34m";
	@Getter
	private static final String PURPLE = "\u001B[35m";
	@Getter
	private static final String CYAN = "\u001B[36m";
	@Getter
	private static final String WHITE = "\u001B[37m";
	@Getter
	private static final String RESET = "\u001B[0m";

	//  Fondo
	private static final String BLACK_BACKGROUND = "\u001B[40m";
	private static final String RED_BACKGROUND = "\u001B[41m";
	private static final String GREEN_BACKGROUND = "\u001B[42m";
	private static final String YELLOW_BACKGROUND = "\u001B[43m";
	private static final String BLUE_BACKGROUND = "\u001B[44m";
	private static final String PURPLE_BACKGROUND = "\u001B[45m";
	private static final String CYAN_BACKGROUND = "\u001B[46m";
	private static final String WHITE_BACKGROUND = "\u001B[47m";

	public static String BLACK(String text) {
		return BLACK + text + RESET;
	}

	public static String BLUE(String text) {
		return BLUE + text + RESET;
	};

	public static String CYAN(String text) {
		return CYAN + text + RESET;
	};

	public static String GREEN(String text) {
		return GREEN + text + RESET;
	};

	public static String PURPLE(String text) {
		return PURPLE + text + RESET;
	};

	public static String RED(String text) {
		return RED + text + RESET;
	};

	public static String YELLOW(String text) {
		return YELLOW + text + RESET;
	};

	public static String WHITE(String text) {
		return WHITE + text + RESET;
	};

	public static String BLACK_BACKGROUND(String text) {
		return BLACK_BACKGROUND + text + RESET;
	};

	public static String BLUE_BACKGROUND(String text) {
		return BLUE_BACKGROUND + text + RESET;
	};

	public static String CYAN_BACKGROUND(String text) {
		return CYAN_BACKGROUND + text + RESET;
	};

	public static String GREEN_BACKGROUND(String text) {
		return GREEN_BACKGROUND + text + RESET;
	};

	public static String PURPLE_BACKGROUND(String text) {
		return PURPLE_BACKGROUND + text + RESET;
	};

	public static String RED_BACKGROUND(String text) {
		return RED_BACKGROUND + text + RESET;
	};

	public static String YELLOW_BACKGROUND(String text) {
		return YELLOW_BACKGROUND + text + RESET;
	};

	public static String WHITE_BACKGROUND(String text) {
		return WHITE_BACKGROUND + text + RESET;
	};

	public static String BLACK(int text) {
		return BLACK + text + RESET;
	}

	public static String BLUE(int text) {
		return BLUE + text + RESET;
	};

	public static String CYAN(int text) {
		return CYAN + text + RESET;
	};

	public static String GREEN(int text) {
		return GREEN + text + RESET;
	};

	public static String PURPLE(int text) {
		return PURPLE + text + RESET;
	};

	public static String RED(int text) {
		return RED + text + RESET;
	};

	public static String YELLOW(int text) {
		return YELLOW + text + RESET;
	};

	public static String WHITE(int text) {
		return WHITE + text + RESET;
	};

	public static String BLACK_BACKGROUND(int text) {
		return BLACK_BACKGROUND + text + RESET;
	};

	public static String BLUE_BACKGROUND(int text) {
		return BLUE_BACKGROUND + text + RESET;
	};

	public static String CYAN_BACKGROUND(int text) {
		return CYAN_BACKGROUND + text + RESET;
	};

	public static String GREEN_BACKGROUND(int text) {
		return GREEN_BACKGROUND + text + RESET;
	};

	public static String PURPLE_BACKGROUND(int text) {
		return PURPLE_BACKGROUND + text + RESET;
	};

	public static String RED_BACKGROUND(int text) {
		return RED_BACKGROUND + text + RESET;
	};

	public static String YELLOW_BACKGROUND(int text) {
		return YELLOW_BACKGROUND + text + RESET;
	};

	public static String WHITE_BACKGROUND(int text) {
		return WHITE_BACKGROUND + text + RESET;
	};
}
