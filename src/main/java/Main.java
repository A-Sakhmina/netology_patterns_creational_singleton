import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Logger logger = Logger.getInstance();
        //[31.12.2019 15:38:22 1] Запускаем программу
        logger.log("Запускаем программу");
        //[31.12.2019 15:38:22 2] Просим пользователя ввести входные данные для списка
        logger.log("Просим пользователя ввести входные данные для списка");
        System.out.println("Введите размер списка:");
        //Введите размер списка: 7
        int listSize; //размер списка
        listSize = scanner.nextInt();
        //Введите верхнюю границу для значений: 10
        System.out.println("Введите верхнюю границу для значений");
        int maxValue; //верхнюю границу для значений
        maxValue = scanner.nextInt();
        //[31.12.2019 15:38:23 3] Создаём и наполняем список
        logger.log("Создаём и наполняем список");
        List<Integer> listValues = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < listSize; i++) {
            listValues.add(random.nextInt(maxValue));
        }
        //Вот случайный список: 3 5 5 1 0 3 6
        System.out.println("Вот случайный список:");
        for (int valueOfList : listValues) {
            System.out.print(valueOfList);
        }
        System.out.println();

        //[31.12.2019 15:38:23 4] Просим пользователя ввести входные данные для фильтрации
        logger.log("Просим пользователя ввести входные данные для фильтрации");
        //Введите порог для фильтра: 4
        System.out.println("Введите порог для фильтра:");
        int filterValue;
        filterValue = scanner.nextInt();
        //[31.12.2019 15:38:23 5] Запускаем фильтрацию
        logger.log("Запускаем фильтрацию");
        Filter filter = new Filter(filterValue);
        listValues = filter.filterOut(listValues);

        int countFiltered = (int) listValues.stream()
                .count();
        logger.log(String.format("Прошло фильтр %d элемента из %d", countFiltered, listSize));

        logger.log("Выводим результат на экран");
        System.out.println("Отфильтрованный список:");
        for (int valueOfList : listValues) {
            System.out.print(valueOfList);
        }
        System.out.println();
        logger.log("Завершаем программу");


    }
}
