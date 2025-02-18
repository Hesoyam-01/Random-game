import java.util.Scanner;
import java.util.Random;

class Main {
    public static void main(String[] args) {
        do {
            Game.start();
        } while (Game.restart());
    }
}

class Game {
    static void start() {
        int tryNumber = 1;
        int random = new Random().nextInt(10);
        System.out.println("Загадано число от 0 до 9. У тебя 3 попытки, чтобы угадать его.");

        while (tryNumber <= 3) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Попытка №" + tryNumber + ": ");

            if (scanner.hasNextInt()) {
                int userAnswer = scanner.nextInt();
                tryNumber += 1;

                if (userAnswer < random) {
                    if (tryNumber != 4) {
                        System.out.println("Больше.");
                    }
                } else if (userAnswer > random) {
                    if (tryNumber != 4) {
                        System.out.println("Меньше.");
                    }
                } else {
                    System.out.println("Угадал!");
                    return;
                }
            } else {
                System.out.println("Нужно ввести число. Попробуй еще раз.");
            }
        }
        System.out.println("Не угадал! Загаданное число - " + random + ".");
    }


    static boolean restart() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Хочешь сыграть еще раз? Да - '1', Нет - '0'");

        while (true) {
            String restartNum = scanner.next();

            switch (restartNum) {
                case "1":
                    return true;
                case "0":
                    return false;
                default:
                    System.out.println("Неверный ввод. Сыграть еще раз? Да - '1', Нет - '0'");
            }
        }
    }
}
