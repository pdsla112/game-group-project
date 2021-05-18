package com.company.BloomFilter;


import java.util.BitSet;

/**
 * This class is the bloom filter.
 * There is only one bloom filter for saving and loading players, so the methods are static.
 * @author Dong Seok La (u6943702)
 */
public class BloomFilter {
    private BitSet bitArr;

    public BloomFilter(BitSet bitArr) {
        this.bitArr = bitArr;
    }

    /**
     * If it shows in the bloom filter that an email hasn't been saved yet in the database,
     * it will convert the boolean value (0/1) at that hash index to true.
     * @param username
     * @author Dong Seok La (u6943702)
     */
    public void add(String username) {
        if (!mightContain(username)) {
            int hash = getHash(username);
            bitArr.set(hash, true);
        }
    }

    /**
     * Checks the boolean value in the bloom filter at that hash index for the inputted email.
     * If false, it is impossible that the email is already saved in the database.
     * If true, that email may or may not have already been saved in the database.
     * @param username
     * @return boolean
     * @author Dong Seok La (u6943702)
     */
    public boolean mightContain(String username) {
        int hash = getHash(username);
        if (bitArr.get(hash))
            return true;
        else
            return false;
    }

    /**
     * Returns the integer hash of the email string.
     * The hash has an upper bound of 63 and a lower bound of 0.
     * @param username
     * @return integer hash value
     * @author Dong Seok La (u6943702)
     */
    public int getHash(String username) {
        int hash = username.hashCode() % 64;
        if (hash < 0)
            return -1 * hash;
        System.out.println("Hash: " + hash);
        return hash;
    }

    /**
     * Returns the current bitset that represents the bloom filter as a data structure.
     * @return BitSet
     * @author Dong Seok La (u6943702)
     */
    public BitSet getBitArr() {
        return bitArr;
    }

    /**
     * Resets the bloom filter to have all its values to be false.
     * Use this method with caution. If you want this to have a lasting effect, you must serialise/save the bloom filter
     * afterwards.
     * @return the "resetted" BitSet
     * @author Dong Seok La (u6943702)
     */
    public BitSet resetBits() {
        bitArr.set(0, 63, false);
        return bitArr;
    }
}
