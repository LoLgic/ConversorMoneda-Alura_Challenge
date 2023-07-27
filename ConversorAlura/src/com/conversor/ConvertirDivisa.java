package com.conversor;


import java.math.RoundingMode;
import java.text.DecimalFormat;




public class ConvertirDivisa {
	
	
	
	public static final double DOLAR = 3966.41;
	public static final double EURO = 4412.39;
    public static final double LIBRA = 5101.30;
    public static final double YEN = 27.98;
    public static final double WON = 3.08;
    public static final double REAL_BRASILERO = 832.53;

    
	public double convertirPesoAMoneda(double valor, double moneda) { 
		return valor * moneda;
	}
	public double convertirMonedaAPeso(double valor, double moneda) {
		return valor / moneda;
	}
	
	public String Redondear(double valor, String decimales) {
        DecimalFormat decimal = new DecimalFormat(decimales);
        decimal.setRoundingMode(RoundingMode.HALF_UP);
        return decimal.format(valor);
    }

					
}

	
	
