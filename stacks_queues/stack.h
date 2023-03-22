//Nicholas Letarte

#ifndef MYSTACK_H
#define MYSTACK_H
#include <stdlib.h>
// Stores the maximum 'depth' of our stack.
// Our implementation enforces a maximum depth of our stack.
// (i.e. capacity cannot exceed MAX_DEPTH for any stack)
# define MAX_DEPTH 32

// Create a node data structure to store data within
// our stack. In our case, we will stores 'integers'
typedef struct node{
	int data;
	struct node* next;
}node_t;

// Create a stack data structure
// Our stack holds a single pointer to a node, which
// is a linked list of nodes.
typedef struct stack{
	int count;		// count keeps track of how many items
				// are in the stack.
	unsigned int capacity;	// Stores the maximum size of our stack
	node_t* head;		// head points to a node on the top of our stack.
}stack_t;

// Creates a stack
// Returns a pointer to a newly created stack.
// The stack should be initialized with data on the heap.
// (Think about what the means in terms of memory allocation)
// The stacks fields should also be initialized to default values.
stack_t* create_stack(unsigned int capacity){
	// Modify the body of this function as needed.
//	stack_t* myStack = NULL;	
	// TODO: Implement me!!
	stack_t* myStack = (stack_t*)malloc(sizeof(stack_t));

	myStack->head = NULL;
	if (capacity >32 || capacity < 0) {
	exit(1);
}
	myStack->capacity = capacity;
	myStack->count = 0;	
	return myStack;
}

// Stack Empty
// Check if the stack is empty
// Returns 1 if true (The stack is completely empty)
// Returns 0 if false (the stack has at least one element enqueued)
int stack_empty(stack_t* s){
	// TODO: Implement me!!
	if (s->count == 0) {
	return 1;
} else
	return 0;
}

// Stack Full
// Check if the stack is full
// Returns 1 if true (The Stack is completely full, i.e. equal to capacity)
// Returns 0 if false (the Stack has more space available to enqueue items)
int stack_full(stack_t* s){
	// TODO: Implement me!
	if (s->count == s->capacity) {
	return 1;
}
	return 0;
}

// Enqueue a new item
// i.e. push a new item into our data structure
// Returns a -1 if the operation fails (otherwise returns 0 on success).
// (i.e. if the Stack is full that is an error, but does not crash the program).
int stack_enqueue(stack_t* s, int item){
	// TODO: Implement me!
//PUSH only from the front (head) of linked list
//STEPS: make a new node,
// give the data of the new node its value,
//  point the next of the new node to top of stack
 //make top pointer point to new node

	node_t* tempNode = (node_t*) malloc(sizeof(node_t));//created new node(node paramters initialized) 
	if (tempNode == NULL)
	{	
		return -1;
	}

	tempNode->data = item;//item is stored in node 	
	tempNode->next =s->head;//next node points to head 
	s->head = tempNode;//Head(front of stack), now equal to value at tempNode
	s->count ++;//increments count up by 1 so there is room for the values
	return 0;
 // Note: you should have two return statements in this function.
}

// Dequeue an item
// Returns the item at the front of the stack and
// removes an item from the stack.
// Removing from an empty stack should crash the program, call exit(1).
int stack_dequeue(stack_t* s){
	// TODO: Implement me!
	// POP function - must only POP from head of linked list
	// STEPS:
	// make a temporary node
	// point temp node to top of stack
	// store value of data of temp node in a variable
	// point top pointer to node next to current head node
	// return value stored in temp node
	if (s == NULL || s->count ==0)
	{
	exit(1);

	}//conditional to check if stack is empty

	else {
	node_t* tempNode;//temp node created
	tempNode = s->head; //tempNode pointed to top of stack
	int item = tempNode->data; //value of data in temp node stored in item variable
	s->head = tempNode->next; //top pointer now points to next node after head node
	s->count--;//count decrimented after dequeue
	free(tempNode);
	return item;//returns value stored in item		
	}
	

	return 9999999; // Note: This line is a 'filler' so the code compiles.
}

// Stack Size
// Queries the current size of a stack
// A stack that has not been previously created will crash the program.
// (i.e. A NULL stack cannot return the size)
unsigned int stack_size(stack_t* s){
	// TODO: Implement me!
	if (s->count >= 0)
 {
	return s->count;
}
else
{
	exit(1);}

	return 0;
}

// Free stack
// Removes a stack and ALL of its elements from memory.
// This should be called before the proram terminates.
void free_stack(stack_t* s){
	// TODO: Implement me!

while (s->head != NULL) {
	node_t* temp;//temporary node variable
	temp = s-> head->next;//temporary node stores the value of the node next to the top (head) of linked list
	free(s->head);//this should free the data located in the nodes.
	s->head= temp;//s->head now equal to the next node in list
}
	free(s); //free the data from the stack
}
#endif
