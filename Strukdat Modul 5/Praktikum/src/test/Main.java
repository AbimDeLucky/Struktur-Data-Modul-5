package test;

import java.util.Scanner;

public class Main {
    private static class Node {
        String data;
        Node left;
        Node right;

        public Node(String data) {
            this.data = data;
        }
    }

    private static class BinaryTree {
        public Node root;

        public void insert(String data) {
            root = insertNode(root, new Node(data));
        }

        private Node insertNode(Node root, Node newNode) {
            if (root == null) {
                root = newNode;
                return root;
            }
            if (newNode.data.compareTo(root.data) < 0) {
                root.left = insertNode(root.left, newNode);
            } else {
                root.right = insertNode(root.right, newNode);
            }
            return root;
        }

        public void inOrder(Node node) {
            if (node != null) {
                inOrder(node.left);
                System.out.print(node.data + " ");
                inOrder(node.right);
            }
        }

        public void postOrder(Node node) {
            if (node != null) {
                postOrder(node.left);
                postOrder(node.right);
                System.out.print(node.data + " ");
            }
        }

        public void preOrder(Node node) {
            if (node != null) {
                System.out.print(node.data + " ");
                preOrder(node.left);
                preOrder(node.right);
            }
        }
    }

    public static void main(String[] args) {
        String cek;
        Scanner scanner = new Scanner(System.in);
        BinaryTree binaryTree = new BinaryTree();

        do {
            System.out.print("Masukkan Data: ");
            String input = scanner.nextLine();
            binaryTree.insert(input);
            System.out.print("Tambah Data? (y/n): ");
            cek = scanner.nextLine();
        } while (cek.equalsIgnoreCase("y"));

        System.out.println("\npreOrder  : ");
        binaryTree.preOrder(binaryTree.root);
        System.out.println("\ninOrder   : ");
        binaryTree.inOrder(binaryTree.root);
        System.out.println("\npostOrder : ");
        binaryTree.postOrder(binaryTree.root);
    }
}
