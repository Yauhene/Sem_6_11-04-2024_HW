import java.util.*;

public class Player { // класс игрока

    int playerChoice;
    public Player () {

    }
    /**
     * Метод первого хода игрока, возвращает номер выбранной двери от 0 до 2.
     * @return - номер выбранной двери от 0 до 2
     */
    public int firstChoice() {
        int result;
        Random random = new Random();
        playerChoice = random.nextInt(0, 2);

        return playerChoice;
    }

    /**
     * Метод второго хода игрока, возвращает номер выбранной двери в зависимости от режима игры
     * @param mode - режим игры
     * @param array - массив-план дверей
     * @param hChoice - номер двери, открытой ведущим
     * @return - номер двери, в итоге указанной игроком
     */
    public int secondChoice(int mode, int[] array, int hChoice) {
        int result = playerChoice;
        if (mode != 1) {

            for (int i = 0; i < array.length; i++) {
                if (i != playerChoice && i != hChoice) {
                    result = i;
                }
            }
        }
        return result;
    }

}
