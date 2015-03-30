package practice;



class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
}


public class RemoveN {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int N=n;
        ListNode first = head;
        ListNode end = head;
        while(N>0){
        	first=first.next;
        	N--;
        }
        if(first==null) {
        	head=head.next;
        	return head;
        }
        while(first!=null){
        	first=first.next;
        	if(first==null) {
        		ListNode x = end.next;
        		end.next=end.next.next;
        		x.next=null;
        		x=null;
        	}
        	end=end.next;
        }
        return head;
    }	
}
