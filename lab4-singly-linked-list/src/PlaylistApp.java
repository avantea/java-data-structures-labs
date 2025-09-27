import java.util.Scanner;

public class PlaylistApp {
    public static void main(String[] args) {
        Playlist playlist = new Playlist();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n ⊹ ࣪  ౨ৎ˚₊ Playlist Manager ⊹ ࣪  ౨ৎ˚₊");
            System.out.println("1: Add Song");
            System.out.println("2: Remove Song");
            System.out.println("3: Play Next");
            System.out.println("4: Playlist");
            System.out.println("5: Exit");
            System.out.print("Choose: ");

            String choice = sc.nextLine().trim();
            switch (choice) {
                case "1":
                    System.out.print("Title: ");
                    String title = sc.nextLine();
                    System.out.print("Artist: ");
                    String artist = sc.nextLine();
                    playlist.addSong(new Song(title, artist));
                    System.out.println("Added!");
                    break;
                case "2":
                    System.out.print("Title to remove: ");
                    String toRemove = sc.nextLine();
                    playlist.removeSong(toRemove);
                    break;
                case "3":
                    playlist.playNext();
                    break;
                case "4":
                    playlist.displayPlaylist();
                    break;
                case "5":
                    System.out.println("Bye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
