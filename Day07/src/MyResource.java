import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MyResource {

    private String name;

    public MyResource(String name) {
        this.name = name;
        System.out.println("[MyResource(" + name + ") 열기]");
    }

    public String read1() {
        System.out.println("[MyResource(" + name + ") 읽기]");
        return "100";
    }

    public String read2() {
        System.out.println("[MyResource(" + name + ") 읽기]");
        return "abc";
    }

    public void close() {
        System.out.println("[MyResource(" + name + ") 닫기]");
    }

    public static void main(String[] args) throws IOException {
       
    	File file = new File("test.txt");
        FileInputStream fis = null;

        try {
            fis = new FileInputStream(file);
            
            int n;
            while ((n = fis.read()) != -1) {
                System.out.print((char) n);
            }
        } catch (IOException io) {
            io.printStackTrace();
        } finally {			
            if (fis != null) {
                fis.close(); 
            }
        }

        MyResource myResource = new MyResource("test");
//        System.out.println(myResource.read1());
//        System.out.println(myResource.read2());
//        myResource.close();
    }
}
