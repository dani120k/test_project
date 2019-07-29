package sokolov;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;


public class Sort_test
{
    private List<String> def_input;
    private List<String> custom_input;

    @Before
    public void init(){
        def_input = Arrays.asList(
                "K1\\SK1",
                "K1\\SK2",
                "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2",
                "K2",
                "K2\\SK1\\SSK1",
                "K2\\SK1\\SSK2"
        );

        custom_input = Arrays.asList(
                "k3",
                "k3\\s1\\t1",
                "k3\\s2\\t2",
                "k1\\q1",
                "k1\\q2",
                "l4\\p5\\p6",
                "l4\\p3\\p4"
        );
    }

    @Test
    public void defaultInput()
    {
        String[] answer = {
                "K2",
                "K2\\SK1",
                "K2\\SK1\\SSK2",
                "K2\\SK1\\SSK1",
                "K1",
                "K1\\SK2",
                "K1\\SK1",
                "K1\\SK1\\SSK2",
                "K1\\SK1\\SSK1"
        };
        Sorter sorter = new Sorter(new CustomComparator(), def_input);
        SortedSet<String> groups = sorter.getGroups();
        Assert.assertEquals(groups.size(), answer.length);
        Iterator<String> iter = groups.iterator();
        int i =0;
        while (iter.hasNext()){
            Assert.assertEquals(answer[i++], iter.next());
        }
    }

    @Test
    public void customInput()
    {
        String[] answer = {
                "l4",
                "l4\\p5",
                "l4\\p5\\p6",
                "l4\\p3",
                "l4\\p3\\p4",
                "k3",
                "k3\\s2",
                "k3\\s2\\t2",
                "k3\\s1",
                "k3\\s1\\t1",
                "k1",
                "k1\\q2",
                "k1\\q1"
        };
        Sorter sorter = new Sorter(new CustomComparator(), custom_input);
        SortedSet<String> groups = sorter.getGroups();
        Assert.assertEquals(groups.size(), answer.length);
        Iterator<String> it = groups.iterator();
        int i =0;
        while (it.hasNext()){
            Assert.assertEquals(answer[i++], it.next());
        }
    }
}
