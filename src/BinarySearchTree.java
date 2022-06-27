import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Locale;
import java.util.Scanner;

// Java program to demonstrate
// insert operation in binary
// search tree
class BinarySearchTree {
    static BinaryTree tree = new BinaryTree();
    static int lineNumber = 1;

    public static void main(String[] args) throws IOException {
//        String filePath="prem1.txt";
        String usn = "1hk19is015";
        String name = "Anthony";
        String branch = "ISE";
        String SemSec = "6A";
//        readData();
        usingReader.stdentDetails stdentDetails = new usingReader.stdentDetails(usn, name, branch, SemSec);
//        mapRoomN0toLineNo();

//base code for entry
        tree.addNode("100a", 0);
        tree.addNode("100b", 1);
//        tree.addNode("101a", 2);
//        tree.addNode(1012, 3);
//        tree.addNode(1021,4);
//        tree.addNode(1022,5);
//        tree.inOrderTraverseTree(tree.root);


        //returning 1 in the beggning
//        System.out.println(tree.findNode(1002));
        String entryOne = "1001#\t1hk19is015#\tPrasanna Anthony#\tISE#\t6A";
        String entryTwo = "1002#\t1hk19is016#\tAnthony#\tISE4#\t6A";
        String entry3 = "";
        String entry4 = "1012#1hk19is013# modify#ISE4#65";
        Scanner S = new Scanner(System.in);
        String choice;
        FileWriter fileWriter = new FileWriter("randText.txt");
        FileWriter fileWriter1 = new FileWriter("temp.txt");
        fileWriter.flush();
        fileWriter1.flush();

        writeData(entryOne, "randText.txt");
        writeData(entryTwo, "randText.txt");
//        writeData(entry3, "randText.txt");
        while (true) {
            printLine("#\t--\t--\t--\t--\t--\t--\t--\t#");
            printLine("#\t***ENTER THE CHOICE***\t\t#\n#\t(A)dd record\t\t\t\t#" +
                    "\n#\t(P)rint database\t\t\t#\n" +
                    "#\t(S)earch record by room no\t#\n" +
                    "#\t(M)odify record\t\t\t\t#\n#\t(D)elete record\t\t\t\t#");
            printLine("#\t--\t--\t--\t--\t--\t--\t--\t#");

            choice = S.next();
            switch (choice.toLowerCase(Locale.ROOT).charAt(0)) {
                case 's' -> {
                    printLine("#\t--\t--\t--\tSearch Record\t--\t--\t--\t#");
                    printLine("enter the Room no to search file");
                    String i = S.next();
                    searchRecord(i);
                    break;
                }
                case 'm' -> {
                    printLine("#\t--\t--\t--\tModify Record\t--\t--\t--\t#");
                    UsingSeekInJava.printLine("enter record to be modified");
                    String i = S.next();
                    printLine(searchRecord((i)));
                    String useDElimiterOn = searchRecord(i);
                    {
                        String updatedEntrty = "";


                        try {
                            Scanner modScanner = new Scanner(useDElimiterOn).useDelimiter("#");
                            String roomNo1 = modScanner.next();
                            String usn1 = modScanner.next();
                            String Name = modScanner.next();
                            String branch1 = modScanner.next();
                            String semsec = modScanner.next();

                            printLine("enter the field u want to update" +
                                    "\n(U)sn\n(N)ame\n(B)ranch\t(S)emsec");
                            String co = S.next();
                            switch (co.toLowerCase(Locale.ROOT).charAt(0)) {
                                case 'u' -> {
                                    printLine("enter the modified usn");
                                    usn1 = S.next();
                                    updatedEntrty = roomNo1 + "#\t" + usn1 + "#\t" + Name + "#\t" + branch1 + "#\t" + semsec;
                                    break;
                                }
                                case 'n' -> {
                                    printLine("enter the modified name");
                                    Name = S.next();
                                    updatedEntrty = roomNo1 + "#\t" + usn1 + "#\t" + Name + "#\t" + branch1 + "#\t" + semsec;
                                    printLine("updated Entry is\n" + updatedEntrty);
                                    break;
                                }
                                case 'b' -> {
                                    printLine("enter the modified branch");
                                    branch1 = S.next();
                                    updatedEntrty = roomNo1 + "#\t" + usn1 + "#\t" + Name + "#\t" + branch1 + "#\t" + semsec;
                                    break;
                                }
                                case 's' -> {
                                    printLine("enter the new name");
                                    semsec = S.next();
                                    updatedEntrty = roomNo1 + "#\t" + usn1 + "#\t" + Name + "#\t" + branch1 + "#\t" + semsec;
                                    break;
                                }
                                default -> {
                                    printLine("worng choice");
                                    break;
                                }

                            }
                            modifyEntry(i, updatedEntrty + "\n");
                        } catch (Exception e) {
                            printLine("");
                        }
                    }
                }
                case 'a' -> {
                    printLine("#\t--\t--\t--\tadd new record\t--\t--\t--\t#");
                    printLine("Enter Room N");
                    String roomNo1 = S.next();

                    printLine("enter the usn no");
                    String usn1 = S.next();
                    printLine("enter the Name");
                    String Name1 = S.next();
                    printLine("enter the Branch");
                    String branch1 = S.next();
                    printLine("enter the SemSec");
                    String semSec1 = S.next();
                    String dataToBeEntered = roomNo1 + "#\t" + usn1 + "\t#" + Name1 + "\t#" + branch1 + "\t#" + semSec1;
                    writeData(dataToBeEntered, "randText.txt");
                    lineNumber++;
                    tree.addNode(roomNo1, lineNumber);
                }
                case 'p' -> {
                    readData();
                }
                default -> printLine("Unexpected value: " + choice.toLowerCase(Locale.ROOT).charAt(0));
            }
        }
    }

