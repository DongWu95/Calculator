package sort;

import java.util.ArrayList;

public class Solution {

    public ListNode sortList(ListNode head) {

        if(head == null)
            return null;
        int i = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<ListNode> nodelist = new ArrayList<ListNode>();
        ArrayList<Integer> orderlist = new ArrayList<Integer>();

        nodelist.add(head);
        orderlist.add(i);
        i++;

        ListNode tmpnode = head;
        list.add(head.val);
        while(tmpnode.next != null){

            tmpnode = tmpnode.next;
            nodelist.add(tmpnode);
            list.add(tmpnode.val);
            orderlist.add(i);
            i++;

        }

        heapsort(list,list.size(),orderlist);

        head = nodelist.get(orderlist.get(0));
        tmpnode = head;

        for(int j = 0;j<orderlist.size()-1;j++){

            tmpnode.next = nodelist.get(orderlist.get(j+1));
            tmpnode = tmpnode.next;


        }

        return head;

    }



    private void heapsort(ArrayList<Integer> list,int n,ArrayList<Integer> orderlist){


        for(int i = n/2-1;i>=0;i--)

            __shiftdown(list,n,i,orderlist);
//	for(int i=0;i<n;i++)
//		cout<<arr[i]<<endl;


        for(int i = n-1;i>0;i--){

            swap(list,0,i);
            swap(orderlist,0,i);
            __shiftdown(list,i,0,orderlist);


        }




    }



    private void swap(ArrayList<Integer> list,int i,int j){

        Integer tmp = list.get(i);
        list.set(i,list.get(j));
        list.set(j,tmp);



    }




    void __shiftdown(ArrayList<Integer> list,int n,int i,ArrayList<Integer> orderlist){


        while(i * 2 + 1<= n-1){

            int j =i * 2 +1;
            if( j + 1 <= n-1)
                j=list.get(j)>list.get(j+1)?j:j+1;

            if(list.get(j) > list.get(i)){
                swap(list,i,j);
                swap(orderlist,i,j);
            }
            else
                break;

            i = j;

        }



    }





    public static void main(String[] args){


        ListNode head = new ListNode(2);

        ListNode next = new ListNode(1);

        head.next = next;


        Solution solution = new Solution();




        head = solution.sortList(head);


        do{


            System.out.println(head.val);

            head = head.next;


        }while (head!=null);














    }




}
