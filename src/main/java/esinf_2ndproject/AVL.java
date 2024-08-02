package esinf_2ndproject;

/**
 * The type Avl.
 *
 * @param <E> the type parameter
 * @author DEI -ESINF
 */
public class AVL <E extends Comparable<E>> extends BST<E> {

    private int balanceFactor(Node<E> node){
        int heightL =0, heightR=0;

        if(node.getLeft() != null){
            heightL = height(node.getLeft());
        }
        if(node.getRight() != null){
            heightR = height(node.getRight());
        }

        return heightR - heightL;
    }

    private Node<E> rightRotation(Node<E> node){
        Node<E> leftson = node.getLeft();
        node.setLeft(leftson.getRight());
        leftson.setRight(node);
        return leftson;
    }

    private Node<E> leftRotation(Node<E> node){
        Node<E> rightson = node.getRight();
        node.setRight(rightson.getLeft());
        rightson.setLeft(node);
        return rightson;
    }

    private Node<E> twoRotations(Node<E> node){
        if (balanceFactor(node) < 0) {
            node.setLeft(leftRotation(node.getLeft()));
            node = rightRotation(node); }
        else {
            node.setRight(rightRotation(node.getRight()));
            node = leftRotation(node); }
        return node;
    }

    private Node<E> balanceNode(Node<E> node) {
        if (balanceFactor(node) < -1) {
            if (balanceFactor(node.getLeft()) > 0) {
                node = twoRotations(node);
            } else {
                node =rightRotation(node);

            }

        } else if (balanceFactor(node) > 1) {
            if (balanceFactor(node.getRight()) < 0) {
                node = twoRotations(node);
            } else {
                node = leftRotation(node);
            }
        }
        return node;
    }

    @Override
    public void insert(E element){
        root = insert(root, element);
    }
    private Node<E> insert(Node<E> node, E element){
        if(node == null){
            return new Node<>(element, null, null);
        }
        if (node.getElement().equals(element)) {
            node.setElement(element);
        } else {
            if(element.compareTo(node.getElement()) < 0){
                node.setLeft(insert(node.getLeft(), element));
                node = balanceNode(node);
            }
            else if(element.compareTo(node.getElement()) > 0){
                node.setRight(insert(node.getRight(), element));
                node = balanceNode(node);
            }
        }
        return node;
    }

    @Override
    public void remove(E element){
        root = remove(element, root());
    }

    private Node<E> remove(E element, BST.Node<E> node) {
        if (node == null) {
            return null;
        }
        if (element.compareTo(node.getElement())==0) {
            if (node.getLeft() == null && node.getRight() == null) {
                return null;
            }
            if (node.getLeft() == null) {
                return node.getRight();
            }
            if (node.getRight() == null) {
                return node.getLeft();
            }
            E min = smallestElement(node.getRight());
            node.setElement(min);
            node.setRight(remove(min, node.getRight()));
        } else if (element.compareTo(node.getElement()) < 0) {
            node.setLeft(remove(element, node.getLeft()));
        } else {
            node.setRight(remove(element, node.getRight()));
        }
        return balanceNode(node);
    }

    public boolean equals(Object otherObj) {

        if (this == otherObj)
            return true;

        if (otherObj == null || this.getClass() != otherObj.getClass())
            return false;

        AVL<E> second = (AVL<E>) otherObj;
        return equals(root, second.root);
    }

    /**
     * Equals boolean.
     *
     * @param root1 the root 1
     * @param root2 the root 2
     * @return the boolean
     */
    public boolean equals(Node<E> root1, Node<E> root2) {
        if (root1 == null && root2 == null)
            return true;
        else if (root1 != null && root2 != null) {
            if (root1.getElement().compareTo(root2.getElement()) == 0) {
                return equals(root1.getLeft(), root2.getLeft())
                        && equals(root1.getRight(), root2.getRight());
            } else
                return false;
        }
        else return false;
    }
}