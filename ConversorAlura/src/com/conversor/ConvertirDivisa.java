package com.conversor;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;



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

	
	
