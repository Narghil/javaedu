package ExcerciseProjects;

import java.io.*;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

import static PG.Utils.IOUtils.sopl;

public class LovedDreaded {
    public static void main(String[] args) {
        String line;
        Map<String, Double> loved2018 = new HashMap<>();
        Map<String, Double> dread2018 = new HashMap<>();
        Map<String, Double> loved2019 = new HashMap<>();
        Map<String, Double> dread2019 = new HashMap<>();
        Map<String, Double> map = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(new File("adatok.txt")))) {
            while ((line = br.readLine()) != null) {
                Scanner sc = new Scanner(line); //.useDelimiter(" ");
                sc.useLocale(Locale.US);
                int year = sc.nextInt();
                String type = sc.next();
                String yearType = year + " " +type;
                sopl(yearType);
                switch( yearType ){
                    case "2018 Loved": map = loved2018; break;
                    case "2019 Loved": map = loved2019; break;
                    case "2018 Dreaded": map = dread2018; break;
                    case "2019 Dreaded": map = dread2019; break;
                }
                String prgName = "";
                Double prgRate = 0d;
                while (sc.hasNext()) {
                    if (sc.hasNextDouble()) {
                        prgRate = sc.nextDouble();
                        sopl(prgName + " " + prgRate);
                        map.put(prgName, prgRate);
                        prgName = "";
                    } else {
                        prgName = prgName + " " + sc.next() ;
                    }
                }
            }
            br.close();
            sopl(loved2018.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
