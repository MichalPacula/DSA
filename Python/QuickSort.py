def qs(array, low, high):
    if low >= high:
        return;

    pivotIndex = partition(array, low, high)

    qs(array, low, pivotIndex - 1)
    qs(array, pivotIndex + 1, high)

def partition(array, low, high):
    pivot = array[high]
    index = low - 1

    for i in range(low, high):
        if array[i] <= pivot:
            index += 1
            tmp = array[i]
            array[i] = array[index]
            array[index] = tmp
    
    index += 1
    array[high] = array[index]
    array[index] = pivot

    return index

def quickSort(array):
    qs(array, 0, len(array) - 1)

array = [9, 3, 7, 4, 69, 420, 42]
print("Array before quick sort: " + str(array))
quickSort(array)
print("Array after quick sort: " + str(array))