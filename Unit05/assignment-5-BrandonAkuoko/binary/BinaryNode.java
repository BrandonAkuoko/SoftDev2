package binary;

public class BinaryNode<E>{
    private E value;
    private BinaryNode<E> left;
    private BinaryNode<E> right;

    public BinaryNode(E value, BinaryNode<E> left, BinaryNode<E> right){
        this.value = value;
        this.left = left;
        this.right = right;
    }
    public BinaryNode(E value){
        this(value, null, null);
    }

    public E getValue(){return this.value;}
    public void setValue(E value){this.value = value;}

    public BinaryNode<E> getLeft(){return this.left;}
    public void setLeft(BinaryNode<E> left){this.left = left;}

    public BinaryNode<E> getRight(){return this.right;}
    public void setRight(BinaryNode<E> right){this.right = right;}

    @Override
    public String toString(){return "BinaryNode{ value = " + value + " left = " + left + " right = " + right + "}";}

    public String infixTraversal(){
        String string = "";
        if(left != null){

        
        string += left.infixTraversal();
        }

        string += this.value + " ";

        if(right != null){
            string += right.infixTraversal();
        }
        return string;
    }
    public boolean search(E target){
        if(this.value == target){return true;}
        boolean found = false;
        if(left != null){found = left.search(target);}
        if(!found && right != null){found = right.search(target);}
        return found;
    }
}
