package com.iagocanalejas.tests.serializers.jackson;


import com.iagocanalejas.dualcache.DualCache;
import com.iagocanalejas.tests.serializers.DualCacheJacksonTest;
import com.iagocanalejas.tests.testobjects.AbstractVehicule;

public class NoRamDiskCustomSerializer extends DualCacheJacksonTest {

    @Override
    public void setUp() throws Exception {
        super.setUp();
        cache = new DualCache.Builder<AbstractVehicule>(CACHE_NAME, TEST_APP_VERSION)
                .enableLog()
                .noRam()
                .useSerializerInDisk(
                        DISK_MAX_SIZE,
                        true,
                        new SerializerForTesting(),
                        getContext())
                .build();
    }
}
