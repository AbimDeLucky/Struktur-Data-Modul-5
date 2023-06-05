package kegiatan2;

import java.util.Scanner;

public class Tree {
    class Node {
        Node right, left;
        String data;

        public Node(String data) {
            this.data = data;
        }
    }

    Node root;

    public void insertNode(String data) {
        root = insertNewNode(root, new Node(data));
    }

    private Node insertNewNode(Node root, Node newNode) {
        if (root == null) {
            root = newNode;
            return root;
        }

        if (newNode.data.compareTo(root.data) < 0) {
            root.left = insertNewNode(root.left, newNode);
        } else {
            root.right = insertNewNode(root.right, newNode);
        }
        return root;
    }

    public void inOrderTraversal(Node root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.print(root.data + " ");
            inOrderTraversal(root.right);
        }
    }

    public void preOrderTraversal(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }

    public void postOrderTraversal(Node root) {
        if (root != null) {
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.data + " ");
        }
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        Scanner input = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\nBinary Tree Traversal");
            System.out.print("1. Tambah data\n2. Tampilkan hasil Traversal\nMasukkan pilihan: ");
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\n--Tambah Data--");
                    System.out.print("Ingin menambahkan berapa data? : ");
                    int numData = input.nextInt();
                    for (int i = 0; i < numData; i++) {
                        System.out.print("Masukkan data " + (i + 1) + ": ");
                        String newData = input.next();
                        tree.insertNode(newData);
                    }
                    break;

                case 2:
                    System.out.println("\nHasil Traversal");
                    System.out.print("InOrder: ");
                    tree.inOrderTraversal(tree.root);
                    System.out.print("\nPostOrder: ");
                    tree.postOrderTraversal(tree.root);
                    System.out.print("\nPreOrder: ");
                    tree.preOrderTraversal(tree.root);
                    isRunning = false;
                    break;

                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih 1 atau 2.");
                    break;
            }
        }
    }
}
