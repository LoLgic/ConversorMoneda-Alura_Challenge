package com.conversor;

import javax.swing.SwingUtilities;

public class Aplicacion {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
            ConversorUI gui = new ConversorUI();
            gui.show();
        });
	}
}
