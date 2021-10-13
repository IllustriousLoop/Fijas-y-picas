
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Main class for the program.
 * recomendaciones:
 * use terminal vsCode to run the program
 * use the terminal to compile the program
 * !run program in linux please
 * 
 * @author Jhair Paris Garcian
 * @author Salvatore D'Angelo
 */

public class Main {
	// Variables of games you vs computer
	private static int numberMain;
	private static ArrayList<Integer> arrayOfValues = new ArrayList<Integer>();
	private static ArrayList<ArrayList<Object>> history = new ArrayList<ArrayList<Object>>();
	private static boolean isWinner = false;
	private static String playerOne = "give";
	private static String playerTwo = "";
	private static int fijas = 0;
	private static int picas = 0;
	private static int currentNumber = 0;

	// Variables for the choice of the game
	private static int choice = 0;
	private static Scanner sc = new Scanner(System.in);
	private static String[] options = { "😎 You VS AI 🤖", "😎 You VS Friend 🥸", "🤖 AI VS AI 🤖", "❌ Exit 🚶" };
	private static String msg = "Choose your game mode:  ";

	//  Background color of the console
	private static String BLACK_BACKGROUND = "\u001B[40m";
	private static String RED_BACKGROUND = "\u001B[41m";
	private static String GREEN_BACKGROUND = "\u001B[42m";
	private static String YELLOW_BACKGROUND = "\u001B[43m";
	private static String BLUE_BACKGROUND = "\u001B[44m";
	private static String PURPLE_BACKGROUND = "\u001B[45m";
	private static String CYAN_BACKGROUND = "\u001B[46m";
	private static String WHITE_BACKGROUND = "\u001B[47m";

	//  Font color of the console
	private static String BLACK = "\u001B[30m";
	private static String RED = "\u001B[31m";
	private static String GREEN = "\u001B[32m";
	private static String YELLOW = "\u001B[33m";
	private static String BLUE = "\u001B[34m";
	private static String PURPLE = "\u001B[35m";
	private static String CYAN = "\u001B[36m";
	private static String WHITE = "\u001B[37m";
	private static String RESET = "\u001B[0m";

