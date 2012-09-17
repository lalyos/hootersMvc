package com.acme.hooters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;

import com.acme.hooters.model.Girl;

public class ApplicationConversionServiceFactoryBean extends FormattingConversionServiceFactoryBean {

    @Override
    protected void installFormatters(FormatterRegistry registry) {
        // TODO Auto-generated method stub
        super.installFormatters(registry);
        registry.addConverter(getGirlToStringConverter());
    }

    private Converter<Girl, String> getGirlToStringConverter() {
        return new Converter<Girl, String>() {

            public String convert(Girl girl) {
                
                return girl.getName();
            }};
    }
}
