package com.tanpang.day11_01;

import java.util.ArrayList;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}
/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * 思路：定位树B的根节点在树A的位置--->遍历树B的所有节点，与树A比较，若有不匹配的，则return false
 * 			若一直到叶子节点结束都没有不匹配，则return true
 * 
 * 难点：
 * @author tanpang
 *
 */
public class 树的子结构 {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        
    	if(root2==null||root1==null) {return false;}
    	
    	ArrayList<TreeNode> save=new ArrayList<TreeNode>();
    	dingwei(root1,root2.val,save);
    	if(save.isEmpty()) {
    		return false;
    	}
    	TreeNode r=root2;
    	for(TreeNode t:save) {
    		System.out.println(t.val+"：次数");
    		if(pan(t, r)) {return true;}
    	}
    	return false;
    	
    }
    /**
     * 这里是核心的判断
     * @param a
     * @param b
     * @return
     */
    public boolean pan(TreeNode a,TreeNode b) {
    	if(a.val!=b.val) {return false;}
    	if(b.left!=null) {
    		if(a.left==null) {return false;}
    		if(!pan(a.left,b.left)) {
    			return false;
    		}
    	}
    	if(b.right!=null) {
    		if(a.right==null) {return false;}
    		if(!pan(a.right,b.right)) {
    			return false;
    		}
    	}
    	return true;
    }
    /**
     * 这里是定位根节点
     * @param n
     * @param a
     * @param save
     * @return
     */
    public ArrayList<TreeNode> dingwei(TreeNode n,int a,ArrayList<TreeNode> save) {
    	 if(n.val==a) {save.add(n);}
    	 if(n.left!=null) {
    		dingwei(n.left,a,save);
    	 }
    	 if(n.right!=null) {
    		  dingwei(n.right,a,save);
    	 }
    	 return save;
    }
}