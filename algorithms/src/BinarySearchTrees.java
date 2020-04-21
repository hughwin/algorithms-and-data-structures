public class BinarySearchTrees <E>{

    private Node head = null;

    private class Node<E extends Comparable<E>> {

        private Node leftNode;
        private Node rightNode;
        private E value;

        private Node(E value, Node leftNode, Node rightNode) {
            this.value = value;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
        }

    }

    public void insert(E value) {

        Node node = new Node((Comparable) value, null, null);

        if (head == null) {
            head = node;
            return;
        } else {
            Node current = head;
            Node parent = head;
            while (current != null) {
                parent = current;
                if (node.value.compareTo(current.value) < 0) {
                    current = current.leftNode;
                } else {
                    current = current.rightNode;
                }
            }
            if (node.value.compareTo(parent.value) < 0){
                parent.leftNode = node;
            }
            else{
                parent.rightNode = node;
            }
        }
    }

    public void printTreeRoot() {
        printTreePostOrder(head);
        System.out.println();
        printTreeInOrder(head);
        System.out.println();
        printTreePreOrder(head);
    }

    private void printTreeInOrder(Node node) {
        if (node == null) {
            return;
        }
        printTreeInOrder(node.leftNode);
        System.out.printf("%s ", node.value);
        printTreeInOrder(node.rightNode);
    }

    private void printTreePostOrder(Node node) {
        if (node != null) {
            printTreePostOrder(node.leftNode);
            printTreePostOrder(node.rightNode);
            System.out.printf("%d ", node.value);
        }
    }

    private void printTreePreOrder(Node node) {
        if (node != null) {
            printTreePreOrder(node.rightNode);
            printTreePreOrder(node.leftNode);
            System.out.printf("%d ", node.value);
        }
    }


}
