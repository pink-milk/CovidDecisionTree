/**
*Decision tree class.
*@author MaiVi Vuong
*@param <T> tag
*/
public class DecisionTree<T> extends BinaryTree<T> implements DecisionTreeInterface<T> {
    /**current node.*/
    public BinaryNode<T> currentNode;
    
    /**constructor.*/
    public DecisionTree(){
        super();
        currentNode=new BinaryNode<T>();
        currentNode=null;
    }
    
    /**constructor.
    *@param data for dtree
    */
    public DecisionTree(T data){
        super(data);
        currentNode=new BinaryNode<T>();
        currentNode=null;
    }
    
    /**check for answer.
    *@return true if node contains final answer.*/
    public boolean isAnswer(){
        if(currentNode.isLeaf()){
            return true;
        }
        else return false;
    }
    
    /**set current node to left child.*/
    public void moveToNo(){
        if(currentNode==null){
            throw new EmptyTreeException("No tree to process");
        }
        currentNode=currentNode.getLeftChild();
    }
    
    /**set current node to right child.*/
   	public void moveToYes(){
        if(currentNode==null){
            throw new EmptyTreeException("No tree to process");
        }
        currentNode=currentNode.getRightChild();
    }
    
    /**set current node to root.*/
   	public void resetCurrentNode(){
        currentNode=root;
    }
    
    /**get curr.
    *@return current node.
    */
   	public BinaryNode<T> getCurrentNode(){
        return this.currentNode;
    }
    
    /**get curr.
    *@return current node data*/
    public T getCurrentData(){
        if(getCurrentNode()==null){
            throw new EmptyTreeException("No tree to process");
        }
        return getCurrentNode().getData();
    }
    
    /**set data in children of curr node.
    @param responseForNo check
    @param responseForYes check*/
   	public void setResponses(T responseForNo, T responseForYes){ 
        BinaryNode<T> no=new BinaryNode<T>(responseForNo);
        BinaryNode<T> yes=new BinaryNode<T>(responseForYes);

        currentNode.setLeftChild(no);
        currentNode.setRightChild(yes);
    }
    
    /**find num of nodes.
    *@return num of nodes in tree
    */
    public int getNumberOfNodes(){
        if(root==null){
            throw new EmptyTreeException("No tree to process");
        }
        return privgetNumberOfNodes(root);
    }
    
    /**find num of nodes.
    *@param root of node
    *@return num of nodes in tree
    */
    private int privgetNumberOfNodes(BinaryNode<T> root){
        if(root==null){return 0;}
        if(root.getData()==null){return 0;}
        
        
        int left=privgetNumberOfNodes(root.leftChild);
        int right=privgetNumberOfNodes(root.rightChild);
        return left+right+1;
        
    }
    
    
    /*public static void main(String[] args) {
        DecisionTree<String> dTree = new DecisionTree<>();
        dTree.setTree("D",null,null);
        DecisionTree<String> fTree = new DecisionTree<>();
        fTree.setTree("F",null,null);
        DecisionTree<String> gTree = new DecisionTree<>();
        gTree.setTree("G",null,null);
        DecisionTree<String> hTree = new DecisionTree<>();
        hTree.setTree("H",null,null);
        DecisionTree<String> eTree = new DecisionTree<>();
        eTree.setTree("E",fTree,gTree);
        DecisionTree<String> bTree = new DecisionTree<>();
        bTree.setTree("B",dTree,eTree);
        
        DecisionTree<String> empty = new DecisionTree<>();
        
        DecisionTree<String> cTree = new DecisionTree<>();
        cTree.setTree("C",empty,hTree);
        DecisionTree<String> aTree = new DecisionTree<>();
        aTree.setTree("A",bTree,cTree);
         
        aTree.resetCurrentNode();
        
        System.out.println(empty.root.data==null);
        System.out.println("NumNodes: "+aTree.getNumberOfNodes());
        System.out.println(aTree.getCurrentData());
    }*/
}