	// Strings with ansi letters
	private static String nameAuthor = " ___________________________________\n/ Hecho por Jhair Paris y Salvatore \\\n\\ Narvarez                          /\n -----------------------------------\n    \\\n     \\\n                                   .::!!!!!!!:.\n  .!!!!!:.                        .:!!!!!!!!!!!!\n  ~~~~!!!!!!.                 .:!!!!!!!!!UWWW$$$\n      :$$NWX!!:           .:!!!!!!XUWW$$$$$$$$$P\n      $$$$$##WX!:      .<!!!!UW$$$$\"  $$$$$$$$#\n      $$$$$  $$$UX   :!!UW$$$$$$$$$   4$$$$$*\n      ^$$$B  $$$$\\     $$$$$$$$$$$$   d$$R\"\n        \"*$bd$$$$      '*$$$$$$$$$$$o+#\"\n             \"\"\"\"          \"\"\"\"\"\"\"\n";
	private static String logoJava = " ._____. ._____. .________________________. ._____. ._____.\n | ._. | | ._. | | .____________________. | | ._. | | ._. |\n | !_| |_|_|_! | | !____________________! | | !_| |_|_|_! |\n !___| |_______! !________________________! !___| |_______!\n .___|_|_| |____________________________________|_|_| |___.\n | ._____| |________________________________________| |_. |\n | !_! | | |                                    | | ! !_! |\n !_____! | |                     [0;34m.[0m              | | !_____!\n ._____. | |                     [0;34m0.[0m             | | ._____.\n | ._. | | |                   [0;34m.kM.[0m             | | | ._. |\n | | | | | |                 [0;34m.dWMx[0m              | | | | | |\n | | | | | |               [0;1;34;94m;[0;34mOMMN:[0m  [0;34m'cd:.[0m        | | | | | |\n | | | | | |             [0;1;34;94mcXM[0;34mMWl.lKMXc.[0m          | | | | | |\n | | | | | |           [0;1;34;94m.XMMM[0;34mo[0m [0;34m.NMN;[0m             | | | | | |\n | | | | | |           [0;1;34;94mOMMX.[0m  [0;34m0MMc[0m              | | | | | |\n | | | | | |           [0;1;34;94m,MMd[0m   [0;34moMMW'[0m             | | | | | |\n | | | | | |            [0;1;34;94m'XM,[0m   [0;34m:WMW.[0m            | | | | | |\n | | | | | |              [0;1;34;94m:K[0;34m,[0m   [0;34m:MM.[0m            | | | | | |\n | | | | | |     [0;1;34;94m.':cl,.[0m    [0;34m'.[0m  [0;34mxk'[0m     [0;34m.ldo[0;37m'[0m   | | | | | |\n | | | | | |    [0;1;34;94moMMMMklc::::[0;34m::colodxx:[0m    [0;34m'W[0;37mMc[0m  | | | | | |\n | | | | | |     [0;1;34;94m.;lox0kkkkk[0;34mxdolc:,.[0m       [0;34mN[0;37mMo[0m  | | | | | |\n | | | | | |       [0;1;34;94m.OW0;'...[0;34m...',co;[0m     [0;34m.KM[0;37mx[0m   | | | | | |\n | | | | | |        [0;1;34;94m;ok0XNWW[0;34mWNNX0kdc,[0m  [0;34m.lkc.[0m    | | | | | |\n | | | | | |         [0;1;34;94m.kK;...[0;34m..';cdc.[0m            | | | | | |\n | | | | | |  [0;1;34;94m,lxkl,[0m [0;1;34;94m:0WMMMM[0;34mMMMMNKkl[0m      [0;34m..[0m    | | | | | |\n | | | | | | [0;1;34;94mKMMM:[0m       [0;1;34;94m...[0;34m..[0m           [0;34m;KX[0m    | | | | | |\n | | | | | | [0;1;34;94m.dKMMNOxoc:;,''[0;34m'''',;:codOXXkc[0m   [0;37m'[0m | | | | | |\n | | | | | |     [0;1;34;94m.,:codxxkkk[0;34mOkkxxdoc:,.[0m   [0;34m.:[0;37mxk;[0m | | | | | |\n | | | | | |        [0;1;34;94m...,;;;,[0;34m,''',,;:ldkOOko;[0;37m.[0m   | | | | | |\n | | | | | |              [0;1;34;94m.,[0;34m:ldddddo:,.[0m         | | | | | |\n | | | | | |                                    | | | | | |\n | | | | | |                                    | | | | | |\n | !_! | | |             ▜▘                     | | ! !_! |\n !_____! | |             ▐▝▀▖▌ ▌▝▀▖             | | !_____!\n ._____. | |            ▌▐▞▀▌▐▐ ▞▀▌             | | ._____.\n | ._. | | |            ▝▘▝▀▘ ▘ ▝▀▘             | | | ._. |\n | !_| |_|_|____________________________________| |_|_|_! |\n !___| |________________________________________| |_______!\n .___|_|_| |___. .________________________. .___|_|_| |___.\n | ._____| |_. | | .____________________. | | ._____| |_. |\n | !_! | | !_! | | !____________________! | | !_! | | !_! |\n !_____! !_____! !________________________! !_____! !_____!\n";
	private static String logoPicas = "                                                                      \n                                                                      \n                                  [0;37m.[0m                                   \n                                 [0;37m.0:[0m                                  \n                                [0;37mcNMWO.[0m                                \n                              [0;34m,0[0;37mMMMMMWx.[0m                              \n                            [0;34m;0MM[0;37mMMMMMMWNk,[0m                            \n                         [0;34m.cXMMMM[0;37mMMMMMMMMMN0:[0m                          \n                       [0;34m;kWMMMMMM[0;37mMMMMMMMMMMMNXd,[0m                       \n                   [0;34m.cOWMMMMMMMMM[0;37mMMMMMMMMMMMMMMNK[0;1;30;90md,[0m                    \n                [0;34m'oKMMMMMMWK00000[0;37m000000000000MMMM[0;1;30;90mMNXk:.[0m                \n             [0;1;34;94m;kN[0;34mMMMMMMWd.[0m                   [0;37mWMMM[0;1;30;90mMMMMWXOl.[0m             \n          [0;1;34;94m.dNMMM[0;34mMMMMMX.[0m [0;34m,lo.[0m  [0;34mcl[0;37mlll;[0m  [0;37m,lllllMMMM[0;1;30;90mMMMMMMMWNO:[0m           \n        [0;1;34;94m'OMMMMMM[0;34mMMMMW.lWMMM;[0m  [0;34mMM[0;37mMMMl[0m  [0;37mKMMMMMMMMM[0;1;30;90mMMMMMMMMMMWX:[0m         \n      [0;1;34;94m.xWMMMMMMM[0;34mMMMMMNMMMMM'[0m [0;34m.MM[0;37mMMM.[0m  [0;37mMMMMMMMMMM[0;1;30;90mMMMMMMMMMMMMMO.[0m       \n     [0;1;34;94m,0MMMMMMMMM[0;34mMMMMMMMMMMM.[0m [0;34m'MM[0;37mMMM[0m  [0;37m'MMMMMMMMMM[0;1;30;90mMMMMMMMMMMMMMM0.[0m      \n    [0;1;34;94m'kMMMMMMMMMM[0;34mMMMMMMMMMMX[0m  [0;34mcMM[0;37mMMX[0m  [0;37m:MMMMMMMMMM[0;1;30;90mMMMMMMMMMMMMMMWx[0m      \n    [0;1;34;94mdWMMMMMMMMMM[0;34mMMMMMMMMMMc[0m  [0;34mkMM[0;37mMMK[0m  [0;37mcMMMMMMMMMM[0;1;30;90mMMMMMMMMMMMMMMMK[0;1;34;94m.[0m     \n    [0;1;34;94m0MMMMMMMMMMM[0;34mMMMMMMMMM0[0m   [0;34mWMM[0;37mMMX[0m  [0;37m'MMMMMkMMMM[0;1;30;90mMMMMMMMMMMMMMMMX[0;1;34;94m'[0m     \n    [0;1;34;94m0WMMMMMMMMMM[0;34mMMMMMMMWl[0m   [0;34m:MMM[0;37mMMM[0m   [0;37m:0XKl'MMMM[0;1;30;90mMMMMMMMMMMMMMMMK[0;1;34;94m.[0m     \n    [0;1;34;94mxNMMMMMMMMMM[0;34mMMMMMMM:[0m    [0;34mXMMM[0;37mMMMx[0m      [0;37m.XMMMM[0;1;30;90mMMMMMMMMMMMMMMMO[0m      \n    [0;1;34;94m.NMMMMMMMMMM[0;34mMMMMMMMK;';KMMMM[0;37mMMMMO,..,oWMMMMM[0;1;30;90mMMMMMMMMMMMMMMX:[0m      \n     [0;1;34;94mcWMMMMMMMMM[0;34mMMMMMMMMMMMMMMMM[0;37mNNWNMMMMMMMMMMMM[0;1;30;90mMMMMMMMMMMMMMNd[0m       \n      [0;1;34;94mcNMMMMMMMM[0;34mMMMMMMMMMMMMMMW0[0;37m'xK;kWMMMMMMMMMM[0;1;30;90mMMMMMMMMMMMMNd[0m        \n       [0;1;34;94m.OWMMMMMM[0;34mMMMMMMMMMMMMWKl[0m  [0;37mdX:[0m [0;37m;0WMMMMMMMM[0;1;30;90mMMMMMMMMMMW0;[0m         \n         [0;1;34;94m,kNMMMM[0;34mMMMMMMMMMMN0c.[0m  [0;37m.xMk[0m   [0;37m,xXWMMMMM[0;1;30;90mMMMMMMMWNO:[0m           \n           [0;1;34;94m.;d0X[0;34mNNWWNNXKx:.[0m     [0;37m;KMN:[0m     [0;37m'cxKXN[0;1;30;90mNNNNXOo;.[0m             \n                [0;34m......[0m         [0;34m.[0;37moMMMX'[0m          [0;1;30;90m...[0m                   \n                               [0;34m:[0;37mNMMMMX'[0m                               \n                              [0;34m:N[0;37mMMMMMMWo[0m                              \n                          [0;34m..;OMM[0;37mMMMMMMMWXo.[0m                           \n                           [0;34m.';:c[0;37mllooollc:;.[0m                           \n                                                                      \n                                                                      \n                                                                      \n           [0;1;34;94m_____[0m [0;34m_[0m  [0;34m_[0m                     [0;37m____[0m  [0;1;30;90m_[0m               \n          [0;1;34;94m|[0m  [0;1;34;94m___[0;34m(_)(_)[0m [0;34m__[0m [0;34m_[0m [0;34m___[0m   [0;37m_[0m   [0;37m_[0m  [0;37m|[0m  [0;37m_[0m [0;37m\\([0;1;30;90m_)[0m [0;1;30;90m___[0m [0;1;30;90m__[0m [0;1;30;90m_[0m [0;1;30;90m___[0m \n          [0;1;34;94m|[0m [0;1;34;94m|_[0m  [0;34m|[0m [0;34m||[0m [0;34m|/[0m [0;34m_`[0m [0;34m/[0m [0;34m__|[0m [0;37m|[0m [0;37m|[0m [0;37m|[0m [0;37m|[0m [0;37m|[0m [0;37m|_)[0m [0;37m|[0m [0;1;30;90m|/[0m [0;1;30;90m__/[0m [0;1;30;90m_`[0m [0;1;30;90m/[0m [0;1;30;90m__|[0m\n          [0;1;34;94m|[0m  [0;1;34;94m_|[0m [0;34m|[0m [0;34m||[0m [0;34m|[0m [0;34m(_|[0m [0;34m\\__[0m [0;34m\\[0m [0;37m|[0m [0;37m|_|[0m [0;37m|[0m [0;37m|[0m  [0;37m__/|[0m [0;1;30;90m|[0m [0;1;30;90m(_|[0m [0;1;30;90m(_|[0m [0;1;30;90m\\__[0m [0;1;30;90m\\[0m\n          [0;1;34;94m|_|[0m   [0;34m|_|/[0m [0;34m|\\__,_|___/[0m  [0;37m\\__,[0m [0;37m|[0m [0;37m|_|[0m   [0;37m|[0;1;30;90m_|\\___\\__,_|___/[0m\n                 [0;34m|__/[0m             [0;37m|___/[0m                         \n";
	private static String welcome = "             __        __   _                            _        \n             \\ \\      / /__| | ___ ___  _ __ ___   ___  | |_ ___  \n              \\ \\ /\\ / / _ \\ |/ __/ _ \\| '_ ` _ \\ / _ \\ | __/ _ \\ \n               \\ V  V /  __/ | (_| (_) | | | | | |  __/ | || (_) |\n                \\_/\\_/ \\___|_|\\___\\___/|_| |_| |_|\\___|  \\__\\___/ \n                                                                  \n";
	private static String createdWith = "            ____                _           _            _ _   _     \n           / ___|_ __ ___  __ _| |_ ___  __| | __      _(_) |_| |__  \n          | |   | '__/ _ \\/ _` | __/ _ \\/ _` | \\ \\ /\\ / / | __| '_ \\ \n          | |___| | |  __/ (_| | ||  __/ (_| |  \\ V  V /| | |_| | | |\n           \\____|_|  \\___|\\__,_|\\__\\___|\\__,_|   \\_/\\_/ |_|\\__|_| |_|\n                                                                     \n";
	private static String startMsg = "                            _____________________________ \n                           /                             \\ \n                           |   ____  _             _     | \n                           |  / ___|| |_ __ _ _ __| |_   | \n                           |  \\___ \\| __/ _` | '__| __|  | \n                           |   ___) | || (_| | |  | |_   | \n                           |  |____/ \\__\\__,_|_|   \\__|  | \n                           |                             | \n                           \\_______________________  __'\\ \n                                                   |/   \\\\ \n                                                    \\    \\\\  . \n                                                         |\\\\/| \n                                                         / ' '\\ \n                                                         . .   . \n                                                        /    ) | \n                                                       '  _.'  | \n                                                       '-'/    \\ \n";

