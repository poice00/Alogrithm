package hadoop_1;

public class ListReverse {
	public static void main(String[] args) {
		Node pHead = new Node(0);
		for (int i = 0; i < 10; i++) {
			Node n = new Node((int) (Math.random()*100));
			//头插法
			n.next = pHead.next;
			pHead.next = n;
		}
		print(pHead);
		reverseList(pHead,4,8);
		print(pHead);
		Node resultNode = reverseList(pHead);
		print(resultNode);
//		reverseList2(resultNode);
//		print(resultNode);
	}


	private static Node reverseList(Node pHead) {
		Node pCur= pHead.next;
		Node tmp;
		pHead.next=null;
		//头指针为空，只是一个标志，需要处理
	    while(pCur!=null){
	    	tmp=pCur.next;
	        pCur.next=pHead.next;//头插法
	        pHead.next=pCur;//头插法
	        pCur=tmp;//移动指针
	    }
	    //下面是一般情况
	    /*while(pCur!=null){
	    	tmp=pCur.next;
	        pCur.next=pHead;
	        pHead=pCur;//移动指针
	        pCur=tmp; //移动指针
	    }*/
	    return pHead;
	}
//	private static Node reverseList2(Node pHead) {
//		Node tmp;
//		Node pCur= pHead.next;
//		while(pCur!=null){
//	    	tmp=pCur.next;
//	        pCur.next=tmp.next;
//	        tmp.next=pHead.next;
//	        pHead.next=tmp;
//	    }
//		return pHead;
//	}
	private static void reverseList(Node pHead, int from, int to) {
		//三个指针
		Node pCur = pHead.next;
		for (int i = 0; i < from-1; i++) {
			pHead = pCur;
			pCur = pCur.next;
		}
		Node pPre = pCur;
		pCur = pCur.next;
		Node pNext;
		for (int i = 0; i < to-from-1; i++) {
			pNext = pCur.next;
			pCur.next = pHead.next;
			pHead.next = pCur;
			pPre.next = pNext;
			pCur = pNext;
		}
	}


	private static void print(Node pHead) {
		while(pHead.next!=null){
			pHead = pHead.next;
			System.out.print(pHead.value + "\t");
		}
		System.out.println();
	}
}
