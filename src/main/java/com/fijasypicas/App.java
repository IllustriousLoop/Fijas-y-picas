package com.fijasypicas;

import java.util.Scanner;

import com.fijasypicas.utils.ChoiseMenu;
import com.fijasypicas.utils.Screen;
import com.fijasypicas.utils.AI.Basic;
import com.fijasypicas.utils.Colors;
import com.fijasypicas.utils.ClearConsole;
import java.util.ArrayList;

public class App {
    private static String[] choices = { "You VS AI", "You VS Friend", "AI VS AI" };
    static Scanner sc = new Scanner(System.in);

    private static void YouVsAI() {
        // Screen.YouVsAI();
        System.out.println("How many " + Colors.PURPLE("digits") + " is the number");
        int n = sc.nextInt();
        if (n >= 2 && n <= 8) {
            Basic ai = new Basic(n);
            while (ai.fijas < n) {
                ArrayList<Integer> list = new ArrayList<Integer>();
                for (int i = 0; i < n; i++) {
                    if (list.size() > 0) {
                        String num = "";
                        ai.showHistory();
                        for (Integer integer : list)
                            num += integer < 10 ? Colors.GREEN(integer + "") : Colors.RED(integer + "");
                        System.out.println(num);
                    }
                    System.out.println("Enter " + Colors.CYAN((i + 1) + "") + " digit: ");
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
        } else {
            YouVsAI();
        }
    }

    public static void main(String[] args) {
        Screen.Welcome();
        new ChoiseMenu(choices, "Choose your game mode: ");
        int value = ChoiseMenu.getChoice();
        switch (value) {
            case 0:
                YouVsAI();
                break;
            case 1:

                break;
            case 2:

                break;
            default:
                System.out.println(Colors.RED("Invalid option"));
                break;
        }
        sc.close();
        Screen.Bye();

    }
}
