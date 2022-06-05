package controle.bittrafego;

import java.awt.Toolkit;
import javax.swing.JOptionPane;

public class Tela_Login extends javax.swing.JFrame {

    public Tela_Login() {
        setIcon();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtPass = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CONTROLE BITTRÁFEGO");
        setPreferredSize(new java.awt.Dimension(960, 631));
        setResizable(false);
        getContentPane().setLayout(null);

        txtPass.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txtPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassActionPerformed(evt);
            }
        });
        getContentPane().add(txtPass);
        txtPass.setBounds(580, 310, 310, 50);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("USUÁRIO:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(580, 160, 150, 29);

        jButton1.setBackground(new java.awt.Color(255, 0, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(670, 430, 120, 37);

        txtId.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        getContentPane().add(txtId);
        txtId.setBounds(580, 190, 310, 50);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("SENHA:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(580, 280, 100, 30);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Fundo1.jpg"))); // NOI18N
        jLabel4.setText("ARMADYNE");
        jLabel4.setToolTipText("ARMADYNE");
        jLabel4.setMinimumSize(new java.awt.Dimension(607, 444));
        jLabel4.setName("ARMADYNE"); // NOI18N
        jLabel4.setPreferredSize(new java.awt.Dimension(960, 600));
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 970, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String id1, password1;
        id1 = new String(txtId.getText());
        password1 = new String(txtPass.getPassword());

        if (("admin".equals(id1)) && ("123".equals(password1))) { //Verifica de os dados de login estão corretos.
            Interface tela = new Interface();
            this.dispose(); //Fecha a tela de login.
            tela.run(); //Executa a função run da interface.
        } else {
            JOptionPane.showMessageDialog(null, "Login Error"); //Emite um erro caso o login esteja incorreto.
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPassActionPerformed
    }//GEN-LAST:event_txtPassActionPerformed

    private void setIcon() { //Seta o ícone do JFrame de login.
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/resources/BTT2.png")));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtId;
    private javax.swing.JPasswordField txtPass;
    // End of variables declaration//GEN-END:variables
}
