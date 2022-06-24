import java.io.*;
import java.util.Scanner;

public class updatingData {
    public static void main(String[] args) {
        try {
            FileReader fileReader=new FileReader("gendwndata.txt");
            BufferedReader bufferedReader=new BufferedReader(fileReader);
            String dataFromFile = null;
            String dataFromFile2="";
            while ((dataFromFile=bufferedReader.readLine())!=null){
//                System.out.println(dataFromFile);
                dataFromFile2 += dataFromFile;
                dataFromFile2 += "\n";
            }
//            System.out.println(dataFromFile2);

            FileWriter fileWriter=new FileWriter("updatingData.txt");
            BufferedWriter  bufferedWriter= new BufferedWriter(fileWriter);
            Scanner scanner= new Scanner(bufferedReader);
            scanner.useDelimiter("\n");
            System.out.println( scanner.useDelimiter("\n").getClass()+"##########");
            System.out.println(dataFromFile2.replace("\t","|"));
            bufferedWriter.append(dataFromFile2.replace("\t","|"));
            bufferedWriter.close();
            bufferedReader.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
