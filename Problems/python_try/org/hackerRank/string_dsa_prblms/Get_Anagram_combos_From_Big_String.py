
# !/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'sherlockAndAnagrams' function below.
#
# The function is expected to return an INTEGER.
# The function accepts STRING s as parameter.
#
# https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem

def check_anagram(s1, s2):
    if sorted(s1) == sorted(s2):
        return True

    return False


def check_combos(s, subj):
    i = 0
    cnt = 0
    s_length = len(s)
    while i + subj <= s_length:

        s1 = s[i:subj]
        j = i + 1

        while j + subj <= s_length:
            s2 = s[j:j + subj]

            if s1 == s2 or check_anagram(s1, s2):
                cnt += 1

            j += 1

        i += 1

    return cnt


def sherlockAndAnagrams(s):
    # Write your code here

    cnt = 0
    subj = len(s) - 1

    while subj > 0:
        cnt += check_combos(s, subj)
        subj -= 1

    return cnt


if __name__ == '__main__':
    inps = ['abba', 'abcd', 'ifailuhkqq', 'kkkk', 'cdcd']

    for q_itr in inps:
        print(sherlockAndAnagrams(q_itr))


