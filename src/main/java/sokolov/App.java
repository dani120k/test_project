package sokolov;
import java.util.*;
import java.util.regex.Pattern;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> input = new ArrayList<>();
        for(int i = 0; i < n; i++)
            input.add(sc.next());
        Sorter sorter = new Sorter(new CustomComparator(), input);
        SortedSet<String> order_groups = sorter.getGroups();
        System.out.println(order_groups.size());
        Iterator<String> iterator = order_groups.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
