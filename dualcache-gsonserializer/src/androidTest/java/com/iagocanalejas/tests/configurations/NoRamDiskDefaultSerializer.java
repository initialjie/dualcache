package com.iagocanalejas.tests.configurations;


import com.iagocanalejas.dualcache.DualCache;
import com.iagocanalejas.tests.DualCacheGsonTest;
import com.iagocanalejas.tests.testobjects.AbstractVehicle;

public class NoRamDiskDefaultSerializer extends DualCacheGsonTest {

    @Override
    public void setUp() throws Exception {
        super.setUp();
        cache = new DualCache.Builder<AbstractVehicle>(CACHE_NAME, TEST_APP_VERSION)
                .enableLog()
                .noRam()
                .useSerializerInDisk(DISK_MAX_SIZE, true, mDefaultParser, getContext())
                .build();
    }
}