package com.iagocanalejas.dualcache.wrappers;


import com.iagocanalejas.dualcache.interfaces.Parser;

/**
 * Created by Iagocanalejas on 26/12/2016.
 * Wraps the default {@link Parser} to add required timestamp value for volatile entries
 *
 * @see {@link VolatileEntry}
 */
public class VolatileParser<T> implements Parser<VolatileEntry<T>> {

    private static final String TIMESTAMP_KEY = " timestamp_key:";

    private Parser<T> mSerializer;

    public VolatileParser(Parser<T> serializer) {
        this.mSerializer = serializer;
    }

    /**
     * Create a {@link VolatileEntry} from a string
     *
     * @param data is the byte array representing the serialized data.
     * @return {@link VolatileEntry}
     */
    @Override
    public VolatileEntry<T> fromString(String data) {
        String[] items = data.split(TIMESTAMP_KEY);
        return new VolatileEntry<>(Long.valueOf(items[1]), mSerializer.fromString(items[0]));
    }

    /**
     * Add the timestamp to the serializable object
     *
     * @param object is the object to serialize.
     * @return object serialized + timestamp serialized
     */
    @Override
    public String toString(VolatileEntry<T> object) {
        return mSerializer.toString(object.getItem())
                + TIMESTAMP_KEY + object.getTimestamp().getTime();
    }
}
