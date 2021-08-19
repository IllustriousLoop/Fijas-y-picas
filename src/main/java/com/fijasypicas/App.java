package com.fijasypicas;

import java.util.*;

/**
 * Main
 */

public class App {

    private static int choice = 0;
    private static Scanner sc = new Scanner(System.in); // ? System.in is a standard input stream
    // Strings with ansi letters
    private static String nameAuthor = "[0;1;34;94m┌───────────────[0;34m──────────────┐[0m\n[0;1;34;94m│[0m [0;1;34;94m▜▘▌[0m     [0;34m▗[0m     [0;34m▛▀▖[0m      [0;37m▗[0m    [0;37m│[0m\n[0;34m│[0m [0;34m▐[0m [0;34m▛▀▖▝▀▖▄[0m [0;34m▙▀▖[0m [0;37m▙▄▘▝▀▖▙▀▖▄[0m [0;37m▞▀▘│[0m\n[0;34m│▌▐[0m [0;34m▌[0m [0;34m▌▞[0;37m▀▌▐[0m [0;37m▌[0m   [0;37m▌[0m  [0;37m▞▀▌▌[0m  [0;1;30;90m▐[0m [0;1;30;90m▝▀▖│[0m\n[0;37m│▝▘[0m [0;37m▘[0m [0;37m▘▝▀▘▀▘▘[0m   [0;1;30;90m▘[0m  [0;1;30;90m▝▀▘▘[0m  [0;1;30;90m▀▘▀▀[0m [0;1;30;90m│[0m\n[0;37m└───────[0;1;30;90m────────────────[0;1;34;94m──────┘[0m";
    private static String logoJava = " ._____. ._____. .________________________. ._____. ._____.\n | ._. | | ._. | | .____________________. | | ._. | | ._. |\n | !_| |_|_|_! | | !____________________! | | !_| |_|_|_! |\n !___| |_______! !________________________! !___| |_______!\n .___|_|_| |____________________________________|_|_| |___.\n | ._____| |________________________________________| |_. |\n | !_! | | |                                    | | ! !_! |\n !_____! | |                     [0;34m.[0m              | | !_____!\n ._____. | |                     [0;34m0.[0m             | | ._____.\n | ._. | | |                   [0;34m.kM.[0m             | | | ._. |\n | | | | | |                 [0;34m.dWMx[0m              | | | | | |\n | | | | | |               [0;1;34;94m;[0;34mOMMN:[0m  [0;34m'cd:.[0m        | | | | | |\n | | | | | |             [0;1;34;94mcXM[0;34mMWl.lKMXc.[0m          | | | | | |\n | | | | | |           [0;1;34;94m.XMMM[0;34mo[0m [0;34m.NMN;[0m             | | | | | |\n | | | | | |           [0;1;34;94mOMMX.[0m  [0;34m0MMc[0m              | | | | | |\n | | | | | |           [0;1;34;94m,MMd[0m   [0;34moMMW'[0m             | | | | | |\n | | | | | |            [0;1;34;94m'XM,[0m   [0;34m:WMW.[0m            | | | | | |\n | | | | | |              [0;1;34;94m:K[0;34m,[0m   [0;34m:MM.[0m            | | | | | |\n | | | | | |     [0;1;34;94m.':cl,.[0m    [0;34m'.[0m  [0;34mxk'[0m     [0;34m.ldo[0;37m'[0m   | | | | | |\n | | | | | |    [0;1;34;94moMMMMklc::::[0;34m::colodxx:[0m    [0;34m'W[0;37mMc[0m  | | | | | |\n | | | | | |     [0;1;34;94m.;lox0kkkkk[0;34mxdolc:,.[0m       [0;34mN[0;37mMo[0m  | | | | | |\n | | | | | |       [0;1;34;94m.OW0;'...[0;34m...',co;[0m     [0;34m.KM[0;37mx[0m   | | | | | |\n | | | | | |        [0;1;34;94m;ok0XNWW[0;34mWNNX0kdc,[0m  [0;34m.lkc.[0m    | | | | | |\n | | | | | |         [0;1;34;94m.kK;...[0;34m..';cdc.[0m            | | | | | |\n | | | | | |  [0;1;34;94m,lxkl,[0m [0;1;34;94m:0WMMMM[0;34mMMMMNKkl[0m      [0;34m..[0m    | | | | | |\n | | | | | | [0;1;34;94mKMMM:[0m       [0;1;34;94m...[0;34m..[0m           [0;34m;KX[0m    | | | | | |\n | | | | | | [0;1;34;94m.dKMMNOxoc:;,''[0;34m'''',;:codOXXkc[0m   [0;37m'[0m | | | | | |\n | | | | | |     [0;1;34;94m.,:codxxkkk[0;34mOkkxxdoc:,.[0m   [0;34m.:[0;37mxk;[0m | | | | | |\n | | | | | |        [0;1;34;94m...,;;;,[0;34m,''',,;:ldkOOko;[0;37m.[0m   | | | | | |\n | | | | | |              [0;1;34;94m.,[0;34m:ldddddo:,.[0m         | | | | | |\n | | | | | |                                    | | | | | |\n | | | | | |                                    | | | | | |\n | !_! | | |             ▜▘                     | | ! !_! |\n !_____! | |             ▐▝▀▖▌ ▌▝▀▖             | | !_____!\n ._____. | |            ▌▐▞▀▌▐▐ ▞▀▌             | | ._____.\n | ._. | | |            ▝▘▝▀▘ ▘ ▝▀▘             | | | ._. |\n | !_| |_|_|____________________________________| |_|_|_! |\n !___| |________________________________________| |_______!\n .___|_|_| |___. .________________________. .___|_|_| |___.\n | ._____| |_. | | .____________________. | | ._____| |_. |\n | !_! | | !_! | | !____________________! | | !_! | | !_! |\n !_____! !_____! !________________________! !_____! !_____!\n";
    private static String logoPicas = "                                                                      \n                                                                      \n                                  [0;37m.[0m                                   \n                                 [0;37m.0:[0m                                  \n                                [0;37mcNMWO.[0m                                \n                              [0;34m,0[0;37mMMMMMWx.[0m                              \n                            [0;34m;0MM[0;37mMMMMMMWNk,[0m                            \n                         [0;34m.cXMMMM[0;37mMMMMMMMMMN0:[0m                          \n                       [0;34m;kWMMMMMM[0;37mMMMMMMMMMMMNXd,[0m                       \n                   [0;34m.cOWMMMMMMMMM[0;37mMMMMMMMMMMMMMMNK[0;1;30;90md,[0m                    \n                [0;34m'oKMMMMMMWK00000[0;37m000000000000MMMM[0;1;30;90mMNXk:.[0m                \n             [0;1;34;94m;kN[0;34mMMMMMMWd.[0m                   [0;37mWMMM[0;1;30;90mMMMMWXOl.[0m             \n          [0;1;34;94m.dNMMM[0;34mMMMMMX.[0m [0;34m,lo.[0m  [0;34mcl[0;37mlll;[0m  [0;37m,lllllMMMM[0;1;30;90mMMMMMMMWNO:[0m           \n        [0;1;34;94m'OMMMMMM[0;34mMMMMW.lWMMM;[0m  [0;34mMM[0;37mMMMl[0m  [0;37mKMMMMMMMMM[0;1;30;90mMMMMMMMMMMWX:[0m         \n      [0;1;34;94m.xWMMMMMMM[0;34mMMMMMNMMMMM'[0m [0;34m.MM[0;37mMMM.[0m  [0;37mMMMMMMMMMM[0;1;30;90mMMMMMMMMMMMMMO.[0m       \n     [0;1;34;94m,0MMMMMMMMM[0;34mMMMMMMMMMMM.[0m [0;34m'MM[0;37mMMM[0m  [0;37m'MMMMMMMMMM[0;1;30;90mMMMMMMMMMMMMMM0.[0m      \n    [0;1;34;94m'kMMMMMMMMMM[0;34mMMMMMMMMMMX[0m  [0;34mcMM[0;37mMMX[0m  [0;37m:MMMMMMMMMM[0;1;30;90mMMMMMMMMMMMMMMWx[0m      \n    [0;1;34;94mdWMMMMMMMMMM[0;34mMMMMMMMMMMc[0m  [0;34mkMM[0;37mMMK[0m  [0;37mcMMMMMMMMMM[0;1;30;90mMMMMMMMMMMMMMMMK[0;1;34;94m.[0m     \n    [0;1;34;94m0MMMMMMMMMMM[0;34mMMMMMMMMM0[0m   [0;34mWMM[0;37mMMX[0m  [0;37m'MMMMMkMMMM[0;1;30;90mMMMMMMMMMMMMMMMX[0;1;34;94m'[0m     \n    [0;1;34;94m0WMMMMMMMMMM[0;34mMMMMMMMWl[0m   [0;34m:MMM[0;37mMMM[0m   [0;37m:0XKl'MMMM[0;1;30;90mMMMMMMMMMMMMMMMK[0;1;34;94m.[0m     \n    [0;1;34;94mxNMMMMMMMMMM[0;34mMMMMMMM:[0m    [0;34mXMMM[0;37mMMMx[0m      [0;37m.XMMMM[0;1;30;90mMMMMMMMMMMMMMMMO[0m      \n    [0;1;34;94m.NMMMMMMMMMM[0;34mMMMMMMMK;';KMMMM[0;37mMMMMO,..,oWMMMMM[0;1;30;90mMMMMMMMMMMMMMMX:[0m      \n     [0;1;34;94mcWMMMMMMMMM[0;34mMMMMMMMMMMMMMMMM[0;37mNNWNMMMMMMMMMMMM[0;1;30;90mMMMMMMMMMMMMMNd[0m       \n      [0;1;34;94mcNMMMMMMMM[0;34mMMMMMMMMMMMMMMW0[0;37m'xK;kWMMMMMMMMMM[0;1;30;90mMMMMMMMMMMMMNd[0m        \n       [0;1;34;94m.OWMMMMMM[0;34mMMMMMMMMMMMMWKl[0m  [0;37mdX:[0m [0;37m;0WMMMMMMMM[0;1;30;90mMMMMMMMMMMW0;[0m         \n         [0;1;34;94m,kNMMMM[0;34mMMMMMMMMMMN0c.[0m  [0;37m.xMk[0m   [0;37m,xXWMMMMM[0;1;30;90mMMMMMMMWNO:[0m           \n           [0;1;34;94m.;d0X[0;34mNNWWNNXKx:.[0m     [0;37m;KMN:[0m     [0;37m'cxKXN[0;1;30;90mNNNNXOo;.[0m             \n                [0;34m......[0m         [0;34m.[0;37moMMMX'[0m          [0;1;30;90m...[0m                   \n                               [0;34m:[0;37mNMMMMX'[0m                               \n                              [0;34m:N[0;37mMMMMMMWo[0m                              \n                          [0;34m..;OMM[0;37mMMMMMMMWXo.[0m                           \n                           [0;34m.';:c[0;37mllooollc:;.[0m                           \n                                                                      \n                                                                      \n                                                                      \n           [0;1;34;94m_____[0m [0;34m_[0m  [0;34m_[0m                     [0;37m____[0m  [0;1;30;90m_[0m               \n          [0;1;34;94m|[0m  [0;1;34;94m___[0;34m(_)(_)[0m [0;34m__[0m [0;34m_[0m [0;34m___[0m   [0;37m_[0m   [0;37m_[0m  [0;37m|[0m  [0;37m_[0m [0;37m\\([0;1;30;90m_)[0m [0;1;30;90m___[0m [0;1;30;90m__[0m [0;1;30;90m_[0m [0;1;30;90m___[0m \n          [0;1;34;94m|[0m [0;1;34;94m|_[0m  [0;34m|[0m [0;34m||[0m [0;34m|/[0m [0;34m_`[0m [0;34m/[0m [0;34m__|[0m [0;37m|[0m [0;37m|[0m [0;37m|[0m [0;37m|[0m [0;37m|[0m [0;37m|_)[0m [0;37m|[0m [0;1;30;90m|/[0m [0;1;30;90m__/[0m [0;1;30;90m_`[0m [0;1;30;90m/[0m [0;1;30;90m__|[0m\n          [0;1;34;94m|[0m  [0;1;34;94m_|[0m [0;34m|[0m [0;34m||[0m [0;34m|[0m [0;34m(_|[0m [0;34m\\__[0m [0;34m\\[0m [0;37m|[0m [0;37m|_|[0m [0;37m|[0m [0;37m|[0m  [0;37m__/|[0m [0;1;30;90m|[0m [0;1;30;90m(_|[0m [0;1;30;90m(_|[0m [0;1;30;90m\\__[0m [0;1;30;90m\\[0m\n          [0;1;34;94m|_|[0m   [0;34m|_|/[0m [0;34m|\\__,_|___/[0m  [0;37m\\__,[0m [0;37m|[0m [0;37m|_|[0m   [0;37m|[0;1;30;90m_|\\___\\__,_|___/[0m\n                 [0;34m|__/[0m             [0;37m|___/[0m                         \n";
    private static String welcome = "             __        __   _                            _        \n             \\ \\      / /__| | ___ ___  _ __ ___   ___  | |_ ___  \n              \\ \\ /\\ / / _ \\ |/ __/ _ \\| '_ ` _ \\ / _ \\ | __/ _ \\ \n               \\ V  V /  __/ | (_| (_) | | | | | |  __/ | || (_) |\n                \\_/\\_/ \\___|_|\\___\\___/|_| |_| |_|\\___|  \\__\\___/ \n                                                                  \n";
    private static String createdWith = "            ____                _           _            _ _   _     \n           / ___|_ __ ___  __ _| |_ ___  __| | __      _(_) |_| |__  \n          | |   | '__/ _ \\/ _` | __/ _ \\/ _` | \\ \\ /\\ / / | __| '_ \\ \n          | |___| | |  __/ (_| | ||  __/ (_| |  \\ V  V /| | |_| | | |\n           \\____|_|  \\___|\\__,_|\\__\\___|\\__,_|   \\_/\\_/ |_|\\__|_| |_|\n                                                                     \n";
    private static String startMsg = "                            _____________________________ \n                           /                             \\ \n                           |   ____  _             _     | \n                           |  / ___|| |_ __ _ _ __| |_   | \n                           |  \\___ \\| __/ _` | '__| __|  | \n                           |   ___) | || (_| | |  | |_   | \n                           |  |____/ \\__\\__,_|_|   \\__|  | \n                           |                             | \n                           \\_______________________  __'\\ \n                                                   |/   \\\\ \n                                                    \\    \\\\  . \n                                                         |\\\\/| \n                                                         / ' '\\ \n                                                         . .   . \n                                                        /    ) | \n                                                       '  _.'  | \n                                                       '-'/    \\ \n";

