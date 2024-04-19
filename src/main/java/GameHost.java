import java.util.*;

public class GameHost { // класс ведущего

    int gameHostChoice;


    /**
     * Функция хода ведущего, возвращает номер открываемой им двери
     * @param pChoice - начальный выбор игрока
     * @param wDoor - номер двери-победителя
     * @param array - массив-схема дверей
     * @return - номер открываемой ведущим двери
     */
    public int choice(int pChoice, int wDoor, int[] array) {
        int result = 0;
        int hostChoice;
        Random random = new Random();

        int counter = 0;
        if ( pChoice == wDoor) {
            hostChoice = random.nextInt(0, 1);
            for (int i = 0; i < array.length; i++) {
                if ((hostChoice > counter) && (array[i] == 0)) {
                    counter++;
                } else {

                    result = i;
                }
            }
        } else {
            for (int i = 0; i < array.length; i++) {
                if ((array[i] == 0) && (i != pChoice)) {
                    result = i;
                }
            }
        }

        return result;
    }
}
