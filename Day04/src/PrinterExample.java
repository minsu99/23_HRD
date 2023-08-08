class Printer {
	void println(int a) {
        System.out.println(a);
    }
    
    void println(boolean b) {
        System.out.println(b);
    }
    void println(double c) {
    	System.out.println(c);
    }
    void println(String d) {
    	System.out.println(d);
    }
    
public class PrinterExample {

	public static void main(String[] args) {
		Printer p = new Printer();
		p.println(10);
		p.println(true);
		p.println(5.7);
		p.println("홍길동");

	}
}}
