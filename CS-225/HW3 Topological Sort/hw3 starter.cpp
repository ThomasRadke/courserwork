#include <iostream>
#include <string>
#include <fstream>
#include <sstream>
#include <algorithm>

using namespace std;

typedef string VertexType;
typedef string ItemType;

//------------------------------------------------
struct NodeType
{
	ItemType info;
	NodeType* next;
};

class StackType
{
public:
	StackType();
	~StackType();

	void MakeEmpty();
	// Function:  Sets stack to an empty state.
	// Post: Stack is empty.

	bool IsFull() const;
	// Function: Determines whether the stack is full.
	// Pre:  Stack has been initialized.
	// Post: Function value = (stack is full)

	bool IsEmpty() const;
	// Function: Determines whether the stack is empty.
	// Pre:  Stack has been initialized.
	// Post: Function value = (stack is empty)

	void Push(ItemType item);
	// Function: Adds newItem to the top of the stack.
	// Pre:  Stack has been initialized and is not full.
	// Post: newItem is at the top of the stack.

	void Pop(ItemType& item);
	// Function: Removes top item from the stack and returns it in item.
	// Pre:  Stack has been initialized and is not empty.
	// Post: Top element has been removed from stack.
	//       item is a copy of the removed item.

	ItemType Top();
	// Function: Returns a copy of the top item from the stack.
	// Pre:  Stack has been initialized and is not empty.
	// Post: Copy of the top element is returned.

private:
	NodeType* xTop;
};
StackType::StackType()
{
	xTop = NULL;
}

StackType::~StackType()
{
	MakeEmpty();
}

void StackType::MakeEmpty()
{
	NodeType* p;

	while (xTop != NULL)
	{
		p = xTop;
		xTop = xTop->next;
		delete p;
	}
}

bool StackType::IsFull() const
{
	NodeType* p;
	p = new NodeType;
	if (p == NULL)
		return true;
	else
	{
		delete p;
		return false;
	}
}

bool StackType::IsEmpty() const
{
	return xTop == NULL;
}

void StackType::Push(ItemType newItem)
{
	NodeType* p = new NodeType;
	p->info = newItem;
	p->next = xTop;
	xTop = p;
}

void StackType::Pop(ItemType& item)
{
	NodeType* p = xTop;
	item = xTop->info;
	xTop = xTop->next;
	delete p;
}

ItemType StackType::Top()
{
	return xTop->info;
}
//------------------------------------------------
//------------------------------------------------
class QueType
{
public:
	QueType();
	// Class constructor.
	// Because there is a default constructor, the precondition that the
	// queue has been initialized is omitted.

	~QueType();
	// Class destructor.

	void MakeEmpty();
	// Function: Initializes the queue to an empty state.
	// Post: Queue is empty.

	bool IsEmpty() const;
	// Function: Determines whether the queue is empty.
	// Post: Function value = (queue is empty)

	bool IsFull() const;
	// Function: Determines whether the queue is full.
	// Post: Function value = (queue is full)

	void Enqueue(ItemType newItem);
	// Function: Adds newItem to the rear of the queue.
	// Pre:  Queue is not full.
	// Post: newItem is at the rear of the queue.

	void Dequeue(ItemType& item);
	// Function: Removes front item from the queue and returns it in item.
	// Pre:  Queue is not empty.
	// Post: Front element has been removed from the queue.
	//       item is a copy of the removed element.

private:
	NodeType* qFront;
	NodeType* qRear;
};

QueType::QueType()	// Class constructor.
					// Post:  qFront and qRear are set to NULL.
{
	qFront = NULL;
	qRear = NULL;
}

void QueType::MakeEmpty()
// Post: Queue is empty; all elements have been deallocated.
{
	NodeType* p;

	while (qFront != NULL)
	{
		p = qFront;
		qFront = qFront->next;
		delete p;
	}
	qRear = NULL;
}

QueType::~QueType()
{
	MakeEmpty();
}

bool QueType::IsFull() const
// Returns true if there is no room for another ItemType on the free store;
// false otherwise.
{
	NodeType* p = new NodeType;
	if (p == NULL)
		return true;
	else
	{
		delete p;
		return false;
	}
}

bool QueType::IsEmpty() const
// Returns true if there are no elements on the queue; false otherwise.
{
	return (qFront == NULL);
}

