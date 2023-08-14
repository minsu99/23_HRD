package my.day08.MapExample;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapExample {
    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<String, Integer>();

        map.put("Blue", 96);
        map.put("hong", 86);
        map.put("white", 92);

        int totalScore = 0;
        int maxScore = 0;
        String name = null;
        
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        for (Map.Entry<String, Integer> entry : entrySet) {
        	if(entry.getValue() > maxScore) {
        		name = entry.getKey();
        		maxScore = entry.getValue();
        	}
        	totalScore += entry.getValue();
        }


        int avgScore = totalScore / map.size();

        System.out.println("평균 점수: " + avgScore);
        System.out.println("최고 점수: " + maxScore);
        System.out.println("최고 점수를 받은 아이디: " + name);
    }
}
