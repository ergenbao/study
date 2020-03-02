package offer;

/**
 * @Author: JH
 * @Date: 2019/4/3 18:28
 * 二叉搜索树的后序遍历序列
 *
 */
public class VerifySquenceOfBst {
//    public boolean verifySquenceOfBST(int [] sequence) {
//        if(sequence == null || sequence.length == 0) return false;
//        int start = 0,end = sequence.length-1;
//        return isSearchTree(sequence,start,end);
//    }
//    public boolean isSearchTree(int [] sequence,int start,int end){
//        if(end==start) return true;
//        int root = sequence[end];
//        int index = end;
//        for(int i = start;i<end;i++){
//            if(sequence[i] > root){
//                index = i;
//                break;
//            }
//        }
//        for(int i = index;i<end;i++)
//            if(sequence[i]< root)
//                return false;
//        if(index == end||index == start)// index = end 时没有右子树；index = start时没有左子树；
//            return isSearchTree(sequence,start,end-1);
//        else
//            return isSearchTree(sequence,start,index-1)&&isSearchTree(sequence,index,end-1);
//
//    }

    public boolean verifySquenceOfBst(int [] sequence) {
        if(sequence.length == 0) {
            return false;
        }
        int start = 0,end = sequence.length -1;
        return isSearchTree(sequence,start,end);
    }
    public boolean isSearchTree(int[] array,int start,int end) {
        if(start == end) {
            return true;
        }
        int root = array[end];
        int index = 0;
        for (int i = start;i<end;i++) {
            if (array[i] > root) {
                //index为右子树的根节点
                index =i;
                break;
            }
        }
        for(int i = index ;i<end;i++) {
            if(array[i]< root) {
                return false;
            }
        }
        if(index == start || index == end) {
            return isSearchTree(array,start,end -1);
        }else {
            return isSearchTree(array,start,index -1) && isSearchTree(array,index,end-1);
        }


    }

}
