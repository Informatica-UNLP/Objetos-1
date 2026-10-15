package ejercicio9.genealogiasalvaje;
import java.time.LocalDate;

public class Mamifero {

	private String id;
	private String especie;
	private java.time.LocalDate fechaNacimiento;
	private Mamifero padre;
	private Mamifero madre;
	
	public Mamifero (String id){
		this.id = id;
		this.padre = null;
		this.madre = null;
		
	}
	
	public String getIdentificador() {
		return this.id;
	}
	
	
	public void setIdentificador(String id){
		this.id = id;
	}
	
	public String getEspecie() {
		return this.especie;
	}
	
	public void setEspecie(String especie) {
		this.especie = especie;
	}

	
	public java.time.LocalDate getFechaNacimiento(){
		return fechaNacimiento;
	}
	
	
	public void setFechaNacimiento(java.time.LocalDate FechaNacimiento){
		this.fechaNacimiento = FechaNacimiento;			
	}

	public Mamifero getPadre() {
		return this.padre;
	}
	
	public void setPadre(Mamifero padre) {
		this.padre = padre;
	}
	
	public Mamifero getMadre() {
		return this.madre;
	}
	
	public void setMadre(Mamifero madre) {
		this.madre = madre;
	}

	public Mamifero getAbueloMaterno(){
		return this.madre != null ? this.madre.getPadre() : null;
	}
	
	public Mamifero getAbuelaMaterna(){
		return this.madre != null ? this.madre.getMadre() : null;
	}
	
	public Mamifero getAbueloPaterno(){
		return this.padre != null ? this.padre.getPadre() : null;
	}
	
	public Mamifero getAbuelaPaterna(){
		return this.padre != null ? this.padre.getMadre() : null;
	}
	
	public boolean soyYo(Mamifero m) {
		return this.equals(m);
	}
	
	public boolean tieneComoAncestroA(Mamifero unMamifero) {
		if (this.soyYo(unMamifero)) {
			return false;
		}
		return this.madre != null && (this.madre == unMamifero
			|| this.madre.tieneComoAncestroA(unMamifero))
			|| this.padre != null && (this.padre == unMamifero
			|| this.padre.tieneComoAncestroA(unMamifero));
	}
			   			   

   

}