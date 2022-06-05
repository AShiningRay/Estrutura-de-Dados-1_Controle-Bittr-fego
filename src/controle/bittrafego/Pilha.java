package controle.bittrafego;

import java.awt.Color;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Pilha implements Runnable {
    
    private Node head, tail, n1; // n1 = Nó auxiliar que permite a busca pelos botões interativos do estacionamento.
    private Random randec = new Random(); // Variável que gera um número aleatório para colocar nos nomes dos carros.
    private int stackdecision = 0; // Variável responsável por gerir qual função o estacionamento fará.
    private Random randcarnum = new Random(); // Gerador de numeros aleatórios para os carros.
    private int size, cardec; // size = Tamanho da pilha, cardec = Variável que determina qual imagem de carro enviar para cada posição visual do estacionamento

    public Pilha() { // Define o head e tail como null e zera o size
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

    public void push(Node node, int cor) {
        if (size == 0) { // Coloca um carro na primeira posição do estacionamento
            head = node; // A cabeça se torna o node(carro) recebido como parâmetro
            tail = node; // A cauda se torna o node(carro) recebido como parâmetro
            size++; // O tamanho da pilha é acrescido de 1.
            if (Interface.checaenvio == true) { // Checa se os dados do carro podem ser enviados ao DB
                Interface.c.estacionamento(Integer.toString(node.getValor()), cor); //Invoca a função para gravação dos carros no DB.
            }
        } else { // Coloca um carro nas próximas posições do estacionamento
            node.setNextNode(head); // A próxima posição apontada pelo node se torna o head da pilha.
            head = node; // O head da pilha se torna o node(carro) recebido como parâmetro, pois este será também o primeiro a sair.
            size = size + 1; // O tamanho é acrescido de 1.
            if (Interface.checaenvio == true) { // Checa se os dados do carro podem ser enviados ao DB
                Interface.c.estacionamento(Integer.toString(node.getValor()), cor); //Invoca a função para gravação dos carros no DB.
            }
        }
        if (size == 1) // Coloca um carro na segunda posição do estacionamento
        {
            if (Interface.checaenvio == true) { // Checa se os dados do carro podem ser enviados ao DB
                Interface.c.estacionamento(Integer.toString(node.getValor()), cor); //Invoca a função para gravação dos carros no DB.
            }
            head = node; // O head da pilha se torna o node(carro) recebido como parâmetro.
        }

    }

    public boolean pop() {
        if (size == 1) { // Remove o carro da primeira posição (última a sair) do estacionamento
            Interface.txtN3.append("\nO Carro " + head.getValor() + " saiu do estacionamento \n"); // Mostra qual carro saiu do estacionamento
            Interface.txtN3.setCaretPosition(Interface.txtN3.getDocument().getLength()); // Faz scrolling automático
            Interface.ShowParkedCar1.setIcon(null); // Remove o ícone visual do carro dessa posição
            head = null; // A cabeça se torna null
            tail = null; // A cauda se torna null
            size = size - 1; // O tamanho é decrescido de 1, tornando-se 0.

            Interface.jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/SetaEstSai.gif"))); // Exibe a animação de saída do carro do estacionamento
            try {
                Thread.sleep(800);
            } catch (InterruptedException ex) {
                Logger.getLogger(Pilha.class.getName()).log(Level.SEVERE, null, ex);
            }
            Interface.jLabel7.setIcon(null); // Retira a animação de saída do carro do estacionamento
        } else if (size == 0) { // Não faz nada e não gera nenhum indicador visual, está aqui apenas porque o gerador de números aleatórios pode escolher remover mesmo com nada na pilha
        } else { // Remove os carros de outras posições da pilha
            Interface.txtN3.append("\nO Carro " + head.getValor() + " saiu do estacionamento \n"); // Mostra qual carro saiu do estacionamento
            Interface.txtN3.setCaretPosition(Interface.txtN3.getDocument().getLength()); // Faz scrolling automático
            head = head.getNextNode(); // A cabeça da pilha se torna o próximo node apontado por ela, para ser o próximo a sair.

            if (size == 5) {// // Remove os ícones visuais dos carros destas posições
                Interface.ShowParkedCar5.setIcon(null); // Remove o ícone da 5ª posição, caso este seja o tamanho da pilha atualmente
            } else if (size == 4) {
                Interface.ShowParkedCar4.setIcon(null); // Remove o ícone da 4ª posição, caso este seja o tamanho da pilha atualmente
            } else if (size == 3) {
                Interface.ShowParkedCar3.setIcon(null); // Remove o ícone da 3ª posição, caso este seja o tamanho da pilha atualmente
            } else if (size == 2) {
                Interface.ShowParkedCar2.setIcon(null); // Remove o ícone da 2ª posição, caso este seja o tamanho da pilha atualmente
            }

            Interface.jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/SetaEstSai.gif"))); // Exibe a animação de saída do carro do estacionamento
            try {
                Thread.sleep(800); // Atrasa 800ms, que é o tempo de 1 repetição do indicador das setas visuais
            } catch (InterruptedException ex) {
                Logger.getLogger(Pilha.class.getName()).log(Level.SEVERE, null, ex);
            }
            Interface.jLabel7.setIcon(null); // Retira a animação de saída do carro do estacionamento
            size = size - 1; // O tamanho da pilha é decrescido de 1.
        }
        return true;

    }

    public String toString() { // Imprime os carros da pilha.
        Node n1 = head;
        String retorno = "";
        while (n1 != null) {

            retorno += n1.getValor();
            retorno += "\n";
            n1 = n1.getNextNode();
        }
        return retorno;
    }

    public void mostraCarro(int csize) {
        if (csize > size) { // Checa se o usuário escolheu uma posição que não tem carros
            Interface.txtremoveCars.append("\nNão há nenhum carro nessa posição ainda.");
            Interface.txtremoveCars.setCaretPosition(Interface.txtremoveCars.getDocument().getLength()); // Faz scrolling automático
        } else if (csize == size) { // Checa se o usuário escolheu a última posição que possui carros
            Interface.txtremoveCars.append("\nNão há nenhum carro na frente deste.");
            Interface.txtremoveCars.setCaretPosition(Interface.txtremoveCars.getDocument().getLength()); // Faz scrolling automático
        } else { // Exibe os carros na frente do selecionado pelo usuário através dos botões visuais.
            Interface.txtremoveCars.append("\nCarros na frente deste:\n");
            Interface.txtremoveCars.setCaretPosition(Interface.txtremoveCars.getDocument().getLength()); // Faz scrolling automático
            n1 = head; // Coloca o node auxiliar como o head, para começar a imprimir os que estão após o enviado pelo botão de selação da interface
            while (n1.getSizenode() > csize) { // Incrementa a posição do node até ele chegar na posição que o botão pressionado enviou (carro 5 -> ultima posição, carro 4 -> penultima )   
                Interface.txtremoveCars.append("\n" + n1.getValor()); // Mostra o carro na posição atual do node
                Interface.txtremoveCars.setCaretPosition(Interface.txtremoveCars.getDocument().getLength()); // Faz scrolling automático
                n1 = n1.getNextNode(); // Pula para a próxima posição de carros.
            }
        }
    }

    public void decider(Node node) {
        this.stackdecision = randec.nextInt(100); // Gera um número aleatorio responsável por decidir se o estacionamento receberá, ou retirará um carro
        if (stackdecision < 60) { // Adiciona um carro aleatoriamente
            if (this.size < 5) { // checa se o estacionamento não está cheio
                try {
                    Thread.sleep(3000); // Atrasa a decisão da chegada do carro a depender do timer definido na função run()
                    Interface.jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/SetaEstEntra.gif")));
                    Thread.sleep(800); // Atrasa 800ms, que é o tempo de 1 repetição do indicador das setas visuais
                    Interface.jLabel7.setIcon(null);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Pilha.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.chegaCarro(node); // chama a função que insere os carros de uma forma que facilite a busca da função mostraCarro()
            }
        } else if (stackdecision >= 60) {
            try {
                Thread.sleep(3000); // Atrasa a decisão da saída carro a depender do timer definido na função run()
            } catch (InterruptedException ex) {
                Logger.getLogger(Pilha.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.pop(); // Remove algum carro aleatoriamente
        } else {
            Interface.txtN3.append("\nO estacionamento está cheio, favor retirar algum(ns) carro(s).\n"); // se o estacionamento estiver cheio, exibir isto.
        }
        Interface.txtN3.setCaretPosition(Interface.txtN3.getDocument().getLength());
        this.run(); // Reinicia a execução do thread do estacionamento.
    }

    public void chegaCarro(Node node) {
        if (size == 0) { // Verifica se o tamanho da pilha é 0
            cardec = randec.nextInt(100); // Decide qual das 5 cores de carros será exibida na posição a ser ocupada em seguida
            if (cardec < 20) {
                Interface.ShowParkedCar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Estacionamento/Pos1Car1.png")));
                node.setSizenode(1); // Coloca o valor da posição a ser ocupada pelo node em uma variável interna, para facilitar a função mostraCarro()
                this.push(node, 1); // Insere o carro nessa posição
            } else if (cardec >= 20 && cardec < 40) {
                Interface.ShowParkedCar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Estacionamento/Pos1Car2.png")));
                node.setSizenode(1); // Coloca o valor da posição a ser ocupada pelo node em uma variável interna, para facilitar a função mostraCarro()
                this.push(node, 2); // Insere o carro nessa posição
            } else if (cardec >= 40 && cardec < 60) {
                Interface.ShowParkedCar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Estacionamento/Pos1Car3.png")));
                node.setSizenode(1); // Coloca o valor da posição a ser ocupada pelo node em uma variável interna, para facilitar a função mostraCarro()
                this.push(node, 3); // Insere o carro nessa posição
            } else if (cardec >= 60 && cardec < 80) {
                Interface.ShowParkedCar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Estacionamento/Pos1Car4.png")));
                node.setSizenode(1); // Coloca o valor da posição a ser ocupada pelo node em uma variável interna, para facilitar a função mostraCarro()
                this.push(node, 4); // Insere o carro nessa posição
            } else if (cardec >= 80 && cardec < 100) {
                Interface.ShowParkedCar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Estacionamento/Pos1Car5.png")));
                node.setSizenode(1); // Coloca o valor da posição a ser ocupada pelo node em uma variável interna, para facilitar a função mostraCarro()
                this.push(node, 5); // Insere o carro nessa posição
            }

        } else if (size == 1) { // Verifica se o tamanho da pilha é 1
            cardec = randec.nextInt(100); // Decide qual das 5 cores de carros será exibida na posição a ser ocupada em seguida
            if (cardec < 20) {
                Interface.ShowParkedCar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Estacionamento/Pos2Car1.png")));
                node.setSizenode(2); // Coloca o valor da posição a ser ocupada pelo node em uma variável interna, para facilitar a função mostraCarro()
                this.push(node, 1); // Insere o carro nessa posição e armazena a cor.
            } else if (cardec >= 20 && cardec < 40) {
                Interface.ShowParkedCar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Estacionamento/Pos2Car2.png")));
                node.setSizenode(2); // Coloca o valor da posição a ser ocupada pelo node em uma variável interna, para facilitar a função mostraCarro()
                this.push(node, 2); // Insere o carro nessa posição e armazena a cor.    
            } else if (cardec >= 40 && cardec < 60) {
                Interface.ShowParkedCar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Estacionamento/Pos2Car3.png")));
                node.setSizenode(2); // Coloca o valor da posição a ser ocupada pelo node em uma variável interna, para facilitar a função mostraCarro()
                this.push(node, 3); // Insere o carro nessa posição e armazena a cor.
            } else if (cardec >= 60 && cardec < 80) {
                Interface.ShowParkedCar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Estacionamento/Pos2Car4.png")));
                node.setSizenode(2); // Coloca o valor da posição a ser ocupada pelo node em uma variável interna, para facilitar a função mostraCarro()
                this.push(node, 4); // Insere o carro nessa posição e armazena a cor. 
            } else if (cardec >= 80 && cardec < 100) {
                Interface.ShowParkedCar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Estacionamento/Pos2Car5.png")));
                node.setSizenode(2); // Coloca o valor da posição a ser ocupada pelo node em uma variável interna, para facilitar a função mostraCarro()
                this.push(node, 5); // Insere o carro nessa posição e armazena a cor. 
            }
        } else if (size == 2) { // Verifica se o tamanho da pilha é 2
            cardec = randec.nextInt(100); // Decide qual das 5 cores de carros será exibida na posição a ser ocupada em seguida
            if (cardec < 20) {
                Interface.ShowParkedCar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Estacionamento/Pos3Car1.png")));
                node.setSizenode(3); // Coloca o valor da posição a ser ocupada pelo node em uma variável interna, para facilitar a função mostraCarro()
                this.push(node, 1);    // Insere o carro nessa posição e armazena a cor.        
            } else if (cardec >= 20 && cardec < 40) {
                Interface.ShowParkedCar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Estacionamento/Pos3Car2.png")));
                node.setSizenode(3); // Coloca o valor da posição a ser ocupada pelo node em uma variável interna, para facilitar a função mostraCarro()
                this.push(node, 2);    // Insere o carro nessa posição e armazena a cor. 
            } else if (cardec >= 40 && cardec < 60) {
                Interface.ShowParkedCar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Estacionamento/Pos3Car3.png")));
                node.setSizenode(3); // Coloca o valor da posição a ser ocupada pelo node em uma variável interna, para facilitar a função mostraCarro()
                this.push(node, 3);    // Insere o carro nessa posição e armazena a cor.   
            } else if (cardec >= 60 && cardec < 80) {
                Interface.ShowParkedCar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Estacionamento/Pos3Car4.png")));
                node.setSizenode(3); // Coloca o valor da posição a ser ocupada pelo node em uma variável interna, para facilitar a função mostraCarro()
                this.push(node, 4);    // Insere o carro nessa posição e armazena a cor.    
            } else if (cardec >= 80 && cardec < 100) {
                Interface.ShowParkedCar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Estacionamento/Pos3Car5.png")));
                node.setSizenode(3); // Coloca o valor da posição a ser ocupada pelo node em uma variável interna, para facilitar a função mostraCarro()
                this.push(node, 5);    // Insere o carro nessa posição e armazena a cor.
            }
        } else if (size == 3) { // Verifica se o tamanho da pilha é 3
            cardec = randec.nextInt(100); // Decide qual das 5 cores de carros será exibida na posição a ser ocupada em seguida
            if (cardec < 20) {
                Interface.ShowParkedCar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Estacionamento/Pos4Car1.png")));
                node.setSizenode(4); // Coloca o valor da posição a ser ocupada pelo node em uma variável interna, para facilitar a função mostraCarro()
                this.push(node, 1); // Insere o carro nessa posição e armazena a cor.           
            } else if (cardec >= 20 && cardec < 40) {
                Interface.ShowParkedCar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Estacionamento/Pos4Car2.png")));
                node.setSizenode(4); // Coloca o valor da posição a ser ocupada pelo node em uma variável interna, para facilitar a função mostraCarro()
                this.push(node, 2); // Insere o carro nessa posição e armazena a cor.         
            } else if (cardec >= 40 && cardec < 60) {
                Interface.ShowParkedCar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Estacionamento/Pos4Car3.png")));
                node.setSizenode(4); // Coloca o valor da posição a ser ocupada pelo node em uma variável interna, para facilitar a função mostraCarro()
                this.push(node, 3); // Insere o carro nessa posição e armazena a cor.  
            } else if (cardec >= 60 && cardec < 80) {
                Interface.ShowParkedCar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Estacionamento/Pos4Car4.png")));
                node.setSizenode(4); // Coloca o valor da posição a ser ocupada pelo node em uma variável interna, para facilitar a função mostraCarro()
                this.push(node, 4); // Insere o carro nessa posição e armazena a cor.
            } else if (cardec >= 80 && cardec < 100) {
                Interface.ShowParkedCar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Estacionamento/Pos4Car5.png")));
                node.setSizenode(4); // Coloca o valor da posição a ser ocupada pelo node em uma variável interna, para facilitar a função mostraCarro()
                this.push(node, 5); // Insere o carro nessa posiçãoe armazena a cor.
            }

        } else if (size == 4) { // Verifica se o tamanho da pilha é 4
            cardec = randec.nextInt(100);// Decide qual das 5 cores de carros será exibida na posição a ser ocupada em seguida
            if (cardec < 20) {
                Interface.ShowParkedCar5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Estacionamento/Pos5Car1.png")));
                node.setSizenode(5); // Coloca o valor da posição a ser ocupada pelo node em uma variável interna, para facilitar a função mostraCarro()
                this.push(node, 1); // Insere o carro nessa posição e armazena a cor.       
            } else if (cardec >= 20 && cardec < 40) {
                Interface.ShowParkedCar5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Estacionamento/Pos5Car2.png")));
                node.setSizenode(5); // Coloca o valor da posição a ser ocupada pelo node em uma variável interna, para facilitar a função mostraCarro()
                this.push(node, 2); // Insere o carro nessa posição e armazena a cor.  
            } else if (cardec >= 40 && cardec < 60) {
                Interface.ShowParkedCar5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Estacionamento/Pos5Car3.png")));
                node.setSizenode(5); // Coloca o valor da posição a ser ocupada pelo node em uma variável interna, para facilitar a função mostraCarro()
                this.push(node, 3); // Insere o carro nessa posição e armazena a cor.
            } else if (cardec >= 60 && cardec < 80) {
                Interface.ShowParkedCar5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Estacionamento/Pos5Car4.png")));
                node.setSizenode(5); // Coloca o valor da posição a ser ocupada pelo node em uma variável interna, para facilitar a função mostraCarro()
                this.push(node, 4); // Insere o carro nessa posição e armazena a cor.
            } else if (cardec >= 80 && cardec < 100) {
                Interface.ShowParkedCar5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Estacionamento/Pos5Car5.png")));
                node.setSizenode(5); // Coloca o valor da posição a ser ocupada pelo node em uma variável interna, para facilitar a função mostraCarro()
                this.push(node, 5); // Insere o carro nessa posição e armazena a cor.
            }

        }
        Interface.txtN3.append("\nO carro " + node.getValor() + " chegou ao estacionamento\n"); // Mostra qual carro chegou ao estacionamento  
        Interface.txtN3.setCaretPosition(Interface.txtN3.getDocument().getLength()); // Faz scrolling automático
        this.run(); // Reinicia a execução do thread do estacionamento.
    }

    @Override
    public void run() {
        Interface.txtN3.setForeground(Color.DARK_GRAY); // Torna a cor de fundo do texto do console cinza
        if (size == 0) { // Verifica se há algum carro no estacionamento
            Interface.txtN3.append("Não há carros no estacionamento...");
            Interface.txtN3.setCaretPosition(Interface.txtN3.getDocument().getLength()); // Faz scrolling automático
        } else {
            Interface.txtN3.append("\nCarros atualmente no estacionamento:\n" + this.toString()); // Imprime os carros de todas as posições, caso hajam.
            Interface.txtN3.setCaretPosition(Interface.txtN3.getDocument().getLength()); // Faz scrolling automático
        } // Mostra todos os carros no estacionamento até o loop atual

        Interface.txtN3.append("\nAguardando a chegada dos carros...\n");
        Interface.txtN3.setCaretPosition(Interface.txtN3.getDocument().getLength()); // Faz scrolling automático

        Node n = new Node(); // Gera um carro por vez, devido ao funcionamento da pilha.
        n.setValor(randcarnum.nextInt(500)); // gera um numero aleatorio para os carros
        this.decider(n); // chama a função que decide o que será feito através de probabilidade
    }

}
