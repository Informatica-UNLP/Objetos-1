package ejercicio11.cuentaConGanchos;

public class CuentaCorriente extends Cuenta{
	
	private double descubierto;
	
	public CuentaCorriente() {
		this.descubierto = 0;
	}
	
	@Override
	protected boolean puedeExtraer(double monto) {
		return this.getSaldo() + this.descubierto >= monto;
	}
	
	public double getDescubierto() {
		return this.descubierto;
	}
	public void setDescubierto(double valor) {
		this.descubierto = valor;
	}
	
}
