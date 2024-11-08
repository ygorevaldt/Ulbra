public class BinaryTree {
    private Node root;

    public BinaryTree(Node root) {
        this.root = root;
    }

    public void insert(int value) {
        this.root = this.insertRecursive(root, value);
    }

    private Node insertRecursive(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }

        if (value < root.getValue()) {
            root.setLeft(this.insertRecursive(root.getLeft(), value));
        }
        else if (value > root.getValue()) {
            root.setRight(this.insertRecursive(root.getRight(), value));
        }

        return root;
    }

    public Boolean fetch(int value) {
        return this.fetchRecursive(this.root, value);
    }

    private Boolean fetchRecursive(Node node, int value) {
        if (node == null) return false;

        if (node.getValue() == value) return true;

        if (node.getValue() < value) 
            return this.fetchRecursive(node.getLeft(), value);

        return this.fetchRecursive(node.getRight(), value);
    }

    public void printInOrder() {
        this.printInOrderRecursive(root);
        System.out.println();
    }

    private void printInOrderRecursive(Node node) {
        if (node == null) return;

        this.printInOrderRecursive(node.getLeft());
        System.out.println(node.getValue() + " ");
        this.printInOrderRecursive(node.getRight());
    }

    public void printInPreOrder() {
        this.printInPreOrderRecursive(root);
        System.out.println();
    }

    private void printInPreOrderRecursive(Node node) {
        if (node == null) return;

        System.out.println(node.getValue() + " ");
        this.printInPreOrderRecursive(node.getLeft());
        this.printInPreOrderRecursive(node.getRight());
    }

    public void printInPosOrder() {
        this.printInPosOrderRecursive(root);
        System.out.println();
    }

    private void printInPosOrderRecursive(Node node) {
        if (node == null) return;

        this.printInPosOrderRecursive(node.getLeft());
        this.printInPosOrderRecursive(node.getRight());
        System.out.println(node.getValue() + " ");
    }

    public void remove(int value) {
        this.root = this.removeRecursive(root, value);
    }

    private Node removeRecursive(Node root, int value) {
        if (root == null) return root;
    
        if (value < root.getValue()) {
            root.setLeft(this.removeRecursive(root.getLeft(), value));
        } else if (value > root.getValue()) {
            root.setRight(this.removeRecursive(root.getRight(), value));
        } else {
            if (root.getLeft() == null && root.getRight() == null) return null;
            
            if (root.getLeft() == null) return root.getRight();
            if (root.getRight() == null) return root.getLeft();
    
            Node successor = this.fetchSmallest(root.getRight());
            root.setValue(successor.getValue());
            root.setRight(removeRecursive(root.getRight(), successor.getValue()));
        }
    
        return root;
    }
    
    private Node fetchSmallest(Node root) {
        while (root.getLeft() != null) {
            root = root.getLeft();
        }
        return root;
    }

    public int getHeight() {
        return this.getHeightRecursive(this.root);
    }
    
    private int getHeightRecursive(Node node) {
        Boolean emptyTree = node == null;
        if (emptyTree) return -1;

        int leftHeight = this.getHeightRecursive(node.getLeft());
        int rightHeight = this.getHeightRecursive(node.getRight());
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public int getNodesAmount() {
        return getNodesAmountRecursive(this.root);
    }
    
    private int getNodesAmountRecursive(Node node) {
        Boolean emptyTree = node == null;
        if (emptyTree) return 0;
        
        int leftTotal = this.getNodesAmountRecursive(node.getLeft());
        int rightTotal = this.getNodesAmountRecursive(node.getRight());
        return 1 + leftTotal + rightTotal;
    }

    public int getLeavesAmount() {
        return getLeavesAmountRecursive(this.root);
    }
    
    private int getLeavesAmountRecursive(Node node) {
        if (node == null) return 0;

        if (node.getLeft() == null && node.getRight() == null) {
            return 1;
        } 
        
        int sumLeft = this.getLeavesAmountRecursive(node.getLeft());
        int sumRight = this.getLeavesAmountRecursive(node.getRight());

        return sumLeft + sumRight;
    }

    public int getDepth(int value) {
        return getDepthRecursive(this.root, value, 0);
    }
    
    private int getDepthRecursive(Node node, int value, int depth) {
        if (node == null) return -1; 
    
        if (node.getValue() == value) return depth;
    
        int leftDepth = this.getDepthRecursive(node.getLeft(), value, depth + 1);
        if (leftDepth != -1) return leftDepth;
    
        return this.getDepthRecursive(node.getRight(), value, depth + 1);
    }
}
