package ejercicio23.ejercicio23_PoliticaDeCancelacion;

public class CancelacionModerada implements PoliticaDeCancelacion {
	
	@Override
	public double reembolso(double monto, int diasDeAnticipacion) {
		double reembolso = 0;
		if (diasDeAnticipacion >= 7) {
			reembolso = monto;
		}
		else if(diasDeAnticipacion <7 && diasDeAnticipacion >=2 ) {
			reembolso = monto * 0.5;
		}
		
		return reembolso;
		
	}
	
}