	/**
	 * Method that prints text with color
	 * 
	 * @see #BLUE(String text)
	 * @see #RED(String text)
	 * @see #GREEN(String text)
	 * @see #YELLOW(String text)
	 * @see #PURPLE(String text)
	 * @see #CYAN(String text)
	 * @see #WHITE(String text)
	 * @see #BLACK(String text)
	 * @see #RED(String text)
	 * @param text the text to be colored
	 * @return a <code> string </code> the colored text
	 */
	public static String BLACK(String text) {
		return BLACK + text + RESET;
	}

	/**
	 * Method that prints text with color
	 * 
	 * @see #BLUE(String text)
	 * @see #RED(String text)
	 * @see #GREEN(String text)
	 * @see #YELLOW(String text)
	 * @see #PURPLE(String text)
	 * @see #CYAN(String text)
	 * @see #WHITE(String text)
	 * @see #BLACK(String text)
	 * @see #RED(String text)
	 * @param text the text to be colored
	 * @return a <code> string </code> the colored text
	 */
	public static String BLUE(String text) {
		return BLUE + text + RESET;
	};

	/**
	 * Method that prints text with color
	 * 
	 * @see #BLUE(String text)
	 * @see #RED(String text)
	 * @see #GREEN(String text)
	 * @see #YELLOW(String text)
	 * @see #PURPLE(String text)
	 * @see #CYAN(String text)
	 * @see #WHITE(String text)
	 * @see #BLACK(String text)
	 * @see #RED(String text)
	 * @param text the text to be colored
	 * @return a <code> string </code> the colored text
	 */
	public static String CYAN(String text) {
		return CYAN + text + RESET;
	};

