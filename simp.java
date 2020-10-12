//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Scanner;

public class SimpleDict {
    public SimpleDict() {
    }

    public static void main(String[] args) {
        Dictionary dict = new Dictionary();
        Scanner input = new Scanner(System.in);
        new String();
        String[] commands = new String[3];
        dict.loadDictionaryFromFile("D:\\Workspace\\oop-asg021-SimpleDict\\DICT.DAT");
        dict.use();

        do {
            System.out.print("> ");
            String command = input.nextLine();
            commands = command.split(" ", 3);
            String var5;
            switch((var5 = commands[0]).hashCode()) {
                case -1335458389:
                    if (var5.equals("delete")) {
                        dict.delete(commands[1]);
                        continue;
                    }
                    break;
                case -1097094790:
                    if (var5.equals("lookup")) {
                        dict.lookup(commands[1]);
                        continue;
                    }
                    break;
                case 96417:
                    if (var5.equals("add")) {
                        dict.add(commands[1], commands[2]);
                        continue;
                    }
                    break;
                case 3482191:
                    if (var5.equals("quit")) {
                        continue;
                    }
                    break;
                case 3522941:
                    if (var5.equals("save")) {
                        dict.save("D:\\Workspace\\oop-asg021-SimpleDict\\DICT.DAT");
                        continue;
                    }
            }

            System.out.println("Error!");
        } while(!commands[0].equals("quit"));

        input.close();
    }
}
