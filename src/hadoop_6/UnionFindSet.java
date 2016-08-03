package hadoop_6;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UnionFindSet {
	private int N;
	private int[] parent;
	private boolean[] visited;
	
	public UnionFindSet(int N) {
		this.N = N;
		parent = new int[N];
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			parent[i] = i;
		}
	}
	//查
	public int find(int i){
		if(i<0 || i>=N) return -1 ;
		int root = i ;
		while(root!=parent[root]){
			root=parent[root];
		}
		//压缩路径
		int t = i,p= 0 ;
		while(parent[t]!=root){
			 p = parent[t];
			 parent[t] = root;
			 root = p ;
		}
		return root; 
	}
	//并
	public void  union(int i,int j){
		int ri = find(i);
		int rj = find(j);
		if(ri!=rj){
			if(visited[i]==false && visited[j]==false){
				parent[rj] = ri;
				visited[i]=true;
				visited[j]=true;
			}else if (visited[i]==true && visited[j]==false){
				parent[rj] = ri;
				visited[j]=true;
			}else if (visited[j]==true && visited[i]==false){
				parent[ri] = rj;
				visited[i]=true;
			}
		}
	}
	
	public int getN() {
		return N;
	}
	public void setN(int n) {
		N = n;
	}
	public int[] getParent() {
		return parent;
	}
	public void setParent(int[] parent) {
		this.parent = parent;
	}
	public static void main(String[] args) {
		int N = 10 ;
		UnionFindSet ufs = new UnionFindSet(N);
		
		ufs.union(2, 6);
		ufs.union(5, 6);
		ufs.union(1, 8);
		ufs.union(2, 9);
		ufs.union(5, 3);
		ufs.union(4, 8);
		ufs.union(4, 0);
		System.out.println(Arrays.toString(ufs.getParent()));
		System.out.println(Arrays.toString(ufs.getVisited()));
		Set<Integer> num = new HashSet<Integer>();
		for (int i = 0; i < N; i++) {
			if(ufs.getVisited()[i]==true){
				num.add(ufs.getParent()[i]);
			}
		}
		System.out.println("共有" + num.size() + "个城市");
		int []path = {0,1,2,1,6,3,8,5};// 1,2,3,4,5,6,7,8
		int []a = {1,2,3,4,5,6,7,8};
		int i = 7;
		System.out.println(a[i]);
		while(i!=path[i]){
			i = path[i] ;
			System.out.println(a[i]);
		}

	}
	public boolean[] getVisited() {
		return visited;
	}
	public void setVisited(boolean[] visited) {
		this.visited = visited;
	}
}
