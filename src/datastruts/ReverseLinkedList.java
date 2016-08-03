package datastruts;

public class ReverseLinkedList {
	public static void main(String[] args) {
		Node head = new Node(0);
		for (int i = 0; i < 6; i++) {
			Node node = new Node((int)(Math.random()*10)); 
			node.next = head.next;
			head.next = node ;
		}
		print(head);
		System.out.println();
		System.out.println("===翻转后===");
		//1.头插翻转
//		Node node = reverse(head);
//		print(node);
		//2.就地翻转
		Node node = reverse2(head);
		print(node);
	}

	private static Node reverse2(Node head) {
		head = head.next;
		Node cur = head.next;
		Node next;
		head.next = null;
		while(cur!=null){//就地翻转
			next = cur.next;
			cur.next = head ;
			head = cur ;
			cur = next ;
		}
		Node pead = new Node(0);
		pead.next = head ;
		return pead;
	}
	private static Node reverse(Node head) {
		Node cur = head.next;
		Node next;
		head.next = null;
		while(cur!=null){//头插翻转
			next = cur.next;
			cur.next = head.next ;
			head.next = cur ;
			cur = next ;
		}
		return head;
	}

	private static void print(Node head) {
		while(head.next!=null){
			head = head.next;
			System.out.print(head.value + "\t");
		}
	}
}
