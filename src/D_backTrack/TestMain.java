package D_backTrack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TestMain {
     
    public static void printAll(List<Integer> candidate, String prefix, int length) {
        if (prefix.length() == length){
            System.out.println(prefix);
        }
        for (int i = 0; i < candidate.size(); i++) {
            List<Integer> temp = new LinkedList<Integer>(candidate);
            printAll(temp, prefix + temp.remove(i), length);
        }
    }
 
    public static void main(String[] args) {
//        Long t1 = System.currentTimeMillis();
        TestMain.printAll(Arrays.asList(1, 2, 3, 4), "", 1);
//        System.out.println(System.currentTimeMillis() - t1);
    }
}