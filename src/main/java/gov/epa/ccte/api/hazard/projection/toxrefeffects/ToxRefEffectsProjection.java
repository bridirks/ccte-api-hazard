package gov.epa.ccte.api.hazard.projection.toxrefeffects;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(enumAsRef = true,name = "ToxRefEffectsProjection", description = "Projection options for ToxRefDB Effects APIs ")
public enum ToxRefEffectsProjection {
    ToxRefEffectsSummary, ToxRefEffectsAll
}
