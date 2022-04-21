package binary;

public class MainBinaryNode {
    public static String infixTraversal(BinaryNode node){
        // left middlenode right
        String string = "";
        if(node != null){
            
            string += infixTraversal(node.getLeft());
            string += node.getValue() + " ";
            string += infixTraversal(node.getRight());

        }
        return string;
    }
    public static void main(String[] args) {
        BinaryNode root = new BinaryNode(2, 
        new BinaryNode(3, new BinaryNode(9), new BinaryNode(4)), 
        new BinaryNode(7, new BinaryNode(1), new BinaryNode(6)));
        
        // root.setLeft(new BinaryNode(3));
        // root.setRight(new BinaryNode(7));
        // root.getLeft().setLeft(new BinaryNode(9));
        // root.getLeft().setRight(new BinaryNode(4));
        // root.getRight().setLeft(new BinaryNode(1));
        // root.getRight().setRight(new BinaryNode(6));
        // String string = infixTraversal(root);
        // System.out.println(string);
        // System.out.println(root); // 9 3 4 || 2 || 1 7 6  

        
        // System.out.println(root.search(9));
        BinaryNode node = new BinaryNode(10);
        node.binaryInsert(10);
        node.binaryInsert(5);
        node.binaryInsert(25);
        node.binaryInsert(1);
        node.binaryInsert(19);
        node.binaryInsert(20);
        System.out.println(node.infixTraversal()); 
        System.out.println(node.binarySearch(20));;

    }
    
}
