package gov.epa.ccte.api.hazard.dto.mapper;

import gov.epa.ccte.api.hazard.domain.ToxValDb;
import gov.epa.ccte.api.hazard.dto.ToxValDbDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ToxValDbMapper {
	ToxValDb toEntity(ToxValDbDto toxValDbDto);

	ToxValDbDto toDto(ToxValDb toxValDb);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    ToxValDb partialUpdate(ToxValDbDto toxValDbDto, @MappingTarget ToxValDb toxValDb);
}