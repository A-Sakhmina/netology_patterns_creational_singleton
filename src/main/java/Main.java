import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Logger logger = Logger.getInstance();

        logger.log("Запускаем программу");

        logger.log("Просим пользователя ввести входные данные для списка");
        System.out.print("Введите размер списка: ");
        int listSize; //размер списка
        listSize = scanner.nextInt();

        System.out.print("Введите верхнюю границу для значений: ");
        int maxValue; //верхнюю границу для значений
        maxValue = scanner.nextInt();

        logger.log("Создаём и наполняем список");
        List<Integer> listValues = randomList(listSize, maxValue);
        //Выводим список
        System.out.print("Вот случайный список: ");
        printList(listValues);

        logger.log("Просим пользователя ввести входные данные для фильтрации");
        System.out.print("Введите порог для фильтра: ");
        int filterValue;
        filterValue = scanner.nextInt();

        logger.log("Запускаем фильтрацию");
        Filter filter = new Filter(filterValue);
        listValues = filter.filterOut(listValues);

        int countFiltered = (int) listValues.stream()
                .count();
        logger.log(String.format("Прошло фильтр %d элемента из %d", countFiltered, listSize));

        logger.log("Выводим результат на экран");
        System.out.print("Отфильтрованный список: ");
        printList(listValues);

        logger.log("Завершаем программу");


    }

    private static List<Integer> randomList(int size, int maxValue) {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            list.add(random.nextInt(maxValue));
        }
        return list;
    }

    private static void printList(List<Integer> list) {
        for (int valueOfList : list) {
            System.out.print(valueOfList + "\t");
        }
        System.out.println();
    }
}
