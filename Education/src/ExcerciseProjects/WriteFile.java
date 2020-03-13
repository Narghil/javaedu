package ExcerciseProjects;

import java.io.*;
import java.util.Date;
import java.util.Random;

public class WriteFile {

    private final static String[] FRUITS = new String[] {
            "alma", "körte", "banán", "kiwi", "narancs", "barack", "szilva", "sárgadinnye", "görögdinnye", "eper", "málna", "mangó"
    };

    public static void main(String[] args) {
        example1(20);
//        example2(20);
//        example3(15);
//        example4(5, "src/fruits3.txt", ")");
    }

    static void example1(int lines) {
        Random random = new Random();

        File f = new File("fruits.txt");
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;

        try {
            fos = new FileOutputStream(f);
            bos = new BufferedOutputStream(fos);

            for (int i=0;i<lines;i++) {
                // Figyeljuk meg, hogy a BufferedOutputStream write() metodusa korlatozott, csak byte-ot vagy byte tombot tud atvenni
                String fruit = WriteFile.FRUITS[random.nextInt(WriteFile.FRUITS.length)];
                int count = random.nextInt(5) + 1;
                bos.write((count + " " + fruit + "\n").getBytes());

                if (i % 10 == 0) {
                    bos.flush();
                }
            }

        } catch (FileNotFoundException fnfe) {
            // FileOutputStream konstruktor dobhat FNFE-t
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            // bos.write() dobhat IOE-t
            ioe.printStackTrace();
        } finally {
            // FONTOS! Meg utoljara hivunk egy flush()-t, hogy minden kiirodjon a bufferbol
            try {
                bos.flush();
                bos.close();
            } catch (IOException ioe) {
                System.out.println("Nem lehet üríteni a buffert vagy lezarni a stream-et!");
                ioe.printStackTrace();
            }
        }
    }

    // Hasznaljunk writer-t, azaz karakter alapu csatornat byte alapu helyett, egyelore csak egy FileWriter-rel
    static void example2(int lines) {
        File f = new File("src/fruits2.txt");
        Random random = new Random();

        FileWriter fw = null;
        try {
            fw = new FileWriter(f);

            for (int i=1;i<=lines;i++) {
                String fruit = WriteFile.FRUITS[random.nextInt(WriteFile.FRUITS.length)];
                int count = random.nextInt(5) + 1;

                String currentLine = i + "./ " + count + "db " + fruit;
                fw.append(currentLine);
                fw.append("\n");

                if (i % 10 == 0) {
                    fw.flush();
                }
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {

            try {
                fw.flush();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Hasznaljunk writer-t, azaz karakter alapu csatornat byte alapu helyett, BufferedWriter-be csomagolt FileWriter-rel
    static void example3(int lines) {
        File f = new File("src/fruits3.txt");
        Random random = new Random();

        BufferedWriter bw = null;

        try {
            bw = new BufferedWriter(new FileWriter(f));

            for (int i=1;i<=lines;i++) {
                String fruit = WriteFile.FRUITS[random.nextInt(WriteFile.FRUITS.length)];
                int count = random.nextInt(5) + 1;

                String currentLine = i + ".) " + count + "db " + fruit;

                bw.write(currentLine);
                bw.newLine();

                if (i % 10 == 0) {
                    bw.flush();
                }
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {

            try {
                bw.flush();
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Meglevo file vegehez akarunk hozzafuzni sorokat ebben a peldaban
     */
    static void example4(int newLines, String pathToFile, String leadingSymbol) {

        File f = new File(pathToFile);
        Random random = new Random();

        PrintWriter pw = null;

        try {
            // FONTOS! Ha azt szeretnenk, hogy letezo fajl eseten hozzafuzesre nyissa meg,
            // ne ujonnan hozza letre, akkor a masodik parameterben egy true-t kell atadni!
            // Ha a file esetleg nem letezik, akkor letre is hozza.
            FileWriter fw = new FileWriter(f, true);
            pw = new PrintWriter(fw);

            // FONTOS! A PrintWriter tele van kenyelmi metodussal a file-ba irashoz
            pw.println("----------------------" + new Date() + "----------------------");

            for (int i=1;i<=newLines;i++) {
                String fruit = WriteFile.FRUITS[random.nextInt(WriteFile.FRUITS.length)];
                int count = random.nextInt(5) + 1;

                String currentLine = "";
                if (leadingSymbol == null) {
                    currentLine += count + " " + fruit;
                } else {
                    currentLine += i + "." + leadingSymbol + " " + count + "db " + fruit;
                }

                pw.println(currentLine);

                if (i % 10 == 0) {
                    pw.flush();
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            pw.flush();
            pw.close();
        }
    }

}