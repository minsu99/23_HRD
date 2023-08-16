package my.json;

import java.io.FileWriter;
import java.io.Writer;
import java.nio.charset.Charset;

import org.json.JSONArray;
import org.json.JSONObject;

public class CreateJsonExample {

    public static void main(String[] args) {

        // JSON타입의 객체 
        JSONObject root = new JSONObject();

        // 속성 추가
        root.put("id", "winter");
        root.put("name", "한겨울");
        root.put("age", 25);
        root.put("student", true);

        // 객체속성 추가
        JSONObject tel = new JSONObject();
        tel.put("home", "042-111-2222");
        tel.put("mobile", "010-123-4561");

        root.put("tel", tel);

        // 배열 속성 추가
        JSONArray skill = new JSONArray();
        skill.put("JAVA");
        skill.put("c++");
        skill.put("python");

        root.put("skill", skill);

        // JSON 객체 얻기 
        String json = root.toString();

        // 콘솔로 출력하기 
        System.out.println(json);

        // 파일로 저장하기 
        try {
            Writer writer = new FileWriter("member.json", Charset.forName("UTF-8"));
            writer.write(json); // JSON 데이터를 파일에 쓰기
            writer.flush();
            writer.close(); // 파일 쓰기 종료
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
