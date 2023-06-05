package Tree;

class BinaryTree{
    public Node root;

    public void NewNode(String data){
        root=NewNode(root, new Node(data));
    }
    private Node NewNode(Node root, Node newData){
        if (root == null){
            root = newData;
            return root;
        }
        if (newData.data.compareTo(root.data) < 0) {
            root.left = NewNode(root.left, newData);
        }else{
            root.right = NewNode(root.right, newData);
        }
        return root;
    }
    public void inOrder(Node node){
        if(node!=null){
            inOrder(node.left);
            System.out.print(node.data+" ");
            inOrder(node.right);
        }
    }
    public void postOrder(Node node) {
        if (node!=null){
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data + " ");
        }
    }
    public void preOrder(Node node) {
        if (node!=null){
            System.out.print(node.data + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }
}