import java.util.regex.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(Pattern.compile(".*er").matcher("Niger").matches());
        System.out.println(Pattern.compile("Me.*").matcher("Mexico").matches());
        System.out.println(Pattern.compile(".*ar.*").matcher("Nicaragua").matches());
        System.out.println(Pattern.compile("Mo.*roc.*co").matcher("Morocco").matches());
        System.out.println(Pattern.compile(".*rr*.*").matcher("Andorra").matches());
        System.out.println(Pattern.compile("B(u.)*ndi").matcher("Burundi").matches());
    }
}


