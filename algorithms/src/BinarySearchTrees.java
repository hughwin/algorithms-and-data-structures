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

    public void printTreeRoot(){
        printTreeHelper(head);
    }

    private void printTreeHelper(Node node) {
        if(node !=  null) {
            printTreeHelper(node.leftNode);
            printTreeHelper(node.rightNode);
            //Visit the node by Printing the node data
            System.out.printf("%d ",node.value);
        }
    }


}
