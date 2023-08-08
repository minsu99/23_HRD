
public class Cafe {

	public static void main(String[] args) {

		CoffeeMachine cf = new CoffeeMachine(2,2,2); // 인자생성자가 추가되면 기본 생성자 우선순위에서 밀려 무시
		cf.makeCoffee(2, 2);
		System.out.println(cf.getSuger());
		cf.setSuger(1);
		System.out.println(cf.getSuger());

	}

}

class CoffeeMachine {
	// 은닉화 
	private int coffee;
	private int suger;
	private int cream;

	// 인자생성자를 만들때 기본 생성자도 같이 만들어줘라
	public CoffeeMachine() {
	}

	// 인자생성자 ---> 자동완성도 가능하다
	public CoffeeMachine(int coffee, int suger, int cream) {
		// super();
		this.coffee = coffee;
		this.suger = suger;
		this.cream = cream;
	}

	// getter
	public int getCoffee() {
		return coffee;
	}

	public int getSuger() {
		return suger;
		
	}

	public int getCream() {
		return cream;
	}

	// setter
	public void setCoffee(int coffee) {
		this.coffee = coffee;
	}

	public void setSuger(int suger) {
		this.suger = suger;
	}

	public void setCream(int cream) {
		this.cream = cream;
	}

	// 오버로딩을  사용하자 그냥 만들생각 말고
	public void makeCoffee(int coffee, int sugar) {
		System.out.println("커피: " + coffee + " , " + "설탕: " + sugar + " 커피를 만듭니다");
	}

	public void makeCoffee(int coffee) {
		System.out.println("커피: " + coffee + " 커피를 만듭니다");
	}

	public void makeCoffee(int coffee, int sugar, int cream) {
		System.out.println("커피: " + coffee + " , " + "크림: " + cream + " , " + "설탕: " + sugar + " 커피를 만듭니다");
	}

}
