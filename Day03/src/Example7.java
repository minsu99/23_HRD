
public class Example7 {

	public static void main(String[] args) {
		
		
		int array[] = {1, 5, 3, 8, 2}; // 배열의 최대값을 구하는 코드 
		int max = -1;
		int min = 100;
		
		for(int i =0; i<array.length; i++) {
			if(max < array[i]) {
				max = Math.max(max, array[i]);  
				min = Math.min(min, array[i]);  
				
			}
			
		}
		System.out.println("최대값: " + max);
		System.out.println("최소값: " + min);
	}
	

}
