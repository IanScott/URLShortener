package com.newbie.urlshortener.util;

/**
 * Utilitize class for calculating Base10.
 * @author Ian van Nieuwkoop
 * Source: https://gist.github.com/jdcrensh/4670128
 */
public class Base62 {

    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static final int BASE = ALPHABET.length();

    private Base62() {}
    
    /**
     * Method for calculating a Base identifier.
     * @param base used to calculate base.
     * @return String containing Base.
     */
    public static String fromBase10(long base) {
        StringBuilder sb = new StringBuilder("");
        while (base > 0) {
            base = fromBase10(base, sb);
        }
        return sb.reverse().toString();
    }

    private static long fromBase10(long i, final StringBuilder sb) {
        int rem = (int) (i % BASE);
        sb.append(ALPHABET.charAt(rem));
        return i / BASE;
    }

    public static long toBase10(String str) {
        return toBase10(new StringBuilder(str).reverse().toString().toCharArray());
    }

    private static long toBase10(char[] chars) {
        long n = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            n += toBase10(ALPHABET.indexOf(chars[i]), i);
        }
        return n;
    }

    private static long toBase10(long n, long pow) {
        return n * (long) Math.pow(BASE, pow);
    }

}
