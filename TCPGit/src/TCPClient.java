import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) throws Exception{
        Socket ClientSocket = new Socket("192.168.31.98",6790);
        OutputStream out = ClientSocket.getOutputStream();
        DataOutputStream dataOut = new DataOutputStream(out);
        out.write("Hello Server".getBytes());
        ClientSocket.close();
    }
}
