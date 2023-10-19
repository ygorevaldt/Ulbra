package com.apdois.app.rules.shared.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class MergeObjects {
    public static <T> T execute(T target, T source) {
        if (target == null) {
            throw new IllegalArgumentException("O objeto de destino não pode ser nulo.");
        }
        if (source == null) {
            return target;
        }

        for (Field field : target.getClass().getDeclaredFields()) {
            if (!Modifier.isFinal(field.getModifiers()) && !Modifier.isStatic(field.getModifiers())) {
                field.setAccessible(true);
                try {
                    Object sourceValue = field.get(source);
                    if (sourceValue != null) {
                        field.set(target, sourceValue);
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        return target;
    }
}