void QueType::Enqueue(ItemType newItem)
// Adds newItem to the rear of the queue.
// Pre:  Queue has been initialized and is not full.
// Post: newItem is at rear of queue.
{
	NodeType* p = new NodeType;
	p->info = newItem;
	p->next = NULL;
	if (qRear == NULL)
		qFront = p;
	else
		qRear->next = p;
	qRear = p;
}

void QueType::Dequeue(ItemType& item)
// Removes front item from the queue and returns it in item.
// Pre:  Queue has been initialized and is not empty.
// Post: Front element has been removed from queue.
//       item is a copy of removed element.
{
	NodeType* p = qFront;
	item = qFront->info;
	qFront = qFront->next;
	if (qFront == NULL)
		qRear = NULL;
	delete p;
}
//------------------------------------------------
//------------------------------------------------

const int MAX_VERTICES = 100;
const int NULL_EDGE = 0;

class GraphType
{
public:
	GraphType();
	GraphType(int maxV);
	~GraphType();
	void MakeEmpty();
	bool IsEmpty() const;
	bool IsFull() const;
	void AddVertex(VertexType);
	void AddEdge(VertexType, VertexType, int);
	int WeightIs(VertexType, VertexType);
	void GetToVertices(VertexType, QueType&);
	void ClearMarks();
	void MarkVertex(VertexType);
	bool IsMarked(VertexType);
	void TopologicalSort();
	void Edges();
	//void DepthFirstSearch(VertexType startVertex, VertexType endVertex);
	//void BreadthFirstSearch(VertexType startVertex, VertexType endVertex);

private:
	int numVertices;
	int maxVertices;
	VertexType* vertices;
	bool* marks;
	int* in_degree;
	int edges[MAX_VERTICES][MAX_VERTICES];
};

GraphType::GraphType()
// Post: Arrays are dynamically allocated for marks and vertices.  numVertices is set to 0; 
//       maxVertices is set to MAX_VERTICES.
{
	numVertices = 0;
	maxVertices = MAX_VERTICES;
	vertices = new VertexType[MAX_VERTICES];
	marks = new bool[MAX_VERTICES];
}

GraphType::GraphType(int maxV)
// Post: Arrays of size maxV are dynamically allocated for marks and vertices.  
//       numVertices is set to 0; maxVertices is set to maxV.
{
	numVertices = 0;
	maxVertices = maxV;
	vertices = new VertexType[maxV];
	marks = new bool[maxV];
}

// Post: arrays for vertices and marks have been deallocated.
GraphType::~GraphType()
{
	delete[] vertices;
	delete[] marks;
}

void GraphType::Edges() { //Helper function to initialize all edges as NULL_EDGE
	for (int i = numVertices-1; i > 0; i--) {
		VertexType vertex1 = vertices[i];
		VertexType vertex2 = vertices[i-1];
		AddEdge(vertex1, vertex2, NULL_EDGE);
		AddEdge(vertex2, vertex1, NULL_EDGE);
	}
}
void GraphType::MakeEmpty()
{
	numVertices = 0;
}

bool GraphType::IsEmpty() const
{
	return numVertices == 0;
}

bool GraphType::IsFull() const
{
	return numVertices == maxVertices;
}

void GraphType::AddVertex(VertexType vertex)
// Post: vertex has been stored in vertices.
{
	vertices[numVertices] = vertex;
	numVertices++;
}

int IndexIs(VertexType* vertices, VertexType vertex)
// Post: Returns the index of vertex in vertices.
{
	int index = 0;

	while (!(vertex == vertices[index]))
		index++;
	return index;
}

void GraphType::AddEdge(VertexType fromVertex, VertexType toVertex, int weight)
// Post: Edge (fromVertex, toVertex) is stored in edges.
{
	int row = IndexIs(vertices, fromVertex);
	int col = IndexIs(vertices, toVertex);
	edges[row][col] = weight;
}

int GraphType::WeightIs(VertexType fromVertex, VertexType toVertex)
// Post: Returns the weight associated with the edge 
//       (fromVertex, toVertex).
{
	int row;
	int col;

	row = IndexIs(vertices, fromVertex);
	col = IndexIs(vertices, toVertex);
	return edges[row][col];
}

void GraphType::GetToVertices(VertexType vertex, QueType& adjVertices)
// Post: 
{
	int fromIndex;
	int toIndex;

	fromIndex = IndexIs(vertices, vertex);
	for (toIndex = 0; toIndex < numVertices; toIndex++)
		if (edges[fromIndex][toIndex] != NULL_EDGE)
			adjVertices.Enqueue(vertices[toIndex]);
}

void GraphType::ClearMarks()
{
	for (int i = 0; i < numVertices; i++)
		marks[i] = false;
}

