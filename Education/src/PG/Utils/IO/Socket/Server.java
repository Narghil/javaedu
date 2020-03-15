//*** Példa a többszálú kiszolgálásra:
//*** https://stackoverflow.com/questions/10131377/socket-programming-multiple-client-to-one-server

package PG.Utils.IO.Socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

public class Server<S, G> {
    //S: Send object type; G: Get object type
    private List<Socket> clientSocketList = new LinkedList<>(); //Ebből több is lehet... szerintem.
    private ServerSocket serverSocket;

    private Server() {
    }

    public Server(Integer port) {
        try {
            if (serverSocket == null) {
                serverSocket = new ServerSocket(port);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Ez csak példa. A kapott socket-et új szálba kellene helyezni, így nem csinál semmit vele, csak van.
    public void serverLoop(){
        Socket clientSocket;
        while (true) {
            try {
                clientSocket = serverSocket.accept();
                clientSocketList.add(clientSocket);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public G serverGet(Socket clientSocket) {
        G res = null;

        try {
            InputStream inputStream = clientSocket.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            res = (G) objectInputStream.readObject();
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    //Válasz küldése(server side);
    public void serverSend(S s, Socket clientSocket) {

        if (clientSocket != null) {
            try {
                OutputStream outputStream = clientSocket.getOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
                objectOutputStream.writeObject(s);
                objectOutputStream.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //Több is lehet... az épp aktuálisat zárja le.
    public void clientClose(Socket clientSocket) {
        try {
            if (clientSocket != null) {
                clientSocket.close();
                clientSocketList.remove(clientSocket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void serverClose() {
        try {
            if (serverSocket != null) {
                serverSocket.close();
                serverSocket = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
