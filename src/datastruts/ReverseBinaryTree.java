package datastruts;

import java.util.LinkedList;
import java.util.Queue;

public class ReverseBinaryTree {
	public static void main(String[] args) {
		BiTree root = new BiTree(5);
		root.left = new BiTree(6);
		root.right = new BiTree(8);
		root.left.left = new BiTree(9);
		root.left.right = new BiTree(4);
		root.right.left = new BiTree(2);
		root.right.right = new BiTree(7);
		print(root);
		reverse(root);
		print(root);
	}

	private static BiTree reverse(BiTree root) {
		if(root==null) return null;
		root.left = reverse(root.left);
		root.right = reverse(root.right);
		swap(root);
		return root;
	}

	private static void swap(BiTree root) {
		BiTree tmp = root.left ;
		root.left = root.right;
		root.right = tmp;
	}

	private static void print(BiTree root) {
		Queue<BiTree> q = new LinkedList<BiTree>();
		q.offer(root);
		while(!q.isEmpty()){
			BiTree b = q.poll();
			System.out.print(b.value + "\t");
			if(b.left!=null){
				q.offer(b.left);
			}
			if(b.right!=null){
				q.offer(b.right);
			}
		}
		System.out.println();
	}
}
