package com.conversor;

import java.awt.Component;


import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;

public class ImageComboBoxRenderer extends DefaultListCellRenderer {
	private static final long serialVersionUID = 1L;
	private ImageIcon usaIcon = new ImageIcon(getClass().getResource("/usa.png"));
	private ImageIcon brasilIcon = new ImageIcon(getClass().getResource("/brasil.png"));
	private ImageIcon euroIcon = new ImageIcon(getClass().getResource("/euro.png"));
	private ImageIcon libraIcon = new ImageIcon(getClass().getResource("/libra.png"));
	private ImageIcon japonIcon = new ImageIcon(getClass().getResource("/japon.png"));
	private ImageIcon coreaIcon = new ImageIcon(getClass().getResource("/corea.png"));
	
	@Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index,
            boolean isSelected, boolean cellHasFocus) {
        JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        
        if (value != null) {
            String item = value.toString();
            if (item.contains("USD - Dólar Estadounidense")) {
                label.setIcon(usaIcon);      
            } else if (item.contains("BRL - Real brasilero")) {
            	label.setIcon(brasilIcon);
            } else if (item.contains("EUR - Euro")) {
            	label.setIcon(euroIcon);
            } else if (item.contains("GBP - Libra esterlina")) {
            	label.setIcon(libraIcon);
            } else if (item.contains("JPY - Yen japonés")) {
            	label.setIcon(japonIcon);
            } else if (item.contains("KRW - Won surcoreano")) {
            	label.setIcon(coreaIcon);
            }
            
        }   
        return label;
    }
	
   
  
}