	/**
	 * Method that prints text with color
	 * 
	 * @see #BLUE(String text)
	 * @see #RED(String text)
	 * @see #GREEN(String text)
	 * @see #YELLOW(String text)
	 * @see #PURPLE(String text)
	 * @see #CYAN(String text)
	 * @see #WHITE(String text)
	 * @see #BLACK(String text)
	 * @see #RED(String text)
	 * @param text the text to be colored
	 * @return a <code> string </code> the colored text
	 */
	public static String GREEN(String text) {
		return GREEN + text + RESET;
	};

	/**
	 * Method that prints text with color
	 * 
	 * @see #BLUE(String text)
	 * @see #RED(String text)
	 * @see #GREEN(String text)
	 * @see #YELLOW(String text)
	 * @see #PURPLE(String text)
	 * @see #CYAN(String text)
	 * @see #WHITE(String text)
	 * @see #BLACK(String text)
	 * @see #RED(String text)
	 * @param text the text to be colored
	 * @return a <code> string </code> the colored text
	 */
	public static String PURPLE(String text) {
		return PURPLE + text + RESET;
	};

	/**
	 * Method that prints text with color
	 * 
	 * @see #BLUE(String text)
	 * @see #RED(String text)
	 * @see #GREEN(String text)
	 * @see #YELLOW(String text)
	 * @see #PURPLE(String text)
	 * @see #CYAN(String text)
	 * @see #WHITE(String text)
	 * @see #BLACK(String text)
	 * @see #RED(String text)
	 * @param text the text to be colored
	 * @return a <code> string </code> the colored text
	 */
	public static String RED(String text) {
		return RED + text + RESET;
	};

