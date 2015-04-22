package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;
import java.util.List;

import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import javax.swing.JComponent;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import Controller.GeoJsonParser;
import Controller.OnFeatureClickHandler;

import com.esri.core.map.Feature;
import com.esri.core.map.Graphic;
import com.esri.core.symbol.CompositeSymbol;
import com.esri.core.symbol.SimpleFillSymbol;
import com.esri.core.symbol.SimpleLineSymbol;
import com.esri.map.GraphicsLayer;
import com.esri.map.JMap;
import com.esri.map.MapEvent;
import com.esri.map.MapEventListenerAdapter;
import com.esri.map.MapOptions;
import com.esri.map.MapOptions.MapType;
import com.esri.toolkit.overlays.HitTestOverlay;
import com.esri.toolkit.overlays.InfoPopupOverlay;

public class Map {	

// 	private final FXMap map;
// 	private final GraphicsLayer graphicsLayer;
// 	
//	public Map(){
//		map = new FXMap();
//		graphicsLayer = new GraphicsLayer();
//		generateWorldLayer();
//		generateCountriesLayer();
//		addHitListener();
//	}
//	
//	private void generateWorldLayer(){
//	 	    ArcGISTiledMapServiceLayer worldLayer = new ArcGISTiledMapServiceLayer(
//	 		        "http://services.arcgisonline.com/ArcGIS/rest/services/NGS_Topo_US_2D/MapServer");
//	 	   map.getLayerList().add(worldLayer);
//	}
//	
//	private void generateCountriesLayer(){
//		 try {
//		      // create an instance of the parser
//		      GeoJsonParser geoJsonParser = new GeoJsonParser();
//		      
//		      // provide the symbology for the features
//		      CompositeSymbol symbol = new CompositeSymbol();
//		      symbol.add(new SimpleFillSymbol(new Color(0, 255, 0, 70)));
//		      symbol.add(new SimpleLineSymbol(Color.BLACK, 2));
//		      geoJsonParser.setSymbol(symbol).setOutSpatialReference(map.getSpatialReference());
//		      
//		      // parse geojson data   
//		      File data = new File("src\\res\\countries.geo.json");
//		      List<Feature> features = geoJsonParser.parseFeatures(data);
//		      
//		      // add parsed features to a layer
//		      for (Feature f : features) {
//		       graphicsLayer.addGraphic(new Graphic(f.getGeometry(), f.getSymbol(), f.getAttributes()));
//		      }
//		 	    map.getLayerList().add(graphicsLayer);
//		    } catch (Exception ex) {
//		      throw new RuntimeException(ex);
//		    }
//	}
//	
//	private void addHitListener(){
//	    // add a overlay to highlight features at the clicked location
//	    final HitTestOverlay hitTestOverlay = new HitTestOverlay(graphicsLayer, onFeatureClick);
//	    
//	    // add a overlay to show popup with features' info at the clicked location 
//	    InfoPopupOverlay infoPopupOverlay = new InfoPopupOverlay();
//	    infoPopupOverlay.setPopupTitle("Selected Country");
//	    infoPopupOverlay.addLayer(graphicsLayer);
//	}
		  
//		  public FXMap getMap(){
//			  return map;
//		  }
	
	private JMap map;

	private Stage root;
	private String selectedMap;
	
	public Map(Stage root, String selectedMap){
		this.root = root;
		this.selectedMap = selectedMap;
	}
	
