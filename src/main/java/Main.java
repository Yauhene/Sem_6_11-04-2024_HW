import java.util.*;

import static java.lang.Math.random;

public class Main {

    static int gameTimes = 1000; // количество игр
    static double percentages_1; // процентное соотношение побед при настаивании игроком на первом выборе
    static double percentages_2; // процентное соотношение побед при смене выбора
    static int victories_1; // количество побед при настаивании игроком на первом выборе
    static int victories_2; // количество побед при  смене выбора
    static HashMap<Integer,String> mapRes = new HashMap<>();
    static HashMap<Integer,String> mapRes_1 = new HashMap<>();
    static HashMap<Integer,String> mapRes_2 = new HashMap<>();

    public static void main(String[] args) {

        System.out.println("Режим 1 (настаивать на первом выборе): ");
        Game.setWinCount(0); // обнуление счетчика побед в классе Game
        for (int i = 0; i < gameTimes; i++) {
            Game game_1 = new Game(1, i);
        }
        victories_1 = Game.getWinCount();
        percentages_1 = (double) victories_1 / gameTimes;
        mapRes_1 = mapRes;

        System.out.println("Режим 2 (изменить решение): ");
        Game.setWinCount(0); // обнуление счетчика побед в классе Game
        for (int i = 0; i < gameTimes; i++) {
            Game game_2 = new Game(2, i);
        }
        victories_2 = Game.getWinCount();
        percentages_2 = (double) victories_2 / gameTimes;
        mapRes_2 = mapRes;

        System.out.println();

        System.out.println("========== Статистика по режимам игры ====================");
        System.out.println("Режим 1 (настаивать на первом выборе): ");
        System.out.println("    Количество побед игрока - " + victories_1 + ", процент побед - " + percentages_1 + " %");

        System.out.println("Режим 2 (изменить решение): ");
        System.out.println("    Количество побед игрока - " + victories_2 + ", процент побед - " + percentages_2 + " %");
        System.out.println("===========================================================");

        // данный вывод результатов сделан исключительно из требования создать HashMap с результатами
        // серии игр в домашнем задании
        /*
        System.out.println();
        System.out.println("Режим 1 (настаивать на первом выборе): ");
        showStatistics(mapRes_1);
        System.out.println();
        System.out.println("Режим 2 (изменить решение): ");
        showStatistics(mapRes_2);

         */
    }

    public static void showStatistics(HashMap<Integer, String> map) {
        System.out.println();
        System.out.println("Вывод содержимого мапы статистики серии игр: ");
        for (Map.Entry entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : "   + entry.getValue());
        }
    }
}
