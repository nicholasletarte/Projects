//Nicholas Letarte

#ifndef MYQUEUE_H
#define MYQUEUE_H
#include <stdlib.h> 
// The main data structure for the queue
struct queue{
	unsigned int back;	    // The next free position in the queue
				    		// (i.e. the end or tail of the line)
	unsigned int front;	    // Current 'head' of the queue
				    		// (i.e. the front or head of the line)
	unsigned int size;	    // How many total elements we currently have enqueued.
	unsigned int capacity;  // Maximum number of items the queue can hold
	int* data; 		    	// The 'integer' data our queue holds	
};
// Creates a global definition of 'queue_t' so we 
// do not have to retype 'struct queue' everywhere.
typedef struct queue queue_t;

// Create a queue
// Returns a pointer to a newly created queue.
// The queue should be initialized with data on
// the heap.
queue_t* create_queue(unsigned int _capacity){
//	queue_t* myQueue = NULL;
	// TODO: Implement me!
	queue_t* myQueue= (queue_t*)malloc(sizeof(queue_t));
//	myQueue = (queue_t*)malloc(sizeof(queue_t*));
	myQueue->data = (int*)malloc(sizeof(int)*_capacity);//This is where the size of the queue gets created
	myQueue->size = 0;
	myQueue->capacity= _capacity;
	myQueue->front = 0;
//	myQueue->back = -1;//maybe a bug?
	myQueue->back = 0; 	
	return myQueue;//returns pointer
}

// Queue Empty
// Check if the queue is empty
// Returns 1 if true (The queue is completely empty)
// Returns 0 if false (the queue has at least one element enqueued)
int queue_empty(queue_t* q){
	// TODO: Implement me!
	if (q->size==0)
{
	return 1;
}else 
 return 0;
}
// Queue Full
// Check if the queue is Full
// Returns 1 if true (The queue is completely full)
// Returns 0 if false (the queue has more space available to enqueue items)
int queue_full(queue_t* q){
	// TODO: Implement me!
	if (q->size == q->capacity){
	return 1;
}
	return 0;
}
// Enqueue a new item
// i.e. push a new item into our data structure
// Returns a -1 if the operation fails (otherwise returns 0 on success).
// (i.e. if the queue is full that is an error).
int queue_enqueue(queue_t* q, int item){
	// TODO: Implement me!
	if (q->size == q->capacity)
{	
	return -1; // Note: you should have two return statements in this function.
}

	
else {  q->data[q->back] = item;//newest item becomes the back of list
	q->size++;//increasing total elements that are enqueued
	q->back = (q->back+1) % q->capacity;//allows extra room to add in the back so item can be added	

	return 0;
}
return 0;
}
// Dequeue an item
// Returns the item at the front of the queue and
// removes an item from the queue.
// Removing from an empty queue should crash the program, call exit(1)
int queue_dequeue(queue_t *q){
	// TODO: Implement me!
	if (q==NULL|| q->size==0)//checks if queue is null before it checks if it is 0
{
	exit(1);
}


else
{	int temp = q->data[q->front]; //saving data at front to variable
	q->size--;//decreasing total elements in queue by 1
	q->front = (q->front+1)% q->capacity;//adjusting for the correct index of the front. This way index stays in bounds.
	return temp;//returns front of list
}
	return 99999; // Note: This line is a filler so the code compiles.
}


// Queue Size
// Queries the current size of a queue
// A queue that has not been previously created will crash the program.
// (i.e. A NULL queue cannot return the size, call exit(1))
unsigned int queue_size(queue_t* q){
	// TODO: Implement me!
	if (q != NULL)
{
	return q->size;
}else
 exit(1);
}
// Free queue
// Removes a queue and all of its elements from memory.
// This should be called before the proram terminates.
void free_queue(queue_t* q){
	// TODO: Implement me!
	if (q->data != NULL){
	free(q->data);}//data must be freed from within queue

	free(q);//memory allocated for queue freed	
}


#endif
