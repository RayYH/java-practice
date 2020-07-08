package com.rayyounghong.algorithms.mathematical;

/**
 *
 * @see <a href="https://en.wikipedia.org/wiki/Catalan_number">Catalan Number.</a>
 * @author ray
 */
public class CatalanNumber {
    public int catalan(int n) {
        int res = 0;

        if (n <= 1) {
            return 1;
        }

        for (int i = 0; i < n; i++) {
            res += catalan(i) * catalan((n - 1) - i);
        }

        return res;
    }

    // TODO: more efficient solutions, https://www.geeksforgeeks.org/program-nth-catalan-number/
}
