import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Filter {
    protected int treshold;

    public Filter(int treshold) {
        this.treshold = treshold;
    }

    public List<Integer> filterOut(List<Integer> source) {
        Logger logger = Logger.getInstance();
        List<Integer> result = new ArrayList<>();
        result = source.stream()
                .filter((x) -> {
                    if (x > treshold) logger.log(String.format("Элемент \"%d\" не подходит", x));
                    else logger.log(String.format("Элемент \"%d\" подходит", x));
                    return x < treshold;
                })
                .collect(Collectors.toList());
        return result;
    }

}
