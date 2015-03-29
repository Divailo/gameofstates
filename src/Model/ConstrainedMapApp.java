package Model;

import java.util.List;

import processing.core.PApplet;
import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.GeoJSONReader;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.marker.SimplePointMarker;
import de.fhpotsdam.unfolding.utils.MapUtils;

public class ConstrainedMapApp extends PApplet {

	UnfoldingMap map;

	Location centerLocation = new Location(51.5072, 0.1275);
	float maxPanningDistance = 30;

	public void setup() {
		    size(800, 600);
		 
		    map = new UnfoldingMap(this);
		    MapUtils.createDefaultEventDispatcher(this, map);
		 

		    String rssUrl = "..\\eer.json";
		    List<Feature> features = GeoJSONReader.loadData(this, rssUrl);
		    List<Marker> markers = MapUtils.createSimpleMarkers(features);
		    System.out.println(markers);
		    Location location = map.getLocation(mouseX, mouseY);
		    map.addMarkers(markers);
		}
		 
		public void draw() {
		    map.draw();
		}

}
