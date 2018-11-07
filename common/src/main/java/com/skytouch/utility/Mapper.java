package com.skytouch.utility;

import org.dozer.DozerBeanMapper;

public final class Mapper{

    private static final DozerBeanMapper mapper = new DozerBeanMapper();

    private Mapper() {
        throw new UnsupportedOperationException();
    }

    public static <T> T mapObject(Object source, Class<T> destinationClass) {
        return mapper.map(source, destinationClass);
    }

}

