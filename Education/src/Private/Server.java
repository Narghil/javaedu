package Private;
import PG.Utils.IOUtils;

public class Server {
    public static void main(String[] args) {
        IOUtils<StringBuffer, StringBuffer> iou = new IOUtils();
        StringBuffer sb;

        while( true ) {
            sb = iou.serverGet(9090);
            System.out.println("Server getted this:" /*+ sb.toString() */ );
            sb.append(" AND server appended THIS");
            iou.serverSend(sb, 9090);
            iou.serverClientClose();
        }
        //iou.serverClose();
    }
}
