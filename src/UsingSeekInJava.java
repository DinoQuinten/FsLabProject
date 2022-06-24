import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;

public class UsingSeekInJava {
    static final RandomAccessFile r;
    static HashMap hashMap=new HashMap();
    static int PointerRoom=0;

    static {
        try {
            r = new RandomAccessFile("randText.txt","rw");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        String entryOne="1hk19is015|Prasanna Anthony|ISE|6A";
        String entryTwo="1hk19is016| Anthony|ISE4|6A";
        String entry3="1hk19is017| Any|ISE4|65";
        int roomNo=101;
        writeData(entryOne,roomNo,0);
        readData(0,100);
        writeData(entryTwo,102,36);
        readData(36,100);
        writeData(entry3,101,29);
//        readData(29,100);
    }
    static void readData(int pos,int size) throws IOException {
        RandomAccessFile r = new RandomAccessFile("randText.txt","rw");
        r.seek(pos);
        byte[]bytes=new byte[size];
        printLine(r.readLine());
        r.close();
    }

    static int writeData(String data,int roomNo,int pos) throws IOException {
        RandomAccessFile r = new RandomAccessFile("randText.txt","rw");
        data=data+"\n";
        int sized=data.length();
        createHashTable(roomNo);
        r.seek(pos);
        r.writeBytes(data);
        r.close();
        System.out.println(sized);
        return sized;
    }
    static void modifyEntry(int roomNo){

    }
    static void printLine(String s){
        System.out.println(s);
    }
    static void createHashTable(int roomNo){
        hashMap.put(roomNo,PointerRoom);
    }
}