bool GraphType::IsMarked(VertexType v)
{
	return marks[IndexIs(vertices, v)];
}

void GraphType::MarkVertex(VertexType v)
{
	marks[IndexIs(vertices, v)] = true;
}

void GraphType::TopologicalSort() //TopologicalSort function does not take in any inputs
{
	QueType q;
	int in_degree[100];
	for (int i = 0; i < numVertices; i++) {
		in_degree[i] = 0;//initialize all in degrees to 0
	}
		for (int i = 0; i < numVertices; i++) {//Finds the indegree of each vertex by checking if there exists an edge between each vertex
			for (int j = numVertices-1; j >= 0; j--) {
			VertexType vertex = vertices[i];
			VertexType vertex2 = vertices[j];
			int col = IndexIs(vertices, vertex2);
			int row = IndexIs(vertices, vertex);
			if (edges[col][row] != NULL_EDGE)
				in_degree[i]++;
			}
		}
		int man = 0;// variable used for the do while loop
	do{

		for (int i = 0; i < numVertices; i++) {//enqueues all vertices whos indegree is 0
			if (in_degree[i] == 0) {
				in_degree[i]--;//a not so elloquent way of preventing vertices from being added to the queue more than once
				q.Enqueue(vertices[i]);
			}
		}
		while (!q.IsEmpty()) {//outputs the items in the queue
		VertexType v;
		q.Dequeue(v);
		cout << v << " ";
		QueType r;
		GetToVertices(v, r);
		while (!r.IsEmpty()) {// gets adjacent vertices and subtracts thier indegree
			VertexType let;
			r.Dequeue(let);
			int dex = IndexIs(vertices, let);
			in_degree[dex]--;
			}
		}
		man++;
	} while (man < numVertices);
}
//------------------------------------------------

int main()
{

	//GraphType graph(MAX_VERTICES);
	//string vertex1 = "banana", vertex2 = "peach";

	//graph.AddVertex( vertex1 );
	//graph.AddVertex( vertex2 );

	//graph.AddEdge( vertex1, vertex2, 1 );
	//graph.AddEdge( vertex2, vertex1, NULL_EDGE);

	//cout << "edge weight v1 to v2 is " << graph.WeightIs(vertex1, vertex2) << endl;
	//cout << "edge weight v2 to v1 is " << graph.WeightIs(vertex2, vertex1) << endl;
	//graph.TopologicalSort();
	ifstream infile("Courses.in");
	int i = 0;
	string N;
	string L[100];
	string F;
	string Classes[100];
	string Prereqs[100];
	bool notfound = false;
	getline(infile, F);
	int let = stoi(F);
	GraphType graph(let);
	while (getline(infile, N)) {// adds each class to the graph as a vertex
		L[i] = N;
		i++;
	}
	int f = 0;
	int l = 0;
	for (int j = 0; j < i; j++) {
		string M[100];
		stringstream ssin(L[j]);
		while (ssin.good() && f < 100) {
			ssin >> M[f];
			f++;
		}
		f = 0;
		graph.AddVertex(M[0]);
		Classes[j] = M[0];
		l++;
	}
	int y = 0;
	for (int j = 0; j < i; j++) {
		string M[100];
		stringstream ssin(L[j]);
		while (ssin.good() && f < 100) {
			ssin >> M[f];
			f++;
		}
		f = 0;
		if (M[1] == "0") {
			y++;
			continue;
		}
		else {

			int fu = stoi(M[1]);
			while (fu != 0) {
				int i = 2;
				if (!(find(begin(Classes), end(Classes), M[i]) != end(Classes))) {
					cout << "Class has prerequisite that doesn't exist" << endl;
					return 0;
				}
				i++;
				fu--;
		}
		}
	}
	if (y == 0) {
		cout << "Every class has a prerequisite";
		return 0;
	}
	graph.Edges(); // initiallize all edges to null
	
	for (int j = 0; j < i; j++) { // adds the edges between connected classes
		string M[100];
		stringstream ssin(L[j]);
		while (ssin.good() && f < 100) {
			ssin >> M[f];
			f++;
		}
		f = 0;
		if (M[1] == "0")
			continue;
		else {
			int fu = stoi(M[1]);
			while (fu != 0) {
				int i = 2;
				graph.AddEdge(M[i], M[0],1);
				i++;
				fu--;
			}
		}
	}

	cout << "Required courses may be taken in the following order:" << endl;
	graph.TopologicalSort();

  return 0;
}
