#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'palindromeIndex' function below.
#
# The function is expected to return an INTEGER.
# The function accepts STRING s as parameter.
#

def palindromeIndex(s):
    # Write your code here
    pass

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    test_cases_count = int(input().strip())

    for q_itr in range(test_cases_count):
        s = input() # read string input

        result = palindromeIndex(s)

        fptr.write(str(result) + '\n')

    fptr.close()