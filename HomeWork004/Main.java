package HomeWork004;

public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        binaryTree.add(100);
        binaryTree.add(90);
        binaryTree.add(95);
        binaryTree.add(85);
        binaryTree.add(80);
        binaryTree.add(87);
        binaryTree.add(120);
        binaryTree.add(110);
        binaryTree.add(150);
        binaryTree.add(140);
        binaryTree.add(130);
        binaryTree.add(115);
        binaryTree.print();
        System.out.println("Записей: " + binaryTree.length());

    }
}
