package ejercicio23.ejercicio23_PoliticaDeCancelacion;

public class CancelacionEstricta implements PoliticaDeCancelacion{
	
	@Override
	public double reembolso(double monto, int diasDeAnticipacion) {
		return 0;
	}

}
