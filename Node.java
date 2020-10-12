//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class Node {
    public String word;
    public String meanings;
    public Node next;

    public Node(String word, String meanings) {
        this.word = word;
        this.meanings = meanings;
        this.next = null;
    }

    public void concatMeanings(String concatMeanings) {
        String meanings = String.format("%s, %s", this.meanings, concatMeanings);
        this.meanings = meanings;
    }

    public String toString() {
        return String.format("%s: %s", this.word, this.meanings);
    }
}
