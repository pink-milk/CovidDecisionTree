/**
*bin tree class.
*@author MaiVi Vuong
*@param <T> tag
*/
public class BinaryTree<T> implements BinaryTreeInterface<T> {
    
    /**root node.*/
    public BinaryNode<T> root;
    
    /**constructor.*/
    public BinaryTree(){
        root=new BinaryNode<T>();
    }
    
    /**constructor.
    *@param data at root
    */
    public BinaryTree(T data){
        root=new BinaryNode<T>(data);
    }
    
    /**constructor.
    *@param data at root
    *@param leftTree left node
    *@param rightTree rightNode
    */
    public BinaryTree(T data,BinaryTree<T> leftTree, BinaryTree<T> rightTree){
        root=new BinaryNode<T>(data, leftTree.root,rightTree.root);
    }
    
    /**setter.
    *@param data at root
    *@param leftTree left node
    *@param rightTree rightNode
    */
    public void setTree(T data,BinaryTree<T> leftTree, BinaryTree<T> rightTree){
        this.root.data=data;
        
        if(leftTree!=null){        
            this.root.setLeftChild(leftTree.root);
        }
        
        if(rightTree!=null){
            this.root.setRightChild(rightTree.root);
        }
    }
    
    /**displays all nodes inorder.*/
    public void inorderTraversal(){
        if(root==null){
            throw new EmptyTreeException("No tree to process");
        }
        privinorderTraversal(root);
        
    }
    
    /**displays all nodes inorder.
    *@param root of tree
    */
    private void privinorderTraversal(BinaryNode<T> root){
        if(root==null){
            throw new EmptyTreeException("No tree to process");
        }

        privinorderTraversal(root.leftChild);
        System.out.println(root.data+" ");
        privinorderTraversal(root.rightChild);
    }
    
    /**get root.
    *@return data at root
    */
    public T getRootData(){
        if(root==null){
            throw new EmptyTreeException("No tree to process");
        }
        if(root.data==null){
            throw new EmptyTreeException("No tree to process");
        }
        return this.root.data;
    }
    
    /**return root node.
    *@return node at root*/
   	public BinaryNode<T> getRootNode(){
        return this.root;
    }
     
    /**set node at root.
    *@param node is set
    */
   	public void setRootNode(BinaryNode<T> node){
        this.root=node;
    }
    
    /**find heihgt.
    *@return height of tree*/
   	public int getHeight(){
        if(root==null) return -1;
        
        else{
            return root.getHeight();
        }
    }
    
    /**num nodes in tree.
    *@return number of nodes in tree
    */
   	public int getNumberOfNodes(){
        if(root==null) return -1;
        
        else{
            return root.getNumberOfNodes();
        }
    }
    
    /**checks if tree empty.
    @return true if empty
    */
   	public boolean isEmpty(){
        if(root==null)return true;
        else return false;
    }
    
    /**clears tree.*/
   	public void clear(){
        root=null;
    }
    
    /*public static void main(String[] args) {
        
        //System.out.println("empty node f data is: "+f.getData());
        
        BinaryTree<Integer> b2 = new BinaryTree<Integer>();
        BinaryTree<Integer> b3 = new BinaryTree<Integer>(3);
        BinaryTree<Integer> b1 = new BinaryTree<Integer>();
        
        
        BinaryTree<Integer> b5 = new BinaryTree<Integer>(5);
        
        BinaryTree<Integer> b4 = new BinaryTree<Integer>(4);
        
        BinaryTree<Integer> empty = new BinaryTree<Integer>();
        b2.setTree(2, empty,b5);
        
        b1.setTree(1,b2,b3);
        
        //System.out.println("empty.root.data is: "+empty.isEmpty());
        System.out.println("Height is: "+b1.getHeight());
        
        System.out.println("Num Nodes is: "+b1.getNumberOfNodes());

        
    }*/

}