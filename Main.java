import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    private static ArrayList<Integer> blackList = new ArrayList<Integer>();
    private static int numberMain;
    private static final ArrayList<Integer> arrayOfValues = new ArrayList<Integer>();
    private static final ArrayList<ArrayList<Object>> history = new ArrayList<>();
    private static boolean isWinner = false;
    private static String playerOne = "give";
    private static String playerTwo = "";
    private static int fijas = 0;
    private static int picas = 0;
    private static int currentNumber = 0;
    private static int choice = 0;
    private static final Scanner sc = new Scanner(System.in);
    private static final String[] options = { "You VS AI", "You VS Friend", "Exit" };

    private static int menu() {
        String msg = "Choose your game mode:  ";
        System.out.println(msg);
        for (int i = 0; i < options.length; i++)
            if (i == choice)
                System.out.println("> " + options[i]);
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

    private static boolean isRepeated() {
        boolean prueba = true;
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
            ArrayList<Object> array = new ArrayList<Object>(3);
            ArrayList<Integer> smart = new ArrayList<Integer>(3);
            array.add(listString + emojiFijas + "  " + emojiPicas);
            array.add(player);

            smart.add(Integer.parseInt(listString));
            smart.add(fijas);
            smart.add(picas);

            array.add(smart);
            history.add(array);
        }
        /*
         * for (int i=0;i>history.size();i++){ ArrayList<Object> user = history.get(i);
         * if (Integer.parseInt(user.get(1) + "") == player) {
         * System.out.println(user.get(0)); } }
         */
    }

    private static void nextTurn() {
        boolean numberR = isRepeated();
        for (int i = 0; i < arrayOfValues.size(); i++) {
            int t = Integer.parseInt(arrayOfValues.toString().replaceAll("\\[|\\]", "").replaceAll(", ", ""));
            if (!numberR) {
                if (i == numberMain - 1) {
                    System.out.println(" 💀💀 Remember no figure repeats 🚫🚫 ");
                    if (playerOne.equals("give")) {
                        playerOne = "wait";
                        playerTwo = "clue";
                        System.out.println("Player 2 pass the 'fijas' and 'picas' to Player 1");
                        currentNumber = t;
                    } else if (playerTwo.equals("give")) {
                        playerOne = "clue";
                        playerTwo = "wait";
                        System.out.println("Player 1 pass the 'fijas' and 'picas' to Player 2");
                        currentNumber = t;
                    }
                }
            } else {
                if (i == numberMain - 1) {
                    if (playerOne.equals("give")) {
                        playerOne = "wait";
                        playerTwo = "clue";
                        System.out.println("Player 2 pass the 'fijas' and 'picas' to Player 1");
                        currentNumber = t;
                    } else if (playerTwo.equals("give")) {
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
            System.out.println(" " + currentNumber + " ");
            System.out.println("Enter fijas: ");
            fijas = sc.nextInt();
            System.out.println("Enter picas: ");
            picas = sc.nextInt();

            int player = -1;
            if (playerOne.equals("wait"))
                player = 0;
            else if (playerTwo.equals("wait"))
                player = 1;

            String cNumberS = currentNumber + "";
            ArrayList<Integer> cNumberA = new ArrayList<Integer>();

            for (int i = 0; i < cNumberS.length(); i++)
                cNumberA.add(Integer.parseInt(cNumberS.charAt(i) + ""));

            for (int i = 0; i < history.size(); i++) {
                if (Integer.parseInt(history.get(i).get(1) + "") == player) {
                    ArrayList<Integer> OldData = (ArrayList<Integer>) history.get(i).get(2);
                    String number = OldData.get(0) + "";
                    ArrayList<Integer> array = new ArrayList<Integer>();

                    for (int j = 0; j < number.length(); j++)
                        array.add(Integer.parseInt(number.charAt(j) + ""));

                    int count = 0;
                    for (int j = 0; j < cNumberA.size(); j++) {
                        if (cNumberA.contains(array.get(j))) {
                            count++;
                        }
                    }
                    if (count == numberMain) {
                        if (OldData.get(1) > fijas || OldData.get(1) < fijas || OldData.get(2) > picas
                                || OldData.get(2) < picas) {

                            System.out.println("\t contradiction \t\n\n\n");
                            if (playerOne == "wait") {
                                System.out.println("Player 2 are winner");
                                isWinner = true;
                            }
                            if (playerTwo == "wait") {
                                System.out.println("Player 1 are winner");
                                isWinner = true;
                            }
                            ok = true;
                        }
                    }
                }
            }

            if (picas + fijas > numberMain) {
                System.out
                        .println("The sum of the tracks cannot be greater than the number of digits that were chosen");
            } else if (fijas == numberMain) {
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
                System.out.println(head);
            else if (player == 1)
                System.out.println(head);
        }
        for (int i = 0; i < history.size(); i++) {
            ArrayList<Object> array = history.get(i);
            if (Integer.parseInt(array.get(1) + "") == player) {
                System.out.println(i + 1 + ") " + array.get(0));
            }
        }
        if (history.size() > 0)
            System.out.println("\n 🚧🚧🚧🚧🚧🚧🚧🚧🚧🚧🚧🚧 \n");
    }

    private static void drawTurn() {
        String state1 = "", state2 = "";

        if (playerOne.equals(""))
            state1 = "👻";
        else if (playerTwo.equals(""))
            state2 = "👻";

        if (playerOne.equals("give")) {
            showHistory(0);
            state1 = "💪";
        } else if (playerTwo.equals("give")) {
            showHistory(1);
            state2 = "💪";
        }

        if (playerOne.equals("wait"))
            state1 = "🤏";
        else if (playerTwo.equals("wait"))
            state2 = "🤏";

        if (playerOne.equals("clue"))
            state1 = "🤓";
        else if (playerTwo.equals("clue"))
            state2 = "🤓";
        System.out.println("Player 1: " + state1 + "  Player 2: " + state2);
    }

    public static void Humans() {
        while (!isWinner) {
            arrayOfValues.clear();
            ArrayList<Integer> numberStake = new ArrayList<Integer>();
            drawTurn();
            System.out.println("Enter " + numberMain + " digit: ");
            int v = sc.nextInt();
            int valid = String.valueOf(v).length();
            if (valid < numberMain || valid > numberMain)
                System.out.println("The number is bad");
            else {
                for (int i = 0; i < numberMain; i++) {
                    numberStake.add(v % 10);
                    v /= 10;
                }
                for (int i = 0; i < numberStake.size() / 2; i++) {
                    int temp = numberStake.get(i);
                    numberStake.set(i, numberStake.get(numberStake.size() - i - 1));
                    numberStake.set(numberStake.size() - i - 1, temp);
                }
                arrayOfValues.addAll(numberStake);
                nextTurn();
                drawTurn(); // cosmetic
                finishTurn();
            }
        }
    }

    private static void Ai() {
        while (!isWinner) {
            arrayOfValues.clear();
            ArrayList<Integer> numberStake = new ArrayList<Integer>();
            System.out.println("Enter " + numberMain + " digit: ");
            int v = sc.nextInt();
            int valid = String.valueOf(v).length();
            if (valid < numberMain || valid > numberMain)
                System.out.println("The number is bad");
            else {
                for (int i = 0; i < numberMain; i++) {
                    numberStake.add(v % 10);
                    v /= 10;
                }
                for (int i = 0; i < numberStake.size() / 2; i++) {
                    int temp = numberStake.get(i);
                    numberStake.set(i, numberStake.get(numberStake.size() - i - 1));
                    numberStake.set(numberStake.size() - i - 1, temp);
                }
                arrayOfValues.addAll(numberStake);

            }
        }
    }

    private static ArrayList<Integer> myNumber = new ArrayList<>();
    // ArrayList contain numbers from 1 to 9
    private static ArrayList<Integer> suggests = new ArrayList<>() {
        {
            for (int i = 1; i <= 9; i++)
                add(i);
        }
    };

    private static void Ai2() {
        for (int i = 0; i < numberMain; i++) {
            int temp = (int) (Math.random() * 9 + 1);
            if (!myNumber.contains(temp))
                myNumber.add(temp);
        }
        boolean found = false;
        while (!isWinner) {
            arrayOfValues.clear();
            showHistory(0);
            ArrayList<Integer> tempBlack = new ArrayList<Integer>();
            if (!found) {
                for (int i = 0; i < numberMain; i++) {
                    int index = (int) (Math.random() * 9 + 1) - 1;
                    if (!blackList.contains(suggests.get(index)) && !tempBlack.contains(suggests.get(index))) {
                        arrayOfValues.add(suggests.get(index));
                        tempBlack.add(suggests.get(index));
                    } else {
                        if (blackList.size() == (numberMain >= 5 ? numberMain : numberMain == 3 ? 9 : 8)) {
                            System.out.println("You are loser");
                            isWinner = true;
                            break;
                        } else
                            i--;
                    }
                }
                int n = 0, f = 0, p = 0;

                if (history.size() > 1) {
                    int possibility1 = Integer.parseInt(history.get(history.size() - 1).get(1) + "");
                    if (possibility1 == 0) {
                        ArrayList<Integer> values = (ArrayList<Integer>) history.get(history.size() - 1).get(2);
                        n = values.get(0);
                        f = values.get(1);
                        p = values.get(2);
                    }
                    int possibility2 = Integer.parseInt(history.get(history.size() - 2).get(1) + "");
                    if (possibility2 == 4) {// 0
                        ArrayList<Integer> values = (ArrayList<Integer>) history.get(history.size() - 2).get(2);
                        n = values.get(0);
                        f = values.get(1);
                        p = values.get(2);
                    }
                }
                
            } else {
                int n = 0, f = 0, p = 0;
                int possibility1 = Integer.parseInt(history.get(history.size() - 1).get(1) + "");
                if (possibility1 == 0) {
                    ArrayList<Integer> values = (ArrayList<Integer>) history.get(history.size() - 1).get(2);
                    n = values.get(0);
                    f = values.get(1);
                    p = values.get(2);
                }
                if (history.size() > 1) {
                    int possibility2 = Integer.parseInt(history.get(history.size() - 2).get(1) + "");
                    if (possibility2 == 4) {// 0
                        ArrayList<Integer> values = (ArrayList<Integer>) history.get(history.size() - 2).get(2);
                        n = values.get(0);
                        f = values.get(1);
                        p = values.get(2);
                    }
                }
                if (p < numberMain) {
                    System.out.println("mm..");
                } else if (p == numberMain) {
                    System.out.println("ok..");// 6 to 3
                }
            }

            if (isWinner)
                break;
            System.out.println("Your number is " + arrayOfValues);
            System.out.println("Give me the 'fijas' and 'picas'");
            System.out.println("Enter 'fijas'");
            fijas = sc.nextInt();
            System.out.println("Enter 'picas'");
            picas = sc.nextInt();
            if (fijas == numberMain) {
                System.out.println("I am Winner");
                System.out.println("You are loser");
                isWinner = true;
                break;
            }
            if (fijas == 0 && picas == 0)
                blackList.addAll(arrayOfValues);
            if (fijas + picas > numberMain) {
                System.out.println("I am Winner");
                System.out.println("You are loser");
                isWinner = true;
                break;
            }
            if (picas == numberMain) {
                System.out.println("Found Numbers");
                found = true;
            }
            updateHistory(0);
            System.out.println("\n/-----/");
            System.out.println(blackList);
            System.out.println("/-----/");
        }
    }

    private static void YouVsFriend(int n) {
        numberMain = n;
        System.out.println("How many persons want play");
        int p = sc.nextInt();
        if (p == 2)
            Humans();
        else {
            System.out.println("The number of persons must be 2");
            YouVsFriend(n);
        }
    }

    private static void YouVsAI(int n) {
        numberMain = n;
        System.out.println("Want you start?");
        String val = new Scanner(System.in).nextLine();
        if (val.equals("y")) {
            Ai();
        } else {
            Ai2();
        }
    }

    private static boolean managerType(int type, int n) {
        if (type == 0) {
            YouVsAI(n);
            return false;
        } else if (type == 1) {
            YouVsFriend(n);
            return false;
        } else {
            System.out.println("Invalid option");
            return false;
        }
    }

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            menu();
            if (choice == 2) {
                exit = true;
                break;
            } else {
                System.out.println("How many digits is the number");
                int n = sc.nextInt();
                if (n >= 2 && n <= 8) {
                    isWinner = false;
                    boolean ex = managerType(choice, n);
                    if (ex) {
                        exit = true;
                        break;
                    } else {
                        menu();
                    }
                } else
                    System.out.println("The number of digits must be between 2 and 8");
            }
        }
    }
}