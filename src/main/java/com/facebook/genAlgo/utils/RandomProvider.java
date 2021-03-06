package com.facebook.genAlgo.utils;

public interface RandomProvider {
    int getInt(int bound);
    int getIntFromRange(int fromInclusive, int toExclusive);
    float getFloat();
}
