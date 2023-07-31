import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        HashMap<String,Integer> grades = new HashMap<>();

        grades.put("Algorithms", 10);
        grades.put("Java", 10);
        grades.put("Physics", 0);

        Collection<Integer> gradeValues = grades.values();
        System.out.println(gradeValues);
        for (var grade: gradeValues)
            System.out.println(grade);

        gradeValues.removeAll(Collections.singleton(10));
        System.out.println(gradeValues);
        System.out.println(grades);

    }
}
