import time, math

def binarySearch(array, number:int) -> int:
    low = 0
    high = len(array)
    while(low < high):
        mid = math.floor(low + (high - low)/2)
        value = array[mid]
        if value == number:
            return mid
        elif value < number:
            low = mid + 1
        else:
            high = mid
    
    return -1

array = [i for i in range(1000000000)]

startTime = time.time()
print(binarySearch(array, 1))
endTime = time.time()
print(f"The execution of the algorithm took: {(endTime - startTime)*1000} milliseconds")