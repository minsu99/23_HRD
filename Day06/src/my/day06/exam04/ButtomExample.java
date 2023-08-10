package my.day06.exam04;

public class ButtomExample {

	public static void main(String[] args) {
		Button btnOK = new Button();
		
		class OKListener implements Button.ClickListenter{

			@Override
			public void onClick() {
				System.out.println("OK 버튼이 눌렸습니다. ");
				
			}
			
		}
		
		btnOK.setClickListenter(new OKListener());
		
		btnOK.click();
		
		Button btncancel = new Button();
		
		class CencleListenter implements Button.ClickListenter{

			@Override
			public void onClick() {
				System.out.println("CANCLE 버튼이 눌렸습니다. ");
				
			}
			
		}
		btncancel.setClickListenter(new CencleListenter());
		
		btncancel.click();

	}

}
