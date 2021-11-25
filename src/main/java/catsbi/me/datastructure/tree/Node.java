package catsbi.me.datastructure.tree;

import java.util.Objects;

class Node<T> implements Comparable<Node<T>>{
    Node<T> left;
    Node<T> right;
    T value;

    Node(T value) {
        this.value = value;
        left = null;
        right = null;
    }

    Node<T> getLeft() {
        return left;
    }

    Node<T> getRight() {
        return right;
    }

    @Override
    public int compareTo(Node<T> o) {
        return Integer.compare(value.hashCode(), o.value.hashCode());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Node)) {
            return false;
        }
        Node<?> node = (Node<?>) o;
        return Objects.equals(left, node.left) && Objects.equals(right, node.right) && Objects.equals(value, node.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right, value);
    }
}
