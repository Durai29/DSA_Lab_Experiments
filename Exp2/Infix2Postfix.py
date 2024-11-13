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
            return self.stack[self.top]
    
    def push(self,data):
        if(self.isFull()):
            print("Overflow")
        else:
            self.top += 1
            self.stack[self.top]=data
    
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

infix =  '((a/(b^c))-d)'
s = Stack(len(infix))
operator = {'^':3,'/':2,'*':2,'+':1,'-':1}

for i in infix:
    if i == '(':
        s.push(i)
    elif i not in operator and i!=')': # Operand.
        print(i,end='')
    elif i==')':
        while(s.peek() != '('):
            print(s.pop(),end='')
        s.pop()
    else:
        if not s.isEmpty() and s.peek() in operator:
            if operator[s.peek()] >= operator[i]:
                print(s.pop(),end='')
                s.push(i)
            else: 
                s.push(i)
        else:
            s.push(i)

while not s.isEmpty():
    print(s.pop,end='')