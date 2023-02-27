package gov.epa.ccte.api.hazard.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@Table(name = "skin_eye_vw")
public class SkinEye {
    @Id
    @NotNull
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 255)
    private String classification;

    @Size(max = 255)
    private String dtxsid;

    @Size(max = 255)
    private String endpoint;

    @Size(max = 1024)
    private String guideline;

    @Size(max = 45)
    private String reliability;

    @Size(max = 1024)
    @Column(name = "result_text")
    private String resultText;

    private Long rn;

    @Size(max = 45)
    private String score;

    @Size(max = 45)
    private String source;

    @Size(max = 255)
    private String species;

    @Size(max = 255)
    private String strain;

    @Size(max = 255)
    @Column(name = "study_type")
    private String studyType;

    private Integer year;
}
