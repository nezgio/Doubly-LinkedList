# Doubly-LinkedList
Introduction
Throughout this assignment I focused on learning about double-linked lists in Java. I got better at 
using Java Interfaces and implementing these lists. My main goal was to write code based on the 
instructions in the HW2Interface interface. To do this, I made a LinkedList class that used the 
features of the DLNode class effectively. The process not only allowed me to understand the 
underlying mechanisms of Double-Linked Lists but also provided valuable insights into the 
implementation of Java Interfaces in practical scenarios. 
How the Algorithm Works
The Class Structure of LinkedList:
This class implements the HW2Interface, implying it must define and implement methods specified 
in that interface. The methods are Insert, Delete, ReverseLink, SquashL, OplashL, Output, ROutput, 
toString and LinkedListException. 
It utilizes a Double-Linked List structure: DLNode represents a node in this doubly linked list which 
has right and left pointers to point previous and next nodes. And I also added a constructor in this 
class to reduce the code and make it a bit more compact. Constructor is a special type of method 
that is used to initialize an object. Instead of creating an empty DLNode and initializing its Element 
value in a separate line, we are able to assign Element value right from the constructor call while 
initializing our new DLNode object. We are achieving this by creating a constructor in DLNode class 
which accepts an integer (which will represent our element value) as a parameter and passing our 
own new element value while invoking the constructor. By doing this, we are also forbidding a 
creation of DLNode without its numeric value (making it mandatory).
Properties:
private DLNode head; and private DLNode tail; represent the start and end nodes of the doubly 
linked list. Head has left null pointer and tail has right null pointer. I decided to make them private 
because I wanted to utilize encapsulation concept in order to hide that information from other 
classes. Only LinkedList class should be aware of this information, and other classes should only use 
other public methods (like Output(), toString()…).
Methods:
• Insert Method
Insert Method is a method for inserting new element into the list based on two parameters, 
element (numeric value) and position (on which position in the list it will be inserted). Firstly,
the method initializes a new DLNode newDLNode with the desired element. Then, it handles 
different scenarios which are listed and explained below:
1. If the specified position is out of bounds. If our position, passed as an argument is less 
than zero or greater than the size of the list at current time, I am throwing an 
Exception. (HW2Exception, it will be explained better in LinkedListException Method).
2. If the list is empty. In this step I am checking whether the list is empty (by checking 
whether head and tail are null), and if it is, I am setting my new element as head and 
tail of the list.
3. If the specified position is zero. This means we are inserting newDLNode at the 
beginning of the linked list. I am achieving this by creating double connection with the 
current head node and setting my new element to new head immediately after.
4. If the specified position is equal to size. Which means we are inserting newDLNode at 
the end of the linked list. Like previous scenario, I am connecting my new node to the 
current tail from the right side by making double connection, then setting my new 
element as new tail.
5. If nothing above is the case. This just means we are inserting in the non-empty list, 
somewhere in the middle. I did this by traversing through the elements with a for 
loop, to the desired position. After that, I’m assigning left and right references on my 
new element to the ones from the list, the updating my list element’s references to 
now include my new element.
To Understand the Insert Method visualization is the most important thing. With one 
mistake we can lose all the information. So, in the Insert Method temporary node has really 
important value to control that.
• Delete Method
Delete method has almost the same methodology as Insert. It is following almost same steps 
with a bit different logic behind it.
1. If the specified position is out of bounds. If our position, passed as an argument is less 
than zero or greater than the size of the list at current time, I am throwing an 
Exception. (HW2Exception, it will be explained better in LinkedListException Method).
2. If list has only one element. This case assumes that head is equal to tail. If that’s the 
case, I’m just setting my head and tail to null and with that making an empty list.
3. If the specified position is zero. This means we are removing first element. I am 
achieving this by setting my second element left reference to null, then updating the 
same element to be new head.
4. If the specified position is equal to size -1. Which means we are deleting the node at 
the end of the linked list. It follows the same logic as deleting from the beginning, so 
I’m first setting my second to last element right reference to null, then updating the 
same element to be new tail.
5. If nothing above is the case. I’m finding the position of desired element and updating 
the references on the two elements around it to include themselves, by creating 
double link between them.
• ReverseLink Method
Reverses the direction of the doubly linked list by swapping the left and right pointers of each 
node. I have achieved this by going through all the elements of the list with while loop until we 
reach null (end of list). I’m utilizing temp for storing data in order not to lose any while 
swapping my links. For each element of the list, I’m setting its right reference to the left and 
vice versa. After all the elements are updated in this way, I’m updating my tail reference and 
head reference, as well as setting left reference for head and right reference for tail to null.
• SquashL Method
Merges consecutive nodes with the same value, replacing them with a single node containing 
the count of such elements. Again, I used while loop to go through all the elements of my list. 
Additionally, I used another while loop to count number of consecutive elements while saving 
next element reference in temp variable. When I ultimately count number of elements, I know 
my temp variable will hold reference to the first different element. Now, I’m creating a new 
element, which will be representation of consecutive elements count and then it’s really easy 
to insert it in the list since I’m just double linking it with current element and temp by updating 
their references and assigning new to the new element. After that, I move to the next nonconsecutive element by assigning temp to the current.
• OplashL Method
Opposite of SquashL, it expands nodes with a count greater than 1 into separate nodes with 
individual elements. Again, the base idea is to loop through elements of the list and analyze 
situations. While looping through elements with while loop, I’m storing my next element in a 
temp variable. First, I’m checking whether there is only one occurrence of the current element, 
if it is, I’m only removing counting element and double binding my current with my temp (next 
element). If this is not the case, I have to create one or more elements (depending on counting 
element value). I’m looping through creation of elements with for loop and updating existing 
references to include new elements. Here, I have special case, when I’m adding my first new 
element, since I must remove counting element and put new element in its place. Also, I’m 
keeping past reference for each new element in a separate variable, in order to connect current 
new element to it. After executing all this, I’m moving to the next element in the list.
• Output Method
This method essentially traverses the linked list from the head to the end (tail) and prints each 
element's value along the way, displaying all the elements in the list with appropriate 
formatting. I’m using while loop for traversing and looping all the way until I reach null, which 
means we made it to the end of the list. First, I take my head element as my current, then, with 
each iteration, I’m printing the current element value, then moving to the next element by 
setting right reference of my current element as my new current reference.
• ROutput Method
This method effectively traverses the linked list from the tail to the beginning (head) and prints 
each element's value in reverse order, displaying all the elements in the list but in a reversed 
sequence. The methodology is almost the same as with Output method, only we need to 
change two things. We need to start from tail of the list by initially setting current element to 
tail, and then with each iteration, instead of moving to the right reference each time, we are 
moving to the left.
• toString Method
This method generates a string representation of the linked list by sequentially adding each 
element's value, separated by spaces, creating a readable format of the linked list contents. 
It initializes an empty string strDLL to store the elements of the linked list. It starts at the head 
of the linked list. Within each iteration, it appends the Element value of the current node to the 
strDLL string. After appending the element value, it moves the next element, by assigning right 
reference of the current element to be new current. The method continues this process until it 
reaches the end of the linked list (current becomes null). During each iteration, it adds the 
element value to the string strDLL, separated by spaces. Once the loop finishes, it returns the 
string strDLL, which contains all the elements of the linked list in the specified format.
• LinkedListException Method
The method is declared to return an Exception type. Throws an exception (HW2Exception) 
when an invalid operation occurs. Whenever this method is called, it immediately throws an 
instance of HW2Exception using the throw keyword. This means that whenever a condition is 
met that necessitates invoking this method, it stops the execution flow by throwing an instance 
of HW2Exception. When an unexpected condition happens during the linked list manipulation 
methods (such as Insert, Delete, etc.), this method is called to raise an exception indicating an 
issue or an error.
HW2Exception is a new exception class, that is extended from Exception class, and is used to 
describe exceptions happening within the linked list operations.
• getSize Method
This method is a helper method I created in order to reliably know size of my list at any given 
time. It is working by utilizing counter variable and looping through all the elements in the list 
while incrementing the counter. In the end, when current element of the list reaches null, It is 
returning counter variable.
Overall Functionality:
LinkedList Class which implements the methods of HW2Interface interface allows insertion, 
deletion, reversal, and transformations of the linked list elements based on various conditions.
Provides methods to output the list elements in both forward and reverse order.
Handles exceptions for invalid operations on the linked list.
Summary:
This LinkedList class offers a versatile implementation of a doubly linked list, providing functionalities 
for modification, transformation, and traversal of the list elements while handling edge cases and 
exceptions effectively
