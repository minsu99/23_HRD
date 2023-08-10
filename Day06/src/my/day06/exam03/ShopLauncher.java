package my.day06.exam03;

public class ShopLauncher {
	public static void main(String[] args) {
		IShop iShop = new MyShop();
		iShop.SetTitle("My Shop");
		iShop.genUser();
		iShop.genProduct();
		iShop.start();
		
	
	}
}
	