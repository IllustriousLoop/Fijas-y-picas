import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    private static int numberMain;
    private static ArrayList<Integer> secretNumber = new ArrayList<Integer>();
    private static final ArrayList<Integer> arrayOfValues = new ArrayList<Integer>();
    static ArrayList<Integer> humanGuess = new ArrayList<Integer>();
    static ArrayList<Boolean> humanGuessValid = new ArrayList<Boolean>();
    private static final ArrayList<ArrayList<Object>> history = new ArrayList<>();
    private static boolean isWinner = false;
    private static String playerOne = "give";
    private static String playerTwo = "";
    private static int fijas = 0, picas = 0;
    static int privFijas = 0, privPicas = 0;
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

    private static void updateHistory(int player, boolean shape) {
        if (shape) {
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
        } else {
            String listString = "", emojiFijas = "", emojiPicas = "";
            for (Integer s : humanGuess)
                listString += s;
            if (privFijas!= 0)
                for (int i = 0; i < privFijas; i++)
                    emojiFijas += " 🎯";
            if (privPicas!= 0)
                for (int i = 0; i < privPicas; i++)
                    emojiPicas += " 🤡";
            if (listString != "") {
                ArrayList<Object> array = new ArrayList<Object>(3);
                ArrayList<Integer> smart = new ArrayList<Integer>(3);
                array.add(listString + emojiFijas + "  " + emojiPicas);
                array.add(player);

                smart.add(Integer.parseInt(listString));
                smart.add(privFijas);
                smart.add(privPicas);

                array.add(smart);
                history.add(array);
            }
        }
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
                    updateHistory(0, true);
                    playerOne = "";
                    playerTwo = "give";
                    System.out.println("Try to guess the number of Player 1");
                } else if (playerTwo == "clue") {
                    playerOne = "give";
                    playerTwo = "";
                    System.out.println("Try to guess the number of Player 2");
                } else if (playerTwo == "wait") {
                    updateHistory(1, true);
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

    static int donkey = 0;

    private static void givePicasFijas() {
        showHistory(1);
        humanGuess.clear();
        privFijas = 0;
        privPicas = 0;  
        System.out.println("\n\nHuman try to guess my number,\nRemember that number is of " + numberMain + " digits");
        int inputGuess = new Scanner(System.in).nextInt();
        int valid = String.valueOf(inputGuess).length();
        for (int i = 0; i < numberMain; i++) {
            humanGuess.add(inputGuess % 10);
            inputGuess /= 10;
        }
        for (int i = 0; i < humanGuess.size() / 2; i++) {
            int temp = humanGuess.get(i);
            humanGuess.set(i, humanGuess.get(humanGuess.size() - i - 1));
            humanGuess.set(humanGuess.size() - i - 1, temp);
        }
        boolean test = true;
        for (int i = 0; i < humanGuess.size(); i++)
            for (int j = 0; j < humanGuess.size(); j++)
                if (i != j && humanGuess.get(i) == humanGuess.get(j))
                    test = false;
        for (int i = 0; i < humanGuess.size(); i++)
            humanGuessValid.add(false);

        if (valid < numberMain || valid > numberMain) {
            System.out.println("The number is bad");
            System.out.println("I'm winner");
            isWinner = true;
        } else if (!test) {
            System.out.println("There are numbers repeat");
            System.out.println("I'm winner");
            isWinner = true;
        } else {
            for (int i = 0; i < humanGuess.size(); i++) {
                if (humanGuess.get(i) == secretNumber.get(i)) {
                    privFijas++;
                    humanGuessValid.set(i, true);
                }
                if (secretNumber.contains(humanGuess.get(i)) && !humanGuessValid.get(i)) {
                    privPicas++;
                }
                if (i == numberMain - 1) {
                    if (privFijas == numberMain) {
                        System.out.println("You win");
                        isWinner = true;
                    } else {
                        System.out.println("There are 'fija': " + privFijas + " and 'picas': " + privPicas);
                        updateHistory(1, false);
                    }
                }
            }
        }
    }

    static int interactions = 0;
    static String way = "0";
    static int count = 0;
    static int count2 = 0;
    static int unitsTemp = 0;
    static int TenthsTemp = 0;
    static ArrayList<Integer> units = new ArrayList<Integer>() {
        {
            for (int i = 0; i < 10; i++)
                add(i);
        }
    };
    static ArrayList<Integer> source = new ArrayList<Integer>() {
        {
            for (int i = 0; i < 10; i++)
                add(i);
        }
    };
    static ArrayList<Integer> Tenths = new ArrayList<Integer>() {
        {
            for (int i = 1; i < 10; i++)
                add(i);
        }
    };
    static ArrayList<Integer> Helps = new ArrayList<Integer>();

    private static void removeSource(int value) {
        for (int i = 0; i < source.size(); i++) {
            if (source.get(i) == value) {
                source.remove(i);
                break;
            }
        }
    }

    private static void removeTenths(int value) {
        for (int i = 0; i < Tenths.size(); i++) {
            if (Tenths.get(i) == value) {
                Tenths.remove(i);
                break;
            }
        }
    }

    private static void removeUnits(int value) {
        for (int i = 0; i < units.size(); i++) {
            if (units.get(i) == value) {
                units.remove(i);
                break;
            }
        }
    }

    private static void getPicasFijas() {
        if (interactions == 0) {
            for (int i = 0; i < numberMain; i++) {
                int n = (int) (Math.random() * 9 + 1);
                if (arrayOfValues.contains(n))
                    i--;
                else
                    arrayOfValues.add(n);
            }
            interactions++;
        }
        System.out.println(
                "\n\nYour number is " + arrayOfValues.toString().replaceAll("\\[|\\]", "").replaceAll(", ", ""));
        System.out.println("Give me the 'fijas' and 'picas'");
        System.out.println("Enter 'fijas'");
        fijas = sc.nextInt();
        System.out.println("Enter 'picas'");
        picas = sc.nextInt();

        if (interactions != 0)
            interactions++;
        if ((picas + fijas) > numberMain) {
            System.out.println("The sum of the tracks cannot be greater than the number of digits that were chosen");
            System.out.println("I am Winner");
            isWinner = true;
        } else if (fijas == numberMain) {
            System.out.println("I am Winner");
            System.out.println("You are loser");
            isWinner = true;
        } else if (way == "win") {
            interactions--;
            System.out.println("I check well my accounts and give me winner");
            System.out.println("I am Winner");
            System.out.println("You are loser");
            isWinner = true;
        } else {
            if (numberMain == 2) {
                int U = arrayOfValues.get(1);
                int T = arrayOfValues.get(0);
                if (fijas == 0 && picas == 0) {
                    if (way.equals("0")) {
                        removeSource(T);
                        removeSource(U);
                        removeTenths(T);
                        removeTenths(U);
                        removeUnits(T);
                        removeUnits(U);

                        arrayOfValues.clear();
                        if (source.size() > 2) {
                            arrayOfValues.add(source.get(source.size() - 1));
                            arrayOfValues.add(source.get(source.size() - 2));
                        } else if (source.size() == 2 && source.get(1) != 0) {
                            way = "win";
                            arrayOfValues.add(source.get(1));
                            arrayOfValues.add(source.get(0));
                        } else {
                            way = "win";
                            arrayOfValues.add(source.get(0));
                            arrayOfValues.add(source.get(1));
                        }
                    } else if (way.equals("1")) {
                        way = "12";
                        removeSource(Helps.get(0));
                        removeSource(Helps.get(2));

                        removeTenths(Helps.get(0));
                        removeTenths(Helps.get(1));
                        removeTenths(Helps.get(2));
                        unitsTemp = Helps.get(1);

                        arrayOfValues.clear();
                        System.out.println(Tenths.toString());
                        if (Tenths.size() == 1) {
                            way = "win";
                            System.out.println(Tenths);
                            arrayOfValues.add(Tenths.get(0));
                            arrayOfValues.add(unitsTemp);
                        } else {
                            for (int i = 0; i < Tenths.size(); i++) {
                                if (i < Tenths.size()) {
                                    arrayOfValues.add(Tenths.get(i));
                                    arrayOfValues.add(Tenths.get(i + 1));
                                    break;
                                } else {
                                    System.out.println("I couldn't found number");
                                    System.out.println("You are Winner");
                                }
                            }
                        }
                    } else if (way.equals("2")) {
                        way = "21";
                        count2++;
                        if (count2 == 2) {
                            removeTenths(Helps.get(0));
                            removeTenths(Helps.get(1));
                            removeTenths(Helps.get(2));
                            unitsTemp = Helps.get(0);
                        } else {
                            removeTenths(T);
                            removeTenths(U);
                        }
                        arrayOfValues.clear();
                        if (Tenths.size() < 2) {
                            way = "win";
                            arrayOfValues.add(Tenths.get(0));
                            arrayOfValues.add(unitsTemp);
                        } else {
                            for (int i = 0; i < Tenths.size(); i++) {
                                arrayOfValues.add(Tenths.get(i));
                                arrayOfValues.add(Tenths.get(i + 1));
                                break;
                            }
                        }
                    } else if (way.equals("21")) {
                        removeTenths(T);
                        removeTenths(U);
                        arrayOfValues.clear();
                        if (Tenths.size() < 2) {
                            way = "win";
                            arrayOfValues.add(Tenths.get(0));
                            arrayOfValues.add(unitsTemp);
                        } else {
                            for (int i = 0; i < Tenths.size(); i++) {
                                arrayOfValues.add(Tenths.get(i));
                                arrayOfValues.add(Tenths.get(i + 1));
                                break;
                            }
                        }
                    } else {
                        if (way.equals("12") || way.equals("21")) {
                            removeTenths(T);
                            removeTenths(U);
                            arrayOfValues.clear();
                            if (Tenths.size() == 1 && way.equals("12")) {
                                way = "win";
                                arrayOfValues.add(Tenths.get(0));
                                arrayOfValues.add(Helps.get(1));
                            } else if (Tenths.size() == 1 && way.equals("21")) {
                                way = "win";
                                arrayOfValues.add(Tenths.get(0));
                                arrayOfValues.add(Helps.get(0));
                            } else {
                                for (int i = 0; i < Tenths.size(); i++) {
                                    if (Tenths.size() > 1) {
                                        arrayOfValues.add(Tenths.get(i));
                                        arrayOfValues.add(Tenths.get(i + 1));
                                        break;
                                    } else {
                                        System.out.println("I couldn't found number");
                                        System.out.println("You are Winner");
                                    }
                                }
                            }
                        } else if (way.equals("11") || way.equals("23")) {
                            removeUnits(T);
                            removeUnits(U);
                            arrayOfValues.clear();
                            if (units.size() == 1) {
                                if (way.equals("11")) {
                                    way = "win";
                                    arrayOfValues.add(Helps.get(0));
                                    arrayOfValues.add(units.get(0));
                                } else {
                                    way = "win";
                                    arrayOfValues.add(Helps.get(1));
                                    arrayOfValues.add(units.get(0));
                                }
                            } else {
                                for (int i = 0; i < units.size(); i++) {
                                    if (units.size() > 1) {
                                        arrayOfValues.add(units.get(i));
                                        arrayOfValues.add(units.get(i + 1));
                                        break;
                                    } else {
                                        System.out.println("I couldn't found number");
                                        System.out.println("You are Winner");
                                    }
                                }
                            }
                        }
                    }
                } else if (fijas == 1 && picas == 0) {
                    if (way.equals("0")) {
                        way = "1";
                        arrayOfValues.clear();
                        for (int i = 0; i < source.size(); i++) {
                            if (source.get(i) != U && source.get(i) != T) {
                                arrayOfValues.add(T);
                                arrayOfValues.add(source.get(i));
                                Helps.add(T);
                                Helps.add(U);
                                Helps.add(source.get(i));
                                break;
                            }
                        }
                    } else if (way.equals("1")) {
                        way = "11";
                        removeSource(Helps.get(1));
                        removeSource(Helps.get(2));
                        TenthsTemp = Helps.get(0);

                        removeUnits(Helps.get(0));
                        removeUnits(Helps.get(1));
                        removeUnits(Helps.get(2));

                        arrayOfValues.clear();
                        if (units.size() == 1) {
                            way = "win";
                            arrayOfValues.add(Helps.get(0));
                            arrayOfValues.add(units.get(0));
                        } else {
                            count = 0;
                            for (int i = 0; i < units.size(); i++) {
                                if (units.get(i) != 0) {
                                    if (count < 2) {
                                        count++;
                                        Helps.add(units.get(i));
                                    } else {
                                        arrayOfValues.add(Helps.get(3));
                                        arrayOfValues.add(Helps.get(4));
                                        break;
                                    }
                                } else {
                                    arrayOfValues.add(Helps.get(3));
                                }
                            }
                        }
                    } else if (way.equals("11")) {
                        way = "win";
                        arrayOfValues.clear();
                        arrayOfValues.add(TenthsTemp);
                        arrayOfValues.add(U);
                    } else if (way.equals("12")) {
                        way = "win";
                        arrayOfValues.clear();
                        arrayOfValues.add(T);
                        arrayOfValues.add(unitsTemp);
                    } else if (way.equals("2")) {
                        way = "23";
                        TenthsTemp = Helps.get(1);
                        removeUnits(Helps.get(0));
                        removeUnits(Helps.get(1));
                        removeUnits(Helps.get(2));
                        arrayOfValues.clear();

                        if (units.size() > 1) {
                            arrayOfValues.add(units.get(0));
                            arrayOfValues.add(units.get(1));
                        } else {
                            way = "win";
                            arrayOfValues.add(TenthsTemp);
                            arrayOfValues.add(units.get(0));
                        }
                    } else if (way.equals("21")) {
                        way = "win";
                        arrayOfValues.clear();
                        arrayOfValues.add(T);
                        arrayOfValues.add(unitsTemp);
                    } else if (way.equals("23")) {
                        way = "win";
                        arrayOfValues.clear();
                        arrayOfValues.add(TenthsTemp);
                        arrayOfValues.add(U);
                    }
                } else if (fijas == 0 && picas == 1) {
                    arrayOfValues.clear();
                    if (way.equals("0")) {
                        way = "2";
                        count2++;
                        for (int i = 0; i < source.size(); i++) {
                            if (source.get(i) != U && source.get(i) != T) {
                                arrayOfValues.add(U);
                                arrayOfValues.add(source.get(i));
                                Helps.add(T);
                                Helps.add(U);
                                Helps.add(source.get(i));
                                break;
                            }
                        }
                    } else if (way.equals("1")) {
                        if (U == 0) {
                            interactions--;
                            System.out.println("What? 10 99");
                        } else {
                            way = "win";
                            TenthsTemp = Helps.get(2);
                            unitsTemp = Helps.get(1);
                            arrayOfValues.add(TenthsTemp);
                            arrayOfValues.add(unitsTemp);
                        }
                    } else if (way.equals("11")) {
                        way = "win";
                        arrayOfValues.clear();
                        arrayOfValues.add(TenthsTemp);
                        arrayOfValues.add(T);
                    } else if (way.equals("12")) {
                        way = "win";
                        arrayOfValues.clear();
                        arrayOfValues.add(U);
                        arrayOfValues.add(Helps.get(1));
                    } else if (way.equals("2")) {
                        if (U == 0) {
                            System.out.println("What? check well your answer");
                        } else {
                            way = "win";
                            arrayOfValues.clear();
                            arrayOfValues.add(U);
                            arrayOfValues.add(Helps.get(0));
                        }
                    } else if (way.equals("21")) {
                        way = "win";
                        unitsTemp = Helps.get(0);
                        arrayOfValues.clear();
                        arrayOfValues.add(U);
                        arrayOfValues.add(unitsTemp);
                    } else if (way.equals("23")) {
                        way = "win";
                        arrayOfValues.clear();
                        arrayOfValues.add(TenthsTemp);
                        arrayOfValues.add(T);
                    }
                } else if (fijas == 1 && picas == 1) {
                    way = "win";
                    System.out.println("What? These values are not possibles");
                } else if (picas == 2) {
                    if (U == 0) {
                        System.out.println("Check your answer");
                    } else {
                        way = "win";
                        arrayOfValues.clear();
                        arrayOfValues.add(U);
                        arrayOfValues.add(T);
                    }
                } else if (fijas < 0 || fijas > 2 || picas < 0 || picas > 2) {
                    System.out.println("There values are not possible ");
                } else {
                    System.out.println("'picas' and 'fijas' must be 0 between 2");
                }
            } else if (numberMain == 3) {
                if (fijas == 0 && picas == 0) {
                } else if (fijas == 1 && picas == 0) {
                } else if (fijas == 0 && picas == 1) {
                } else if (fijas == 1 && picas == 1) {
                } else if (fijas == 2 && picas == 0) {
                } else if (fijas == 0 && picas == 2) {
                } else if (fijas == 2 && picas == 1) {
                } else if (fijas == 1 && picas == 2) {
                } else if (fijas == 3) {
                } else if (fijas < 0 || fijas > 3 || picas < 0 || picas > 3) {
                    System.out.println("it's not possible this values");
                } else {
                    System.out.println("'picas' and 'fijas' must be 0 between 3");
                }
            } else if (numberMain == 4) {
                if (fijas == 0 && picas == 0) {
                } else if (fijas == 1 && picas == 0) {
                } else if (fijas == 0 && picas == 1) {
                } else if (fijas == 1 && picas == 1) {
                } else if (fijas == 2 && picas == 0) {
                } else if (fijas == 0 && picas == 2) {
                } else if (fijas == 2 && picas == 1) {
                } else if (fijas == 1 && picas == 2) {
                } else if (fijas == 3 && picas == 0) {
                } else if (fijas == 0 && picas == 3) {
                } else if (fijas == 3 && picas == 1) {
                } else if (fijas == 1 && picas == 3) {
                } else if (fijas == 2 && picas == 2) {
                } else if (fijas == 4) {
                } else if (fijas < 0 || fijas > 4 || picas < 0 || picas > 4) {
                    System.out.println("it's not possible this values");
                } else {
                    System.out.println("'picas' and 'fijas' must be 0 between 4");
                }
            }
        }
    }

    private static void Ai(boolean isFirst) {
        while (!isWinner) {
            if (interactions == 0) {
                for (int i = 0; i < numberMain; i++) {
                    int n = (int) (Math.random() * 9 + 1);
                    if (secretNumber.contains(n))
                        i--;
                    else
                        secretNumber.add(n);
                }
            }
            if (isFirst) {
                givePicasFijas();
                if (isWinner)
                    break;
                getPicasFijas();
            } else {
                getPicasFijas();
                if (isWinner)
                    break;
                givePicasFijas();
            }
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
            Ai(true);
        } else {
            Ai(false);
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