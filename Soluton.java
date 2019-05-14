import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

import static java.lang.Integer.parseInt;

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String pathFileName = reader.readLine();

        FileInputStream fins = new FileInputStream(pathFileName);
        int i = -1;
        String s = "";
        while((i = fins.read()) != -1) {
//            System.out.print((char)i);
            s = s + (char)i;
        }

        reader.close();
        fins.close();

        String [] numbers = s.split("\n");
        ArrayList<Integer> numb = new ArrayList<Integer>();
        ArrayList<Integer> numbFine = new ArrayList<Integer>();
        for (String text: numbers) {
            numb.add(parseInt(text));
        }

        for (Integer n : numb) {
            if (n % 2 == 0) numbFine.add(n);
        }

        Collections.sort(numbFine);

//        System.out.println();
//        System.out.println();
        for (Integer n: numbFine) {
            System.out.println(n);
        }
    }
}
