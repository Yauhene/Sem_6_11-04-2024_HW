import java.util.*;

public class Player {

    int playerChoice;
    public Player () {

    }
    /**
     * Метод первого хода игрока, возвращает номер выбранной двери от 0 до 2.
     * @return
     */
    public int firstChoice() {
        int result;
        Random random = new Random();
        playerChoice = random.nextInt(0, 2);

        return playerChoice;
    }

    public int secondChoice(int mode, int[] array, int hChoice) {
        int result = playerChoice;
        if (mode != 1) {

            for (int i = 0; i < array.length; i++) {

                if (i != playerChoice && i != hChoice) {
                    result = i;
//                    break;
                }
            }
        }
        return result;
    }

}
