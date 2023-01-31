package gov.epa.ccte.api.hazard.dto.mapper;

import gov.epa.ccte.api.hazard.domain.Hazard;
import gov.epa.ccte.api.hazard.dto.HazardDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface HazardMapper {
    Hazard toEntity(HazardDto hazardDto);

    HazardDto toDto(Hazard hazard);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Hazard partialUpdate(HazardDto hazardDto, @MappingTarget Hazard hazard);
}