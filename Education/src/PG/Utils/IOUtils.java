package PG.Utils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
//*** import java.util.LinkedList;
//*** import java.util.List;
import java.lang.Class;

public class IOUtils<S, G> {
    //<S> as Send, <G> as Get
    private Socket clientSocket;
    private Socket serverClientSocket; //Ebből több is lehet... szerintem.
    private ServerSocket serverServerSocket;

    //***private List<Socket> serverClientSocketes = new LinkedList<Socket>();

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
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //Deszerializálás:
    public G SerInp(String fname) {
        FileInputStream fsi;
        ObjectInputStream ois = null;
        G res = null;
        Object o;

        try {
            fsi = new FileInputStream(fname);
            ois = new ObjectInputStream(fsi);
            o = ois.readObject();
            //if (o instanceof G) {
                res = (G) o;
            //}
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return res;
    }

    //*** Server-Client connection via sockets *****************************************************************

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
        Object o;

        try {
            if (clientSocket == null) clientSocket = new Socket(host, port);
            //Get
            InputStream inputStream = clientSocket.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            o = objectInputStream.readObject();
            //if (G.class.isAssignableFrom( G ) ) {
                res = (G) o;
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

    //Object olvasása socket-ről (server side);
    public G serverGet(Integer port) {
        G res = null;
        Object o;

        try {
            if (serverServerSocket == null) {
                serverServerSocket = new ServerSocket(port);
            }
            System.out.println("ServerSocket awaiting connections...");
            //Több is lehet... szerintem
            serverClientSocket = serverServerSocket.accept(); // blocking call, this will wait until a connection is attempted on this port.
            //*** serverClientSocketes.add(serverClientSocket);
            System.out.println("Connection from " + serverClientSocket + "!");
            InputStream inputStream = serverClientSocket.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            o = objectInputStream.readObject();
            //if (o instanceof G) {
                res = (G) o;
            //}
            //*** System.out.println("CLIENTS:");
            //*** System.out.println(serverClientSocketes.toString());
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    //Válasz küldése(server side);
    public void serverSend(S s, Integer port) {

        if (serverClientSocket != null) {
            try {
                System.out.println("Connection at " + serverClientSocket + "!");
                OutputStream outputStream = serverClientSocket.getOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
                objectOutputStream.writeObject(s);
                objectOutputStream.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //Több is lehet... az épp aktuálisat zárja le.
    public void serverClientClose() {
        try {
            if (serverClientSocket != null) {
                //*** serverClientSocketes.remove(serverClientSocket);
                serverClientSocket.close();
                serverClientSocket = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void serverClose() {
        try {
            if (serverServerSocket != null) {
                serverServerSocket.close();
                serverServerSocket = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
