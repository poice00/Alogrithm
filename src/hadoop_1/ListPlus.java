package hadoop_1;

public class ListPlus {
	public static void main(String[] args) {
		Node pHead = new Node(0);
		for (int i = 0; i < 6; i++) {
			Node n = new Node((int) (Math.random()*10));
			//头插法
			n.next = pHead.next;
			pHead.next = n;
		}
		print(pHead);
		Node pHead2 = new Node(0);
		for (int i = 0; i < 9; i++) {
			Node n = new Node((int) (Math.random()*10));
			//头插法
			n.next = pHead2.next;
			pHead2.next = n;
		}
		print(pHead2);
		Node resultNode = add(pHead , pHead2);
		print(resultNode);
	}

	private static Node add(Node pHead, Node pHead2) {
		Node pSum = new Node(0);
		Node ptail = pSum;
		Node p1 = pHead.next;
		Node p2 = pHead2.next;
		Node pCur;
		int carry = 0;
		int value = 0;
		while(p1!=null && p2!=null){
			value = p1.value + p2.value + carry;
			carry = value / 10 ;
			value %= 10 ;
			pCur = new Node(value);
			ptail.next = pCur;
			ptail = pCur;
			
			p1 = p1.next;
			p2 = p2.next;
		}
		Node p = p1!=null ? p1 :p2 ;
		while(p!=null){
			value = p.value + carry;
			carry = value / 10 ;
			value %= 10 ;
			pCur = new Node(value);
			ptail.next = pCur;
			ptail = pCur;
			
			p = p.next;
		}
		if(carry!=0) ptail.next = new Node(carry);
		return pSum;
	}

	private static void print(Node pHead) {
		while(pHead.next!=null){
			pHead = pHead.next;
			System.out.print(pHead.value + "\t");
		}
		System.out.println();
	}
}
