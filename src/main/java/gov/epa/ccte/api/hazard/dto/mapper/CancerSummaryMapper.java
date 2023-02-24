package gov.epa.ccte.api.hazard.dto.mapper;

import gov.epa.ccte.api.hazard.domain.CancerSummary;
import gov.epa.ccte.api.hazard.dto.CancerSummaryDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CancerSummaryMapper {
    CancerSummary toEntity(CancerSummaryDto cancerSummaryDto);

    CancerSummaryDto toDto(CancerSummary cancerSummary);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    CancerSummary partialUpdate(CancerSummaryDto cancerSummaryDto, @MappingTarget CancerSummary cancerSummary);
}
