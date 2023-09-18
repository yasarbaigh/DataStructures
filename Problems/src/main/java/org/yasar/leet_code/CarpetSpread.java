package org.yasar.leet_code;

import java.util.Arrays;

// https://leetcode.com/problems/maximum-white-tiles-covered-by-a-carpet/submissions/?source=submission-noac
public class CarpetSpread {

	public static void main(String[] args) {

		int[][] ab = { { 1, 5 }, { 10, 11 }, { 12, 18 }, { 20, 25 }, { 30, 32 } };
		System.out.println(max_mine(ab, 10));

		int[][] cd = { { 10, 11 }, { 1, 1 } };
		System.out.println(max_mine(cd, 2));

		int[][] cd1 = { { 8051, 8057 }, { 8074, 8089 }, { 7994, 7995 }, { 7969, 7987 }, { 8013, 8020 }, { 8123, 8139 },
				{ 7930, 7950 }, { 8096, 8104 }, { 7917, 7925 }, { 8027, 8035 }, { 8003, 8011 } };

		System.out.println(max_mine(cd1, 9854));

		int[][] cd5 = { { 33783, 33797 }, { 33410, 33438 }, { 20562, 20570 }, { 24869, 24896 }, { 26430, 26451 },
				{ 24643, 24670 }, { 23936, 23945 }, { 32946, 32952 }, { 34837, 34860 }, { 23325, 23327 },
				{ 19285, 19335 }, { 22471, 22498 }, { 34645, 34690 }, { 19501, 19523 }, { 23672, 23698 },
				{ 21473, 21521 }, { 27452, 27479 }, { 21810, 21830 }, { 25227, 25275 }, { 31705, 31724 },
				{ 27804, 27838 }, { 21944, 21978 }, { 22535, 22585 }, { 28153, 28191 }, { 28110, 28112 },
				{ 28497, 28520 }, { 34141, 34178 }, { 34409, 34445 }, { 35586, 35609 }, { 32364, 32369 },
				{ 27428, 27447 }, { 27612, 27638 }, { 24240, 24271 }, { 20600, 20600 }, { 22046, 22091 },
				{ 36195, 36244 }, { 22855, 22861 }, { 21710, 21748 }, { 25518, 25565 }, { 26140, 26176 },
				{ 22949, 22966 }, { 24124, 24155 }, { 33621, 33667 }, { 26781, 26829 }, { 29690, 29701 },
				{ 19418, 19451 }, { 19556, 19596 }, { 26501, 26547 }, { 35897, 35921 }, { 21281, 21327 },
				{ 21086, 21123 }, { 35000, 35042 }, { 20703, 20740 }, { 20441, 20462 }, { 35719, 35767 },
				{ 26321, 26365 }, { 30275, 30296 }, { 34095, 34109 }, { 32077, 32098 }, { 24410, 24417 },
				{ 28282, 28306 }, { 35117, 35118 }, { 30893, 30923 }, { 30515, 30527 }, { 31071, 31105 },
				{ 34983, 34993 }, { 21226, 21276 }, { 35560, 35572 }, { 35088, 35100 }, { 31336, 31371 },
				{ 23074, 23123 }, { 22016, 22035 }, { 22343, 22351 }, { 35515, 35552 }, { 23406, 23406 },
				{ 31140, 31170 }, { 23515, 23555 }, { 33692, 33701 }, { 21759, 21786 }, { 31997, 32047 },
				{ 30234, 30256 }, { 21678, 21689 }, { 28469, 28484 }, { 28570, 28596 }, { 25649, 25688 },
				{ 32509, 32537 }, { 21544, 21559 }, { 21400, 21441 }, { 25072, 25085 }, { 20991, 21021 },
				{ 28597, 28613 }, { 34001, 34018 }, { 28757, 28778 }, { 31205, 31205 }, { 22705, 22753 },
				{ 31018, 31031 }, { 27757, 27801 }, { 29397, 29422 }, { 22140, 22159 }, { 26245, 26271 },
				{ 27846, 27866 }, { 34463, 34503 }, { 24985, 25012 }, { 25378, 25395 }, { 30311, 30361 },
				{ 20070, 20078 }, { 36025, 36056 }, { 34321, 34361 }, { 25349, 25354 }, { 24909, 24935 },
				{ 26210, 26242 }, { 22818, 22822 }, { 36256, 36264 }, { 34229, 34232 }, { 27164, 27180 },
				{ 29171, 29181 }, { 19787, 19832 }, { 20647, 20658 }, { 26860, 26876 }, { 25592, 25636 },
				{ 36151, 36151 }, { 35961, 35963 }, { 23885, 23928 }, { 30573, 30606 }, { 28960, 28968 },
				{ 20150, 20190 }, { 18900, 18940 }, { 23717, 23754 }, { 34773, 34793 }, { 29811, 29849 },
				{ 25427, 25428 }, { 25092, 25116 }, { 27273, 27312 }, { 30408, 30417 }, { 20202, 20229 },
				{ 32458, 32503 }, { 24786, 24815 }, { 36423, 36442 }, { 28898, 28941 }, { 18948, 18986 },
				{ 24464, 24493 }, { 28627, 28654 }, { 20808, 20847 }, { 22594, 22611 }, { 27675, 27680 },
				{ 29855, 29890 }, { 26004, 26048 }, { 27029, 27031 }, { 32695, 32735 }, { 20511, 20525 },
				{ 34900, 34938 }, { 29189, 29192 }, { 32780, 32800 }, { 27688, 27729 }, { 25316, 25319 },
				{ 35213, 35263 }, { 31871, 31910 }, { 24309, 24319 }, { 23563, 23578 }, { 27315, 27343 },
				{ 22370, 22376 }, { 23449, 23485 }, { 31281, 31287 }, { 27953, 27964 }, { 23582, 23616 },
				{ 22127, 22138 }, { 29647, 29674 }, { 30456, 30457 }, { 27987, 27998 }, { 29597, 29621 },
				{ 29102, 29150 }, { 31738, 31741 }, { 30662, 30704 }, { 20948, 20983 }, { 19647, 19678 },
				{ 19158, 19207 }, { 19233, 19249 }, { 33920, 33959 }, { 29933, 29966 }, { 25465, 25495 },
				{ 18999, 19043 }, { 33294, 33318 }, { 20295, 20339 }, { 30960, 31001 }, { 29072, 29077 },
				{ 19873, 19878 }, { 30842, 30860 }, { 33064, 33088 }, { 23158, 23208 }, { 32845, 32845 },
				{ 27194, 27197 }, { 27082, 27125 }, { 32213, 32233 }, { 36081, 36129 }, { 32977, 32979 },
				{ 32911, 32934 }, { 33881, 33896 }, { 25167, 25188 }, { 32102, 32135 }, { 19089, 19120 },
				{ 26095, 26107 }, { 27215, 27245 }, { 21339, 21389 }, { 34552, 34586 }, { 22863, 22899 },
				{ 28353, 28399 }, { 25980, 25999 }, { 35144, 35182 }, { 20099, 20131 }, { 36290, 36308 },
				{ 34588, 34607 }, { 29508, 29553 }, { 35298, 35345 }, { 22771, 22792 }, { 33224, 33235 },
				{ 32600, 32607 }, { 24588, 24613 }, { 25847, 25889 }, { 25039, 25050 }, { 24836, 24857 },
				{ 29728, 29767 }, { 26974, 26995 }, { 20920, 20939 }, { 33002, 33036 }, { 19623, 19628 },
				{ 25693, 25735 }, { 28200, 28234 }, { 29211, 29215 }, { 31273, 31280 }, { 23967, 24012 },
				{ 35385, 35387 }, { 33744, 33752 }, { 26452, 26470 }, { 22444, 22457 }, { 20743, 20784 },
				{ 22300, 22311 }, { 32245, 32277 }, { 27578, 27582 }, { 34054, 34055 }, { 30060, 30099 },
				{ 24063, 24084 }, { 23041, 23052 }, { 30004, 30030 }, { 20242, 20261 }, { 28971, 29014 },
				{ 34717, 34736 }, { 31512, 31539 }, { 31623, 31659 }, { 23005, 23017 }, { 27393, 27394 },
				{ 22101, 22116 }, { 26727, 26766 }, { 25918, 25946 }, { 29237, 29267 }, { 33836, 33845 },
				{ 29283, 29293 }, { 23617, 23618 }, { 23756, 23779 }, { 23313, 23318 }, { 30608, 30648 },
				{ 27037, 27038 }, { 21152, 21176 }, { 28785, 28799 }, { 21864, 21884 }, { 20368, 20403 },
				{ 22408, 22423 }, { 32394, 32424 }, { 32574, 32593 }, { 19341, 19378 }, { 35409, 35447 },
				{ 25817, 25835 }, { 33268, 33282 }, { 33176, 33195 }, { 26414, 26424 }, { 31783, 31831 },
				{ 22640, 22674 }, { 33119, 33155 }, { 19710, 19741 }, { 28079, 28079 }, { 24366, 24397 },
				{ 28843, 28882 }, { 35477, 35512 }, { 30476, 30514 }, { 20014, 20028 }, { 30720, 30744 },
				{ 25766, 25786 }, { 21066, 21068 }, { 19920, 19968 }, { 31478, 31486 }, { 34249, 34251 },
				{ 27893, 27927 }, { 33347, 33371 }, { 28046, 28058 }, { 32279, 32308 }, { 32944, 32944 },
				{ 23235, 23282 }, { 28440, 28443 }, { 33573, 33610 }, { 33443, 33444 }, { 21909, 21913 },
				{ 24717, 24765 }, { 35964, 36014 }, { 23641, 23659 }, { 21596, 21609 }, { 32658, 32668 },
				{ 24160, 24192 }, { 27135, 27147 }, { 35806, 35847 }, { 30790, 30807 }, { 31939, 31963 },
				{ 35658, 35672 }, { 20888, 20914 }, { 29322, 29355 }, { 30755, 30784 }, { 31217, 31267 },
				{ 24564, 24586 }, { 32164, 32206 }, { 28694, 28736 }, { 26558, 26605 }, { 30142, 30192 },
				{ 36357, 36401 }, { 35924, 35928 }, { 28620, 28624 }, { 29456, 29505 }, { 27012, 27017 },
				{ 26926, 26958 }, { 32610, 32614 }, { 31304, 31327 }, { 24495, 24539 }, { 26656, 26705 },
				{ 36474, 36501 }, { 32322, 32333 }, { 34635, 34640 }, { 34292, 34304 }, { 31386, 31428 },
				{ 23827, 23874 }, { 21620, 21654 }, { 23343, 23358 }, { 32878, 32891 }, { 31589, 31597 },
				{ 22201, 22251 }, { 29024, 29071 }, { 27504, 27529 }, { 33488, 33522 } };
		System.out.println(max_mine(cd5, 2144));
	}

