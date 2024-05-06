package datastructer_hw3;

//Emre Karaburu 

public class BST {

    Node root;

    public BST() {
        root = null;
    }

    public void insert(Contact contact) {
        root = insertRecursive(root, contact);
    }

    private Node insertRecursive(Node root, Contact contact) {
        if (root == null) {
            root = new Node(contact);
            return root;
        }

        if (contact.lastName.compareTo(root.contact.lastName) < 0) {
            root.left = insertRecursive(root.left, contact);
        } else if (contact.lastName.compareTo(root.contact.lastName) > 0) {
            root.right = insertRecursive(root.right, contact);
        }

        return root;
    }

    public void inorder() {
        inorderRecursive(root);
    }

    private void inorderRecursive(Node root) {
        if (root != null) {
            inorderRecursive(root.left);
            System.out.println("- " + root.contact);
            inorderRecursive(root.right);
        }
    }

    public void preorder() {
        inorderRecursive(root);
    }

    private void preOrderRecursive(Node root) {
        if (root != null) {
            System.out.println("- " + root.contact);
            preOrderRecursive(root.left);
            preOrderRecursive(root.right);
        }
    }

    public void postOrder() {
        postOrderRecursive(root);
    }

    private void postOrderRecursive(Node root) {
        if (root != null) {
            postOrderRecursive(root.left);
            postOrderRecursive(root.right);
            System.out.println("- " + root.contact);
        }
    }

    public Contact search(String lastName) {
        return searchRecursive(root, lastName);
    }

    private Contact searchRecursive(Node root, String lastName) {
        if (root == null || root.contact.lastName.equals(lastName)) {
            return (root != null) ? root.contact : null;
        }

        if (lastName.compareTo(root.contact.lastName) < 0) {
            return searchRecursive(root.left, lastName);
        } else {
            return searchRecursive(root.right, lastName);
        }
    }

    public void delete(String lastName) {
        root = deleteRecursive(root, lastName);
    }

    private Node deleteRecursive(Node root, String lastName) {
        if (root == null) {
            return root;
        }

        if (lastName.compareTo(root.contact.lastName) < 0) {
            root.left = deleteRecursive(root.left, lastName);
        } else if (lastName.compareTo(root.contact.lastName) > 0) {
            root.right = deleteRecursive(root.right, lastName);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.contact = minValue(root.right);

            root.right = deleteRecursive(root.right, root.contact.lastName);
        }

        return root;
    }

    private Contact minValue(Node root) {
        Contact minv = root.contact;
        while (root.left != null) {
            minv = root.left.contact;
            root = root.left;
        }
        return minv;
    }

}
