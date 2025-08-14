class Solution {
    TreeNode findInorderPredecessor(TreeNode curr){

        TreeNode IP = curr.left;

        while(IP.right != null && IP.right != curr){
            IP = IP.right;
        }

        return IP;

    }
    
    TreeNode curr;

    TreeNode prev = null;

    TreeNode first = null;
    TreeNode second = null;


    void check(TreeNode curr, TreeNode prev){
        if(prev != null){

            if(curr.val < prev.val){

                if(first == null){    //pehli gadbadi ka pehla first waala bada waala uthao 
                    first = prev;
                }

                second = curr;        //dusri gadbadi ka second uthao chhota waala 
                                       //agar dusri naa mili kabhi toh yeh akeli gadbadi ko aapas mein swap kardo 
                                       //isliye curr ko second mein store kardo agar dusri mili toh toh apne aap second mein uski dusri gadbadi ka chhota isme store ho jaega
            }

        }

        this.prev = curr;
    }

    public void recoverTree(TreeNode root) {
        
        //Morris Traversal + 2 cases
        curr = root;

        while(curr != null){

            if(curr.left == null){

                //print
                check(curr, prev);

                curr = curr.right;
            }else{

                TreeNode IP = findInorderPredecessor(curr);

                //2 cases 
             
                if(IP.right == null){    // pehli baar left mein jaaoge  toh vaapis aane ka intezaam karna padega

                    IP.right = curr;
                    curr = curr.left;
                
                }else{      //left traverse ho chuka hai aur left traverse khatam hone ke baad vaapas aaya hun parent matlab current ke paas

                    //delete karo yeh extra connection
                    IP.right = null;

                    //delete karne ke baad ab left toh sab ho gaya hai toh ab inorder ke hissab se ab yeh node ko print karlo
                    
                    //print
                    check(curr, prev);

                    curr = curr.right;

                }
                
            }

        }

        if(first != null && second != null){
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }

    }
}
