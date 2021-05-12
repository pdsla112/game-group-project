package com.company.BloomFilter;

import java.util.BitSet;

public class BloomFilter {
    private static final BitSet bitArr = new BitSet(64);

    public static void main(String[] args) {
        BitSet bitArray = new BitSet(64);
        add("pdsla112");
        System.out.println(mightContain("pdsla112"));
        System.out.println(resetBits());
    }

    public static void add(String email) {
        if (!mightContain(email)) {
            int hash = getHash(email);
            bitArr.set(hash, true);
        }
    }

    public static boolean mightContain(String email) {
        int hash = getHash(email);
        if (bitArr.get(hash))
            return true;
        else
            return false;
    }

    public static int getHash(String email) {
        int hash = email.hashCode() % 64;
        if (hash < 0)
            return -1 * hash;
        return hash;
    }

    public static BitSet getBitArr() {
        return bitArr;
    }

    public static BitSet resetBits() {
        bitArr.set(0, 63, false);
        return bitArr;
    }
}