	public void dispose(){
		this.map.dispose();
	}
	
	  
	  // ------------------------------------------------------------------------
	  // Core functionality
//	  // ------------------------------------------------------------------------
//	  /**
//	   * Parse GeoJSON file and add the features to a graphics layer.
//	   * @param graphicsLayer layer to which the features should be added.
//	   */
	  private void addGeoJsonFeatures(GraphicsLayer graphicsLayer) {
		  try {
	      // create an instance of the parser
	      GeoJsonParser geoJsonParser = new GeoJsonParser();
	      
	      // provide the symbology for the features
	      CompositeSymbol symbol = new CompositeSymbol();
	      symbol.add(new SimpleFillSymbol(new Color(0, 255, 0, 70)));
	      symbol.add(new SimpleLineSymbol(Color.BLACK, 2));
	      geoJsonParser.setSymbol(symbol).setOutSpatialReference(map.getSpatialReference());
	      
	      // parse geojson data   
//	      File data = new File("src\\res\\eucountries.geo.json");
	      List<Feature> features = geoJsonParser.parseFeatures(getClass().getResourceAsStream("/res/" + selectedMap+ ".geo.json"));
	      
	      // add parsed features to a layer
	      for (Feature f : features) {
	       graphicsLayer.addGraphic(new Graphic(f.getGeometry(), f.getSymbol(), f.getAttributes()));
	      }
	    } catch (Exception ex) {
	      throw new RuntimeException(ex);
	    }
	  }
	  
	  // ------------------------------------------------------------------------
	  // Static methods
	  // ------------------------------------------------------------------------
	  /**
	   * Starting point of this application.
	   * 
	   * @param args arguments to this application.
	   */
	  

	  // ------------------------------------------------------------------------
	  // Public methods
	  // ------------------------------------------------------------------------
	  /**
	   * Creates and displays the UI, including the map, for this application.
	   * 
	   * @return the UI component.
	   */
	  public JComponent createUI() {
	    JComponent contentPane = createContentPane();
	    map = createMap();
	    contentPane.add(map);
	    return contentPane;
	  }

	  // ------------------------------------------------------------------------
	  // Private methods
	  // ------------------------------------------------------------------------
	  /**
	   * Creates a content pane.
	   * 
	   * @return a content pane.
	   */
	  private static JLayeredPane createContentPane() {
	    JLayeredPane contentPane = new JLayeredPane();
	    contentPane.setBounds(100, 100, 1000, 700);
	    contentPane.setLayout(new BorderLayout(0, 0));
	    contentPane.setVisible(true);
	    return contentPane;
	  }

	  /**
	   * Creates a window.
	   * 
	   * @return a window.
	   */
	  public JPanel createWindow() {
	    JPanel window = new JPanel();
	    window.setBounds(100, 100, 1000, 700);
	    window.setLayout(new BorderLayout(0, 0));
        root.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
            	System.out.println("Window is closing");
            	System.exit(1);
            }
        });     
	    return window;
	  }
	  
	  /**
	   * Creates a map with a graphics layer and required overlays.
	   * @return a map instance.
	   */
	  private JMap createMap() {

	    MapOptions options = new MapOptions(MapType.NATIONAL_GEOGRAPHIC);
	    final JMap jMap = new JMap(options);
	    
	    // create the graphics layer to which the features will be added
	    final GraphicsLayer graphicsLayer = new GraphicsLayer();
	    jMap.getLayers().add(graphicsLayer);
	    
	    // add a overlay to highlight features at the clicked location
	    final HitTestOverlay hitTestOverlay = new HitTestOverlay(graphicsLayer, new OnFeatureClickHandler());
	    jMap.addMapOverlay(hitTestOverlay);
	    
	    // add a overlay to show popup with features' info at the clicked location 
	    InfoPopupOverlay infoPopupOverlay = new InfoPopupOverlay();
	    infoPopupOverlay.setPopupTitle("Selected Country");
	    infoPopupOverlay.setItemTitle("Name: {name}");
	    infoPopupOverlay.addLayer(graphicsLayer);
	    jMap.addMapOverlay(infoPopupOverlay);

	    // add features after map is ready
	    jMap.addMapEventListener(new MapEventListenerAdapter() {
	      @Override
	      public void mapReady(final MapEvent arg0) {
	        SwingUtilities.invokeLater(new Runnable() {
	          @Override
	          public void run() {
	            addGeoJsonFeatures(graphicsLayer);
	          }
	        });
	      }
	    });

	    return jMap;
	  }
	  

	  
	}