package projet.karlo.model;

import lombok.Data;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;


@Entity
@Data
public class TypeVoiture {
    
    @Id
    private String idTypeVoiture;

    @Column(nullable = false)
    private String nomTypeVoiture;

    @Column(nullable = false)
    private String description;

    @OneToMany
    (mappedBy = "typeVoiture")
    @JsonIgnore
    private List<VoitureLouer> voitureLouer;

    @OneToMany
    (mappedBy = "typeVoiture")
    @JsonIgnore
    private List<VoitureVendre> voitureVendre;
}
