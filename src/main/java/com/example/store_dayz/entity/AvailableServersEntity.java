package com.example.store_dayz.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "available_servers")
@Data
public class AvailableServersEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @ManyToOne
  @JoinColumn(name = "item_id", referencedColumnName = "id")
  private ItemsEntity item;

  private String name;

  public AvailableServersEntity(ItemsEntity item, String name) {
    this.item = item;
    this.name = name;
  }

  public void updateAvailableServersEntity(ItemsEntity item, String name){
    this.item = item;
    this.name = name;
  }

  public AvailableServersEntity() {

  }
}
