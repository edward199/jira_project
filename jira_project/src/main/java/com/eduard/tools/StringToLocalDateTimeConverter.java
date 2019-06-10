package com.eduard.tools;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.core.convert.converter.Converter;

public class StringToLocalDateTimeConverter implements Converter<String, LocalDateTime> {
	@Override
	public LocalDateTime convert(String source) {
		DateTimeFormatter formatter = DateTimeFormatter.BASIC_ISO_DATE;
		return LocalDateTime.parse(source, formatter);
	}
}
