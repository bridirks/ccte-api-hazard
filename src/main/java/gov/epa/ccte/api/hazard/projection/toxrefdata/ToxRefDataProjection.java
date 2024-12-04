package gov.epa.ccte.api.hazard.projection.toxrefdata;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(enumAsRef = true,name = "ToxRefDataProjection", description = "Projection options for ToxRefDB Data APIs ")
public enum ToxRefDataProjection {
    ToxRefDataSummary, ToxRefDataAll
}
