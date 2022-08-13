import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) throws Exception {
        Socket ClientSocket = new Socket("192.168.0.110", 6789);
        OutputStream out = ClientSocket.getOutputStream();
        DataOutputStream dataOut = new DataOutputStream(out);

        byte[] bytes = FileUtility.read_by_bytes("test.jpg");
        dataOut.writeInt(bytes.length);
        dataOut.write(bytes);
        ClientSocket.close();
    }
}
