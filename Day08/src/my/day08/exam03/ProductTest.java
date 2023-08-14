package my.day08.exam03;

class TV{
	
}
class Car{
	
}


class product <K , M>{
	private K kind;
	private M model;
	
	// getter 반환타입 있다.
	public K getKind() {
		return this.kind;
	}
	
	public M getModel() {
		return this.model;
	}
	// setter 
	public void setKind(K kind) {
		this.kind = kind;
	}
	public void setModel(M model) {
		this.model = model;
	}
}




public class ProductTest {

	public static void main(String[] args) {
		product<TV, String> p1 = new product<>();
		
		p1.setKind(new TV());
		p1.setModel("샘숭울트라 24K 8DTV");
		System.out.println("제품정보: "  + p1.getModel());
		

	}

}
