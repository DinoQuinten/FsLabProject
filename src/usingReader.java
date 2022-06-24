import java.io.*;
import java.util.Scanner;

public class usingReader {
    public static void main(String[] args) throws IOException {
        String filePath="gendwndata.txt";
String usn="1hk19is015";
String name="Anthony";
String branch="ISE";
String SemSec="6A";
String NewSemSec="6B";
        readData();
    }
    static void readData() throws IOException {
        FileReader fileReader=new FileReader("gendwndata.txt");
        BufferedReader bufferedReader=new BufferedReader(fileReader);
        System.out.println(bufferedReader.readLine());
    }
    static void writeData() throws IOException {

    }
    static void modifyEntry(String editTrem,String NewUsn,String newName,String newSemSec) throws IOException {
    String trmpfile="temp.txt";
        File oldFile=new File("gendwndata.txt");
        File newFile=new File("temp.txt");
        String USN="",name="",branch="",semSec="";
        FileWriter fw=new FileWriter(trmpfile,true);
        BufferedWriter bufferedWriter=new BufferedWriter(fw);
        PrintWriter printWriter=new PrintWriter(bufferedWriter);
        Scanner scanner=new Scanner(new File("gendwndata.txt"));
        scanner.useDelimiter("\\\\Q|\\\\E");
        while(scanner.hasNext()){
            USN=scanner.next();
            name=scanner.next();
            semSec=scanner.next();
            if(USN.equals(editTrem)){
                printWriter.println(NewUsn+"|"+newName+"|"+newSemSec);
            }
            else
                printWriter.println(USN+"|"+name+"|"+semSec);
        }
        scanner.close();
        printWriter.flush();
        oldFile.delete();
        File dump= new File("gendwndata.txt");
        newFile.renameTo(dump);
    }
    static void printLine(String s){
        System.out.println(s);
    }
    static void createHashTable(int roomNo){
    }
}
