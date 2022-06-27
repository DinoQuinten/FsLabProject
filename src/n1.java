import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class n1 {
    public static void main(String[] args) throws IOException {
//        FileWriter fileWriter = new FileWriter("a.txt");
//        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//        int SrNo=1;
//        for (int i = 1; i <= 4; i++) {
//            int k = i * 100;
//            for (int j = 1; j <= 15; j++) {
//
//                bufferedWriter.append(SrNo+"\t"+(k + j) + "\t\t name"+(j+k)+"\n");
////                System.out.println(k+j);
//                SrNo++;
//            }
//        }
//        bufferedWriter.close();


        BufferedReader bufferedReader = new BufferedReader(new FileReader("updatingData.txt"));
        Scanner scanner = new Scanner(bufferedReader.readLine());
//        scanner.useDelimiter("\n");
//        String newLinew = "";
//        while ((newLinew = bufferedReader.readLine()) != null) {
////            System.out.println(newLinew);
//        }
////       System.out.println( saperateElememtsName(scanner.nextLine()));
//        String[] coulmnName;
//        for (int i = 0; ; i++) {
//
//        }
//    }

//    private static String saperateElememtsName(String s) {
//        Scanner scanner = new Scanner(s);
//        scanner.useDelimiter("\\Q|\\E");
//        String s1 = "";
//        while (scanner.hasNext()) {
//            s1 = scanner.next();
////            System.out.println(s1);
//        }
//        return s1;
        String entryOne="1hk19is015|Prasanna Anthony|ISE|6A";
        String entryTwo="1hk19is016| Anthony|ISE4|6A";
//        writeData(entryOne,0);
//        writeData(entryTwo,0);
        System.out.println(entryOne.hashCode());


    }
//    static void writeData(String data,int pos) throws IOException {
//        RandomAccessFile r = new RandomAccessFile("randText.txt","rw");
//        int sized=data.length();
////        createHashTable(roomNo);
//        r.seek(pos);
//        r.writeBytes(data);
//        r.close();
//        PointerRoom=sized+1;
//        return sized;

}
