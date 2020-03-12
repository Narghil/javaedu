package Private;
import PG.Utils.IOUtils;

public class Client {
    public static void main(String[] args) {
        IOUtils<StringBuffer, StringBuffer> iou = new IOUtils();
        StringBuffer sb, sbRet;

        while( true ) {
            sb = new StringBuffer("Client send to server this StringBuilder object" + args[0]);
            iou.clientSend(sb, "localhost", 9090);
            sbRet = iou.clientGet("localhost", 9090);
            System.out.println("Client send:" + sb.toString());
            System.out.println("Server response:" + sbRet.toString());
            try {
                Thread.sleep(2000);
            } catch( Exception e){
                e.printStackTrace();
            }
            iou.clientClose();
        }
    }

}

