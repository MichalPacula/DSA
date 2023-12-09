import java.util.ArrayList;

public class MinHeap {

    ArrayList<Integer> dataArray = new ArrayList<>();
    int length = 0;

    public void insert(int value){
        dataArray.set(length, value);
        heapifyUp(length);
        length++;
    }

    public int delete(){
        if(length == 0){
            return -1;
        }

        int out = dataArray.get(0);
        length--;

        if(length == 0){
            dataArray = new ArrayList<>();
            return out;
        }

        dataArray.set(0, dataArray.get(length));
        heapifyDown(0);
        return out;
    }

    public void heapifyDown(int index){
        int leftIndex = leftChild(index);
        int rightIndex = rightChild(index);
        if(index >= length || leftIndex >= length){
            return;
        }

        int leftValue = dataArray.get(leftIndex);
        int rightValue = dataArray.get(rightIndex);
        int value = dataArray.get(index);

        if(leftValue > rightValue && value > rightValue){
            dataArray.set(rightIndex, value);
            dataArray.set(index, rightValue);
            heapifyDown(rightIndex);
        } else if(rightValue > leftValue && value > leftValue){
            dataArray.set(leftIndex, value);
            dataArray.set(index, leftValue);
            heapifyDown(leftIndex);
        }
    }

    public void heapifyUp(int index){
        if(index == 0){
            return;
        }

        int parent = this.parent(index);
        int parentValue = dataArray.get(parent);
        int value = dataArray.get(index);
        if(parentValue > value){
            dataArray.set(parent, value);
            dataArray.set(index, parentValue);
            heapifyUp(parent);
        }
    }

    public int leftChild(int index){
        return (index*2) + 1;
    }

    public int rightChild(int index){
        return (index*2) + 2;
    }

    public int parent(int index){
        return (index - 1) / 2;
    }
}
