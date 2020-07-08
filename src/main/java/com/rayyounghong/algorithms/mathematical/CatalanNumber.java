package com.rayyounghong.algorithms.mathematical;

/**
 * {@link CatalanNumber} provides method to calculate the n-th catalan number.
 *
 * @see <a href="https://en.wikipedia.org/wiki/Catalan_number">Catalan number</a>
 * @author ray
 */
public class CatalanNumber {

    /**
     * Find nth catalan number.
     *
     * @param n
     *            given number
     * @return the {@code n}-th catalan number
     */
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

}
