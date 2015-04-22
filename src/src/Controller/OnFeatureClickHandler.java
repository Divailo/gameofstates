package Controller;

import java.util.List;

import com.esri.core.map.Feature;
import com.esri.map.GraphicsLayer;
import com.esri.toolkit.overlays.HitTestEvent;
import com.esri.toolkit.overlays.HitTestListener;

public class OnFeatureClickHandler implements HitTestListener {

	@Override
    public void featureHit(HitTestEvent event) {
	      List<Feature> hitFeatures = event.getOverlay().getHitFeatures();
	      GraphicsLayer graphicsLayer = (GraphicsLayer) event.getOverlay().getLayer();
	      for (Feature feature : hitFeatures) {
	        int id = (int) feature.getId();
	        if (graphicsLayer.isGraphicSelected(id)) {
	          // if graphic is selected in the layer, unselect it
	          graphicsLayer.unselect(id);
	        } else {
	          // otherwise select graphic in the layer
	          graphicsLayer.select(id);
	        }
	      }
	    }
	
	

}