	/**
	 * Method that prints text with color
	 * 
	 * @see #BLUE(String text)
	 * @see #RED(String text)
	 * @see #GREEN(String text)
	 * @see #YELLOW(String text)
	 * @see #PURPLE(String text)
	 * @see #CYAN(String text)
	 * @see #WHITE(String text)
	 * @see #BLACK(String text)
	 * @see #RED(String text)
	 * @param text the text to be colored
	 * @return a <code> string </code> the colored text
	 */
	public static String YELLOW(String text) {
		return YELLOW + text + RESET;
	};

	/**
	 * Method that prints text with color
	 * 
	 * @see #BLUE(String text)
	 * @see #RED(String text)
	 * @see #GREEN(String text)
	 * @see #YELLOW(String text)
	 * @see #PURPLE(String text)
	 * @see #CYAN(String text)
	 * @see #WHITE(String text)
	 * @see #BLACK(String text)
	 * @see #RED(String text)
	 * @param text the text to be colored
	 * @return a <code> string </code> the colored text
	 */
	public static String WHITE(String text) {
		return WHITE + text + RESET;
	};

	/**
	 * Method that prints text with background color
	 * 
	 * @see #BLUE_BACKGROUND(String text)
	 * @see #RED_BACKGROUND(String text)
	 * @see #GREEN_BACKGROUND(String text)
	 * @see #YELLOW_BACKGROUND(String text)
	 * @see #PURPLE_BACKGROUND(String text)
	 * @see #CYAN_BACKGROUND(String text)
	 * @see #WHITE_BACKGROUND(String text)
	 * @see #BLACK_BACKGROUND(String text)
	 * @param text the text to be colored
	 * @return a <code> string </code> Black colored background
	 */
	public static String BLACK_BACKGROUND(String text) {
		return BLACK_BACKGROUND + text + RESET;
	};

