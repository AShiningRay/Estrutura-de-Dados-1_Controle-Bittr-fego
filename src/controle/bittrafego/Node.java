package controle.bittrafego;

public class Node {

    private int valor, sizenode = 0;
    private Node nextNode;

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    public int getSizenode() {
        return sizenode;
    }

    public void setSizenode(int sizenode) {
        this.sizenode = sizenode;
    }

}
