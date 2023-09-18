#!/bin/python3


#
# Complete the 'anagram' function below.
#
# The function is expected to return an INTEGER.
# The function accepts STRING s as parameter.
#
def sort_chars_in_string(s1):
    return ''.join(sorted(s1))


def anagram(s):
    # Write your code here

    ln = len(s)
    if ln % 2 == 1:
        return -1

    mid = int(ln / 2)
    s1 = s[: mid]
    s2 = s[mid:]

    ana = {}
    for i in range(mid):
        v = ana.get(s1[i])
        if v:
            ana[s1[i]] = v + 1
        else:
            ana[s1[i]] = 1

    count = 0
    for i in range(mid):
        v = ana.get(s2[i])
        if v and v > 0:
            ana[s1[i]] = v - 1
        else:
            count += 1
    return count


sinput = ['dnqaurlplofnrtmh', 'hhpddlnnsjfoyxpciioigvjqzfbpllssuj', 'xulkowreuowzxgnhmiqekxhzistdocbnyozmnqthhpievvlj', 'dnqaurlplofnrtmh',
          'aujteqimwfkjoqodgqaxbrkrwykpmuimqtgulojjwtukjiqrasqejbvfbixnchzsahpnyayutsgecwvcqngzoehrmeeqlgknnb',
          'lbafwuoawkxydlfcbjjtxpzpchzrvbtievqbpedlqbktorypcjkzzkodrpvosqzxmpad',
          'drngbjuuhmwqwxrinxccsqxkpwygwcdbtriwaesjsobrntzaqbe', 'ubulzt',
          'vxxzsqjqsnibgydzlyynqcrayvwjurfsqfrivayopgrxewwruvemzy', 'xtnipeqhxvafqaggqoanvwkmthtfirwhmjrbphlmeluvoa',
          'gqdvlchavotcykafyjzbbgmnlajiqlnwctrnvznspiwquxxsiwuldizqkkaawpyyisnftdzklwagv']

for q_itr in sinput:
    print(anagram(q_itr))
