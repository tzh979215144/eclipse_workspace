package com.tanpang.day11_01;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 思路：利用递归，如果此节点有左子树或者右子树，则将子节点下的左子树和右子树反转。
 * @author tanpang
 *
 */
public class 二叉树的镜像 {
    public void Mirror(TreeNode root) {
    	if(root==null) {return;}
        fan(root);
    }
    public static void fan(TreeNode n) {
    	if(n.left==null&&n.right==null) {return ;}
    	TreeNode s=n.left;
    	n.left=n.right;
    	if(n.left!=null)
    		fan(n.left);
    	n.right=s;
    	if(n.right!=null)
    		fan(n.right);
    }
}