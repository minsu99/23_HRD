import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputTest {

    public static void main(String[] args) throws IOException {
        File f = new File("test2.txt");
        FileOutputStream fos = new FileOutputStream(f);
        String data = "10"; 

        fos.write(data.getBytes());
        fos.close();

        FileInputStream fis = null;
        try {
            fis = new FileInputStream(f);

            int n;
            while ((n = fis.read()) != -1) {
                System.out.print((char)n); // 읽은 데이터를 문자로 변환하여 출력
            }
        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            fis.close();
        }
    }

}
