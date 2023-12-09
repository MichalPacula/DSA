import time

def bubbleSort(array) -> None:
    for i in range(len(array)):
        for j in range(len(array) - 1 - i):
            if array[j] > array[j + 1]:
                tmp = array[j]
                array[j] = array[j + 1]
                array[j + 1] = tmp

array = [3, 2, 1, 6, 4, 2, 10, 123, 5]

startTime = time.time()
bubbleSort(array)
print(array)
endTime = time.time()
print(f"The execution of the algorithm took: {(endTime - startTime)*1000} milliseconds")