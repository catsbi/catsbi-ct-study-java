package catsbi.me.datastructure.tree;

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
}
