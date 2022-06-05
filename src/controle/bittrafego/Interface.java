package controle.bittrafego;

import java.awt.Toolkit;

public class Interface extends javax.swing.JFrame {

    protected Fila1 f1 = new Fila1();  //Instacia a classe Fila1
    protected Fila2 f2 = new Fila2();  //Instacia a classe Fila2
    protected Pilha p = new Pilha();   //Instacia a classe Pilha
    protected static Sons s = new Sons();     //Instacia a classe Sons
    protected static Connection c = new Connection(); //Instacia a classe Connection
    static boolean checaenvio = false; // Checa se os carros podem ser enviados ao DB.

    //Cria os Threads necessártios
    protected Thread t1 = new Thread(f1);
    protected Thread t2 = new Thread(f2);
    protected Thread t3 = new Thread(p);
    protected Thread t4 = new Thread(s);
    protected Thread t5 = new Thread(c);

    public Interface() {
        setIcon();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        r2C1 = new javax.swing.JLabel();
        r2C2 = new javax.swing.JLabel();
        r2C3 = new javax.swing.JLabel();
        r1C1 = new javax.swing.JLabel();
        r1C2 = new javax.swing.JLabel();
        r1C3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        Semaforo1 = new javax.swing.JLabel();
        Semaforo2 = new javax.swing.JLabel();
        ShowParkedCar5 = new javax.swing.JButton();
        ShowParkedCar4 = new javax.swing.JButton();
        ShowParkedCar3 = new javax.swing.JButton();
        ShowParkedCar2 = new javax.swing.JButton();
        ShowParkedCar1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Cruzamento = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtC = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtN1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtN2 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtN3 = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtremoveCars = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CONTROLE BITTRÁFEGO");
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setPreferredSize(new java.awt.Dimension(1350, 728));
        setResizable(false);
        getContentPane().setLayout(null);
        getContentPane().add(r2C1);
        r2C1.setBounds(350, 350, 140, 60);
        getContentPane().add(r2C2);
        r2C2.setBounds(190, 380, 150, 60);
        getContentPane().add(r2C3);
        r2C3.setBounds(20, 410, 160, 70);

        r1C1.setFont(new java.awt.Font("BankGothic Md BT", 1, 12)); // NOI18N
        r1C1.setForeground(new java.awt.Color(240, 240, 240));
        getContentPane().add(r1C1);
        r1C1.setBounds(550, 370, 120, 60);
        getContentPane().add(r1C2);
        r1C2.setBounds(660, 410, 130, 70);
        getContentPane().add(r1C3);
        r1C3.setBounds(800, 450, 150, 100);

        jButton1.setBackground(new java.awt.Color(51, 153, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("INICIAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(290, 560, 130, 40);

        Semaforo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/semaphor1red.jpg"))); // NOI18N
        getContentPane().add(Semaforo1);
        Semaforo1.setBounds(490, 267, 20, 30);

        Semaforo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/semaphor2green.jpg"))); // NOI18N
        getContentPane().add(Semaforo2);
        Semaforo2.setBounds(552, 267, 30, 50);

        ShowParkedCar5.setFont(new java.awt.Font("BankGothic Md BT", 1, 11)); // NOI18N
        ShowParkedCar5.setForeground(new java.awt.Color(240, 240, 240));
        ShowParkedCar5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ShowParkedCar5.setBorderPainted(false);
        ShowParkedCar5.setContentAreaFilled(false);
        ShowParkedCar5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowParkedCar5ActionPerformed(evt);
            }
        });
        getContentPane().add(ShowParkedCar5);
        ShowParkedCar5.setBounds(585, 284, 87, 36);

        ShowParkedCar4.setFont(new java.awt.Font("BankGothic Md BT", 1, 11)); // NOI18N
        ShowParkedCar4.setForeground(new java.awt.Color(240, 240, 240));
        ShowParkedCar4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ShowParkedCar4.setBorderPainted(false);
        ShowParkedCar4.setContentAreaFilled(false);
        ShowParkedCar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowParkedCar4ActionPerformed(evt);
            }
        });
        getContentPane().add(ShowParkedCar4);
        ShowParkedCar4.setBounds(560, 270, 85, 43);

        ShowParkedCar3.setFont(new java.awt.Font("BankGothic Md BT", 1, 11)); // NOI18N
        ShowParkedCar3.setForeground(new java.awt.Color(240, 240, 240));
        ShowParkedCar3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ShowParkedCar3.setBorderPainted(false);
        ShowParkedCar3.setContentAreaFilled(false);
        ShowParkedCar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowParkedCar3ActionPerformed(evt);
            }
        });
        getContentPane().add(ShowParkedCar3);
        ShowParkedCar3.setBounds(530, 260, 86, 32);

        ShowParkedCar2.setFont(new java.awt.Font("BankGothic Md BT", 1, 11)); // NOI18N
        ShowParkedCar2.setForeground(new java.awt.Color(240, 240, 240));
        ShowParkedCar2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ShowParkedCar2.setBorderPainted(false);
        ShowParkedCar2.setContentAreaFilled(false);
        ShowParkedCar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowParkedCar2ActionPerformed(evt);
            }
        });
        getContentPane().add(ShowParkedCar2);
        ShowParkedCar2.setBounds(500, 250, 86, 35);

        ShowParkedCar1.setFont(new java.awt.Font("BankGothic Md BT", 1, 11)); // NOI18N
        ShowParkedCar1.setForeground(new java.awt.Color(240, 240, 240));
        ShowParkedCar1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ShowParkedCar1.setBorderPainted(false);
        ShowParkedCar1.setContentAreaFilled(false);
        ShowParkedCar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowParkedCar1ActionPerformed(evt);
            }
        });
        getContentPane().add(ShowParkedCar1);
        ShowParkedCar1.setBounds(470, 230, 90, 44);

        jLabel8.setFont(new java.awt.Font("BankGothic Md BT", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(240, 240, 240));
        jLabel8.setText("Console do MongoDB:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(30, 580, 210, 30);
        getContentPane().add(jLabel7);
        jLabel7.setBounds(390, 200, 340, 240);
        getContentPane().add(jLabel6);
        jLabel6.setBounds(290, 200, 410, 240);

        Cruzamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/cruzamento.gif"))); // NOI18N
        Cruzamento.setPreferredSize(new java.awt.Dimension(640, 360));
        getContentPane().add(Cruzamento);
        Cruzamento.setBounds(10, 10, 970, 560);

        txtC.setColumns(20);
        txtC.setFont(new java.awt.Font("BankGothic Md BT", 1, 14)); // NOI18N
        txtC.setRows(5);
        jScrollPane5.setViewportView(txtC);

        getContentPane().add(jScrollPane5);
        jScrollPane5.setBounds(20, 610, 540, 80);

        txtN1.setEditable(false);
        txtN1.setColumns(20);
        txtN1.setRows(5);
        jScrollPane1.setViewportView(txtN1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(980, 30, 360, 190);

        txtN2.setEditable(false);
        txtN2.setColumns(20);
        txtN2.setRows(5);
        jScrollPane2.setViewportView(txtN2);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(980, 250, 360, 190);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Rua 1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(1140, 10, 80, 22);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Rua 2");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(1140, 230, 70, 22);

        txtN3.setEditable(false);
        txtN3.setColumns(20);
        txtN3.setRows(5);
        jScrollPane3.setViewportView(txtN3);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(980, 460, 360, 190);

        txtremoveCars.setColumns(20);
        txtremoveCars.setRows(5);
        jScrollPane4.setViewportView(txtremoveCars);

        getContentPane().add(jScrollPane4);
        jScrollPane4.setBounds(640, 580, 330, 96);

        jLabel5.setFont(new java.awt.Font("BankGothic Md BT", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(240, 240, 240));
        jLabel5.setText("Saida do seletor de carros:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(660, 560, 280, 20);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Estacionamento");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(1110, 440, 120, 20);

        jButton3.setBackground(new java.awt.Color(255, 0, 0));
        jButton3.setFont(new java.awt.Font("Tahoma", 3, 16)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("PARAR E SAIR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(420, 560, 210, 40);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Fundo.jpg"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 1620, 700);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//Inicia alguns threads.
        t1.start();
        t2.start();
        t3.start();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        System.exit(0); //Sai do programa.
    }//GEN-LAST:event_jButton3ActionPerformed

    private void ShowParkedCar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowParkedCar1ActionPerformed
        p.mostraCarro(1); //Mostra os carros atrás do referido carro.
    }//GEN-LAST:event_ShowParkedCar1ActionPerformed

    private void ShowParkedCar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowParkedCar2ActionPerformed
        p.mostraCarro(2); //Mostra os carros atrás do referido carro.
    }//GEN-LAST:event_ShowParkedCar2ActionPerformed

    private void ShowParkedCar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowParkedCar3ActionPerformed
        p.mostraCarro(3); //Mostra os carros atrás do referido carro.
    }//GEN-LAST:event_ShowParkedCar3ActionPerformed

    private void ShowParkedCar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowParkedCar4ActionPerformed
        p.mostraCarro(4); //Mostra os carros atrás do referido carro.
    }//GEN-LAST:event_ShowParkedCar4ActionPerformed

    private void ShowParkedCar5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowParkedCar5ActionPerformed
        p.mostraCarro(5); //Mostra os carros atrás do referido carro.
    }//GEN-LAST:event_ShowParkedCar5ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel Cruzamento;
    public static javax.swing.JLabel Semaforo1;
    public static javax.swing.JLabel Semaforo2;
    public static javax.swing.JButton ShowParkedCar1;
    public static javax.swing.JButton ShowParkedCar2;
    public static javax.swing.JButton ShowParkedCar3;
    public static javax.swing.JButton ShowParkedCar4;
    public static javax.swing.JButton ShowParkedCar5;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    public static javax.swing.JLabel jLabel6;
    public static javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    public static javax.swing.JLabel r1C1;
    public static javax.swing.JLabel r1C2;
    public static javax.swing.JLabel r1C3;
    public static javax.swing.JLabel r2C1;
    public static javax.swing.JLabel r2C2;
    public static javax.swing.JLabel r2C3;
    public static javax.swing.JTextArea txtC;
    public static javax.swing.JTextArea txtN1;
    public static javax.swing.JTextArea txtN2;
    public static javax.swing.JTextArea txtN3;
    public static javax.swing.JTextArea txtremoveCars;
    // End of variables declaration//GEN-END:variables

    private void setIcon() { //Seta o icone do JFrame
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/resources/BTT2.png")));
    }

    public void run() {//Inicia os Threads de Som e de Conecção com o Banco de Dados.
        new Interface().setVisible(true);
        t4.start();
        t5.start();
    }
}
