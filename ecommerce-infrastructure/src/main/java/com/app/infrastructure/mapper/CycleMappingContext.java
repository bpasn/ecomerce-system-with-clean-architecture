package com.app.infrastructure.mapper;

import java.util.IdentityHashMap;
import java.util.Map;

public class CycleMappingContext {
    private final Map<Object,Object> knowInstances = new IdentityHashMap<>();

    public <T> T getMappedInstance(Object source, Class<T> targetType){
        return targetType.cast(knowInstances.get(source));
    }

    public void storeMappedInstance(Object source, Object target){
        knowInstances.put(source,target);
    }
}
