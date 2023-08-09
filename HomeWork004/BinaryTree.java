package HomeWork004;


public class BinaryTree<T extends Comparable<T>> {
    private Node root;
    private int size;

    public boolean add(T value) {
        if (root == null) {
            root = new Node(value);
            root.color = Color.black;
            size = 1;
        }
        return addNode(root, value) != null;

    }

    private Node addNode(Node node, T value){
        if (node.value.compareTo(value) == 0)
            return null;
        if (node.value.compareTo(value) > 0) {
            if (node.leftNode == null) {
                node.leftNode = new Node(value);
                size++;
                return node.leftNode;
            }
            Node addedNode = addNode(node.leftNode, value);
            node.leftNode = rebalance(node.leftNode);
            return addedNode;
        }
        if (node.rightNode == null) {
            node.rightNode = new Node(value);
            size++;
            return node.rightNode;
        }
        Node addedNode = addNode(node.rightNode, value);
        node.rightNode = rebalance(node.rightNode);
        return addedNode;
    }

    public int length() {
        return size;
    }

    public void print() {
        print(root);
    }

    private Node rebalance(Node node) {
        Node checkNode = node;
        boolean needNext = true;
        while (needNext) {
            needNext = false;
            if (checkNode.rightNode != null && checkNode.rightNode.color == Color.red &&
                    (checkNode.leftNode == null || checkNode.leftNode.color == Color.black)) {
                needNext = true;
                checkNode = rightSwap(checkNode);
            }
            if (checkNode.leftNode != null && checkNode.leftNode.leftNode != null && checkNode.leftNode.color == Color.red &&
                    checkNode.leftNode.leftNode.color == Color.red) {
                needNext = true;
                checkNode = leftSwap(checkNode);
            }
            if (checkNode.leftNode != null && checkNode.rightNode != null && checkNode.leftNode.color == Color.red &&
                    checkNode.rightNode.color == Color.red) {
                colorSwap(checkNode);
            }
        }
        return checkNode;
    }

    private Node rightSwap(Node node) {
        Node moveingNode = node.rightNode;
        Node between = moveingNode.leftNode;
        System.out.println("Правый поворот: " + node);
        moveingNode.leftNode = node;
        node.rightNode = between;
        moveingNode.color = node.color;
        node.color = Color.red;
        return moveingNode;
    }

    private Node leftSwap(Node node) {
        System.out.println("Левый поворот: " + node);
        Node moveingNode = node.leftNode;
        Node between = moveingNode.rightNode;
        moveingNode.rightNode = node;
        node.leftNode = between;
        moveingNode.color = node.color;
        node.color = Color.red;
        return moveingNode;
    }

    private void colorSwap(Node node) {
        node.leftNode.color = Color.black;
        node.rightNode.color = Color.black;
        node.color = Color.red;
        System.out.println("Поворот цвета: " + node);
    }

    private Node find(Node node, T value) {
        if (node == null)
            return null;
        if (node.value.compareTo(value) == 0)
            return node;
        if (node.value.compareTo(value) > 0)
            return find(node.leftNode, value);
        return find(node.rightNode, value);
    }

    private void print(Node node) {
        if (node == null)
            return;
        System.out.println(node);
        print(node.leftNode);
        print(node.rightNode);
    }

    private class Node {
        T value;
        Node leftNode;
        Node rightNode;
        Color color;

        public Node(T value) {
            this.value = value;
            this.color = Color.red;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.value.toString() + " " + this.color);
            if (this.leftNode != null)
                sb.append(" l:" + this.leftNode.value.toString() + " " + this.leftNode.color);
            if (this.rightNode != null)
                sb.append(" r:" + this.rightNode.value.toString() + " " + this.rightNode.color);
            return sb.toString();
        }
    }

    private enum Color {red, black}
}

