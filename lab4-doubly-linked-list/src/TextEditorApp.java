import java.util.Scanner;

public class TextEditorApp {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n ⊹ ࣪  ౨ৎ˚₊ Simple Text Editor ⊹ ࣪  ౨ৎ˚₊");
            System.out.println("1: Add text");
            System.out.println("2: Undo");
            System.out.println("3: Redo");
            System.out.println("4: Print");
            System.out.println("5: Exit");
            System.out.print("Choose: ");

            String choice = sc.nextLine().trim();
            switch (choice) {
                case "1":
                    System.out.print("Type text to add: ");
                    String txt = sc.nextLine();
                    editor.add(txt);
                    System.out.println("Current text:");
                    editor.printCurrent();
                    break;
                case "2":
                    String afterUndo = editor.undo();
                    System.out.println("After undo:");
                    System.out.println(afterUndo);
                    break;
                case "3":
                    String afterRedo = editor.redo();
                    System.out.println("After redo:");
                    System.out.println(afterRedo);
                    break;
                case "4":
                    System.out.println("Current:");
                    editor.printCurrent();
                    break;
                case "5":
                    System.out.println("Bye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid.");
            }
        }
    }
}
