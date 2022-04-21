package binary;

public class BinarySearchTree<E extends Comparable<E>>{
    private BinaryNode<E> root;
    private int size;

    public BinarySearchTree(E initValue){
        root = new BinaryNode<E>(initValue);
        size = 1;
    }
    public int getSize(){return this.size;}
    
    /**
     * This function searches through a node and returns true for certain situations
     * @param root
     * @param target
     * @return
     */
    public boolean binarySearch(BinaryNode<E> root, E target){
        if(root.getValue() == target){return true;}
        if(root.getLeft()!= null && target.compareTo(root.getValue()) < 0){
            if(binarySearch(root.getLeft(), target) == true){
                return true;
            }
        }
        else if(root.getRight() != null){
            if(binarySearch(root.getRight(), target)){
                return true;
            }
        }
        return false;
    }
    /**
     * Not sure why we created this function as this does not serve any purpose
     * @param target
     * @return
     */
    private boolean search(E target){
        if(binarySearch(this.root, target)){
            return true;
        }
        return false;
    }
    /**
     * This function inserts the certain value into a node and searches to make sure the node is empty and then creates a new value in that node
     * @param root
     * @param value
     */
    public void binaryInsert(BinaryNode<E> root, E value){
        if(value.compareTo(root.getValue()) < 0){
            if(root.getLeft() == null){
                root.setLeft(new BinaryNode<>(value));
            }
            else{
                binaryInsert(root.getLeft(), value);
            }
        }
        else{
            if(value.compareTo(root.getValue()) > 0){
                if(root.getRight() == null){
                    root.setRight(new BinaryNode<>(value));
                }
                else{
                    binaryInsert(root.getRight(), value);
                }
            }
        }
    }
    public void binaryInsert(E value){
        binaryInsert(root, value);
    }

    @Override
    public String toString(){
        return root.infixTraversal(); 
    }

    public static void main(String[] args) {
        BinarySearchTree<Pokemon> tree = new BinarySearchTree<>(new Pokemon ("gyrados", 130));
        tree.binaryInsert(new Pokemon ("charmander", 4));
        tree.binaryInsert(new Pokemon ("squirtle", 7));
        tree.binaryInsert(new Pokemon ("magicarp", 129));
        tree.binaryInsert(new Pokemon ("raichu", 26));

        System.out.println (tree);

    }

    
}
