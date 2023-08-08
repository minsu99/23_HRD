

 class Printer {
	public static void println(int a) {
        System.out.println(a);
    }
    
	public static void println(boolean b) {
        System.out.println(b);
    }
	public static void println(double c) {
    	System.out.println(c);
    }
	public static void println(String d) {
    	System.out.println(d);
    }
    
    public static void main(String[] args) {
        Printer p = new Printer();
        p.println(10);   // 글자가 기울어지면 static이다 
        p.println(true);
        p.println(5.7);
        p.println("홍길동");
        
    }
}
