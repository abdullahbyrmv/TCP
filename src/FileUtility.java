import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtility {
    public static byte[] read_by_bytes(String filename) throws Exception {
        File file = new File(filename);
        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] bytes = new byte[(int) file.length()];
            fis.read(bytes);
            return bytes;
        }
    }

    public static void write_by_bytes(String filename, byte[] data) throws IOException {
        File file = new File(filename);
        FileOutputStream fop = new FileOutputStream(file);

        fop.write(data);
        fop.flush();
        fop.close();
    }
}
