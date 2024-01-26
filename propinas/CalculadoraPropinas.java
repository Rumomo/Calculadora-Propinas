package propinas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Color;

public class CalculadoraPropinas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField vImporte;
	private JTextField vMonto;
	private JTextField vTotal;
	private JComboBox<String> vPorcentaje;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculadoraPropinas frame = new CalculadoraPropinas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CalculadoraPropinas() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CalculadoraPropinas.class.getResource("/propinas/img/R.jpg")));
		setTitle("Cuenta/Propinas");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 298, 385);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Etiqueta de Ingreso de importe
		JLabel vIngreso = new JLabel("Ingreso  de Importe");
		vIngreso.setForeground(new Color(0, 255, 255));
		vIngreso.setHorizontalAlignment(SwingConstants.RIGHT);
		vIngreso.setBounds(79, 17, 154, 14);
		contentPane.add(vIngreso);
		
		vImporte = new JTextField();
		vImporte.setText("Importe de la cuenta");
		vImporte.setHorizontalAlignment(SwingConstants.RIGHT);
		vImporte.setBounds(110, 48, 123, 20);
		contentPane.add(vImporte);
		vImporte.setColumns(10);
		
		JLabel porcentajes = new JLabel("Propinas");
		porcentajes.setForeground(new Color(0, 255, 255));
		porcentajes.setHorizontalAlignment(SwingConstants.RIGHT);
		porcentajes.setBounds(120, 85, 113, 14);
		contentPane.add(porcentajes);
		
		vPorcentaje = new JComboBox<String>();
	    vPorcentaje.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10%", "15%", "20%" }));
	    vPorcentaje.setMaximumRowCount(3);
	    vPorcentaje.setBounds(174, 107, 57, 22);
	    contentPane.add(vPorcentaje);
		
		JLabel monto = new JLabel("Porcentaje de la propina");
		monto.setForeground(new Color(0, 255, 255));
		monto.setHorizontalAlignment(SwingConstants.RIGHT);
		monto.setBounds(66, 155, 167, 14);
		contentPane.add(monto);
		
		vMonto = new JTextField();
		vMonto.setHorizontalAlignment(SwingConstants.RIGHT);
		vMonto.setColumns(10);
		vMonto.setBounds(159, 186, 74, 20);
		contentPane.add(vMonto);
		
		JLabel pagar = new JLabel("Total a pagar");
		pagar.setForeground(new Color(0, 255, 255));
		pagar.setHorizontalAlignment(SwingConstants.RIGHT);
		pagar.setBounds(93, 223, 140, 14);
		contentPane.add(pagar);
		
		vTotal = new JTextField();
		vTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		vTotal.setBounds(159, 254, 74, 20);
		contentPane.add(vTotal);
		vTotal.setColumns(10);
		
		JButton btnReiniciar = new JButton("Reiniciar");
		btnReiniciar.setBounds(79, 295, 89, 23);
		contentPane.add(btnReiniciar);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setForeground(new Color(0, 255, 255));
		lblNewLabel.setIcon(new ImageIcon(CalculadoraPropinas.class.getResource("/propinas/img/fondo.jpg")));
		lblNewLabel.setBounds(0, 0, 282, 346);
		contentPane.add(lblNewLabel);
		
		
		
		/*Agregamos el ActionListener para el botón de Reinicio
		 * ActionListener se utiliza para responder evento, como hacer un clic en un botón
		 * new ActionListener() como cualquier objeto de java para hacer una instancia de ese objeto.
		 * Creo una función con una instancia anónima de la interfaz de ActionListener. avtionPerformed.
		*/
		vPorcentaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				calcularPropina();
			}
			
		});
		
		btnReiniciar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                reiniciar();
            }
        });
		
	}
	
	/*Método para calcular la propina y el total a pagar
	 *
	*/
	private void calcularPropina() {
		try {
			double importe = Double.parseDouble(vImporte.getText().replace(",", ""));
			String porcentajeSeleccionado = vPorcentaje.getSelectedItem().toString();
			double porcentaje = Double.parseDouble(porcentajeSeleccionado.replace("%", "")) / 100.0;

            double montoPropina = importe * porcentaje;
            double totalPagar = importe + montoPropina;

            DecimalFormat df = new DecimalFormat("#,##");
            
            vMonto.setText(df.format(montoPropina));
            vTotal.setText(df.format(totalPagar));
            
		} catch (Exception e) {
			// TODO: handle exception
			reiniciar();
		}
	}
	private void reiniciar() {
		vImporte.setText("Importe de la cuenta");
        vPorcentaje.setSelectedIndex(0);
        vMonto.setText("");
        vTotal.setText("");
    }
}
