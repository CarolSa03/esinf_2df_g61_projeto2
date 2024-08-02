package esinf_2ndproject;

import java.awt.geom.Point2D;
import java.util.Comparator;

/**
 * The type Kd tree.
 *
 * @param <E> the type parameter
 */
public class KdTree<E extends Comparable<E> & KDTreeNodeInterface> extends BST<E> {


    /**
     * The type Kd node.
     *
     * @param <E> the type parameter
     */
    protected static class KdNode<E> extends Node<E> {

        /**
         * Constructs a node with the given element and neighbors.
         *
         * @param element    the element to be stored
         * @param leftChild  reference to a left child node
         * @param rightChild reference to a right child node
         */
        public KdNode(E element, KdNode<E> leftChild, KdNode<E> rightChild) {
            super(element, leftChild, rightChild);
            this.element = element;
            this.left = leftChild;
            this.right = rightChild;
        }

        private E element;
        private KdNode<E> left;
        private KdNode<E> right;

        private Point2D.Double coord;

        public KdNode<E> getLeft() {
            return left;
        }

        public KdNode<E> getRight() {
            return right;
        }


        /**
         * Sets left.
         *
         * @param leftChild the left child
         */
        public void setLeft(KdNode<E> leftChild) {
            left = leftChild;
        }

        /**
         * Sets right.
         *
         * @param rightChild the right child
         */
        public void setRight(KdNode<E> rightChild) {
            right = rightChild;
        }

        public Point2D.Double getCoord() {
            return coord;
        }

        public void setCoord(Point2D.Double coord) {
            this.coord = coord;
        }

        @Override
        public E getElement() {
            return element;
        }

        @Override
        public void setElement(E element) {
            this.element = element;
        }
    }

    protected KdNode<E> root;


    public KdTree() {
        root = null;
    }

    protected KdNode<E> root() {
        return root;
    }

    public KdNode<E> find(E element) {
        return find(root, element, true);
    }

    /**
     * Returns the Node containing a specific Element, or null otherwise.
     *
     * @param element the element to find
     * @return the Node that contains the Element, or null otherwise
     * <p>
     * This method despite not being essential is very useful.
     * It is written here in order to be used by this class and its
     * subclasses avoiding recoding.
     * So its access level is protected
     */
    protected KdNode<E> find(KdNode<E> node, E element, boolean divX) {
        if (node == null) return null;
        if (node.getElement().equals(element)) return node;
        int compareResult = (divX ? compareX : compareY).compare(node, node);
        if (element.compareTo(node.getElement()) < 0) return find(node.getLeft(), element, !divX);
        else return find(node.getRight(), element, !divX);
    }

//    public void insert(E element) {
//        KdNode<E> node = new KdNode<>(element, null, null);
//        if (root == null) {
//            root = node;
//        } else {
//            insert(root, node, node, true);
//        }
//    }

//    private KdNode<E> insert(KdNode<E> currentNode, KdNode<E> node, boolean divX) {
//
//        if ((node.getCoord().equals(currentNode.getCoord()))) {
//            return currentNode;
//        }
//
//        int compareResult = (divX ? compareX : compareY).compare(node, currentNode);
//
//        if (compareResult == -1) {
//            if (currentNode.left == null) {
//                currentNode.setLeft(node);
//                return currentNode;
//            } else {
//                return insert(currentNode.left, node, !divX);
//            }
//        } else {
//            if (currentNode.right == null) {
//                currentNode.setRight(node);
//                return currentNode;
//            } else {
//                return insert(currentNode.getRight(), node, !divX);
//            }
//        }
//    }

    public void insert (E element) {
        root = insert(root, element, true);
    }
    private KdNode insert(KdNode node, E element, boolean depth) {
        if (node == null) return null;
        if(depth){
            if (element.compareTo((E) node.getElement()) < 0) {
                node.setLeft(insert(node.getLeft(), element, !depth));
            } else {
                node.setRight(insert(node.getRight(), element, !depth));
            }
        } else {
            if (element.compareTo((E) node.getElement()) < 0) {
                node.setLeft(insert(node.getLeft(), element, !depth));
            } else {
                node.setRight(insert(node.getRight(), element, !depth));
            }
        }

        return node;
    }

    public void remove(E element) {
        remove(element, root, true);
    }

    private KdNode<E> remove(E element, KdNode<E> node, boolean divX) {
        if (node == null) {
            return null;
        }

        int compareResult = (divX ? compareX : compareY).compare(node, node);

        if (compareResult < 0) {
            node.setLeft(remove(element, node.getLeft(), !divX));
        } else if (compareResult > 0) {
            node.setRight(remove(element, node.getRight(), !divX));
        } else {

            if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getLeft();
            }

            KdNode<E> minRight = (KdNode<E>) smallestElement(node.getRight());
            node.setElement(minRight.getElement());
            node.setRight(remove(minRight.getElement(), node.getRight(), !divX));
        }

        return node;
    }

    private final Comparator<KdNode<E>> compareX = new Comparator<KdNode<E>>() {
        @Override
        public int compare(KdNode<E> p1, KdNode<E> p2) {
            return Double.compare(p1.getElement().getCoords().getX(), p2.getElement().getCoords().getX());
        }
    };

    private final Comparator<KdNode<E>> compareY = new Comparator<KdNode<E>>() {
        @Override
        public int compare(KdNode<E> p1, KdNode<E> p2) {
            return Double.compare(p1.getElement().getCoords().getY(), p2.getElement().getCoords().getY());
        }
    };

    /**
     * Find nearest neighbour e.
     *
     * @param node        the node
     * @param x           the x
     * @param y           the y
     * @param closestNode the closest node
     * @param divX        the div x
     * @return the e
     */
    public E findNearestNeighbour(KdNode<E> node, double x, double y, KdNode<E> closestNode, boolean divX) {

        if (node == null) return null;

        double d = Point2D.distanceSq(node.getElement().getCoords().x, node.getElement().getCoords().y, x, y);

        double closestDist = Point2D.distanceSq(closestNode.getElement().getCoords().x, closestNode.getElement().getCoords().y, x, y);

        if (closestDist > d) {

            closestNode.setElement(node.getElement());
            closestDist = d;

            double delta = divX ? x - node.getElement().getCoords().x : y - node.getElement().getCoords().y;
            double delta2 = delta * delta;

            KdNode<E> node1 = delta < 0 ? node.getLeft() : node.getRight();
            KdNode<E> node2 = delta < 0 ? node.getRight() : node.getLeft();

            findNearestNeighbour(node1, x, y, closestNode, !divX);

            if (delta2 < closestDist) {
                findNearestNeighbour(node2, x, y, closestNode, !divX);
                return closestNode.getElement();
            }
        }

        return closestNode.getElement();
    }
}