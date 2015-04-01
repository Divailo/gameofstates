package View;

import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class CityStatsView extends BorderPane {
	
	// pokazwa statsowete na grada
	// po-kysno moje da go izpolzwame kato cykne6 enemy teritoriq da ti pokazwa gore wlqwo taq informaciq
	
	// po-kysno 6te iska city, za da moje da pokaje nujnite ne6ta
	
	public CityStatsView(){
		//nz dali slidera e naj-podhodq6toto ne6to
		createActualStats();
	}
	
	private void createActualStats(){
		GridPane stats = new GridPane();
		stats.setHgap(10);
		stats.setVgap(10);
        Label militaryLabel = new Label("Military:");
        Label cultureLabel = new Label("Culture:");
        Label faithLabel = new Label("Faith:");
        Label economyLabel = new Label("Economy:");
        stats.add(militaryLabel, 0, 0);
        stats.add(cultureLabel, 0, 1);
        stats.add(faithLabel, 0, 2);
        stats.add(economyLabel, 0, 3);
        
        Slider s1 = new Slider(0,10,5);
        s1.setDisable(true);
        Slider s2 = new Slider(0,10,5);
        s2.setDisable(true);
        Slider s3 = new Slider(0,10,5);
        s3.setDisable(true);
        Slider s4 = new Slider(0,10,5);
        s4.setDisable(true);
        stats.add(s1, 1, 0);
        stats.add(s2, 1, 1);
        stats.add(s3, 1, 2);
        stats.add(s4, 1, 3);
		this.setCenter(stats);
	}

}