	/**
	 * Method that prints text with background color
	 * 
	 * @see #BLUE_BACKGROUND(String text)
	 * @see #RED_BACKGROUND(String text)
	 * @see #GREEN_BACKGROUND(String text)
	 * @see #YELLOW_BACKGROUND(String text)
	 * @see #PURPLE_BACKGROUND(String text)
	 * @see #CYAN_BACKGROUND(String text)
	 * @see #WHITE_BACKGROUND(String text)
	 * @see #BLACK_BACKGROUND(String text)
	 * @param text the text to be colored
	 * @return a <code> string </code> Blue colored background
	 */
	public static String BLUE_BACKGROUND(String text) {
		return BLUE_BACKGROUND + text + RESET;
	};

	/**
	 * Method that prints text with background color
	 * 
	 * @see #BLUE_BACKGROUND(String text)
	 * @see #RED_BACKGROUND(String text)
	 * @see #GREEN_BACKGROUND(String text)
	 * @see #YELLOW_BACKGROUND(String text)
	 * @see #PURPLE_BACKGROUND(String text)
	 * @see #CYAN_BACKGROUND(String text)
	 * @see #WHITE_BACKGROUND(String text)
	 * @see #BLACK_BACKGROUND(String text)
	 * @param text the text to be colored
	 * @return a <code> string </code> Cyan colored background
	 */
	public static String CYAN_BACKGROUND(String text) {
		return CYAN_BACKGROUND + text + RESET;
	};

	/**
	 * Method that prints text with background color
	 * 
	 * @see #BLUE_BACKGROUND(String text)
	 * @see #RED_BACKGROUND(String text)
	 * @see #GREEN_BACKGROUND(String text)
	 * @see #YELLOW_BACKGROUND(String text)
	 * @see #PURPLE_BACKGROUND(String text)
	 * @see #CYAN_BACKGROUND(String text)
	 * @see #WHITE_BACKGROUND(String text)
	 * @see #BLACK_BACKGROUND(String text)
	 * @param text the text to be colored
	 * @return a <code> string </code> Green colored background
	 */
	public static String GREEN_BACKGROUND(String text) {
		return GREEN_BACKGROUND + text + RESET;
	};

