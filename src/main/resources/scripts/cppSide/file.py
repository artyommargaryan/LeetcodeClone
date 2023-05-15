# arg1 = int(input("arg1"))
# arg2 = int(input("arg2"))
# res = arg1 + arg2
# with open('output.txt', 'w') as file:
#     file.write(str(res))

import sys
import Solution

arg1 = int(sys.argv[1])
arg2 = int(sys.argv[2])
res = Solution.twoSum(arg1, arg2)
with open('output.txt', 'w') as file:
    file.write(str(res))
