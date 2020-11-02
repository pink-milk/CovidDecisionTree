import java.util.*;
import java.io.File;
import java.io.IOException;
/**
*bin tree interface.
*@author MaiVi Vuong
*/
public class CovidHealthBuilder {
    /**healthTree.*/
    public DecisionTreeInterface<String> healthTree;
    /**arrlist.*/
    private ArrayList<String> fileArr;
    
    /**
	*Constructor.
	*@param fileName is name of file
    */ 
    public CovidHealthBuilder(String fileName){
        fileArr=readData(fileName);
        
        healthTree=new DecisionTree<String>(fileArr.get(0));
       
        healthTree.setRootNode(buildTree(fileArr,healthTree.getRootNode(),0));
    
    }
    
    /**
    *turn file into array.
    *@param fileName of file
    *@return file as array
	*/
    public ArrayList<String> readData(String fileName){
        ArrayList<String> read= new ArrayList<String>();
        File text=new File(fileName);
        
        try
        {
            Scanner treeScanner;
       
            treeScanner = new Scanner(text);
        
            while(treeScanner.hasNextLine()) {
                String s = treeScanner.nextLine();
                if(s.length() == 0) {
                    return read;
                }
                String[] parts=s.split(",");
            
                for(int i=0;i<parts.length;i++){
                    parts[i]=parts[i].trim();
                    read.add(parts[i]);
                }
            }
        }
        catch(IOException e) 
        {
            System.out.println("Invalid file");
        }
        
        return read;
    }
    
    /**
    *build tree from array.
    *@param fileArr of file
    *@param root of tree
    *@param index i of arr
    *@return tree from array
	*/
    public BinaryNode<String> buildTree(ArrayList<String> fileArr, BinaryNode<String> root, int index){
        
        if(index<fileArr.size()){
            if(fileArr.get(index).contains("null")==true){
                BinaryNode<String> n=null;
                root=n;
            }
            else{
                BinaryNode<String> n=new BinaryNode<String>(fileArr.get(index));
                root=n;
                root.leftChild=buildTree(fileArr, root.leftChild, 2*index+1);
                root.rightChild=buildTree(fileArr, root.rightChild, 2*index+2);
            }
        }
        return root;
    }
    
    /**
    *user decides.
    */
    public void decide(){
      
        if(healthTree.getRootData()==null){
            throw new EmptyTreeException("No tree to process");
        }
        healthTree.resetCurrentNode();
       
        Scanner scnr= new Scanner(System.in);
       
        while(healthTree.isAnswer()==false){
            System.out.println(healthTree.getCurrentNode().getData());
      
            String yn=scnr.nextLine();
           
            if(yn.contains("yes")){
                healthTree.moveToYes();
            }
            else if(yn.contains("no")){
                healthTree.moveToNo();
            }
            else{
                System.out.println("Enter yes or no");
            }
        }
       
        System.out.println(healthTree.getCurrentNode().getData());
        System.out.println("\nSatisfied by my intelligence?\n");
      
        String yn=scnr.nextLine();
           
        if(yn.contains("yes")){
            return;
        }
        else if(yn.contains("no")){
            learn();
        }
    }
    /**
    *user changes tree.
    */
    public void learn(){
        String oldAns=healthTree.getCurrentNode().getData(); //fit
   
        System.out.println("What should be the answer?");
       
        Scanner scnr=new Scanner(System.in);
       
        String newAns=scnr.nextLine();        
        System.out.println("Give me a question whose answer is yes for "+newAns+" but no for "+oldAns);
       
        String question=scnr.nextLine();
      
        updateTree(question,oldAns,newAns);
    }
    /**
    *tree updates for user.
    *@param question string
    *@param noAnswer root
    *@param yesAnswer rightroot
    */
    public void updateTree(String question, String noAnswer, String yesAnswer){
        healthTree.getCurrentNode().setData(question);
        healthTree.setResponses(noAnswer,yesAnswer);
    }
    
    /**
    *healthtree.
    *@return healthTree
    */
    public DecisionTree<String> getHealthTree(){
        return (DecisionTree<String>)this.healthTree;
    }
}