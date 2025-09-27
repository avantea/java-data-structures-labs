public class TextEditor {
    private static class Node {
        String textState;
        Node prev;
        Node next;
        // Node constructor...
        Node(String textState, Node prev, Node next) {
            this.textState = textState;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node currentNode;

    public TextEditor() {
        // Start with an initial empty string state.
        Node initialNode = new Node("", null, null);
        this.currentNode = initialNode;
    }

    public void add(String newText) {
        // Create a new node with the updated text.
        // Set its 'prev' to the current node.
        // Set the current node's 'next' to this new node.
        // Finally, update currentNode to point to the new node.

        // Clear redo history first (erase forward branch)
        currentNode.next = null;

        // Build the new state by appending to current text
        String updated;
        if (currentNode.textState.isEmpty()) {
            updated = newText;           
        } else {
            updated = currentNode.textState + " " + newText; 
        }

        // Create and link the new node
        Node newest = new Node(updated, currentNode, null);
        currentNode.next = newest;

        // Move current pointer forward
        currentNode = newest;
    }

    public String undo() {
        // Check if currentNode.prev is not null.
        // If it is, move currentNode back and return the text.
        // Otherwise, you can't undo.
        if (currentNode.prev == null) {
            // already at the oldest state
            return currentNode.textState;
        }
        currentNode = currentNode.prev;
        return currentNode.textState;
    }

    public String redo() {
        // Check if currentNode.next is not null.
        // If it is, move currentNode forward and return the text.
        if (currentNode.next == null) {
            // nothing to redo
            return currentNode.textState;
        }
        currentNode = currentNode.next;
        return currentNode.textState;
    }

    public void printCurrent() {
        System.out.println(currentNode.textState);
    }
}

