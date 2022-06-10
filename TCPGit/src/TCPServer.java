import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws Exception {
        ServerSocket FirstServerSocket = new ServerSocket(6790);
        while(true){
            Socket connection = FirstServerSocket.accept();
            InputStream is = connection.getInputStream();
            InputStreamReader reader = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(reader);
            String messageFromClient = br.readLine();
            System.out.println("Message From Client : " + messageFromClient);
        }
    }
}
