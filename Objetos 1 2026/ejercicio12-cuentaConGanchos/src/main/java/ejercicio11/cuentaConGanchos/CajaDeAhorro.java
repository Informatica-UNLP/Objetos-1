package ejercicio11.cuentaConGanchos;

public class CajaDeAhorro extends Cuenta{
	private static final double COSTO = 0.02;

	@Override
	protected boolean puedeExtraer(double monto) {
		return this.getSaldo() >= monto * (1 + COSTO);
	}

	@Override
	protected void extraerSinControlar(double monto) {
		super.extraerSinControlar(monto * (1 + COSTO));
	}

	@Override
	public void depositar(double monto) {
		super.depositar(monto * (1 - COSTO));
	}
	
}