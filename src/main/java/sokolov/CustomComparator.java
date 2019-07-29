package sokolov;
import java.util.Comparator;
import java.util.regex.Pattern;

/**
 * Реализация компаратора для сортировки по возрастанию
 */
public class CustomComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] first = o1.split(Pattern.quote("\\"));
        String[] second = o2.split(Pattern.quote("\\"));
        int len = (first.length < second.length) ? first.length : second.length;
        int i = 0;
        while (i < len){
            int compare_result = first[i].compareTo(second[i]);
            if (compare_result !=0)
                return compare_result * (-1);
            i++;
        }

        if (first.length == second.length)
            return 0;
        else
        if (first.length < second.length)
            return -1;
        else
            return 1;
    }
}