	/**
	 * Method that prints text with background color
	 * 
	 * @see #BLUE_BACKGROUND(String text)
	 * @see #RED_BACKGROUND(String text)
	 * @see #GREEN_BACKGROUND(String text)
	 * @see #YELLOW_BACKGROUND(String text)
	 * @see #PURPLE_BACKGROUND(String text)
	 * @see #CYAN_BACKGROUND(String text)
	 * @see #WHITE_BACKGROUND(String text)
	 * @see #BLACK_BACKGROUND(String text)
	 * @param text the text to be colored
	 * @return a <code> string </code> Purple colored background
	 */
	public static String PURPLE_BACKGROUND(String text) {
		return PURPLE_BACKGROUND + text + RESET;
	};

	/**
	 * Method that prints text with background color
	 * 
	 * @see #BLUE_BACKGROUND(String text)
	 * @see #RED_BACKGROUND(String text)
	 * @see #GREEN_BACKGROUND(String text)
	 * @see #YELLOW_BACKGROUND(String text)
	 * @see #PURPLE_BACKGROUND(String text)
	 * @see #CYAN_BACKGROUND(String text)
	 * @see #WHITE_BACKGROUND(String text)
	 * @see #BLACK_BACKGROUND(String text)
	 * @param text the text to be colored
	 * @return a <code> string </code> Red colored background
	 */
	public static String RED_BACKGROUND(String text) {
		return RED_BACKGROUND + text + RESET;
	};

	/**
	 * Method that prints text with background color
	 * 
	 * @see #BLUE_BACKGROUND(String text)
	 * @see #RED_BACKGROUND(String text)
	 * @see #GREEN_BACKGROUND(String text)
	 * @see #YELLOW_BACKGROUND(String text)
	 * @see #PURPLE_BACKGROUND(String text)
	 * @see #CYAN_BACKGROUND(String text)
	 * @see #WHITE_BACKGROUND(String text)
	 * @see #BLACK_BACKGROUND(String text)
	 * @param text the text to be colored
	 * @return a <code> string </code> Yellow colored background
	 */
	public static String YELLOW_BACKGROUND(String text) {
		return YELLOW_BACKGROUND + text + RESET;
	};

	/**
	 * Method that prints text with background color
	 * 
	 * @see #BLUE_BACKGROUND(String text)
	 * @see #RED_BACKGROUND(String text)
	 * @see #GREEN_BACKGROUND(String text)
	 * @see #YELLOW_BACKGROUND(String text)
	 * @see #PURPLE_BACKGROUND(String text)
	 * @see #CYAN_BACKGROUND(String text)
	 * @see #WHITE_BACKGROUND(String text)
	 * @see #BLACK_BACKGROUND(String text)
	 * @param text the text to be colored
	 * @return a <code> string </code> White colored background
	 */
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

	// Clear the console
	private static void ClearConsole() {
		final String os = System.getProperty("os.name");
		if (os.contains("Windows")) {
			// Runtime.getRuntime().exec("cls");
			System.out.println("windows");
		} else {
			System.out.print("\u001b[H\u001b[2J");
			System.out.flush();
		}
	}

	private static void ClearConsole(int x) {
		for (int i = 0; i < 99999999 * x; i++) {
			int slow = (int) (Math.random() * 999) / 1121121;
		}
		final String os = System.getProperty("os.name");
		if (os.contains("Windows")) {
			// Runtime.getRuntime().exec("cls");
			System.out.println("windows");
		} else {
			System.out.print("\u001b[H\u001b[2J");
			System.out.flush();
		}
	}

