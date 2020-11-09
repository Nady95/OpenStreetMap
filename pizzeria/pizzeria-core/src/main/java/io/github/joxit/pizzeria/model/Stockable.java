package io.github.joxit.pizzeria.model;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * @author Jones Magloire @Joxit
 * @since 2017-11-01
 */
@MappedSuperclass
public abstract class Stockable implements Serializable {
  @Id
  private String name;
  private float prix;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public float getPrix() {
    return prix;
  }

  public void setPrix(float prix) {
    this.prix = prix;
  }

  @Override
  public String toString() {
    return "Stockable{" +
        "name='" + name + '\'' +
        ", prix=" + prix +
        '}';
  }
}
