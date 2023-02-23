package gov.epa.ccte.api.hazard.dto.mapper;

import gov.epa.ccte.api.hazard.domain.Ecotox;
import gov.epa.ccte.api.hazard.dto.EcotoxDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface EcotoxMapper {
    Ecotox toEntity(EcotoxDto ecotoxDto);

    EcotoxDto toDto(Ecotox ecotox);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Ecotox partialUpdate(EcotoxDto ecotoxDto, @MappingTarget Ecotox ecotox);
}
