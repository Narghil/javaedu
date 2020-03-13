package ExcerciseProjects;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import static PG.Utils.IOUtils.sopl;
import static PG.Utils.ScreenUtils.cls;

public class FruitCounter {
    public static void main(String[] args) {
        String line;
        String[] words;
        Integer count, value;
        Map<String, Integer> map = new HashMap<>();

        cls();sopl("");
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File("fruits.txt")));
            while ((line = br.readLine()) != null) {
                sopl(line);
                words = line.split(" ");
                count = Integer.parseInt(words[0]);
                value = map.get( words[1] );
                if( value == null){ value = 0 ; }
                map.put(words[1], value + count);
            }
            br.close();

            sopl("");
            sopl(map.toString());

        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
    }
}