	public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
		for (int[] row : tiles)
			System.out.println(Arrays.toString(row));

		Arrays.sort(tiles, (a, b) -> {
			return a[0] - b[0];
		});
		int x = 0;
		int y = 0;
		long maxCount = 0;
		long count = 0;

		while (y < tiles.length && x <= y) {
			long start = tiles[x][0];
			long end = tiles[y][1];

			if (end - start + 1 <= carpetLen) {
				count += tiles[y][1] - tiles[y][0] + 1;
				maxCount = Math.max(maxCount, count);
				y++;
			} else {
				long midDist = start + carpetLen - 1;
				long s = tiles[y][0];
				long e = tiles[y][1];
				if (midDist <= e && midDist >= s)
					maxCount = Math.max(maxCount, count + midDist - s + 1);
				count -= tiles[x][1] - tiles[x][0] + 1;
				x++;
			}
		}
		return (int) maxCount;
	}

	public static int max_mine(int[][] tiles, int carpetLen) {
		for (int[] row : tiles) {
			System.out.println(Arrays.toString(row));
		}
		// System.out.println(carpetLen);

		Arrays.sort(tiles, (a, b) -> {
			return a[0] - b[0];
		});

		int x = 0;
		int y = 0;
		long max_tile_count = 0;
		long tile_count = 0;

		while (y < tiles.length && x <= y) {
			long start = tiles[x][0];
			long end = tiles[y][1];

			if (end - start + 1 <= carpetLen) {

				// able to cover next-cell with carpet
				tile_count += tiles[y][1] - tiles[y][0] + 1;
				max_tile_count = Math.max(max_tile_count, tile_count);

				y++;
			} else {

				// unable to cover next-cell with carpet
				long mid_cell_covered = start + carpetLen - 1;
				long ys = tiles[y][0];
				long ye = tiles[y][1];

				// checking if next-call can be partially covered
				if (ys <= mid_cell_covered && mid_cell_covered <= ye)
					max_tile_count = Math.max(max_tile_count, tile_count + mid_cell_covered - ys + 1);

				// starting from X-next-cell
				// so reducing the current-X Tiles
				tile_count -= tiles[x][1] - tiles[x][0] + 1;
				x++;
			}
		}
		return (int) max_tile_count;
	}

}