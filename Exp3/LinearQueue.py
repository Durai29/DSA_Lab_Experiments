class Queue:
    def __init__(self,max):
        self.max = max
        self.queue = [None]*max
        self.front = self.rear = -1

    def isEmpty(self):
        return self.front == -1 and self.rear == -1

    def isFull(self):
        return self.rear == self.max-1
    
    def enqueue(self,data):
        if self.isFull():
            print("Overflow")
        else:
            if self.isEmpty():
                self.front +=1
                self.rear +=1
            else:
                self.rear += 1
            self.queue[self.rear] = data
    
    def dequeue(self):
        if self.isEmpty():
            print("Underflow")
        else:
            data = self.queue[self.front]
            if self.front==self.rear:
                self.front = self.rear =-1
            else:
                self.front += 1
            return data 
    
    def display(self):
        if self.isEmpty():
            print("Empty Queue")
        else:
            for i in range(self.front,self.rear+1):
                print(i,end=' ')
            
q = Queue(5)
for i in range(3):
    q.enqueue(i)
print(q.dequeue())
q.display()
print(q.dequeue())
q.display()
