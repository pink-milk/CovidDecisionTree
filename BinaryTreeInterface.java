/**
*bin tree interface.
*@author MaiVi Vuong
*@param <T> tag
*/
public interface BinaryTreeInterface<T> {
    /**get root.
    *@return data at root
    */
    public T getRootData();
    
    /**return root node.
    *@return node at root*/
   	public BinaryNode<T> getRootNode();
     
    /**set node at root.
    *@param node is set
    */
   	public void setRootNode(BinaryNode<T> node);
    
    /**find heihgt.
    *@return height of tree*/
   	public int getHeight(); 
    
    /**num nodes in tree.
    *@return number of nodes in tree
    */
   	public int getNumberOfNodes();
    
    /**checks if tree empty.
    @return true if empty
    */
   	public boolean isEmpty();
    
    /**clears tree.*/
   	public void clear();
   
   	
}