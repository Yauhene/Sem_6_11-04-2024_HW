import java.util.*;

public class Game {

//    public static int[] doorsArray; // массив дверей

    int playerChoice;
    int gameHostChoice;
    int winDoor; // индекс выигрышной двери
    int mode; // тип игры, 1 - игрок настаивает на первоначальном выборе, 2 - меняет свое решение

    Map<Integer,String> mapRes = new HashMap<>();


    static int winCount = 0;


    int[] doorsArray = new int[]{0, 0, 0};

    Random random = new Random();

    public Game(int mode) {

        this.mode = mode;
        this.winDoor = random.nextInt(0,3);

        Player player = new Player();
        GameHost gameHost = new GameHost();

        doorsArray[winDoor] = 1;

        System.out.println();

        System.out.println("Победная дверь # " + (winDoor + 1) + " ( состояние двери - " + doorsArray[winDoor] + ") ");

        System.out.print("Состояние комнат: ");
        for (int item: doorsArray) {
            System.out.print(item + ", ");
        }
        System.out.println("\n");

        playerChoice = player.firstChoice();
        System.out.println("Игрок выбрал дверь # " + (playerChoice + 1) + " ( состояние двери - " + doorsArray[playerChoice] + ") ");

        gameHostChoice = gameHost.choice(playerChoice, winDoor, doorsArray);
        System.out.println("Ведущий открыл дверь # " + (gameHostChoice + 1) +  " ( состояние двери - " + doorsArray[gameHostChoice] + ") ");

        playerChoice = player.secondChoice(mode, doorsArray, gameHostChoice);
        System.out.println("Игрок выбрал дверь # " + (playerChoice + 1) + " ( состояние двери - " + doorsArray[playerChoice] + ") ");

//        if (playerChoice == winDoor) {
//            winCount++;
//            System.out.println("Победа игрока !!!");
//            mapRes. "victory";
//        } else {
//            System.out.println("Игрок проиграл.");
//            return "defeat";
//        }

        result(playerChoice,winDoor);
    }

    public int getWinDoor() {
        return winDoor;
    }

    public int getPlayerChoice() {
        return playerChoice;
    }

    public static String result(int playerChoice, int winDoor) {
        if (playerChoice == winDoor) {
            winCount++;
            System.out.println("Победа игрока !!!");
            return "victory";
        } else {
            System.out.println("Игрок проиграл.");
            return "defeat";
        }
    }

    public int getMode() {
        return mode;
    }

    public int[] getDoorsArray() {
        return doorsArray;
    }

    public static int getWinCount() {
        return winCount;
    }

    public static void setWinCount(int winCount) {
        Game.winCount = winCount;
    }
}
