package com.iagocanalejas.tests.serializers.jackson;


import com.iagocanalejas.core.Builder;
import com.iagocanalejas.tests.serializers.DualCacheJacksonTest;
import com.iagocanalejas.tests.testobjects.AbstractVehicule;

public class RamCustomSerializerDiskCustomSerializer extends DualCacheJacksonTest {

    @Override
    public void setUp() throws Exception {
        super.setUp();
        cache = new Builder<AbstractVehicule>(CACHE_NAME, TEST_APP_VERSION)
                .enableLog()
                .useSerializerInRam(RAM_MAX_SIZE, new SerializerForTesting())
                .useSerializerInDisk(DISK_MAX_SIZE, true, new SerializerForTesting(), getContext())
                .build();
    }
}