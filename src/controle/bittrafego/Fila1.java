package controle.bittrafego;

import java.awt.Color;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Fila1 implements Runnable {

    private int vcar1 = 0;
    private int vcar2 = 0;
    private int vcar3 = 0;
    /* 
Criação de variáveis da classe.
     */
    private int ver1 = 0;
    private int cor[] = new int[3];
    private int cor1, cor2, cor3;
    private String carros[] = new String[3];
    private Node head, tail;
    private int size, caminho;
    private Random randway = new Random();

    public Fila1() {
        head = null;
        tail = null;
        size = 0;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void enqueue(Node node) {
        if (size == 0) { // Caso o tamanho da fila seja 0, o comando enqueue() realiza uma função específica
            node.setNextNode(head); // A função setNextNode do Node enviado ao enqueue recebe o head como parâmetro
            head = node; // O node recebido como parâmetro também se torna o head
            size = size + 1; // O Tamanho da fila é aumentado de 0 para 1
            if (size == 1) { // A condição de tamanho sempre será atendida neste caso, portanto...
                tail = node; // O node recebido como parâmetro também se torna o tail
            }

        } else { // Caso já exista 1 ou mais elementos na fila, essa condicional é acionada.
            tail.setNextNode(node);  // A função setNextNode do tail recebe o node recebido pelo enqueue como parâmetro
            tail = node; // O tail se torna o Node recebido como parâmetro.
            size = size + 1; // O Tamanho da fila é aumentado em 1
            if (size == 1) { // A condição de tamanho sempre será atendida neste caso, portanto...
                head = tail; // O node recebido como parâmetro também se torna o tail
            }
        }

    }

    public boolean dequeue() {
        if (size == 1) { // Caso o tamanho seja 1, essa condicional é acionada
            head = null; // A cabeça se torna null
            tail = null; // A cauda se torna null
            size = size - 1; // O tamanho, que antes era 1, é decrescido de 1, tornando-se 0.
        } else if (size == 0) { // Caso o tamanho seja 0, nenhuma função sobre a fila é realizada.
            System.out.println("");
        } else { // Caso o tamanho seja maior que 1, esta condicional é acessada
            head = head.getNextNode(); // A cabeça é movida para o próximo nó apontado pela mesma
            size = size - 1; // O tamanho é decrescido de 1.
        }
        return true;
    }

    public int front() {
        return head.getValor();
    }

    public String toString() {

        Node n = head;
        String retorno = "";
        int j = 0;

        while (n != null) {
            carros[j] = Integer.toString(n.getValor());
            retorno += n.getValor();
            retorno += "\n";
            n = n.getNextNode();
            j++;
        }
        return retorno;
    }

    public void dorme() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Fila1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void dorme2() {
        try {
            Thread.sleep(3200); // Soma 3.2s aos 0.8s do sleep de animação e a 1s da troca do for, totalizando 5s de tempo de saída para cada carro.
        } catch (InterruptedException ex) {
            Logger.getLogger(Fila1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void sinalaberto() {
        if (carros[0] != null && carros[1] != null && carros[2] != null && Interface.checaenvio == true) { //Caso tenha 3 carros armazenados ele chama a função que armazena 3 carros de uma vez.
            Interface.c.guarda3(carros[0], carros[1], carros[2], cor[0], cor[1], cor[2], 1);
        } else if (carros[0] != null && carros[1] != null && carros[2] == null && Interface.checaenvio == true) { //Caso tenha 2 carros armazenados ele chama a função que armazena 2 carros de uma vez.
            Interface.c.guarda2(carros[0], carros[1], cor[0], cor[1], 1);
        } else if (carros[0] != null && carros[1] == null && carros[2] == null && Interface.checaenvio == true) { //Caso tenha 1 carro armazenados ele chama a função que armazena 1 carros.
            Interface.c.guarda1(carros[0], cor[0], 1);
        }

        Interface.Semaforo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/semaphor1green.jpg"))); //Troca a imagem do semáforo para verde.
        Interface.txtN1.append("\n* O SEMÁFORO 1 ESTÁ ABERTO. (VERDE). *\n");
        Interface.txtN1.setForeground(Color.green); //Seta o console com a cor verde.
        Interface.txtN1.setCaretPosition(Interface.txtN1.getDocument().getLength()); //Faz o scroll automático.
        try {
            Thread.sleep(3000); // Atrasa a saída do primeiro carro, caso contrário, ele sairia instantâneamente.
        } catch (InterruptedException ex) {
            Logger.getLogger(Fila1.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 0; i < 3; i++) {

            caminho = randway.nextInt(100); //Gera números aleatórios entre 0 e 100.

            if (i == 0 && carros[0] != null && carros[1] != null && carros[2] != null) { //Faz o primeiro carro sair da rua, se tiver algum carro nela, movendo as 2 posições anteriores para a frente, caso ambas estejam populadas.
                vcar1 = 1;
                Interface.txtN1.setText(Interface.txtN1.getText() + "\nSaiu o carro N° " + carros[0] + " da Rua 1.\n");
                Interface.txtN1.setCaretPosition(Interface.txtN1.getDocument().getLength());
                if (caminho < 50) { //De acordo com o valor gerado anteriormente, escolhe pra qual rua o carro vai.
                    Interface.jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Seta1Rua1.gif")));
                    try {
                        Thread.sleep(800); //Atrasa em 800ms a execução.
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Fila1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Interface.jLabel6.setIcon(null); //Deixa o gif da seta oculto.
                    Interface.r1C1.setIcon(null); //Deixa a posição 1 da rua 1 oculta, ou seja, sem carros.
                } else {
                    Interface.jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Seta2Rua1.gif")));
                    try {
                        Thread.sleep(800);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Fila1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Interface.jLabel6.setIcon(null);
                    Interface.r1C1.setIcon(null);
                }
                Interface.r1C3.setIcon(null);
                if (cor[1] == 1) { //De acordo com a cor do carro, seta o gif na posição 1 da rua.
                    Interface.r1C1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rua1/Pos1Car1.png")));
                } else if (cor[1] == 2) {
                    Interface.r1C1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rua1/Pos1Car2.png")));
                } else if (cor[1] == 3) {
                    Interface.r1C1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rua1/Pos1Car3.png")));
                } else if (cor[1] == 4) {
                    Interface.r1C1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rua1/Pos1Car4.png")));
                } else if (cor[1] == 5) {
                    Interface.r1C1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rua1/Pos1Car5.png")));
                }

                if (cor[2] == 1) {//De acordo com a cor do carro, seta o gif na posição 2 da rua.
                    Interface.r1C2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rua1/Pos2Car1.png")));
                } else if (cor[2] == 2) {
                    Interface.r1C2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rua1/Pos2Car2.png")));
                } else if (cor[2] == 3) {
                    Interface.r1C2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rua1/Pos2Car3.png")));
                } else if (cor[2] == 4) {
                    Interface.r1C2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rua1/Pos2Car4.png")));
                } else if (cor[2] == 5) {
                    Interface.r1C2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rua1/Pos2Car5.png")));
                }

                dequeue(); //Remove o primeiro carro da fila.

            }

            if (i == 0 && carros[0] != null && carros[1] != null && carros[2] == null) { //Faz o primeiro carro sair da rua, se tiver algum carro nela, movendo o carro da segunda posição para ela, caso haja algum carro nela.
                vcar1 = 1;
                Interface.txtN1.setText(Interface.txtN1.getText() + "\nSaiu o carro N° " + carros[0] + " da Rua 1.\n");
                Interface.txtN1.setCaretPosition(Interface.txtN1.getDocument().getLength());
                if (caminho < 50) { //De acordo com o valor gerado anteriormente, escolhe pra qual rua o carro vai.
                    Interface.jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Seta1Rua1.gif")));
                    try {
                        Thread.sleep(800); //Atrasa em 800ms a execução.
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Fila1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Interface.jLabel6.setIcon(null); //Deixa o gif da seta oculto.
                    Interface.r1C1.setIcon(null); //Deixa a posição 1 da rua 1 oculta, ou seja, sem carros.
                } else {
                    Interface.jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Seta2Rua1.gif")));
                    try {
                        Thread.sleep(800);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Fila1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Interface.jLabel6.setIcon(null);
                    Interface.r1C1.setIcon(null);
                }
                Interface.r1C2.setIcon(null);
                Interface.r1C3.setIcon(null);
                if (cor[1] == 1) { //De acordo com a cor do carro, seta o gif na posição 1 da rua.
                    Interface.r1C1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rua1/Pos1Car1.png")));
                } else if (cor[1] == 2) {
                    Interface.r1C1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rua1/Pos1Car2.png")));
                } else if (cor[1] == 3) {
                    Interface.r1C1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rua1/Pos1Car3.png")));
                } else if (cor[1] == 4) {
                    Interface.r1C1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rua1/Pos1Car4.png")));
                } else if (cor[1] == 5) {
                    Interface.r1C1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rua1/Pos1Car5.png")));
                }

                dequeue(); //Remove o primeiro carro da fila.

            }

            if (i == 0 && carros[0] != null && carros[1] == null && carros[2] == null) { //Faz o primeiro carro sair da rua.
                vcar1 = 1;
                Interface.txtN1.setText(Interface.txtN1.getText() + "\nSaiu o carro N° " + carros[0] + " da Rua 1.\n");
                Interface.txtN1.setCaretPosition(Interface.txtN1.getDocument().getLength());
                if (caminho < 50) { //De acordo com o valor gerado anteriormente, escolhe pra qual rua o carro vai.
                    Interface.jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Seta1Rua1.gif")));
                    try {
                        Thread.sleep(800); //Atrasa em 800ms a execução.
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Fila1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Interface.jLabel6.setIcon(null); //Deixa o gif da seta oculto.
                    Interface.r1C1.setIcon(null); //Deixa a posição 1 da rua 1 oculta, ou seja, sem carros.
                } else {
                    Interface.jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Seta2Rua1.gif")));
                    try {
                        Thread.sleep(800);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Fila1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Interface.jLabel6.setIcon(null);
                    Interface.r1C1.setIcon(null);
                }

                dequeue(); //Remove o primeiro carro da fila.

            }

            if (vcar1 == 0) {
                try {
                    Thread.sleep(800); //Atrasa em 800ms a execução.
                } catch (InterruptedException ex) {
                    Logger.getLogger(Fila1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (i == 1 && carros[1] != null && carros[2] != null) {//Faz o segundo carro sair da rua, se tiver algum carro nela, movendo terceira posição para frente, caso esteja populada.
                vcar2 = 1;
                Interface.txtN1.append("\nSaiu o carro N° " + carros[1] + " da Rua 1.\n");
                Interface.txtN1.setCaretPosition(Interface.txtN1.getDocument().getLength());
                if (caminho < 50) {
                    Interface.jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Seta1Rua1.gif")));
                    try {
                        Thread.sleep(800);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Fila1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Interface.jLabel6.setIcon(null);
                    Interface.r1C2.setIcon(null);
                } else {
                    Interface.jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Seta2Rua1.gif")));
                    try {
                        Thread.sleep(800);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Fila1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Interface.r1C2.setIcon(null);
                    Interface.jLabel6.setIcon(null);
                }
                Interface.r1C2.setIcon(null);
                if (cor[2] == 1) { //Seta o segundo carro da fila na primeira posição, para simular movimento.
                    Interface.r1C1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rua1/Pos1Car1.png")));
                } else if (cor[2] == 2) {
                    Interface.r1C1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rua1/Pos1Car2.png")));
                } else if (cor[2] == 3) {
                    Interface.r1C1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rua1/Pos1Car3.png")));
                } else if (cor[2] == 4) {
                    Interface.r1C1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rua1/Pos1Car4.png")));
                } else if (cor[2] == 5) {
                    Interface.r1C1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rua1/Pos1Car5.png")));
                }

                dequeue(); //Remove o segundo carro da fila.
            }

            if (i == 1 && carros[1] != null && carros[2] == null) {//Faz o segundo carro sair da rua, se tiver algum carro nela.
                vcar2 = 1;
                Interface.txtN1.append("\nSaiu o carro N° " + carros[1] + " da Rua 1.\n");
                Interface.txtN1.setCaretPosition(Interface.txtN1.getDocument().getLength());
                if (caminho < 50) {
                    Interface.jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Seta1Rua1.gif")));
                    try {
                        Thread.sleep(800);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Fila1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Interface.jLabel6.setIcon(null);
                    Interface.r1C2.setIcon(null);
                } else {
                    Interface.jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Seta2Rua1.gif")));
                    try {
                        Thread.sleep(800);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Fila1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Interface.r1C2.setIcon(null);
                    Interface.jLabel6.setIcon(null);
                }
                Interface.r1C1.setIcon(null);

                dequeue(); //Remove o segundo carro da fila.
            }

            if (vcar2 == 0) {
                try {
                    Thread.sleep(800); //Atrasa em 800ms a execução.
                } catch (InterruptedException ex) {
                    Logger.getLogger(Fila1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (i == 2 && carros[2] != null) { //Faz o terceiro carro sair da rua, se tiver algum carro nela.
                vcar3 = 1;
                Interface.txtN1.append("\nSaiu o carro N° " + carros[2] + " da Rua 1.\n");
                Interface.txtN1.setCaretPosition(Interface.txtN1.getDocument().getLength());
                if (caminho < 50) {
                    Interface.jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Seta1Rua1.gif")));
                    try {
                        Thread.sleep(800);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Fila1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Interface.jLabel6.setIcon(null);
                    Interface.r1C1.setIcon(null);
                } else {
                    Interface.jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Seta2Rua1.gif")));
                    try {
                        Thread.sleep(800);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Fila1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Interface.jLabel6.setIcon(null);
                    Interface.r1C1.setIcon(null);
                }
                dequeue(); //Remove o terceiro carro da fila.
            }
            if (vcar3 == 0) {
                try {
                    Thread.sleep(800); //Atrasa em 800ms a execução.
                } catch (InterruptedException ex) {
                    Logger.getLogger(Fila1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (i == 2) { //Depois que todos os carros saírem, é setado todas as posições em null. 
                Interface.r1C1.setIcon(null);
                Interface.r1C2.setIcon(null);
                Interface.r1C3.setIcon(null);
            }
            dorme2(); //Executa a função dorme2 (que tem delay de 4,7 segundos) a cada rodada no laço "for".
        }
        vcar1 = 0;
        vcar2 = 0;
        vcar3 = 0;
        carros[0] = null;
        carros[1] = null;
        carros[2] = null;
        run(); //No final do laço for ele chama a função run para recomeçar o ciclo.
    }

    @Override
    public void run() {
        int vi = 0;
        int alea;
        Random gerador = new Random();  // Cria o gerador de números aleatórios. 


        /*O "for" abaixo refere-se ao período em que o sinal fica fechado, ou seja, 15 segundos. Nesse período
ele empilha os carros de forma aleatória enquanto o sinal está fechado.
         */
        int ver = 0; //Evita loop na parte que evita a geração de carros com o cruzamento cheio.
        int chega; //Variável que recebe o número aleatório de quando os carros chegam.

        for (int i = 0; i < 15; i++) {
            //Gera uma cor aleatória para os 3 carros que chegarem.
            cor1 = gerador.nextInt(5);
            cor2 = gerador.nextInt(5);
            cor3 = gerador.nextInt(5);

            /*Gera os números aleatórios para a chegada dos carros, 
            e ainda evita desses números serem menores que o "i".
             */
            chega = gerador.nextInt((15 - i) + 1) + i;

            if (size == 3 && ver == 0) { //Evita a geração de carros com o cruzamento cheio.
                Interface.txtN1.append("\nCruzamento da Rua 1 cheio, aguardando liberação.\n");
                Interface.txtN1.setCaretPosition(Interface.txtN1.getDocument().getLength());
                ver = 1;
            } else if (ver == 0) {

                /*Gera números aleatórios para os carros. O Node é necessário aqui dentro pois caso contrário
ele gera números aleatórios e sobrepoem os carros atuais na fila a cada passada no laço.        
                 */
                //Cada Node corresponde a um carro.
                Node n1 = new Node();
                Node n2 = new Node();
                Node n3 = new Node();
                n1.setValor(gerador.nextInt(500));
                n2.setValor(gerador.nextInt(500));
                n3.setValor(gerador.nextInt(500));

                if (i == 0) {
                    Interface.txtN1.setForeground(Color.red);
                    Interface.txtN1.append("\n* O SEMÁFORO 1 ESTÁ FECHADO. (VERMELHO). *\n");
                    Interface.txtN1.setCaretPosition(Interface.txtN1.getDocument().getLength());
                    Interface.Semaforo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/semaphor1red.jpg")));
                }

                /* Caso o tamanho do "size" abaixo seja 0, significa que não tem nenhum carro no cruzamento,
    logo ele empilha de forma aleatória uma quantidade entre 1 e 3 de carros quando o "i" chegar no número aleatório gerado acima.
                 */
                if (size == 0 && i == chega) { // Se o tamanho for = 0 quer dizer que não tem nenhum carro no cruzamento.
                    alea = gerador.nextInt(3); // Gera um número aleatório de quantos carros vão chegar no cruzamento.

                    if (alea == 0) { //De acordo com o número aleatório empilha uma quantidade de carros.
                        Interface.txtN1.append("\nCarro: " + n1.getValor() + " chegou ao cruzamento na Rua 1.");
                        Interface.s.roda(); //Executa a função de buzina.
                        Interface.txtN1.setCaretPosition(Interface.txtN1.getDocument().getLength());

                        if (cor1 == 0) { //Seta uma cor aleatória  no carro da primeira posição.
                            Interface.r1C1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rua1/Pos1Car1.png")));
                            cor[0] = 1;
                        } else if (cor1 == 1) {
                            Interface.r1C1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rua1/Pos1Car2.png")));
                            cor[0] = 2;
                        } else if (cor1 == 2) {
                            Interface.r1C1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rua1/Pos1Car3.png")));
                            cor[0] = 3;
                        } else if (cor1 == 3) {
                            Interface.r1C1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rua1/Pos1Car4.png")));
                            cor[0] = 4;
                        } else if (cor1 == 4) {
                            Interface.r1C1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rua1/Pos1Car5.png")));
                            cor[0] = 5;
                        }
                        enqueue(n1); //Efileira um carro.
                    } else if (alea == 1) {//De acordo com o número aleatório empilha uma quantidade de carros.
                        Interface.txtN1.append("\nCarros: " + n1.getValor() + " e " + n2.getValor() + " chegaram ao cruzamento na Rua 1.");
                        Interface.s.roda();
                        Interface.txtN1.setCaretPosition(Interface.txtN1.getDocument().getLength());
                        if (cor1 == 0) { //Seta a cor do primeiro carro da rua.
                            Interface.r1C1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rua1/Pos1Car1.png")));
                            cor[0] = 1; //Armazena a cor do primeiro carro da rua.
                        } else if (cor1 == 1) {
                            Interface.r1C1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rua1/Pos1Car2.png")));
                            cor[0] = 2;
                        } else if (cor1 == 2) {
                            Interface.r1C1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rua1/Pos1Car3.png")));
                            cor[0] = 3;
                        } else if (cor1 == 3) {
                            Interface.r1C1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rua1/Pos1Car4.png")));
                            cor[0] = 4;
                        } else if (cor1 == 4) {
                            Interface.r1C1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rua1/Pos1Car5.png")));
                            cor[0] = 5;
                        }

                        if (cor2 == 0) {//Seta a cor do segundo carro da rua.
                            Interface.r1C2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rua1/Pos2Car1.png")));
                            cor[1] = 1; //Armazena a cor do segundo.
                        } else if (cor2 == 1) {
                            Interface.r1C2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rua1/Pos2Car2.png")));
                            cor[1] = 2;
                        } else if (cor2 == 2) {
                            Interface.r1C2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rua1/Pos2Car3.png")));
                            cor[1] = 3;
                        } else if (cor2 == 3) {
                            Interface.r1C2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rua1/Pos2Car4.png")));
                            cor[1] = 4;
                        } else if (cor2 == 4) {
                            Interface.r1C2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rua1/Pos2Car5.png")));
                            cor[1] = 5;
                        }

                        enqueue(n1); //Efileira um carro.
                        enqueue(n2); //Efileira um carro.

                    } else if (alea == 2) {//De acordo com o número aleatório empilha uma quantidade de carros.
                        Interface.txtN1.append("\nCarros: " + n1.getValor() + ", " + n2.getValor() + " e " + n3.getValor() + " chegaram ao cruzamento Rua 1.");
                        Interface.s.roda();
                        Interface.txtN1.setCaretPosition(Interface.txtN1.getDocument().getLength());

                        if (cor1 == 0) {
                            Interface.r1C1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rua1/Pos1Car1.png")));
                            cor[0] = 1;
                        } else if (cor1 == 1) {
                            Interface.r1C1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rua1/Pos1Car2.png")));
                            cor[0] = 2;
                        } else if (cor1 == 2) {
                            Interface.r1C1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rua1/Pos1Car3.png")));
                            cor[0] = 3;
                        } else if (cor1 == 3) {
                            Interface.r1C1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rua1/Pos1Car4.png")));
                            cor[0] = 4;
                        } else if (cor1 == 4) {
                            Interface.r1C1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rua1/Pos1Car5.png")));
                            cor[0] = 5;
                        }

                        if (cor2 == 0) {
                            Interface.r1C2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rua1/Pos2Car1.png")));
                            cor[1] = 1;
                        } else if (cor2 == 1) {
                            Interface.r1C2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rua1/Pos2Car2.png")));
                            cor[1] = 2;
                        } else if (cor2 == 2) {
                            Interface.r1C2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rua1/Pos2Car3.png")));
                            cor[1] = 3;
                        } else if (cor2 == 3) {
                            Interface.r1C2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rua1/Pos2Car4.png")));
                            cor[1] = 4;
                        } else if (cor2 == 4) {
                            Interface.r1C2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rua1/Pos2Car5.png")));
                            cor[1] = 5;
                        }

                        if (cor3 == 0) {
                            Interface.r1C3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rua1/Pos3Car1.png")));
                            cor[2] = 1;
                        } else if (cor3 == 1) {
                            Interface.r1C3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rua1/Pos3Car2.png")));
                            cor[2] = 2;
                        } else if (cor3 == 2) {
                            Interface.r1C3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rua1/Pos3Car3.png")));
                            cor[2] = 3;
                        } else if (cor3 == 3) {
                            Interface.r1C3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rua1/Pos3Car4.png")));
                            cor[2] = 4;
                        } else if (cor3 == 4) {
                            Interface.r1C3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rua1/Pos3Car5.png")));
                            cor[2] = 5;
                        }

                        enqueue(n1); //Enfileira um carro.
                        enqueue(n2); //Enfileira um carro.
                        enqueue(n3); //Enfileira um carro.
                    }
                } /* Caso o tamanho do "size" abaixo seja 1, significa que  tem um carro no cruzamento,
    logo ele empilha de forma aleatória uma quantidade entre 1 e 2 de carros quando o "i" chegar no número aleatório gerado acima..
                 */ else if (size == 1 && i == chega) { // Se o tamanho for = 1 quer dizer que  tem um carro no cruzamento.
                    alea = gerador.nextInt(2); // Gera um número aleatório de quantos carros vão chegar no cruzamento.

                    if (alea == 0) { //De acordo com o número aleatório empilha uma quantidade de carros.
                        Interface.txtN1.append("\nCarro: " + n1.getValor() + " chegou ao cruzamento Rua 1.");
                        Interface.s.roda(); //Chama a função buzina.
                        Interface.txtN1.setCaretPosition(Interface.txtN1.getDocument().getLength());

                        if (cor2 == 0) {
                            Interface.r1C2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rua1/Pos2Car1.png")));
                            cor[1] = 1;
                        } else if (cor2 == 1) {
                            Interface.r1C2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rua1/Pos2Car2.png")));
                            cor[1] = 2;
                        } else if (cor2 == 2) {
                            Interface.r1C2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rua1/Pos2Car3.png")));
                            cor[1] = 3;
                        } else if (cor2 == 3) {
                            Interface.r1C2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rua1/Pos2Car4.png")));
                            cor[1] = 4;
                        } else if (cor2 == 4) {
                            Interface.r1C2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rua1/Pos2Car5.png")));
                            cor[1] = 5;
                        }

                        enqueue(n2); //Enfileira um carro.
                    } else if (alea == 1) {//De acordo com o número aleatório empilha uma quantidade de carros.
                        Interface.txtN1.append("\nCarros: " + n2.getValor() + " e " + n3.getValor() + " chegaram ao cruzamento Rua 1.");
                        Interface.s.roda();
                        Interface.txtN1.setCaretPosition(Interface.txtN1.getDocument().getLength());

                        if (cor2 == 0) {
                            Interface.r1C2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rua1/Pos2Car1.png")));
                            cor[1] = 1;
                        } else if (cor2 == 1) {
                            Interface.r1C2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rua1/Pos2Car2.png")));
                            cor[1] = 2;
                        } else if (cor2 == 2) {
                            Interface.r1C2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rua1/Pos2Car3.png")));
                            cor[1] = 3;
                        } else if (cor2 == 3) {
                            Interface.r1C2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rua1/Pos2Car4.png")));
                            cor[1] = 4;
                        } else if (cor2 == 4) {
                            Interface.r1C2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rua1/Pos2Car5.png")));
                            cor[1] = 5;
                        }

                        if (cor3 == 0) {
                            Interface.r1C3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rua1/Pos3Car1.png")));
                            cor[2] = 1;
                        } else if (cor3 == 1) {
                            Interface.r1C3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rua1/Pos3Car2.png")));
                            cor[2] = 2;
                        } else if (cor3 == 2) {
                            Interface.r1C3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rua1/Pos3Car3.png")));
                            cor[2] = 3;
                        } else if (cor3 == 3) {
                            Interface.r1C3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rua1/Pos3Car4.png")));
                            cor[2] = 4;
                        } else if (cor3 == 4) {
                            Interface.r1C3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rua1/Pos3Car5.png")));
                            cor[2] = 5;
                        }

                        enqueue(n2); //Enfileira um carro.
                        enqueue(n3); //Enfileira um carro.

                    }

                } /* Caso o tamanho do "size" abaixo seja 2, significa que  tem dois carros no cruzamento,
    logo ele empilha de forma aleatória a quantidade de 1 carro quando o "i" chegar no número aleatório gerado acima..
                 */ else if (size == 2 && i == chega) { // Se o tamanho for = 2 quer dizer que tem dois carros no cruzamento.
                    Interface.txtN1.append("Carro " + n3.getValor() + " chegou ao cruzamento Rua 1.");
                    Interface.s.roda();
                    Interface.txtN1.setCaretPosition(Interface.txtN1.getDocument().getLength());

                    if (cor3 == 0) {
                        Interface.r1C3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rua1/Pos3Car1.png")));
                        cor[2] = 1;
                    } else if (cor3 == 1) {
                        Interface.r1C3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rua1/Pos3Car2.png")));
                        cor[2] = 2;
                    } else if (cor3 == 2) {
                        Interface.r1C3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rua1/Pos3Car3.png")));
                        cor[2] = 3;
                    } else if (cor3 == 3) {
                        Interface.r1C3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rua1/Pos3Car4.png")));
                        cor[2] = 4;
                    } else if (cor3 == 4) {
                        Interface.r1C3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rua1/Pos3Car5.png")));
                        cor[2] = 5;
                    }

                    enqueue(n3); //Enfileira um carro.

                }

                if (size == 0 && vi == 0) { // Se size = 0 ele emite uma mensagem para esperar os primeiros carros na fila, assim é mais fácil acompanhar.
                    Interface.txtN1.append("\nTempo aleatório, aguardando chegada dos carros na Rua 1.\n");
                    Interface.txtN1.setCaretPosition(Interface.txtN1.getDocument().getLength());
                    vi = 1;
                } else if (size != 0) { //Lista todos os carros na rua.
                    Interface.txtN1.append("\n\n" + "Carros na rua 1: \n" + toString());
                    Interface.txtN1.setCaretPosition(Interface.txtN1.getDocument().getLength());
                }

            }
            dorme(); //Executa a função dorme (que tem delay de 1 segundo) a cada rodada no laço "for".

            if (i == 14) {
                sinalaberto();//No final do laço for ele chama a função sinalaberto para recomeçar o ciclo.
            }
        }
    }
}
