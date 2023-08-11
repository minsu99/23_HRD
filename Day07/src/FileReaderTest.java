import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {

	// xxxReader : 2바이트 데이터 처리 입력 객체 read()
	// xxxWriter : 2바이트 데이터 처리 출력 객체 write()

	public static void main(String[] args) throws IOException {


		FileReader fr = new FileReader("C:\\Users\\COMPUTER\\eclipse-workspace\\Day07\\src\\" + "FileOutputTest.java");
		BufferedReader br = new BufferedReader(fr); // 리더를 넘겨줘
		String result = null;

		while ((result = br.readLine()) != null) {
			System.out.println(result);
		}
	}
}
