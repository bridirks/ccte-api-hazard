package gov.epa.ccte.api.hazard.config.converter;

import gov.epa.ccte.api.hazard.domain.ImageFormat;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToImageFormatConverter implements Converter<String, ImageFormat> {
    @Override
    public ImageFormat convert(String source) {
        return ImageFormat.valueOf(source.toUpperCase());
    }
}
