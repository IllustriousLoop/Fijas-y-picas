package com.fijasypicas;

import com.fijasypicas.utils.ChoiseMenu;
import com.fijasypicas.utils.ClearConsole;
import com.fijasypicas.utils.Screen;
import com.fijasypicas.utils.AI.Start;

public class App {
    private static String[] choices = { "😎 You VS AI 🤖", "😎 You VS Friend 🥸", "🤖 AI VS AI 🤖", "❌ Exit 🚶" };

    public static void main(String[] args) {
        Screen.Welcome();
        boolean exit = false;
        while (!exit) {
            new ChoiseMenu(choices, "Choose your game mode: ");
            int value = ChoiseMenu.getChoice();
            if (value == 3) {
                exit = true;
                break;
            } else {
                new Start(value);
                new ClearConsole(250);
            }
        }
        Screen.Bye();
    }
}
