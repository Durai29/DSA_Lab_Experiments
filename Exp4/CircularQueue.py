class CircularQueue:
    def __init__(self,max):
        self.max = max
        self.queue = [None]*max
        self.front = self.rear = -1

    def isEmpty(self):
        return self.front == -1 and self.rear == -1
    
    def isFull(self):
        return self.front == (self.rear+1) % self.max
    
    def enqueue(self,data):
        if self.isFull():
            print("Overflow")
        else:
            if self.isEmpty():
                self.front += 1
                self.rear += 1
            else:
                self.rear = (self.rear+1) % self.max
            self.queue[self.rear] = data

    def dequeue(self):
        if self.isEmpty():
            print("UnderFlow")
        else:
            data = self.queue[self.front]
            if self.front == self.rear:
                self.front = -1
                self.rear = -1
            else:
                self.front += (self.front+1) % self.max
            return data
        
    def display(self):
        if self.isEmpty():
            print("Empty Queue")
        else:
            i = self.front
            while(i!=self.rear):
                print(self.queue[i],end=' ')
                i = (i+1) % self.max

            print(self.queue[i])

q = CircularQueue(4)
for i in range(1,5):
    q.enqueue(i)
print(q.dequeue())
q.enqueue(5)
q.display()