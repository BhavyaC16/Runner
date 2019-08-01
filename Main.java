import java.util.Scanner;

class LinkedList 
{ 
    static class Node
    { 
        int data;
        Node next;

        public Node()
        {
        	this.data = 0;
        	next = null;
        }

        public Node(int d)
        {
        	this.data = d;
        	next = null;
        }
    }; 
  	static Node head = null;
    static void insert_at_front(int data) 
    {
        Node ptr_to_insert = new Node(data);
        ptr_to_insert.next = head;
        head = ptr_to_insert;
    }

    static void insert_at_rear(int data)
    {
    	Node ptr_to_insert = new Node(data);
    	Node ptr = head;
    	while(ptr!=null && ptr.next!=null)
    	{
    		ptr = ptr.next;
    	}
    	ptr.next = ptr_to_insert;
    }



    static void traverse_to_print(int d)
    {
    	Node ptr = head;
    	while(ptr!=null && ptr.next!=null)
    	{
    		if(ptr.data!=d){
    		System.out.print(ptr.data);
    		System.out.print(" ");
    	}
    		ptr = ptr.next;
    	}
    }
    static void traverse_to_print()
    {
    	Node ptr = head;
    	while(ptr!=null && ptr.next!=null)
    	{
    		
    		System.out.print(ptr.data);
    		System.out.print(" ");
    		ptr = ptr.next;
    	}
    }
    static void delete_last_node()
    {
    	if(head!=null)
    	{
    		Node prev = head;
	    	Node curr = head.next;
	    	while(curr!=null && curr.next!=null)
	    	{
	    		prev = curr;
	    		curr = curr.next;
	    	}
	    	if(curr==null)
	    	{
	    		prev=null;
	    		head=prev;
	    	}
	    	else if(curr.next==null)
	    	{
	    		prev.next = null;
	    	}
    	}
    	
    }
    public static void main(String args[]) 
    {
    	Scanner sc = new  Scanner(System.in);
    	int t = sc.nextInt();
    	int c = 0;
    	do{
    		int flag = 0;
    		
    		
    		int n = sc.nextInt();
    		int [] list = new int[n];
    		for(int i = 0; i<n; i++)
    		{
    			int a = sc.nextInt();
    			list[i]=a;
    			if(i==0){
    				insert_at_front(a);
    			}
    			else{
    				insert_at_rear(a);
    			}
    			
    		}
    		insert_at_rear(0);
    		int l = sc.nextInt();
    		if(l>0 && l<=n)
    		{
    			System.out.println("True");
    			flag = 1;
    			int d = list[l-1];
    			System.out.println(n+1-l);
    			traverse_to_print(d);
    		}
    		else
    		{
    			System.out.println("False");
    			System.out.println(0);
    			traverse_to_print();
    		}
    		c++;
    		for(int j = 0;j<=n;j++)
    		{
    			delete_last_node();
    		}
    		
    	}while(c<t);	
    	
   	}    
 }