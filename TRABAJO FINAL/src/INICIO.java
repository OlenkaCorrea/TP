import javax.swing.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class INICIO extends JFrame {   
    
    public INICIO() {        
        initComponents();
    }
                       
    private void initComponents() {               
        java.awt.GridBagConstraints gridBagConstraints;        
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(400, 300));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("INGRESAR EL NUMERO DE DNI");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        jPanel2.add(jLabel1, gridBagConstraints);

        jTextField1.setText("9999999");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField1, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel1.add(jPanel2, gridBagConstraints);

        jPanel3.setLayout(new java.awt.GridBagLayout());

        jButton1.setText("INGRESAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel1.add(jPanel3, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(jPanel1, gridBagConstraints);

        pack();
    }                       

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        String DNI= jTextField1.getText();// Esta funcion almacen el DNI ingresado por el usuario
        Boolean CumpleConElAño=false;//Esto es una variable que verifica si el dni ingresado cumple con el plazo solicitado de un año
        Boolean isEnLaEmpresa=false;    //  Esta es una variable que verifica si el usuario trabaja en la empresa
        for(int i=0;i<arreglo.length;i++){
            if(arreglo[i].DNI.equals(DNI)){
                isEnLaEmpresa=true;
                if(ChronoUnit.DAYS.between(arreglo[i].FechaDeContratado,LocalDate.now())>DIAS_DEL_AÑO){
                    new VACACIONES().setVisible(true);  
                    this.setVisible(false);
                    this.dispose();
                    CumpleConElAño=true;
                    break;
            }
        }        
    }
    if(isEnLaEmpresa==true && CumpleConElAño==false){
        new Apto().setVisible(true);
        this.setVisible(false);
        this.dispose();
    }
    if(isEnLaEmpresa==false){
        new NoApto().setVisible(true); 
        this.setVisible(false);
        this.dispose();
    }  
                                            
           
    }        
                                          

    
    public static void main(String args[]) {        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(INICIO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(INICIO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(INICIO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(INICIO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new INICIO().setVisible(true);
            }
        });
    }
    //dias del año
    private final int DIAS_DEL_AÑO=365;
    //Numero de DNI de los trabajdores
    private Trabajador[] arreglo={new Trabajador("Mauricio Fernandini","9999999", LocalDate.of(2022,1,1)),
    new Trabajador("Pedro Castillo","7777777",LocalDate.of(2023,5,6)),new Trabajador("Antonio Pavon","1111111",LocalDate.of(2023,4,3))};                 
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextField1;
                      
}
