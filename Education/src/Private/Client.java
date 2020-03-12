package Private;
import PG.Utils.IOUtils;

public class Client {
    public static void main(String[] args) {
        IOUtils<StringBuffer, StringBuffer> iou = new IOUtils<>();
        StringBuffer sb, sbRet;
        String host = "192.168.1.6";

        //while( true ) {
            sb = new StringBuffer("Client send to server this StringBuilder object" );
            iou.clientSend(sb, host, 9090);
            System.out.println("Client send:" + sb.toString());
            sbRet = iou.clientGet(host, 9090);
            System.out.println("Server response:" + sbRet.toString());
            //
            //sbRet = iou.clientGet("localhost", 9090);
            //System.out.println("Server second response:" + sbRet.toString());
            try {
                Thread.sleep(2000);
            } catch( Exception e){
                e.printStackTrace();
            }
            iou.clientClose();
        //}
    }

}

