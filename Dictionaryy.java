//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Dictionary {
    private Node head = null;

    public Dictionary() {
    }

    public void loadDictionaryFromFile(String fileName) {
        BufferedReader bufferedReader = null;

        try {
            String currentLine = null;
            bufferedReader = new BufferedReader(new FileReader(fileName));

            while(true) {
                while((currentLine = bufferedReader.readLine()) != null) {
                    int index = currentLine.indexOf(":");
                    String word = currentLine.substring(0, index);
                    String meanings = currentLine.substring(index + 2, currentLine.length());
                    Node node = new Node(word, meanings);
                    if (this.head == null) {
                        this.head = node;
                    } else {
                        Node currentNode;
                        for(currentNode = this.head; currentNode.next != null; currentNode = currentNode.next) {
                        }

                        currentNode.next = node;
                    }
                }

                return;
            }
        } catch (IOException var17) {
            var17.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException var16) {
                var16.printStackTrace();
            }

        }

    }

    public void add(String word, String meanings) {
        Node newNode = new Node(word, meanings);
        if (this.head == null) {
            this.head = newNode;
        } else if (this.head.word.compareTo(word) > 0) {
            newNode.next = this.head;
            this.head = newNode;
        } else {
            Node currentNode;
            for(currentNode = this.head; currentNode.next != null; currentNode = currentNode.next) {
                if (currentNode.word.equals(word)) {
                    if (currentNode.meanings.indexOf(meanings) < 0) {
                        currentNode.concatMeanings(meanings);
                    } else {
                        System.out.println("Word and meanings already exists!");
                    }

                    return;
                }

                if (currentNode.next.word.compareTo(word) > 0) {
                    newNode.next = currentNode.next;
                    currentNode.next = newNode;
                    return;
                }
            }

            if (currentNode.word.equals(word)) {
                if (currentNode.meanings.indexOf(meanings) < 0) {
                    currentNode.concatMeanings(meanings);
                } else {
                    System.out.println("Word and meanings already exists!");
                }

            } else {
                currentNode.next = newNode;
            }
        }
    }

    public void lookup(String word) {
        if (this.head == null) {
            System.out.println("Dictionary is empty!");
        } else {
            for(Node currentNode = this.head; currentNode != null; currentNode = currentNode.next) {
                if (currentNode.word.equals(word)) {
                    System.out.println(currentNode.meanings);
                    return;
                }
            }

            System.out.println("Not found!");
        }
    }

    public void delete(String word) {
        if (this.head == null) {
            System.out.println("Dictionary is empty!");
        } else if (this.head.word.equals(word)) {
            if (this.head.next == null) {
                this.head = null;
            } else {
                this.head = this.head.next;
            }

            System.out.println(word + " deleted!");
        } else {
            Node currentNode;
            for(currentNode = this.head; currentNode.next != null; currentNode = currentNode.next) {
                if (currentNode.next.word.equals(word)) {
                    currentNode.next = currentNode.next.next;
                    System.out.println(word + " deleted!");
                    return;
                }
            }

            if (currentNode.word.equals(word)) {
                currentNode = null;
                System.out.println(word + " deleted!");
            } else {
                System.out.println("Not found!");
            }
        }
    }

    public void save(String fileName) {
        BufferedWriter bufferedWriter = null;

        try {
            bufferedWriter = new BufferedWriter(new FileWriter(fileName));
            if (this.head != null) {
                Node currentNode;
                for(currentNode = this.head; currentNode.next != null; currentNode = currentNode.next) {
                    bufferedWriter.write(currentNode.toString() + "\n");
                }

                bufferedWriter.write(currentNode.toString());
                return;
            }

            System.out.println("Dictionary is empty!");
        } catch (IOException var13) {
            var13.printStackTrace();
            return;
        } finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
            } catch (IOException var12) {
                var12.printStackTrace();
            }

        }

    }

    public void use() {
        System.out.println("> add <word>: <meanings>");
        System.out.println("> lookup <word>");
        System.out.println("> delete <word>");
        System.out.println("> save");
        System.out.println("> quit");
    }
}
