import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws Exception {

    }

    public static void readAsBytes() throws Exception {
        System.out.println("waiting for client");
        ServerSocket FirstServerSocket = new ServerSocket(6789);
        while (true) {
            Socket connection = FirstServerSocket.accept();
            DataInputStream dataStream = new DataInputStream(connection.getInputStream());
            byte[] arr = readMessage(dataStream);
            FileUtility.write_by_bytes("testCopy.jpg", arr);
        }
    }

    public static byte[] readMessage(DataInputStream din) throws Exception {
        int msgLength = din.readInt();
        byte[] msg = new byte[msgLength];
        din.readFully(msg);
        return msg;
    }

    public static void readAsString() throws Exception {
        ServerSocket FirstServerSocket = new ServerSocket(6790);
        while (true) {
            Socket connection = FirstServerSocket.accept();
            InputStream is = connection.getInputStream();
            System.out.println("Waiting for Client");
            InputStreamReader reader = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(reader);
            String messageFromClient = br.readLine();
            System.out.println("Message From Client : " + messageFromClient);
        }
    }
}
