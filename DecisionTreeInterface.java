/**
*decision tree interface.
*@author MaiVi Vuong
*@param <T> tag
*/
public interface DecisionTreeInterface<T> extends BinaryTreeInterface<T> {
    /** check for answer.
    *@return true if node contains final answer.*/
    public boolean isAnswer();
    
    /**set current node to left child.*/
   	public void moveToNo(); 
    
    /**set current node to right child.*/
   	public void moveToYes();
        
    /**set current node to root.*/
   	public void resetCurrentNode();
     
    /**get curr.
    *@return current node.*/
   	public BinaryNode<T> getCurrentNode();
    
    /**set data in children of curr node.
    @param responseForNo check
    @param responseForYes check*/
   	public void setResponses(T responseForNo, T responseForYes);
   
   	
}