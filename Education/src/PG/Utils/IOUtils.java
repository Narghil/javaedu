package PG.Utils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class IOUtils<S> {
    //Szerializálás:
    public void SerOut(S s, String fname) {
        FileOutputStream fso;
        ObjectOutputStream oos = null;

        try {
            fso = new FileOutputStream(fname);
            oos = new ObjectOutputStream(fso);
            oos.writeObject(s);
            oos.close();
        } catch (Exception exp) {
            //nothing yet
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (Exception e) {
                //nothing yet
            }
        }
    }

    //Deszerializálás:
    public S SerInp(String fname) {
        FileInputStream fsi;
        ObjectInputStream ois = null;
        S res = null;

        try {
            fsi = new FileInputStream(fname);
            ois = new ObjectInputStream(fsi);
            res = (S) ois.readObject();
        } catch (Exception exp) {
            //nothing yet
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (Exception e) {
                //nothing yet
            }
        }
        return res;
    }

    //Object küldése socket-re (client side):
    public void clientSend(S s, String host, Integer port) {
        Socket socket = null;

        try {
            socket = new Socket(host, port);
            OutputStream outputStream = socket.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(s);
        } catch (Exception e) {
            //nothing yet
        } finally {
            try {
                if (socket != null) {
                    socket.close();
                }
            } catch (Exception e) {
                //Nothing yet
            }
        }
    }

    //Object olvasása socket-ről (server side);
    public S serverGet( Integer port){
        S res = null;
        ServerSocket serverSocket = null;
        Socket clientSocket = null;

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("ServerSocket awaiting connections...");
            clientSocket = serverSocket.accept(); // blocking call, this will wait until a connection is attempted on this port.
            System.out.println("Connection from " + clientSocket + "!");
            InputStream inputStream = clientSocket.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            res = (S)objectInputStream.readObject();
        } catch( Exception e){
            //Nothing yet
        }
        return res;
    }

}