    static void readData() throws IOException {
        FileReader fileReader = new FileReader("randText.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        for (int i = 0; i <= lineNumber; i++) {

            System.out.println(bufferedReader.readLine());
        }
    }

    static void writeData(String dataStream, String fileName) throws IOException {
        FileWriter fileWriter = new FileWriter(fileName, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.append(dataStream + "\n");
        Scanner scanner = new Scanner(dataStream).useDelimiter("\\Q#\\E");
//        printLine(scanner.next());
        bufferedWriter.close();
    }

    static void modifyEntry(String roomNo, String recordToBeEdited) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader("randText.txt"));
        String preFixData = "";
//        System.out.println(tree.findNode(roomNo));
        for (int i = 0; i <= lineNumber; i++) {
            if (tree.findNode(roomNo) == i) {
                preFixData += recordToBeEdited;
                printLine(preFixData);
                String drop = bufferedReader.readLine();
            } else {
                printLine(preFixData);
                preFixData += bufferedReader.readLine() + "\n";
            }
        }
        bufferedReader.close();
//        System.out.println(preFixData);
        writeData(preFixData, "temp.txt");
        copyFile();
        FileWriter fileWriter1 = new FileWriter("temp.txt");
        fileWriter1.flush();


    }

    static String searchRecord(String roomNo) throws IOException {
        if (tree.findNode(roomNo) == -1) {

//            printLine ("Room Does not Exists");
            return ("Room Does not Exists");
        } else {
            FileReader fileReader = new FileReader("randText.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            for (int i = 0; i < tree.findNode(roomNo); i++) {
                bufferedReader.readLine();
            }
            String returnedRecord = bufferedReader.readLine();
            bufferedReader.close();
            printLine(returnedRecord);
//            if(compD.compareTo(null)==0){
//                return ("room not acc");
//            }else
            printLine("line no is" + tree.findNode(roomNo) + "");
            return returnedRecord;
        }

    }

    static void printLine(String s12) {
        System.out.println(s12);
    }

    public static void copyFile() throws IOException {
        Files.copy(Path.of("temp.txt"), Path.of("randText.txt"), StandardCopyOption.REPLACE_EXISTING);
    }

    static void mapRoomN0toLineNo() {
        int no = 0;
        String s = "";
        for (int i = 1; i <= 4 && no <= 400; i++) {
            for (int j = 1; j < 10; j++) {
                no = i * 100;
                no = no + j;
                s = no + "A";
                lineNumber++;
                tree.addNode(s, lineNumber);

                s = no + "B";
                lineNumber++;
                tree.addNode(s, lineNumber);
            }
        }
    }

    public static class stdentDetails {

        String Usn, Name, Branch, SemSec;

        public stdentDetails(String usn, String name, String branch, String semsec) {
            Usn = usn;
            Name = name;
            Branch = branch;
            SemSec = semsec;
        }

    }

    public static class BinaryTree {

        BinaryTree.Node root;

        public void addNode(String key, int name) {

            // Create a new Node and initialize it

            BinaryTree.Node newNode = new BinaryTree.Node(key, name);

            // If there is no root this becomes root

            if (root == null) {

                root = newNode;

            } else {

                // Set root as the Node we will start
                // with as we traverse the tree

                BinaryTree.Node focusNode = root;

                // Future parent for our new Node

                BinaryTree.Node parent;

                while (true) {

                    // root is the top parent so we start
                    // there

                    parent = focusNode;

                    // Check if the new node should go on
                    // the left side of the parent node

                    if (key.compareTo(focusNode.key) > 0) {

                        // Switch focus to the left child

                        focusNode = focusNode.leftChild;

                        // If the left child has no children

                        if (focusNode == null) {

                            // then place the new node on the left of it

                            parent.leftChild = newNode;
                            return; // All Done

                        }

                    } else { // If we get here put the node on the right

                        focusNode = focusNode.rightChild;

                        // If the right child has no children

                        if (focusNode == null) {

                            // then place the new node on the right of it

                            parent.rightChild = newNode;
                            return; // All Done

                        }

                    }

                }
            }

        }

        // All nodes are visited in ascending order
        // Recursion is used to go to one node and
        // then go to its child nodes and so forth

        public void inOrderTraverseTree(BinaryTree.Node focusNode) {

            if (focusNode != null) {

                // Traverse the left node

                inOrderTraverseTree(focusNode.leftChild);

                // Visit the currently focused on node

                System.out.println(focusNode);

                // Traverse the right node

                inOrderTraverseTree(focusNode.rightChild);

            }

        }

        public void preorderTraverseTree(BinaryTree.Node focusNode) {

            if (focusNode != null) {

                System.out.println(focusNode);

                preorderTraverseTree(focusNode.leftChild);
                preorderTraverseTree(focusNode.rightChild);

            }

        }

        public void postOrderTraverseTree(usingReader.BinaryTree.Node focusNode) {

            if (focusNode != null) {

                postOrderTraverseTree(focusNode.leftChild);
                postOrderTraverseTree(focusNode.rightChild);

                System.out.println(focusNode);

            }

        }

        public int findNode(String key) {

            // Start at the top of the tree

            BinaryTree.Node focusNode = root;

            // While we haven't found the Node
            // keep looking

            while (focusNode.key.compareTo(key) != 0) {

                // If we should search to the left

                if (key.compareTo(focusNode.key) > 0) {

                    // Shift the focus Node to the left child

                    focusNode = focusNode.leftChild;

                } else {

                    // Shift the focus Node to the right child

                    focusNode = focusNode.rightChild;

                }

                // The node wasn't found

                if (focusNode == null)
                    return -1;

            }

            return focusNode.name;

        }


        static class Node {

            String key;
            int name;

            Node leftChild;
            Node rightChild;

            Node(String key, int name) {

                this.key = key;
                this.name = name;

            }

            public String toString() {

                return name + " has the key " + key;

                /*
                 * return name + " has the key " + key + "\nLeft Child: " + leftChild +
                 * "\nRight Child: " + rightChild + "\n";
                 */

            }

        }
    }

}
// This code is contributed by Ankur Narain Verma