    // method clear console
    public static void ClearConsole() {
        final String os = System.getProperty("os.name");
        if (os.contains("Windows")) {
            // ! Runtime.getRuntime().exec("cls"); use this for windows
            System.out.println("windows");
        } else {
            System.out.print("\u001b[H\u001b[2J");
            System.out.flush();
        }
    }

    // method of choise in the console
    private static int choise(String[] choices, String msg) {
        ClearConsole();
        System.out.println(msg);
        for (int i = 0; i < choices.length; i++) {
            if (i == choice)
                System.out.println("> " + choices[i]);
            else
                System.out.println("  " + choices[i]);
        }
        String view = sc.nextLine();
        switch (view) {
            case "s":
                if (choice + 1 == choices.length)
                    choice = 0;
                else
                    choice++;
                return choise(choices, msg);
            case "S":
                if (choice + 1 == choices.length)
                    choice = 0;
                else
                    choice++;
                return choise(choices, msg);
            case "w":
                if (choice > 0)
                    choice--;
                else
                    choice = 0;
                return choise(choices, msg);
            case "W":
                if (choice > 0)
                    choice--;
                else
                    choice = 0;
                return choise(choices, msg);
            default:
                return choice;
        }
    }

    public static void welcome() {
        try {
            ClearConsole();
            System.out.println(welcome);
            Thread.sleep(1000);
            ClearConsole();
            System.out.println(logoPicas);
            Thread.sleep(1000);
            ClearConsole();
            System.out.println(createdWith);
            Thread.sleep(1000);
            ClearConsole();
            System.out.println(logoJava);
            Thread.sleep(1000);
            ClearConsole();
            System.out.println(startMsg);
            Thread.sleep(2000);
            ClearConsole();
        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    public static void main(String[] args) {
        welcome();
        String[] choices = { "You VS AI", "You VS Friend", "AI VS AI" };
        int val = choise(choices, "Choose your game mode: ");
        System.out.println(choices[val]);
        ClearConsole();
        System.out.println("By:");
        System.out.println(nameAuthor);
    }
}
