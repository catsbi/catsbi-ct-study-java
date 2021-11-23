package catsbi.me.datastructure.tree;

import java.util.Optional;

public class CustomBinaryTree<T> {
    public Node<T> head = null;

    public boolean insert(T value) {
        Node<T> findNode = this.head;
        Node<T> newNode = new Node<>(value);

        if (this.head == null) {
            this.head = newNode;
            return true;
        }

        return insert(findNode, newNode);
    }

    private boolean insert(Node<T> findNode, Node<T> targetNode) {
        final int compareResult = findNode.compareTo(targetNode);
        if (compareResult == 0) {
            return false;
        }

        if (compareResult > 0) {
            if (findNode.left != null) {
                return insert(findNode.left, targetNode);
            }
            findNode.left = targetNode;
            return true;
        }

        if (findNode.right != null) {
            return insert(findNode.right, targetNode);
        }
        findNode.right = targetNode;
        return true;
    }



    public Optional<Node<T>> search(T value) {
        if (head == null) {
            return Optional.empty();
        }

        Node<T> findNode = this.head;
        final Node<T> newNode = new Node<>(value);

        while (findNode != null) {
            if (findNode.value.equals(value)) {
                return Optional.of(findNode);
            } else if (findNode.compareTo(newNode) > 0) {
                findNode = findNode.left;
            } else {
                findNode = findNode.right;
            }
        }
        return Optional.empty();
    }

}
