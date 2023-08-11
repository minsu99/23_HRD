import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileWriteTest {
    public static void main(String[] args) throws IOException {
    	FileWriter fw = new FileWriter("test2.txt");
        BufferedWriter bw = new BufferedWriter(fw);

        String str = null;
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader key = new BufferedReader(isr);

        while (!(str = key.readLine()).equals("x")) {
            bw.write(str); // 입력 받은 내용을 파일에 쓰기
            bw.newLine(); // 다음 줄로 이동
            bw.flush(); // 버퍼 비우기
        }

        bw.close();
        isr.close();

        System.out.println("파일 저장 끝");
        FileReader fr = new FileReader("test2.txt");
        BufferedReader br = new BufferedReader(fr); // 리더를 넘겨줘
        String result = null;

        while ((result = br.readLine()) != null) {
            System.out.println(result);
        }

        br.close();
        fr.close();
    
    }
    
}
