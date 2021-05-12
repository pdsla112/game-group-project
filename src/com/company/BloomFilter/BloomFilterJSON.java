package com.company.BloomFilter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.BitSet;

/**
 * This class has the responsibility of saving and loading Player bloom filter.
 * @author Dong Seok La (u6943702)
 */
public class BloomFilterJSON {
    /**
     * Saves the bloom filter (could be edited) to the database.
     * @param bloomFilter
     * @author Dong Seok La (u6943702)
     */
    public static void saveBloomFilter(BitSet bloomFilter) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter("BloomFilterDB.json")) {
            JsonElement tree = gson.toJsonTree(bloomFilter);
            gson.toJson(tree, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Retrieve the bloom filter from the database.
     * @return BloomFilter
     * @author Dong Seok La (u6943702)
     */
    public static BloomFilter loadBloomFilter() {
        BloomFilter data = null;
        Gson gson = new Gson();
        JsonReader jsonReader = null;
        final Type objectType = new TypeToken<BloomFilter>(){}.getType();
        try {
            jsonReader = new JsonReader(new FileReader("BloomFilterDB.json"));
            data = gson.fromJson(jsonReader, objectType);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return data;
    }
}
