package ru.levin.tmspring.converter;

import feign.FeignException;
import feign.Response;
import feign.codec.DecodeException;
import feign.codec.Decoder;

import java.io.IOException;
import java.lang.reflect.Type;

public class LocalDateFeignAdapter implements Decoder {

    @Override
    public Object decode(final Response response, final Type type) throws IOException, DecodeException, FeignException {
        return null;
    }

}
