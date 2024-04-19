import java.util.*;

public class Game {

    int playerChoice; // выбор игрока, номер двери
    int gameHostChoice; // номер двери, открытой ведущим после первого хода игрока
    int winDoor; // индекс выигрышной двери
    int mode; // тип игры, 1 - игрок настаивает на первоначальном выборе, 2 - меняет свое решение
    int counter; // счетчик, id игры в мапе mapRes
    Map<Integer,String> mapRes = new HashMap<>(); // статистическая мапа игры


    static int winCount = 0; // количество побед в серии игр


    int[] doorsArray = new int[]{0, 0, 0}; // массив-план дверей, 0 - за ней пусто, 1 - выигрышная дверь

    Random random = new Random();

    /**
     * Конструктор игры
     * @param mode - тип игры, 1 - настаивание игроком на первом выборе, 2 - смена выбора
     * @param counter - номер игры в серии
     */
    public Game(int mode, int counter) {

        this.mode = mode;
        this.winDoor = random.nextInt(0,3);
        this.counter = counter;

        Player player = new Player();
        GameHost gameHost = new GameHost();

        doorsArray[winDoor] = 1; // вносим дверь-победитель в массив дверей

        System.out.println();
        System.out.print("Попытка # " + (counter+1) + ". Комнаты: "); // вывод состояния комнат в консоль
        for (int item: doorsArray) {
            System.out.print(item + ", ");
        }
        System.out.println("Победная дверь # " + (winDoor + 1) + " ( состояние двери - " + doorsArray[winDoor] + ") ");

        playerChoice = player.firstChoice(); // первый ход игрока
        System.out.print("Ход игрока, дверь # " + (playerChoice + 1) + " ( " + doorsArray[playerChoice] + " ). ");

        gameHostChoice = gameHost.choice(playerChoice, winDoor, doorsArray); // ход ведущего
        System.out.print("Ход ведущего # " + (gameHostChoice + 1) +  " ( " + doorsArray[gameHostChoice] + " ). ");

        playerChoice = player.secondChoice(mode, doorsArray, gameHostChoice); // итоговый ход игрока
        System.out.println("Игрок выбрал дверь # " + (playerChoice + 1) + " ( состояние двери - " + doorsArray[playerChoice] + ") ");

        Main.mapRes_1.put(counter, result()); // внесение итогов текущей игры в иапу серии игр
    }

    /**
     * Функция принятия решения о результате игры, возвращает вердикт в отношении игрока
     * @return
     */
    public String result() {
        if (playerChoice == winDoor) {
            winCount++;
            System.out.println("Победа игрока !!!");
            return "victory";
        } else {
            System.out.println("Игрок проиграл.");
            return "defeat";
        }

    }

    public static int getWinCount() {
        return winCount;
    }

    public static void setWinCount(int winCount) {
        Game.winCount = winCount;
    }
}
