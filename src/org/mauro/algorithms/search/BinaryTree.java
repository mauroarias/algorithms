package org.mauro.algorithms.search;

import static org.mauro.Entries.BINARY_TREE;
import static org.mauro.Entries.LOOK_FOR_BINARY_TREE;

public class BinaryTree {
    public void solution() {
        System.out.println(isThere(BINARY_TREE, LOOK_FOR_BINARY_TREE));
    }

    public boolean isThere(final int[] values, final int lookingFor) {
        final Tree tree = convertToTree(values);
        System.out.println(tree);
        return tree.find(lookingFor);
    }

    public Tree convertToTree(final int[] values) {
        final Tree tree =  new Tree(new Node(values[0], null, null, null));
        for (int i = 1; i < values.length; i++) {
            tree.addValue(values[i]);
        }
        return tree;
    }

    public static class Tree {

        public Node entryNode;
        public int size = 1;

        public Tree(Node entryNode) {
            this.entryNode = entryNode;
        }

        public boolean addValue(final int value) {
            Node node = findNodeOrFatherNode(entryNode, value);
            if (node.value == value) {
                return false;
            } else if (node.value > value) {
                node.minors = new Node(value, node, null, null);
            } else {
                node.biggers = new Node(value, node, null, null);
            }
            size++;
            return true;
        }

        public boolean find(final int value) {
            return findNodeOrFatherNode(entryNode, value).value == value;
        }

        private Node findNodeOrFatherNode(final Node node, final int lookingFor) {
            if (node.value > lookingFor) {
                if (node.minors != null) {
                    return findNodeOrFatherNode(node.minors, lookingFor);
                }
            } else if (node.value < lookingFor) {
                if (node.biggers != null) {
                    return findNodeOrFatherNode(node.biggers, lookingFor);
                }
            }
            return node;
        }

        public String toString() {
            return "Tree{" +
                    "entryNode=" + entryNode +
                    "size=" + size +
                    '}';
        }
    }

    public static class Node {
        public int value;
        public Node father;
        public Node minors;
        public Node biggers;

        public Node(int value, Node father, Node minors, Node biggers) {
            this.value = value;
            this.father = father;
            this.minors = minors;
            this.biggers = biggers;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    getMinor() +
                    getBigger() +
                    '}';
        }

        private String getMinor() {
            return minors == null ? "" : ", minors=" + minors;
        }

        private String getBigger() {
            return biggers == null ? "" : ", biggers=" + biggers;
        }
    }
}
