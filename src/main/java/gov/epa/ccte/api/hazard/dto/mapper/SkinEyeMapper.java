package gov.epa.ccte.api.hazard.dto.mapper;

import gov.epa.ccte.api.hazard.domain.SkinEye;
import gov.epa.ccte.api.hazard.dto.SkinEyeDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface SkinEyeMapper {
    SkinEye toEntity(SkinEyeDto skinEyeDto);

    SkinEyeDto toDto(SkinEye skinEye);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    SkinEye partialUpdate(SkinEyeDto skinEyeDto, @MappingTarget SkinEye skinEye);
}
