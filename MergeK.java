package practice;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;



class ListNode {
	int val;
    ListNode next;
    ListNode(int x) {
    	val = x;        
    	next = null;
    }
    public String toString(){
    	return "=="+this.val+"===";
    }
 }


public class MergeK {
    public ListNode mergeKLists(List<ListNode> lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(10,new Comparator<ListNode>(){
        	@Override
        	public int compare(ListNode n1,ListNode n2){
        		return n1.val-n2.val;
        	}
        });
        
        for(int i=0;i<lists.size();i++){
        	ListNode x = lists.get(i);
        	if(x!=null){
        		pq.offer(x);
        	}
        }
        ListNode head = null;
        ListNode pre = head;
        while(!pq.isEmpty()){
        	ListNode cur = pq.poll();
        	if(head==null){
        		head=cur;
        		pre=head;
        	}else{
        		pre.next=cur;
        	}
        	pre = cur;
        	if(cur.next!=null){
        		pq.offer(cur.next);
        	}
        	
        }
        return head;
    }
    
    public static void main(String[] args){
    	ListNode head=null;
    	ListNode pre = head;
    	System.out.println(head+" "+pre);
    	head = new ListNode(3);
    	pre = head;
    	System.out.println(head+" "+pre);
    }
}
