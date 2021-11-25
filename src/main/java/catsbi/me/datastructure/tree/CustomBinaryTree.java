package catsbi.me.datastructure.tree;

import java.util.Objects;
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

    public boolean delete(T value) {
        boolean searched = false;
        Node<T> curParentNode = this.head;
        Node<T> curNode = this.head;
        final Node<T> targetNode = new Node<>(value);

        if (this.head == null) {
            return false;
        }

        if (isHeadNode(value)) {
            this.head = null;
            return true;
        }

        while (curNode != null) {
            if (curNode.value.equals(targetNode.value)) {
                searched = true;
                break;
            } else if (curNode.compareTo(targetNode) > 0) {
                curParentNode = curNode;
                curNode = curNode.left;
            } else {
                curParentNode = curNode;
                curNode = curNode.right;
            }
        }

        if (!searched) {
            return false;
        }

        //Case 1. Node가 Leaf Node인 경우
        if (isLeafNode(curNode)) {
            deleteLeafNode(curParentNode, targetNode);
            return true;
        }

        //Case 2. Node의 left Node가 있는 경우
        if (hasLeftNode(curNode)) {
            addEdgeNode(curParentNode, curNode.left, curParentNode.compareTo(targetNode));
            return true;
        }

        //Case 3. Node의 Right Node가 있는 경우
        if (hasRightNode(curNode)) {
            addEdgeNode(curParentNode, curNode.right, curParentNode.compareTo(targetNode));
            return true;
        }

        //Case 4. Node의 양 측 Node가 모두 있는 경우
        Node<T> changeNode = curNode.right;
        Node<T> changeParentNode = curNode.right;

        while (changeNode.left != null) {
            changeParentNode = changeNode;
            changeNode = changeNode.left;
        }

        if (changeNode.right != null) {
            changeParentNode.left = changeNode.right;
        } else {
            changeParentNode.left = null;
        }

        if (curParentNode.compareTo(targetNode) > 0) {
            curParentNode.left = changeNode;
        } else {
            curParentNode.right = changeNode;
        }

        if (curNode.right != changeNode) {
            changeNode.right = curNode.right;
        }
        changeNode.left = curNode.left;

        return true;
    }

    private void addEdgeNode(Node<T> curParentNode, Node<T> node, int compareResult) {
        if (compareResult > 0) {
            curParentNode.left = node;
            return;
        }
        curParentNode.right = node;
    }

    private void deleteLeafNode(Node<T> curParentNode, Node<T> targetNode) {
        if (curParentNode.compareTo(targetNode) > 0) {
            curParentNode.left = null;
        } else {
            curParentNode.right = null;
        }
    }

    private boolean hasRightNode(Node<T> curNode) {
        return curNode.left == null && curNode.right != null;
    }

    private boolean hasLeftNode(Node<T> curNode) {
        return curNode.left != null && curNode.right == null;
    }

    private boolean isLeafNode(Node<T> curNode) {
        return curNode.left == null && curNode.right == null;
    }

    private boolean isHeadNode(T value) {
        return this.head.value == value
                && Objects.isNull(this.head.left)
                && Objects.isNull(this.head.right);
    }

}
