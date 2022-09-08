
// 논리연산
/*
public class Demo {
    public static void main(String[] args) {
        boolean tag = false;
        tag = tag && true || ! tag;
        System.out.println(tag);
    }
}
*/


// 문자열 (객체)
/*
public class Demo {
    public static void main(String[] args) {
        String slogan = "자유는 공짜가 아니다";
        System.out.println(slogan);
        System.out.println(slogan.length());
        String slogan2 = "  " + slogan + "  ";
        System.out.println(slogan2 + "!");
        System.out.println(slogan2.length());
        String slogan3 = slogan2.trim();
        System.out.println(slogan3 + "!");
        System.out.println(slogan);
        System.out.println(slogan3);
        System.out.println(slogan == slogan3);
        System.out.println(slogan.equals(slogan3));
        System.out.println(slogan.charAt(5));
        System.out.println(slogan.substring(4,6));
        String slogan_eng = "Freedom is not free";
        System.out.println(slogan_eng);
        System.out.println(slogan_eng.toUpperCase());
        System.out.println(slogan_eng.toLowerCase());
        System.out.println(slogan_eng.indexOf('o'));
        System.out.println(slogan_eng.indexOf('o',6));
        System.out.println("a".compareTo("d"));
        System.out.println("D".compareTo("A"));
    }
}
*/


// 프로그램 인수로 전달

public class Demo {
    public static void main(String[] args) {
        String who = args[0];
        String what = args[1];
        System.out.println(who + " likes " + what + ".");
    }
}




