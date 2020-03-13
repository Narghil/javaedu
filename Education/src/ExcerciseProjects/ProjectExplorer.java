package ExcerciseProjects;

import java.io.File;
import java.io.IOException;

import static PG.Utils.IOUtils.sop;
import static PG.Utils.IOUtils.sopl;
import static PG.Utils.StringUtils.replicate;

public class ProjectExplorer {
    public static void main(String[] args) {
        String param;
        if( args.length ==0){ param = "."; } else {param = args[0];}
        printDir(0, new File( param) );
    }

    public static void printDir( int depth, File parFile ){
        String[] fileNames;

        if( ! parFile.exists() ){
            sopl(  parFile.getName() + " nem található!");
        } else {
            sop( replicate(""+(char)(9),depth) + parFile.getName() );
            if (parFile.isDirectory()) {
                sopl(" <DIRECTORY>");
                fileNames = parFile.list();
                if( fileNames == null){
                    sopl( replicate( ""+(char)(9),depth)+" - nem olvasható");
                } else {
                    for (String fName : fileNames) {
                        printDir(depth + 1, new File(parFile.getPath() + File.separator + fName)) ;
                    }
                }
            } else {
                if( ! parFile.isFile() ){
                    sop( " - nem olvasható");
                }
                sopl("");
            }
        }
    }
}
