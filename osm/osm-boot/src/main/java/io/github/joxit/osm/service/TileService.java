package io.github.joxit.osm.service;

import io.github.joxit.osm.model.Tile;
import io.github.joxit.osm.persistence.TileDAO;
import io.github.joxit.osm.utils.Svg;
import mil.nga.sf.geojson.GeoJsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Service pour retourner les tuiles.
 *
 * @author Jones Magloire @Joxit
 * @since 2019-11-03
 */
@Service
public class TileService {

  /**
   * Ici il faut prendre les coordonnées de la tuile et renvoyer la donnée PNG associée.
   * Vous pouvez y ajouter des fonctionnalités en plus pour améliorer les perfs.
   *
   * @param tile qu'il faut renvoyer
   *
   * @return le byte array au format png
   */
  public byte[] getTile(Tile tile) {
    if(tile.getX() < 0 || tile.getY() < 0 || tile.getZ() < 0) {
      throw new IllegalArgumentException("Nombre négatif");
    } else if(tile.getX() > Math.pow(2, tile.getZ()) || tile.getY() > Math.pow(2, tile.getZ())) {
      throw new IllegalArgumentException("x ou y trop grand");
    } else if(tile.getZ() > 24) {
      throw new IllegalArgumentException("z ne doit pas dépasser 24");
    } else {
      return Svg.getTile(tile);
    }
  }

  /**
   * @return le contenu du fichier prefectures.geojson
   */
  public String getPrefectures() throws IOException {
    return Files.readString(Path.of(Paths.get(System.getProperty("user.dir")) + "/osm-core/src/main/resources/prefectures.geojson"));
  }

  /**
   * Il faudra créer votre DAO pour récuperer les données.
   * Utilisez ce que vous voulez pour faire le DAO.
   *
   * @return les éléments contenus dans la base de données
   */
  public GeoJsonObject getPOIs() {
    return null;
  }
}
