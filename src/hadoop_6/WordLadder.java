package hadoop_6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

/**
 * 单词变换问题
 * @author ssy
 * start = "hit"
 * end= "cog"
 * dict = [hot,dot,dog,lot,log]
 * hit->hot->dot->dog->cog
 */
public class WordLadder {
	public static void main(String[] args) {
		String start = "hit" ;
		String end = "cog" ;
		String []dic = {"hot","dot","dog","lot","log"};
		Set<String> dict = new TreeSet<String>();
		for (String s : dic) {
			dict.add(s);
		}
		System.out.println(start);
		System.out.println(end);
		System.out.println(dict);
		System.out.println(calcLadderLength(start,end,dict));
		System.out.println(ladderLength(start, end, dict));
	}
	

	private static int calcLadderLength(String start, String end,
			Set<String> dict) {
		Queue<String> q = new LinkedList<String>();
		Set<String> visit = new TreeSet<String>();
		int step = 0 ;
		int curNumber = 1 ;
		int nextNumber = 0 ;
		q.offer(start);
		while(!q.isEmpty()){
			String cur = q.poll();
			curNumber -- ;
			List<String> children = extend(cur,dict,end,visit);
			System.out.println("--" + children);
			System.out.println("curNumber:" + curNumber);
			nextNumber += children.size();
			while(curNumber==0){
				step ++;
				curNumber = nextNumber ;
				nextNumber = 0 ;
			}
			for (String child : children) {
				if(child.endsWith(end)) return step;
				q.offer(child);
			}
		}
		return 0;
	}
	/**
	 * 
	 * @param cur 当前单词
	 * @param dict 字典
	 * @param end 结束的单词
	 * @param visit 遍历过的单词
	 * @return 可以直达的单词
	 */
	private static List<String> extend(String cur, Set<String> dict,
			String end, Set<String> visit) {
		List<String> childrenList = new ArrayList<String>();
		StringBuilder child = new StringBuilder(cur) ;
		for (int i = 0; i < cur.length(); i++) {
			char t  = child.charAt(i);
			for (char c = 'a'; c !='z'; c++) {
				if(c==t) continue;
				child.setCharAt(i, c);
				if(child.toString().equals(end) || (dict.contains(child.toString()) &&  !visit.contains(child.toString()))){
					childrenList.add(child.toString());
					visit.add(child.toString());
				}
				
			}
			child.setCharAt(i, t);
		}
		return childrenList;
	}
	public static int ladderLength(String start, String end, Set<String> dict) {  
        if (start == null || end == null || start.equals(end)  
                || start.length() != end.length())  
            return 0;  
  
  
        Queue<String> queue=new LinkedList<String>();  
        HashMap<String,Integer> dist=new HashMap<String,Integer>();  
          
        queue.add(start);  
        dist.put(start, 1);  
          
        while(!queue.isEmpty())  
        {  
            String head=queue.poll();  
              
            int headDist=dist.get(head);  
            //从每一个位置开始替换成a~z  
            for(int i=0;i<head.length();i++)  
            {  
                for(char j='a';j<'z';j++)  
                {  
                    if(head.charAt(i)==j) continue;  
                      
                    StringBuilder sb=new StringBuilder(head);  
                    sb.setCharAt(i, j);  
                      
                    if(sb.toString().equals(end)) return headDist+1;  
                      
                    if(dict.contains(sb.toString())&&!dist.containsKey(sb.toString()))  
                    {  
                        queue.add(sb.toString());  
                        dist.put(sb.toString(), headDist+1);  
                    }  
                }  
            }  
        }  
        return 0;  
	}  
}
