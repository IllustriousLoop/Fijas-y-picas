package com.fijasypicas;

import com.fijasypicas.utils.ChoiseMenu;
import com.fijasypicas.utils.Screen;
import com.fijasypicas.utils.Colors;

public class App {
    private static String[] choices = { "You VS AI", "You VS Friend", "AI VS AI" };

    public static void main(String[] args) {
        Screen.Welcome();
        new ChoiseMenu(choices, "Choose your game mode: ");
        int value = ChoiseMenu.getChoice();
        System.out.println(Colors.getYELLOW() + "You choose: " + Colors.getRESET() + value);
        Screen.Bye();
    }
}
