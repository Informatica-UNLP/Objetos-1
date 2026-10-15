package ejercicio10.farolas;
import java.util.ArrayList;
import java.util.List;


public class Farola {

	private boolean isOn;
	private List <Farola> neighbors;



	public Farola () {
		this.turnOff();
		this.neighbors = new ArrayList <Farola> ();
	}


	public void pairWithNeighbor(Farola otraFarola ) {
		if (!this.neighbors.contains(otraFarola)) {
		this.neighbors.add(otraFarola);	
		otraFarola.pairWithNeighbor(this);
		}	
	}


	public List<Farola> getNeighbors () {
		return this.neighbors;
		
	}

	public void turnOn() {	
		if (this.isOff()) {
			this.isOn = !this.isOn; 
			this.getNeighbors().forEach(farola -> farola.turnOn());
		}		
	}


	public void turnOff() {	
		if (this.isOn()) {
			this.isOn = !this.isOn; 
			this.getNeighbors().forEach(farola -> farola.turnOff());
		}		
	}


	public boolean isOn() {
		return this.isOn;
	}


	public boolean isOff() {
		return !this.isOn;
	}
		
}
