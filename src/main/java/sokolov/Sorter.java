package sokolov;
import java.util.*;
import java.util.regex.Pattern;

public class Sorter {
    private List<String> input;
    private SortedSet<String> sorted;

    public Sorter( Comparator<String> comp, List<String> input){
        this.input = input;
        sorted = new TreeSet<>(comp);
        this.sort();
    }

    private void sort(){
        for(String str : input){
            String[] groups = str.split(Pattern.quote("\\"));
            StringBuilder to_insert = new StringBuilder(groups[0]);
            sorted.add(to_insert.toString());
            for(int i = 1; i < groups.length; i++){
                to_insert.append("\\")
                         .append(groups[i]);
                sorted.add(to_insert.toString());
            }

        }
    }

    public SortedSet<String> getGroups(){
        return sorted;
    }


}
