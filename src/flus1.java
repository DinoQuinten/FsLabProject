import java.io.IOException;
import java.util.Scanner;

public class flus1 {
    public static void main(String[] args) throws IOException {
//        FileWriter fileWriter1=new FileWriter("temp.txt");
//fileWriter1.flush();
        String s = "1001#1hk19is015#Prasanna Anthony#ISE#6A";
        Scanner modScanner = new Scanner(s).useDelimiter("#");
        String roomNo1 = modScanner.next();
        String usn1 = modScanner.next();
        String Name = modScanner.next();
        String branch1 = modScanner.next();
        String semsec = modScanner.next();
        System.out.println(roomNo1);
        System.out.println(usn1);
        System.out.println(Name);
        System.out.println(branch1);
        System.out.println(semsec);
    }
}
