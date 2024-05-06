package datastructer_hw3;

//Emre Karaburu 

public class Node {

    Contact contact;
    Node left, right;

    public Node(Contact contact) {
        this.contact = contact;
        this.left = null;
        this.right = null;
    }
}
