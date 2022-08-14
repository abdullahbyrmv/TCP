import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws Exception {
        readAsBytes();
    }

    public static void readAsBytes() throws Exception {
        System.out.println("waiting for client");
        ServerSocket FirstServerSocket = new ServerSocket(6789);
        while (true) {
            Socket connection = FirstServerSocket.accept();
            DataInputStream dataStream = new DataInputStream(connection.getInputStream());

//            byte[] arr = readMessage(dataStream);
//            FileUtility.write_by_bytes("testCopy.jpg", arr);

            String res = readRequest(dataStream);
            System.out.println(res);

            OutputStream outStr = connection.getOutputStream();
            DataOutputStream dataOutStr = new DataOutputStream(outStr);

            byte[] bytes = FileUtility.read_by_bytes("C:\\Users\\User\\Desktop\\JAVA PROJECTS\\TCP\\src\\test.jpg");
            writeResponse(dataOutStr, bytes);
//            byte[] arr = readMessage(dataStream);
//            FileUtility.write_by_bytes("testCopy.jpg", arr);
            connection.close();
        }
    }

    private static void writeResponse(OutputStream out, byte[] s) throws Exception {
        String response = "HTTP/1.1 200 OK\r\n"
                + "Server: YarServer/2009-09-09\r\n"
                + "Content-Type: image/jpeg\r\n"
                + "Content-Length: " + s.length + "\r\n"
                + "Connection : close\r\n";
        String result = response + s;
        out.write(result.getBytes());
        out.flush();
    }

    private static String readRequest(InputStream in) throws IOException {
        InputStreamReader isr = new InputStreamReader(in);
        BufferedReader reader = new BufferedReader(isr);
        String msg = "";
        while (true) {
            String s = reader.readLine();
            if (s == null || s.trim().length() == 0) {
                break;
            } else {
                msg = msg + s + "\r\n";
            }
            System.out.println("Server request : " + s);
            System.out.println();
        }
        return msg;
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
