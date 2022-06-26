import java.io.*;

public class usingReader {static BinaryTree tree=new BinaryTree();
    public static void main(String[] args) throws IOException {
//        String filePath="prem1.txt";
        String usn = "1hk19is015";
        String name = "Anthony";
        String branch = "ISE";
        String SemSec = "6A";
        String NewSemSec = "6B";
//        readData();


        tree.addNode(1001,0);
        tree.addNode(1002,1);
        tree.addNode(1011,2);
        tree.addNode(1012,3);
        tree.addNode(1021,4);
        tree.addNode(1022,5);
//        tree.inOrderTraverseTree(tree.root);


        //returning 1 in the beggning
//        System.out.println(tree.findNode(1002));
        String entryOne = "1001|1hk19is015|Prasanna Anthony|ISE|6A";
        String entryTwo = "1002|1hk19is016| Anthony|ISE4|6A";
        String entry3 = "1011|1hk19is017| Any|ISE4|65";
        String entry4 = "1012|1hk19is013| modify|ISE4|65";
        FileWriter fileWriter = new FileWriter("randText.txt");
        FileWriter fileWriter1 = new FileWriter("temp.txt");
        fileWriter.flush();
        fileWriter1.flush();

        writeData(entryOne, "randText.txt");
        writeData(entryTwo, "randText.txt");
        writeData(entry3, "randText.txt");
//        readData();
        modifyEntry(1011, entry4);
//        searchRecord(1001);
    }

    static void readData() throws IOException {
        FileReader fileReader = new FileReader("randText.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        System.out.println(bufferedReader.readLine());
    }

    static void writeData(String dataStream, String fileName) throws IOException {
        FileWriter fileWriter = new FileWriter(fileName, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.append(dataStream + "\n");
        bufferedWriter.close();
    }

    static void modifyEntry(int roomNo, String recordToBeEdited) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader("randText.txt"));
        String preFixData = "";
        System.out.println(tree.findNode(roomNo));
        for (int i = 0; i < 4; i++) {
            if (tree.findNode(roomNo) == i) {
                preFixData += recordToBeEdited + "\n";
            } else {
                preFixData += bufferedReader.readLine() + "\n";
            }
        }
        System.out.println(preFixData);
        writeData(preFixData, "temp.txt");

    }

    static void searchRecord(int roomNo) throws IOException {
        if (tree.findNode(roomNo) == -1) {
            printLine("Room Does not Exists");
        } else {
            FileReader fileReader = new FileReader("randText.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            for (int i = 0; i < tree.findNode(roomNo) - 1; i++) {
                bufferedReader.readLine();
            }
            printLine(bufferedReader.readLine());
            bufferedReader.close();
        }
    }

    static void printLine(String s) {
        System.out.println(s);
    }


    public static class BinaryTree {

        Node root;

        public void addNode(int key, int name) {

            // Create a new Node and initialize it

            Node newNode = new Node(key, name);

            // If there is no root this becomes root

            if (root == null) {

                root = newNode;

            } else {

                // Set root as the Node we will start
                // with as we traverse the tree

                Node focusNode = root;

                // Future parent for our new Node

                Node parent;

                while (true) {

                    // root is the top parent so we start
                    // there

                    parent = focusNode;

                    // Check if the new node should go on
                    // the left side of the parent node

                    if (key < focusNode.key) {

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

        public void inOrderTraverseTree(Node focusNode) {

            if (focusNode != null) {

                // Traverse the left node

                inOrderTraverseTree(focusNode.leftChild);

                // Visit the currently focused on node

                System.out.println(focusNode);

                // Traverse the right node

                inOrderTraverseTree(focusNode.rightChild);

            }

        }

        public void preorderTraverseTree(Node focusNode) {

            if (focusNode != null) {

                System.out.println(focusNode);

                preorderTraverseTree(focusNode.leftChild);
                preorderTraverseTree(focusNode.rightChild);

            }

        }

        public void postOrderTraverseTree(Node focusNode) {

            if (focusNode != null) {

                postOrderTraverseTree(focusNode.leftChild);
                postOrderTraverseTree(focusNode.rightChild);

                System.out.println(focusNode);

            }

        }

        public int findNode(int key) {

            // Start at the top of the tree

            Node focusNode = root;

            // While we haven't found the Node
            // keep looking

            while (focusNode.key != key) {

                // If we should search to the left

                if (key < focusNode.key) {

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

            int key;
            int name;

            Node leftChild;
            Node rightChild;

            Node(int key, int name) {

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