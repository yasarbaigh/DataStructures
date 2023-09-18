from bisect import bisect_right, insort_right
def maximumWhiteTiles(self, tiles, carpetLen: int) -> int:
    # 2D-list, sort based on first-value of each-row-list
    tiles.sort()

    # gives as 2 columns , if 2d-array or list
    column_1, column_2 = zip(*tiles)

    # in sorted-list, Finds the best index-location to place the 55
    r = bisect_right(column_1, 55)

    # in sorted-list,  places 55 in the right of index-location
    r = insort_right(column_1, 55)

def sort_chars_in_string(str):
    return ''.join(sorted(str))
print(sort_chars_in_string('YasAr'))

sorted_list = ['ball', 'tarzan', 'Tarzan', 'Cat', 'cat']
sorted_list.sort()

print(sorted_list)




