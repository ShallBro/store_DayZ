package com.example.store_dayz.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "info_group")
@Getter
@Setter
public class InfoGroup extends GenericGroup {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  private String name;

  private String founder;

  private String description;

  private String motto;

  private String quote;

  private String goals;

  private String lifeInside;

  private String structure;

  private String image;

  private String caruselImg;

  @OneToMany(mappedBy = "item", cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
  @JsonManagedReference
  private List<Feature> features;

}
