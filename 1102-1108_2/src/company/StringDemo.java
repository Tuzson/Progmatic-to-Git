package company;

public class StringDemo {

    public static void main(String[] args) {
        String s = "alma";
        s = s.replace("ma", "holnap");
        //System.out.println(s);
        //System.out.println(buildLongString('a', 100));
        //System.out.println(buildLongStringAndEatUpLotsofMemory('a', 100));

        String s1 = "alma";
        String s2 = "al" + "ma";
        String s3 = concat("al", "ma");
        System.out.println(s1 == s2);
        //s2 = s2.intern();
        System.out.println(s1 == s3);
    }

    private static String concat(String s1, String s2){
        return s1 + s2;
    }

    public static String buildLongString(char ch, int length){
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < length; i++) {
            sb.append(ch);
        }
        return sb.toString();
    }

    public static String buildLongStringAndEatUpLotsofMemory(char ch, int length){
        String base = "";
        for (int i = 0; i < length; i++) {
            base = base + ch;
        }
        return base;
    }
}
