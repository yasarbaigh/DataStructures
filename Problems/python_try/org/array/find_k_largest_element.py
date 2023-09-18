import heapq

# https://www.geeksforgeeks.org/k-largestor-smallest-elements-in-an-array/

# Function to find k largest array element


def kLargest(v, N, K):
    # Implementation using
    # a Priority Queue
    pq = []
    heapq.heapify(pq)

    for i in range(N):

        # Insert elements into
        # the priority queue
        heapq.heappush(pq, v[i])

        # If size of the priority
        # queue exceeds k
        if (len(pq) > K):
            heapq.heappop(pq)

    # Print the k largest element
    while (len(pq) != 0):
        print(heapq.heappop(pq), end=' ')
    print()


# driver program

# Given array
arr = [11, 3, 2, 1, 15, 5, 4, 45, 88, 96, 50, 45]
# Size of array
n = len(arr)
k = 3
print(k, " largest elements are : ", end='')
kLargest(arr, n, k)
