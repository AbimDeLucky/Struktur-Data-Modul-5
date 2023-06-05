package Tree;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String cek;
        Scanner add = new Scanner(System.in);
        BinaryTree binaryTree = new BinaryTree();

        do{
            System.out.print("Masukkan Data : ");
            String input = add.nextLine();
            binaryTree.NewNode(input);
            System.out.print("Tambah Data? (y/n) : ");
            cek = add.nextLine();
        }while(cek.equals("y"));

        System.out.println("\npreOrder  : ");
        binaryTree.preOrder(binaryTree.root);
        System.out.println("\ninOrder   : ");
        binaryTree.inOrder(binaryTree.root);
        System.out.println("\npostOrder : ");
        binaryTree.postOrder(binaryTree.root);

    }
}