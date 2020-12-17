package pl.paweln.dp.behavioral.iterator.tree;

import java.util.Iterator;

public class InOrderIterator<T> implements Iterator<T> {
    private Node<T> current, root;
    private boolean start;

    public InOrderIterator(Node<T> root) {
        this.root = current = root;
        while (current.left != null) {
            current = current.left;
        }
    }

    private boolean hasRightMostParent (Node<T> node) {
        if (node.parent == null) return false;
        else {
            return (node == node.parent.left) || hasRightMostParent(node.parent);
        }
    }

    @Override
    public boolean hasNext() {
        return current.left != null || current.right != null || hasRightMostParent(current);
    }

    @Override
    public T next() {
        if (!start)
        {
            start = true;
            return current.value;
        }

        if (current.right != null)
        {
            current = current.right;
            while (current.left != null)
                current = current.left;
            return current.value;
        }
        else
        {
            Node<T> p = current.parent;
            while (p != null && current == p.right)
            {
                current = p;
                p = p.parent;
            }
            current = p;
            return current.value;
        }
    }
}
