class Solution {
    public ListNode reverseBetween(ListNode h, int l, int r) {
        ListNode d=new ListNode(0);d.next=h;
        ListNode p=d;
        for(int i=1;i<l;i++)p=p.next;
        ListNode c=p.next,n=null;
        for(int i=0;i<r-l;i++){
            n=c.next;
            c.next=n.next;
            n.next=p.next;
            p.next=n;
        }
        return d.next;
    }
}
