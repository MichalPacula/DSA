import time

def linearSearch(array, number: int) -> int:
    for i in range(len(array)):
        if array[i] == number:
            return i
    
    return -1

array = [i for i in range(1000000)]

startTime = time.time()
print(linearSearch(array, 1000000))
endTime = time.time()
print(f"The execution of the algorithm took: {(endTime - startTime)*1000} milliseconds")