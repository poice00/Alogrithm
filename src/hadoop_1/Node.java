package hadoop_1;

public class Node {
	int value;
	Node next;
	public Node(int value) {
		super();
		this.value = value;
	}
	int length(){
		int i = 0 ;
		while(next!=null){
			next = next.next;
			i++;
		}
		return i;
	}
}
