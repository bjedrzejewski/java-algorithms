package hackerrank.worldcodesprint6;

import java.util.Scanner;

/**
 * Created by bartoszjedrzejewski on 27/08/2016.
 */
public class Abbreviation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int qi = 0; qi < q; qi++){
            String a = in.next();
            String b = in.next();
            boolean found = find(a, b);
            String answer = "NO";
            if(found) {
                answer = "YES";
            }
            System.out.println(answer);
        }
    }

    public static boolean find(String a, String b){
        if(b.length() == 0){
            return true;
        }
        if(b.length() > a.length()){
            return false;
        }
        if(b.length() == a.length()){
            a = a.toUpperCase();
            if(a.contains(b)){
                return true;
            } else {
                return false;
            }
        }
        char c;
        for(int i = 0; i < a.length(); i++){
            c = a.charAt(i);
            if(Character.isUpperCase(c)) {
                String uB = b;
                while(uB.length() > 0) {
                    int in = b.indexOf(c);
                    if (in < 0) {
                        return false;
                    }
                    if (find(a.substring(0, i), b.substring(0, in))
                            && find(a.substring(i + 1, a.length()), b.substring(in + 1, b.length()))) {
                        return true;
                    } else {
                        b = b.substring(in+1);
                    }
                }
                return false;
            }
        }
        a = a.toUpperCase();
        int bi = 0;
        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) == b.charAt(bi)){
                bi++;
            }
            if(bi == b.length()){
                return true;
            }
        }
        return false;
    }

}
