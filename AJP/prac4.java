import java.util.Scanner;
class prac4
{
    class Node
    {
        int data;
        Node next;

        public Node(int data)
        {
            this.data=data;
            this.next=null;
        }

    }

    private Node head;
    private Node tail;

    public prac4()
    {
        this.head=null;
        this.tail=null;
    }

    public void add(int data)
    {
        Node newNode= new Node(data);
        if(head==null)
        {
            head=newNode;
            tail=newNode;
        }
        else
        {
            tail.next=newNode;
            tail=newNode;
        }
    }

    public void kill()
    {   
        tail.next=head;
        Node current=head;
        while(current.next != current)
        {
            current.next= current.next.next;
            current=current.next;
        }
        System.out.println("Safe position is: "+current.data);
    }

    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        prac4 obj=new prac4();

        System.out.println("\nEnter number of Soldiers: ");
        int n = sc.nextInt();

        for(int i=1;i<=n;i++)
        {
            obj.add(i);
        }
        obj.kill();

        sc.close();
        System.exit(0);
    }
}