	// Welcome message
	public static void Welcome() {
		ClearConsole();
		System.out.println(welcome);
		ClearConsole(1);
		System.out.println(logoPicas);
		ClearConsole(1);
		System.out.println(createdWith);
		ClearConsole(1);
		System.out.println(logoJava);
		ClearConsole(1);
		System.out.println(startMsg);
		ClearConsole(1);
	}

	// Goodbye message
	public static void Bye() {
		System.out.println(nameAuthor);
	}

	// method of choise in the console
	private static int menu() {
		ClearConsole();
		System.out.println(msg);
		for (int i = 0; i < options.length; i++)
			if (i == choice)
				System.out.println(BLUE("> ") + CYAN(options[i]));
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

	// Utils
	private static boolean isRepeated() {
		boolean prueba = true;
		// Check if there is a repeating element in arrayOfValues
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
					ClearConsole();
					System.out.println(PURPLE_BACKGROUND(BLACK(" 💀💀 Remember no figure repeats 🚫🚫 ")));
					ClearConsole();
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
				ClearConsole();
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
			System.out.println(YELLOW_BACKGROUND(" " + BLACK(currentNumber + " ")));
			System.out.println("Enter " + CYAN("fijas") + ": ");
			fijas = sc.nextInt();
			System.out.println("Enter " + CYAN("picas") + ": ");
			picas = sc.nextInt();
			if (picas + fijas > numberMain) {
				System.out
						.println("The sum of the tracks cannot be greater than the number of digits that were chosen");
			} else if (fijas == numberMain) {
				ClearConsole();
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
				ClearConsole();
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
				System.out.println(YELLOW(head));
			else if (player == 1)
				System.out.println(PURPLE(head));
		}
		for (int i = 0; i < history.size(); i++) {
			ArrayList<Object> array = history.get(i);
			if (Integer.parseInt(array.get(1) + "") == player) {
				System.out.println(YELLOW((i + 1) + ") ") + array.get(0));
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
		System.out.println(YELLOW("Player 1: ") + state1 + PURPLE("  Player 2: ") + state2);
	}

	// Methods of mode game human vs human
	//? Total logic
	public static void Humans() {
		while (!isWinner) {
			arrayOfValues.clear();
			ArrayList<Integer> numberStake = new ArrayList<Integer>();
			drawTurn();
			System.out.println("Enter " + numberMain + " digit: ");
			int v = sc.nextInt();
			int valid = String.valueOf(v).length();
			if (valid < numberMain || valid > numberMain)
				System.out.println(RED_BACKGROUND("The number is bad"));
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
	//? Init logic
	private static void YouVsFriend(int n) {
		numberMain = n;
		System.out.println("How many " + PURPLE("persons") + " want play");
		int p = sc.nextInt();
		if (p == 2)
			Humans();
		else {
			System.out.println(RED("The number of persons must be 2"));
			ClearConsole(1);
			YouVsFriend(n);
		}
	}

	// Start game
	private static boolean managerType(int type, int n) {
		if (type == 0) {
			System.out.println(GREEN_BACKGROUND(BLACK("Not implemented yet")));
			return false;
		} else if (type == 1) {
			YouVsFriend(n);
			return false;
		} else if (type == 2) {
			System.out.println(GREEN_BACKGROUND(BLACK("Not implemented yet")));
			return false;
		} else {
			System.out.println(RED("Invalid option"));
			return false;
		}
	}

	public static void main(String[] args) {
		Welcome();
		boolean exit = false;
		while (!exit) {
			menu();
			if (choice == 3) {
				exit = true;
				break;
			} else {
				System.out.println("How many " + PURPLE("digits") + " is the number");
				int n = sc.nextInt();
				if (n >= 2 && n <= 8) {
					boolean ex = managerType(choice, n);
					if (ex) {
						exit = true;
						break;
					} else {
						ClearConsole(1);
						menu();
					}
				} else
					System.out.println(RED("The number of digits must be between 2 and 8"));
				ClearConsole(1);
			}
		}
		Bye();
	}
}