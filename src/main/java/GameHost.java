import java.util.*;

public class GameHost {

    int gameHostChoice;
//    public GameHost;

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
