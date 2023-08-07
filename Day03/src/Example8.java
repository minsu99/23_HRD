
public class Example8 {

	public static void main(String[] args) {
		
//		int array[][] = { 
//				{ 95, 86 }, 
//				{ 83, 92, 96 }, 
//				{ 78, 83, 93, 87, 88 } 
//		};

		int array1[][] = new int [3][];
		array1[0] = new int[2];
		array1[1] = new int[3];
		array1[2] = new int[5];
		
		array1[0][0] = 95;
		array1[0][1] = 86;
		array1[1][0] = 83;
		array1[1][1] = 92;
		array1[1][2] = 96;
		array1[2][0] = 78;
		array1[2][1] = 83;
		array1[2][2] = 93;
		array1[2][3] = 87;
		array1[2][4] = 88;
		
		
		int sum = 0;
	    
		for (int i = 0; i < array1.length; i++) {
			for (int j = 0; j < array1[i].length; j++) {
				sum += array1[i][j];
				
			}
		}
		
		int count = 0;  //배열의 크기?  
		
		// i와 j를 반복문에서 배열의 크기만큼 a에 저장 
		for (int i=0; i<array1.length; i++) {
			for(int j =0; j<array1[i].length; j++) {
				count++;
				
			}
		}
		double avg = (double) sum / count;
		System.out.println("SUM: " + sum);
		System.out.println("AVG: " + avg);
		
		
		
	}
	

}
