package com.mvc.databiner;

import org.apache.catalina.User;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author zl
 */
public class UserGenericConverter implements GenericConverter {
    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        Set<ConvertiblePair> pairs = new HashSet<ConvertiblePair>();
        pairs.add(new ConvertiblePair(Integer.class, String.class));
        pairs.add(new ConvertiblePair(String.class, String.class));
        return pairs;
    }

    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        if (Objects.isNull(source) || Objects.isNull(sourceType) || Objects.isNull(targetType)) {
            return null;
        }
        String res = null;
        if (sourceType.getType() == Integer.class) {
            res=String.valueOf(source);
        } else if (sourceType.getType() == String.class) {
            res= (String) source;
        }
        return res;
    }
}
