package com.example.store_dayz.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class InfoGroup {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  private String structure;

  private String lifeInside;

  private String goals;

  private String quote;

  private String motto;

  private String description;

  private String founder;

  private String value;

  private String name;

  @ManyToOne
  @JoinColumn(name = "features_id", referencedColumnName = "id")
  private Feature feature;

}
