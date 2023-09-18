from bisect import bisect_right


# https://leetcode.com/problems/maximum-white-tiles-covered-by-a-carpet/submissions/?source=submission-noac
class Solution:
    def maximumWhiteTiles(self, tiles, carpetLen: int) -> int:
        # sort based on first-value of each-item
        tiles.sort()
        maxCover = 0
        starts, ends = zip(*tiles)
        dp = [0] * (len(tiles) + 1)  # dp: total covered lengths from 0
        for i in range(len(tiles)):
            dp[i + 1] = dp[i] + ends[i] - starts[i] + 1  # length of each tile is end - start + 1
        for l in range(len(tiles)):
            e = starts[l] + carpetLen
            r = bisect_right(starts, e)
            cover = dp[r] - dp[l] - max(0, ends[r - 1] - e + 1)
            # total cover on the right MINUS total cover on the left MINUS offset
            maxCover = max(maxCover, cover)
        return maxCover


sl = Solution()
print(sl.maximumWhiteTiles([[1, 5], [12, 18], [30, 32], [20, 25], [10, 11 ], ], 10))
print(sl.maximumWhiteTiles([[10, 11], [1, 1]], 2))
print(sl.maximumWhiteTiles([[8051, 8057], [8074, 8089], [7994, 7995], [7969, 7987], [8013, 8020], [8123, 8139],
                            [7930, 7950], [8096, 8104], [7917, 7925], [8027, 8035], [8003, 8011]], 9854))
