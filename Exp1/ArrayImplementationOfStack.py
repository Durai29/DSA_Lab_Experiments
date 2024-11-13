class Stack:
    def __init__(self,max):
        self.max = max
        self.stack = [None]*max
        self.top = -1

    def isEmpty(self):
        return self.top == -1

    def isFull(self):
        return self.top == self.max-1

    def peek(self):
        if(self.isEmpty()):
            print("Empty stack")
        else:
            print(self.stack[self.top])
    
    def push(self,data):
        if(self.isFull()):
            print("Overflow")
        else:
            self.top += 1
            self.stack[self.top]=data
            print("Pushed")
    
    def pop(self):
        if(self.isEmpty()):
            print("Underflow")
        else:
            data = self.stack[self.top]
            self.top -= 1
            return data
        
    def display(self):
        if(self.isEmpty()):
            print("Empty Stack")
        else:
            for i in range(self.top+1):
                print(self.stack[i])

s = Stack(5)
s.push(1)
s.push(2)
s.push(3)
print("Poped: ",s.pop())
s.display()

        