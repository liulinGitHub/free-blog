package com.blog.core.common.config;

import com.blog.core.common.enums.BaseEnum;
import com.google.common.collect.Maps;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

import java.util.Map;

/**
 * @Describe
 * @Author:
 * @Date: 2019/3/20 9:32
 * @Version 1.0
 */
public class EnumConverterFactory implements ConverterFactory<String, BaseEnum> {

    private static final Map<Class, Converter> converterMap = Maps.newHashMap();

    @Override
    public <T extends BaseEnum> Converter<String, T> getConverter(Class<T> targetType) {
        Converter<String, T> converter = converterMap.get(targetType);
        if(converter == null){
            converter = new CodeConverterToEnum<>(targetType);
            converterMap.put(targetType, converter);
        }
        return converter;
    }
    /**
     *
     * ClassName: StrToEnum
     * Function: Spring接收到的参数值为字符串类型，Spring会根据枚举的值与传入的字符串进行对应  <br/>
     */
    class CodeConverterToEnum<T extends BaseEnum> implements Converter<String, T> {
        private Map<String, T> enumMap = Maps.newHashMap();

        public CodeConverterToEnum(Class<T> enumType) {
            T[] enums = enumType.getEnumConstants();
            for(T e : enums) {
                enumMap.put(e.getValue(), e);
            }
        }

        @Override
        public T convert(String source) {
            return enumMap.get(source);
        }
    }

}
