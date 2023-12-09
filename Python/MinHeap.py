class MinHeap:
    dataArray = []
    length = 0

    def insert(self, value):
        self.dataArray[self.length] = value
        self.heapifyUp(self.length)
        self.length += 1

    def delete(self):
        if self.length == 0:
            return -1
        
        out = self.dataArray[0]
        self.length -= 1
        if self.length == 0:
            self.dataArray = []
            return out
        
        self.dataArray[0] = self.dataArray[self.length]
        self.heapifyDown(0)
        return out

    def heapifyDown(self, index):
        leftIndex = self.leftChild(index)
        rightIndex = self.rightChild(index)

        if index >= self.length or leftIndex >= self.length:
            return;

        leftValue = self.dataArray[leftIndex]
        rightValue = self.dataArray[rightIndex]
        value = self.dataArray[index]

        if leftValue > rightValue and value > rightValue:
            self.dataArray[rightIndex] = value
            self.dataArray[index] = rightValue
            self.heapifyDown(rightIndex)
        elif rightValue > leftValue and value > leftValue:
            self.dataArray[leftIndex] = value
            self.dataArray[index] = leftValue
            self.heapifyDown(leftIndex)

    def heapifyUp(self, index):
        if index == 0:
            return;

        parent = self.parent(index)
        parentValue = self.dataArray[parent]
        value = self.dataArray[index]

        if parentValue > value:
            self.dataArray[parent] = value
            self.dataArray[index] = parentValue
            self.heapifyUp(parent)

    def parent(self, index):
        return (index - 1) // 2

    def leftChild(self, index):
        return (index * 2) + 1
    
    def rightChild(self, index):
        return (index * 2) + 2