package ExcerciseProjects;

import java.io.File;
import java.util.Arrays;

import static PG.Utils.IOUtils.sopl;
import static PG.Utils.StringUtils.replicate;

public class ProjectExplorer {
    public static void main(String[] args) {
        sopl("START HERE:" + "C:/javaedu");
        printDir(0,new File("C:/javaedu") );
    }

    public static void printDir( int depth, File parFile ){
        String[] fileNames;

        fileNames = parFile.list();
        if( fileNames == null){
            return;
        } else {
            for (String fName: fileNames ) {
                File f = new File( parFile.getAbsolutePath(), fName );
                String s = replicate(""+(char)(9),depth) + f.getName();
                if( f.isDirectory() ){
                    sopl( s + " <DIR>");
                    printDir( depth+1, f);
                } else {
                    sopl( s );
                }
            }
        }

        //sopl(Arrays.toString(parFile.list() ));
    }
}
