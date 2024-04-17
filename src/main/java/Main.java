import java.util.*;

public class Main {

    static int gameTimes = 1000;
    static double percentages_1;
    static double percentages_2;
    static int victories_1;
    static int victories_2;
    static Map<Integer,String> mapRes_1 = new HashMap<>();
    static Map<Integer,String> mapRes_2 = new HashMap<>();

    public static void main(String[] args) {

        System.out.println("Режим 1 (настаивать на первом выборе): ");
        for (int i = 0; i < gameTimes; i++) {
            Game game_1 = new Game(1);
            mapRes_1.put(i, Game.result();
        }
        victories_1 = Game.getWinCount();
        percentages_1 = (double) victories_1 / gameTimes;

        Game.setWinCount(0);

        System.out.println("Режим 2 (изменить решение): ");
        for (int i = 0; i < gameTimes; i++) {
            Game game_2 = new Game(2);
            mapRes_2.put(i, Game.result());
        }
        victories_2 = Game.getWinCount();
        percentages_2 = (double) victories_2 / gameTimes;

        System.out.println();

        System.out.println("========== Статистика по режимам игры ====================");
        System.out.println("Режим 1 (настаивать на первом выборе): ");
        System.out.println("    Количество побед игрока - " + victories_1 + ", процент побед - " + percentages_1 + " %");

        System.out.println("Режим 2 (изменить решение): ");
        System.out.println("    Количество побед игрока - " + victories_2 + ", процент побед - " + percentages_2 + " %");
    }

//    public String statistics() {
//        if (Game.getPlayerChoice() == Game.getW) {
//            winCount++;
//            System.out.println("Победа игрока !!!");
//            return "victory";
//        } else {
//            System.out.println("Игрок проиграл.");
//            return "defeat";
//        }
//    }
}
