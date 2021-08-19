package com.fijasypicas.utils;

import java.io.IOException;

public class ClearConsole {
	private void clean() {
		final String os = System.getProperty("os.name");
		if (os.contains("Windows")) {
			try {
				Runtime.getRuntime().exec("cls");// use this for windows
			} catch (IOException e) {
			}
			System.out.println("windows");
		} else {
			System.out.print("\u001b[H\u001b[2J");
			System.out.flush();
		}
	}

	public ClearConsole() {
		clean();
	}

	public ClearConsole(int time) {
		try {
			Thread.sleep(1000);
			clean();
		} catch (InterruptedException e) {
		}
	}
}
