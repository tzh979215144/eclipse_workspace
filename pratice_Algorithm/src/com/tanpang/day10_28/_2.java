package com.tanpang.day10_28;


class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

public class _2 {
	public static void main(String[] args) {
		int[] pre={1,2,3,4};
		int[] in ={1,2,3,4};
		TreeNode t=reConstructBinaryTree(pre ,in);
		System.out.println(t);
		while(t!=null) {
			System.out.println("\t"+t.val);
			System.out.print(t.left.val+"\t");
			System.out.println(t.right.val+"\t");
			t=t.left;
		}
	}
    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre.length==0||in.length==0||pre.length!=in.length) {
        	return null;
        }
        int len = pre.length;
        return gogogo(pre,in,len);
    }

	public static TreeNode gogogo(int [] pre,int [] in, int len) {
		// TODO Auto-generated method stub
		//建立根节点
		TreeNode root = new TreeNode(pre[0]);
		System.out.println("root"+pre[0]);
		int flag=-1;
		boolean flagLeft= false;
		boolean flagRight=true;
		int[] preLeft= new int[len];
		int[] inLeft= new int[len];
		int[] preRight= new int[len];
		int[] inRight= new int[len];
		//找寻根节点在中序遍历中的位置下标
		for(int i=0;i<len;i++) {
			if(root.val==in[i]) {
				flag=i;
				System.out.println("i="+i+"***111111");//3
				if(i==0) {
					flagLeft=true;
				}
				continue;
			}
			if(flag==-1)
				System.out.println(in[i]+"****22222222");
				inLeft[i]=in[i];
			if(flag!=-1) {
				flagRight=false;
				System.out.println(in[i]+"*****33333"+"第"+i+"次");
				inRight[i-flag-1]=in[i];
			}
		}
		for(int i=0;i<flag;i++) {
			System.out.println("here"+pre[i+1]);
			preLeft[i]=pre[i+1];
		}
		for(int i=0;i<len-flag-1;i++) {
			System.out.println("there"+pre[i+flag+1]);
			preRight[i]=pre[i+flag+1];
		}
		System.out.println("flag!!!"+flag);
		if(flagLeft==true) {
			System.out.println("结束---------");
			root.left=null;
		}else {
			root.left=gogogo(preLeft,inLeft,flag);
		}
		
		if(flagRight==true) {
			System.out.println("结束++++++");
			root.right=null;
		}else {
			root.right=gogogo(preRight,inRight,len-flag-1);
		}
		
		return root;
	}
    
}
