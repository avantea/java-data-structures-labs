public class Playlist {
    private static class Node {
        Song song;
        Node next;
        // Node constructor...
        Node(Song song) {
            this.song = song;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private Node currentNode;
    private int size;

    public Playlist() {
        this.head = null;
        this.tail = null;
        this.currentNode = null;
        this.size = 0;
    }

    public void addSong(Song song) {
        // Adds a song to the end of the playlist.
        Node newest = new Node(song);
        if (head == null) {
            head = newest;
            tail = newest;
        } else {
            tail.next = newest;
            tail = newest;
        }
        size++;
    }

    public void removeSong(String title) {
        // Handle two cases: removing the head and removing from elsewhere.
        // Don't forget to update the tail if the last song is removed.
        if (head == null) return;

        // Case 1: remove head
        if (head.song.getTitle().equalsIgnoreCase(title)) {
            if (currentNode == head) currentNode = (head.next != null) ? head.next : null;
            head = head.next;
            if (head == null) tail = null;
            size--;
            return;
        }

        // Case 2: remove from elsewhere
        Node prev = head;
        Node curr = head.next;
        while (curr != null) {
            if (curr.song.getTitle().equalsIgnoreCase(title)) {
                prev.next = curr.next;
                if (curr == tail) tail = prev;
                if (currentNode == curr) currentNode = (prev.next != null) ? prev.next : head;
                size--;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    public void playNext() {
        // If currentNode is null, start from the head.
        // Otherwise, advance to the next node.
        // If you reach the end, loop back to the head.
        if (head == null) {
            System.out.println("Playlist is empty.");
            return;
        }
        if (currentNode == null) {
            currentNode = head;
        } else {
            currentNode = currentNode.next;
            if (currentNode == null) currentNode = head; // wrap around
        }
        System.out.println("Now playing: " + currentNode.song);
    }

    public void displayPlaylist() {
        // Traverse from the head and print each song.
        if (head == null) {
            System.out.println("Playlist is empty.");
            return;
        }
        System.out.println("\n--- Playlist (" + size + " songs) ---");
        Node p = head;
        int i = 1;
        while (p != null) {
            System.out.println(i + ". " + p.song);
            p = p.next;
            i++;
        }
    }
}

