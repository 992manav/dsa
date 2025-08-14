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

                if(first == null){    //pehli gadbadi ka phela first waala badawala  uthao 
                    first = prev;
                }

                second = curr;        //dusri gadbadi ka seoc uthao chhota  waala 
                                       //agar dursti naa mili kabhi toh yeh akeli gadbadi kao aapas mein swap kardo 
                                       //isliye curr ko second mein store kardo aga r dusri mili toh toh apne aap second mein usk dursri gadbadi ka chhpt isme sitore ho jaega
            }

        }

        this.prev = curr;
    }

    public void recoverTree(TreeNode root) {
        
        //Morris Travesal + 2 cases
        curr = root;

        while(curr != null){

            if(curr.left == null){

                //print
                check(curr, prev);

                curr = curr.right;
            }else{

                TreeNode IP = findInorderPredecessor(curr);

                //2 cases 
             
                if(IP.right == null){    // pehli baar left mein jaaoge  toh vaapis aane ka intajaam karna padega

                    IP.right = curr;
                    curr = curr.left;
                
                }else{      //left traverse ho chuka hai aur left travese khatam hone ke naaad vaapi aaya hun parent matlab current ke paas

                    //delete karo yeh extra connection
                    IP.right = null;

                    //delete karne kae baad ab left toh sab ho gaya hai toh ab inoporder ke hissab se ab yeh nopde ko print karpo
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
