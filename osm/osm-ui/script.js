const accessToken = ''

const map = new mapboxgl.Map({
  container: 'map', // container id
  style: {
    "version": 8,
    "sources": {},
    "layers": []
  },
  center: [-74.50, 40],
  zoom: 2,
  hash: true
});

// Récuperer un trajet voiture
// https://api.jawg.io/routing/route/v1/car/{lng},{lat};{lng},{lat}?access-token=<access-token>&overview=full&steps=false&geometries=geojson
// https://api.jawg.io/routing/route/v1/car/2.342865,48.858705;7.71048,44.97739?access-token=<access-token>&overview=full&steps=false&geometries=geojson
function getRouting(c1, c2) {
  return fetch(`https://api.jawg.io/routing/route/v1/car/${c1.lng},${c1.lat};${c2.lng},${c2.lat}?access-token=${accessToken}&overview=full&steps=false&geometries=geojson`)
    // on transforme la réponse en JSON, méthode de la spec de fetch
    // https://developer.mozilla.org/fr/docs/Web/API/Body/json
    .then(res => res.json())
    .then(res => {
      // Réponse : {"code":"Ok","routes":[ { GeoJSON } ], "waypoints": [ { Metadata } ] }
      // Do stuff
  })
}

map.on("load", () => {
  // Code executé après le chargement de la carte
  // C'est ici qu'on peut ajouter de nouvelles sources ou de nouveaux layers
  // Lien de l'API mapbox-gl-js : https://docs.mapbox.com/mapbox-gl-js/api/
  // Quelques méthodes utiles:
  // Ajout de source : map.addSource("nom-de-source", {type: "source-type", data: "data-url or content"})
  // Ajout de layer : map.addLayer("nom-de-layer", {id: "id-layer", type: "type-layer", source: "source-ref", paint: {}, layout: {}})
});