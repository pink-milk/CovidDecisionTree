/**
*binary tree node.
*@author MaiVi Vuong
*@param <T> tag
*/
public class BinaryNode<T> {
    /**data in node.*/
    public T data;
    /**left child node.*/
    public BinaryNode<T> leftChild;
    /**right child node.*/
    public BinaryNode<T> rightChild;
    
    /**node constructor.*/
    public BinaryNode(){
        this.data=null;
        leftChild=null;
        rightChild=null;
    }
    
    /**node constructor.
    *@param data for constructor
    */
    public BinaryNode(T data){
        this.data=data;
        leftChild=null;
        rightChild=null;
    }
    
    /**node constructor.
    *@param data for constr.
    *@param leftNode of curr
    *@param rightNode of curr
    */
    public BinaryNode(T data,BinaryNode<T> leftNode,BinaryNode<T> rightNode){
        this.data=data;
        leftChild=leftNode;
        rightChild=rightNode;
    }
    
    /**node set.
    *@param data to set node
    */
    public void setData(T data){
        this.data=data;
    }
    
    /**node get.
    *@return data get from node
    */
    public T getData(){
        return this.data;
    }
    
    /**node set child.
    *@param leftNode set to leftchild
    */
    public void setLeftChild(BinaryNode<T> leftNode){
        leftChild=leftNode;
    }
    
    /**node get left child.
    *@return leftNode get from leftchild
    */
    public BinaryNode<T> getLeftChild(){
        return leftChild;
    }
    
    /**node set child.
    *@param rightNode set to rightchild
    */
    public void setRightChild(BinaryNode<T> rightNode){
        rightChild=rightNode;
    }
    
    /**node get child.
    *@return righttNode get from righttchild
    */
    public BinaryNode<T> getRightChild(){
        return rightChild;
    }
    
    /**check if node has left.
    *@return boolean if node has leftchild
    */
    public boolean hasLeftChild(){
        if(leftChild==null){
            return false;
        }
        else{return true;}
    }
    
    /**check if node has right.
    *@return boolean if node has rightchild
    */
    public boolean hasRightChild(){
        if(rightChild==null){
            return false;
        }
        else{return true;}
    }
    
    /**check if node is leaf.
    *@return boolean if node is leafd
    */
    public boolean isLeaf(){
        if((hasLeftChild()==false)&&(hasRightChild()==false)){
            return true;
        }
        else{
            return false;
        }
    }
    /**find height.
    *@return height of node
    */
    public int getHeight(){
        if(this==null){
            return -1;         
        } 
        
        int leftHeight=0;
        int rightHeight=0;
        if(leftChild!=null){
            leftHeight= 1+leftChild.getHeight();
        }
        if(rightChild!=null){
            rightHeight= 1+rightChild.getHeight();
        }
        
        return Math.max(leftHeight,rightHeight);
        
    }
    
    /**find num of nodes.
    *@return num of nodes in tree
    */
    public int getNumberOfNodes(){
        if(this==null){
            return 0;
        }
        int leftHeight=0;
        int rightHeight=0;
        if(this.leftChild!=null){
            leftHeight= this.leftChild.getNumberOfNodes();
        }
        if(this.rightChild!=null){
            rightHeight= this.rightChild.getNumberOfNodes();
        }
        
        return leftHeight+rightHeight+1;
    }
    
    /**copy tree.
    *@return copied tree root
    */
    public BinaryNode<T> copy(){
        if(this.data==null){
            throw new EmptyTreeException("No tree to process");
        }
        
        BinaryNode<T> root=new BinaryNode<T>(this.data,this.leftChild,this.rightChild);
        this.leftChild.copy();
        this.rightChild.copy();
        
        return root;
    }
    
    /*public static void main(String[] args) {
        BinaryNode<String> b = new BinaryNode<String>("B");
        BinaryNode<String> f=new BinaryNode<String>();
        b.setLeftChild(f);
        
        //System.out.println("empty node f data is: "+f.getData());
        
        BinaryNode<Integer> b2 = new BinaryNode<Integer>(2);
        BinaryNode<Integer> b3 = new BinaryNode<Integer>(3);
        BinaryNode<Integer> b1 = new BinaryNode<Integer>(1);
        
        
        BinaryNode<Integer> b5 = new BinaryNode<Integer>(5);
        
        BinaryNode<Integer> b4 = new BinaryNode<Integer>(4);
        
        b2.setLeftChild(b4);
        b2.setRightChild(b5);
        
        b1.setLeftChild(b2);
        b1.setRightChild(b3);
        
        System.out.println("Height is: "+b1.getHeight());
        System.out.println("Number of Nodes is: "+b1.getNumberOfNodes());
    
    }  */
}