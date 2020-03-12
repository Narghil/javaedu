package PG.Utils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class IOUtils<S, G> {
    //<S> as Send, <G> as Get
    private Socket clientSocket;
    private Socket serverClientSocket; //Ebből több is lehet... szerintem.
    private ServerSocket serverServerSocket;

    public IOUtils() {
        serverServerSocket = null;
        serverClientSocket = null;
        clientSocket = null;
    }

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
    public G SerInp(String fname) {
        FileInputStream fsi;
        ObjectInputStream ois = null;
        G res = null;

        try {
            fsi = new FileInputStream(fname);
            ois = new ObjectInputStream(fsi);
            res = (G) ois.readObject();
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

    //*** Server-Client connection via sockets

    //Object küldése socket-re (client side):
    public void clientSend(S s, String host, Integer port) {

        try {
            if(clientSocket == null) clientSocket = new Socket(host, port);
            OutputStream outputStream = clientSocket.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(s);
            objectOutputStream.flush();
        } catch (Exception e) {
            //nothing yet
        }
    }

    //Object fogadása(client side):
    public G clientGet(String host, Integer port) {
        G res = null;

        try {
            if(clientSocket == null) clientSocket = new Socket(host, port);
            //Get
            InputStream inputStream = clientSocket.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            res = (G) objectInputStream.readObject();
        } catch (Exception e) {
            //nothing yet
        }
        return res;
    }

    public void clientClose(){
        try {
            if (clientSocket != null) {
                clientSocket.close();
                clientSocket = null;
            }
        } catch (Exception e) {
            //Nothing yet
        }

    }

    //Object olvasása socket-ről (server side);
    public G serverGet(Integer port) {
        G res = null;

        try {
            if( serverServerSocket == null){ serverServerSocket = new ServerSocket(port);}
            System.out.println("ServerSocket awaiting connections...");
            //Több is lehet... szerintem
            serverClientSocket = serverServerSocket.accept(); // blocking call, this will wait until a connection is attempted on this port.
            System.out.println("Connection from " + serverClientSocket + "!");
            InputStream inputStream = serverClientSocket.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            res = (G) objectInputStream.readObject();
        } catch (Exception e) {
            //Nothing yet
        }
        return res;
    }

    //Válasz küldése(server side);
    public void serverSend(S s, Integer port) {

        if( serverClientSocket != null) {
            try {
                System.out.println("Connection at " + serverClientSocket + "!");
                OutputStream outputStream = serverClientSocket.getOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
                objectOutputStream.writeObject(s);
                objectOutputStream.flush();
            } catch (Exception e) {
                //Nothing yet
            }
        }
    }

    //Több is lehet... melyiket?
    public void serverClientClose(){
        try {
            if (serverClientSocket != null) {
                serverClientSocket.close();
                serverClientSocket = null;
            }
        } catch (Exception e) {
            //Nothing yet
        }
    }

    public void serverClose(){
        try {
            if (serverServerSocket != null) {
                serverServerSocket.close();
                serverServerSocket = null;
            }
        } catch (Exception e) {
            //Nothing yet
        }

    }

}
