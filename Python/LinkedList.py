class Node:
    def __init__(self,data):
        self.data= data
        self.next= None
        
class LinkedList:
    def __init__(self):
        self.head=None
        self.tail=None
        
    def insertAtEnd(self, data):
        newNode = Node(data)
        if self.head is None:
            self.head=newNode
            self.tail=newNode
            return
        
        self.tail.next=newNode
        self.tail=newNode
        
    def insertAtBegin(self,data):
        newNode = Node(data)
        if self.head is None:
            self.head=newNode
            
        newNode.next=self.head
        self.head=newNode
        
    def disp(self):
        currentNode=self.head
        while(currentNode):
            print(currentNode.data)
            currentNode=currentNode.next
   
    def insertAfter(self,pos,value):
        newnode = Node(value)
        ptr = self.head
        c=1
        while(ptr and c<pos):
            c+=1
            ptr=ptr.next
        newnode.next=ptr.next
        ptr.next=newnode
        
a = LinkedList()
a.insertAtEnd(1)
a.insertAtEnd(2)
a.insertAtEnd(3)

a.insertAtBegin(4)
a.insertAtBegin(5)
a.insertAtBegin(6)

a.insertAfter(3,7)

a.disp()
   