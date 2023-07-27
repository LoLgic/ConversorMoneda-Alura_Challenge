package com.conversor;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class ConversorUI {
	
	private JFrame frame;
	private JLabel lblResultadoAMoneda;
	private JLabel lblResultadoAPeso;
	private JTextField txtCantidad;
	private JComboBox<String>comboMoneda;
	private String pais;
	private String valorStr;
	
	
	private final static String PATH_FILE = "/logo.png";

	public ConversorUI() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 598, 326);
		frame.setSize(390,600);
		frame.setTitle("Conversor Alura Latam");
		frame.setResizable(false);
		frame.setBackground(Color.decode(Colors.BG.getColor()));
		frame.setLayout(null);
		frame.getContentPane();
		
		Image icon = new ImageIcon(getClass().getResource(PATH_FILE)).getImage();
		frame.setIconImage(icon);
		
		
		Componentes();
	}

	private void Componentes() {
		JLabel lblTitle = new JLabel("Conversor de divisas");
		lblTitle.setBounds(60, 20, 300, 40);
		lblTitle.setForeground(Color.decode(Colors.BLACK.getColor()));
		lblTitle.setFont(new Font(lblTitle.getFont().getName(), Font.BOLD, 24));
		
		
		JLabel lblColombia = new JLabel();
		lblColombia.setBounds(110, 45, 300, 40);
		lblColombia.setText("Peso Colombiano");
		lblColombia.setFont(new Font(lblColombia.getFont().getName(), Font.BOLD, 17));
		lblColombia.setForeground(Color.decode(Colors.BLACK.getColor()));
		 
		JLabel lblConvertir = new JLabel("Convertir");
		lblConvertir.setForeground(Color.decode(Colors.BLUE.getColor()));
		lblConvertir.setBounds(40, 80, 300, 40);
		lblConvertir.setFont(new Font(lblConvertir.getFont().getName(), Font.BOLD, 14));
		
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setForeground(Color.decode(Colors.BLACK.getColor()));
		lblCantidad.setBounds(20, 130, 300, 40);
		lblCantidad.setFont(new Font(lblCantidad.getFont().getName(), Font.BOLD, 16));
		
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(20, 170, 335, 50);
		txtCantidad.setBorder(BorderFactory.createLineBorder(Color.decode(Colors.BLACK_OTHER.getColor()),1));
		txtCantidad.setFont(new Font(txtCantidad.getFont().getName(), Font.PLAIN, 16));

		String placeholder = "Ingrese la cantidad aquí...";
        txtCantidad.setText(placeholder);

		txtCantidad.addFocusListener(new FocusListener(){
			@Override
			public void focusGained(FocusEvent e) {
				txtCantidad.setBorder(BorderFactory.createLineBorder(Color.decode(Colors.BORDER.getColor()),1));
				if (txtCantidad.getText().equals(placeholder)) {
					txtCantidad.setText("");
					txtCantidad.setForeground(Color.decode(Colors.BLACK.getColor()));
				}
				
			}
			@Override
			public void focusLost(FocusEvent e) {
				txtCantidad.setBorder(BorderFactory.createLineBorder(Color.decode(Colors.BLACK.getColor()),1));	
				if (txtCantidad.getText().isEmpty()) {
					txtCantidad.setText(placeholder);
				}
			}	
		});
		txtCantidad.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) && c != KeyEvent.VK_ENTER && c != KeyEvent.VK_BACK_SPACE) {
                    e.consume();
                    JOptionPane.showMessageDialog(frame,"Ingrese solo números", "Error", JOptionPane.ERROR_MESSAGE);
                    txtCantidad.setText("");
                }
            }
        });
			
		JLabel lblConvertidoA = new JLabel("Convertido a");
		lblConvertidoA.setForeground(Color.decode(Colors.BLACK.getColor()));
		lblConvertidoA.setBounds(20, 220, 300, 40);
		lblConvertidoA.setFont(new Font(lblConvertidoA.getFont().getName(), Font.BOLD, 16));
		try {
			UIManager.put("ComboBox.selectionBackground", Color.decode(Colors.BG.getColor()));
	        UIManager.put("ComboBox.selectionForeground", Color.BLACK);
	        
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		DefaultComboBoxModel<String> comboBoxListDe = new DefaultComboBoxModel<>();
		comboBoxListDe.addElement("USD - Dólar Estadounidense");
		comboBoxListDe.addElement("EUR - Euro");
		comboBoxListDe.addElement("GBP - Libra esterlina");
		comboBoxListDe.addElement("JPY - Yen japonés");
		comboBoxListDe.addElement("KRW - Won surcoreano");
		comboBoxListDe.addElement("BRL - Real brasilero");
		comboMoneda = new JComboBox<>(comboBoxListDe);
		comboMoneda.setBounds(20, 260, 335, 50);
		comboMoneda.setRenderer(new ImageComboBoxRenderer());
		comboMoneda.setBackground(Color.decode(Colors.BG.getColor()));
		comboMoneda.setFont(new Font(comboMoneda.getFont().getName(), Font.PLAIN, 16));
		comboMoneda.setBorder(BorderFactory.createLineBorder(Color.decode(Colors.BORDER.getColor()),5));
        comboMoneda.setBorder(null);
  
        

        lblResultadoAMoneda = new JLabel();
        lblResultadoAMoneda.setForeground(Color.decode(Colors.BLACK.getColor()));
        lblResultadoAMoneda.setFont(new Font(lblResultadoAMoneda.getFont().getName(), Font.BOLD, 18));	
        lblResultadoAMoneda.setBounds(20, 350, 336, 40);
		
		
        lblResultadoAPeso = new JLabel();
        lblResultadoAPeso.setForeground(Color.decode(Colors.BLACK.getColor()));
        lblResultadoAPeso.setFont(new Font(lblResultadoAPeso.getFont().getName(), Font.BOLD, 18));	
        lblResultadoAPeso.setBounds(20, 370, 336, 40);
		
        
		JButton btnConvertir = new JButton("Convertir");
		btnConvertir.setFocusPainted(false);
		btnConvertir.setFont(new Font(btnConvertir.getFont().getName(), Font.BOLD, 18));
		btnConvertir.setBounds(20, 450, 336, 40);
		btnConvertir.setBorder(null);
		btnConvertir.setBackground(Color.decode(Colors.BLUE.getColor()));
		btnConvertir.setForeground(Color.WHITE);
		btnConvertir.addMouseListener(new MouseAdapter() {
        	@Override
            public void mouseEntered(MouseEvent e) {
        		btnConvertir.setBackground(Color.decode(Colors.BLUE.getColor()));  
            }
        	@Override
            public void mouseExited(MouseEvent e) {
        		btnConvertir.setBackground(Color.decode(Colors.BLUE_OTHER.getColor()));  
            }
        });
		btnConvertir.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        			valorStr = txtCantidad.getText();
        		if (!valorStr.isEmpty()) {
        			try {
        				double valor = Double.parseDouble(valorStr);
            			convertirDivisa(valor);
					} catch (NumberFormatException ex) {
						JOptionPane.showMessageDialog(frame, "El campo no puede estar vacío", "Error", JOptionPane.ERROR_MESSAGE);
					}
        		}else {
        			JOptionPane.showMessageDialog(frame, "El campo no puede estar vacío", "Error", JOptionPane.ERROR_MESSAGE);
        		}
        	}
        });
		
		JLabel lblCreado = new JLabel("Create by Mario Petro");
		lblCreado.setForeground(Color.decode(Colors.BLACK.getColor()));
		lblCreado.setBounds(120, 520, 336, 40);
		lblCreado.setFont(new Font(lblCantidad.getFont().getName(), Font.PLAIN, 12));
		
		frame.add(lblTitle);
		frame.add(lblColombia);
		frame.add(lblConvertir);
		frame.add(lblCantidad);
		frame.add(txtCantidad);
		frame.add(lblConvertidoA);
		frame.add(comboMoneda);
		frame.add(lblResultadoAMoneda);
		frame.add(lblResultadoAPeso);
		frame.add(btnConvertir);
		frame.add(lblCreado);
		
		
	}
	
	private void convertirDivisa(double valor) {
		ConvertirDivisa conversor = new ConvertirDivisa();
		String opcionSeleccionada = (String) comboMoneda.getSelectedItem();
		
		
		double resultadoAPeso = 0.0;
		double resultadoAMoneda = 0.0;
		
		switch (opcionSeleccionada) {
		case "USD - Dólar Estadounidense": 
			resultadoAMoneda = conversor.convertirPesoAMoneda(valor, ConvertirDivisa.DOLAR);
			resultadoAPeso = conversor.convertirMonedaAPeso(valor, ConvertirDivisa.DOLAR);
			pais = " Dolar";
			break;
		case "EUR - Euro":
			resultadoAMoneda = conversor.convertirPesoAMoneda(valor, ConvertirDivisa.EURO);
			resultadoAPeso = conversor.convertirMonedaAPeso(valor, ConvertirDivisa.EURO);
			pais = " Euro";
			break;
		case "GBP - Libra esterlina":
			resultadoAMoneda = conversor.convertirPesoAMoneda(valor, ConvertirDivisa.LIBRA);
			resultadoAPeso = conversor.convertirMonedaAPeso(valor, ConvertirDivisa.LIBRA);
			pais = " LIbra";
			break;
		case "JPY - Yen japonés":
			resultadoAMoneda = conversor.convertirPesoAMoneda(valor, ConvertirDivisa.YEN);
			resultadoAPeso = conversor.convertirMonedaAPeso(valor, ConvertirDivisa.YEN);
			pais = " Yen";
			break;
		case "KRW - Won surcoreano":
			resultadoAMoneda = conversor.convertirPesoAMoneda(valor, ConvertirDivisa.WON);
			resultadoAPeso = conversor.convertirMonedaAPeso(valor, ConvertirDivisa.WON);
			pais = " Won";
			break;
		case "BRL - Real brasilero":
			resultadoAMoneda = conversor.convertirPesoAMoneda(valor, ConvertirDivisa.REAL_BRASILERO);
			resultadoAPeso = conversor.convertirMonedaAPeso(valor, ConvertirDivisa.REAL_BRASILERO);
			pais = " BRL";
			break;
        default:
        	JOptionPane.showMessageDialog(null, "No esta la moneda", "Error", JOptionPane.ERROR_MESSAGE);  
            return;
		}
		
		TamañoFuente(valor);
		
		lblResultadoAMoneda.setText(valorStr + pais + " = "+ conversor.Redondear(resultadoAMoneda,"#0.00" ) + " COP");
		lblResultadoAPeso.setText(valorStr + " COP" + " = "+ conversor.Redondear(resultadoAPeso,"#0.00000") + pais);
		
	}
	
	private void TamañoFuente(double valor) {
		if (valor <= 9999999) {
			lblResultadoAMoneda.setFont(new Font(lblResultadoAMoneda.getFont().getName(), Font.BOLD, 18));
			lblResultadoAPeso.setFont(new Font(lblResultadoAPeso.getFont().getName(), Font.BOLD, 18));
		}else if(valor <= 999999999) {
			lblResultadoAMoneda.setFont(new Font(lblResultadoAMoneda.getFont().getName(), Font.BOLD, 16));
			lblResultadoAPeso.setFont(new Font(lblResultadoAPeso.getFont().getName(), Font.BOLD, 16));
		}else {
			lblResultadoAMoneda.setFont(new Font(lblResultadoAMoneda.getFont().getName(), Font.BOLD, 14));
			lblResultadoAPeso.setFont(new Font(lblResultadoAPeso.getFont().getName(), Font.BOLD, 14));
		}

	}
	
	public void show() {
		frame.setVisible(true);
	}
		
	
}
