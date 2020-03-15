package PG.Utils.IO.Socket;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client<S,G> {
    //S: Send object type; G: Get object type
    private Socket clientSocket;
    public Socket getClientSocket() {
        return clientSocket;
    }

    //Object küldése socket-re (client side):
    public void clientSend(S s, String host, Integer port) {

        try {
            if (clientSocket == null) clientSocket = new Socket(host, port);
            OutputStream outputStream = clientSocket.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(s);
            objectOutputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Object fogadása(client side):
    public G clientGet(String host, Integer port) {
        G res = null;

        try {
            if (clientSocket == null) clientSocket = new Socket(host, port);
            //Get
            InputStream inputStream = clientSocket.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            res = (G) objectInputStream.readObject();
            //}
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    public void clientClose() {
        try {
            if (clientSocket != null) {
                clientSocket.close();
                clientSocket = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
