package controle.bittrafego;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Connection implements Runnable {

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy - hh:mm:ss"); //Faz a formatação da data e hora para ser utilizada no console.
    DB BaseDados; //Cria um objeto DB.
    DBCollection colecao; //Cria uma coleção DB.
    boolean p = false;

    public boolean isP() {
        return p;
    }

    public void run() {
        Interface.txtC.setForeground(Color.blue);
        Interface.txtC.append(dateFormat.format(new Date()) + "\nTentando conectar ao Banco de Dados... \n");
        Interface.txtC.append("\n");
        Interface.txtC.append("\n");
        Interface.txtC.setCaretPosition(Interface.txtC.getDocument().getLength()); //Faz o scroll automático do console.

        Mongo mong = new Mongo("localhost", 27017); //Faz a conecção com o mongoDB.            
        BaseDados = mong.getDB("CBTT"); //Obtém a base de dados CBTT.
        colecao = BaseDados.getCollection("Ruas"); //Obtém a coleção Ruas da base de dados CBTT.

        try {
            DBObject test = new BasicDBObject("ping", "1"); // Realiza um teste de ping para checar a conexão ao DB
            mong.getDB("CBTT").command(test);// Realiza um teste de ping para checar a conexão ao DB
            Interface.checaenvio = true; // Permite ao programa enviar os dados dos carros ao MongoDB
            p = true;
        } catch (Exception e) {
            Interface.checaenvio = false; // Evita que o programa tente enviar os dados dos carros ao MongoDB, para não ocasionar exceções.
            p = false;
        }

        if (p == true) { // Caso a conexão tenha sido feita com sucesso, muda a fonte para verde e sinaliza que pôde conectar, caso contrário, não imprime nada
            Interface.txtC.setForeground(Color.green);
            Interface.txtC.append("\n" + dateFormat.format(new Date()));
            Interface.txtC.append("\n" + "Conectado ao Banco de Dados!");
            Interface.txtC.append("\n");
            Interface.txtC.setCaretPosition(Interface.txtC.getDocument().getLength());
        }
    }

    public void guarda1(String car1, int cor1, int rua) { //Caso tenha somente um carro na rua ele chama essa função que guarda apenas um carro.
        Mongo mong = new Mongo("localhost", 27017);
        BaseDados = mong.getDB("CBTT");
        colecao = BaseDados.getCollection("Ruas");

        BasicDBObject Document = new BasicDBObject(); //Cria um documendo básico do objeto do Banco de Dados.

        Document.put("_id", car1); //Insere a ID no documento.
        Document.put("Cor", cor1);//Insere a Cor no documento.
        Document.put("Rua", rua);//Insere a Rua no documento.
        colecao.insert(Document); //Insere o documento no BD

        Interface.txtC.append("\n" + dateFormat.format(new Date())); //Insere a data no console.
        Interface.txtC.append("\n" + "1 carro gravado com Sucesso no DB."); //Imprime no console.
        Interface.txtC.append("\n");
        Interface.txtC.setCaretPosition(Interface.txtC.getDocument().getLength());
        mong.close(); //Fecha a conexão com o MongoDB para evitar várias conexões abertas.
    }

    public void guarda2(String car1, String car2, int cor1, int cor2, int rua) {//Caso tenha dois na rua ele chama essa função que guarda dois carros.
        Mongo mong = new Mongo("localhost", 27017);
        BaseDados = mong.getDB("CBTT");
        colecao = BaseDados.getCollection("Ruas");

        for (int i = 0; i < 2; i++) {
            BasicDBObject Document = new BasicDBObject();
            if (i == 0) {
                Document.put("_id", car1);
                Document.put("Cor", cor1);
                Document.put("Rua", rua);
                colecao.insert(Document);
            }
            if (i == 1) {
                Document.put("_id", car2);
                Document.put("Cor", cor2);
                Document.put("Rua", rua);
                colecao.insert(Document);
            }
        }
        Interface.txtC.append("\n" + dateFormat.format(new Date())); //Insere a data no console.
        Interface.txtC.append("\n" + "2 carros gravados com Sucesso no DB."); //Imprime no console.
        Interface.txtC.append("\n");
        Interface.txtC.setCaretPosition(Interface.txtC.getDocument().getLength());
        mong.close();
    }

    public void guarda3(String car1, String car2, String car3, int cor1, int cor2, int cor3, int rua) {//Caso tenha tres na rua ele chama essa função que guarda tres carros.
        Mongo mong = new Mongo("localhost", 27017);
        BaseDados = mong.getDB("CBTT");
        colecao = BaseDados.getCollection("Ruas");

        for (int i = 0; i < 3; i++) {
            BasicDBObject Document = new BasicDBObject();
            if (i == 0) {
                Document.put("_id", car1);
                Document.put("Cor", cor1);
                Document.put("Rua", rua);
                colecao.insert(Document);
            }
            if (i == 1) {
                Document.put("_id", car2);
                Document.put("Cor", cor2);
                Document.put("Rua", rua);
                colecao.insert(Document);
            }
            if (i == 2) {
                Document.put("_id", car3);
                Document.put("Cor", cor3);
                Document.put("Rua", rua);
                colecao.insert(Document);
            }

        }
        Interface.txtC.append("\n" + dateFormat.format(new Date())); //Insere a data no console.
        Interface.txtC.append("\n" + "3 carros gravados com Sucesso no DB."); //Imprime no console.
        Interface.txtC.append("\n");
        Interface.txtC.setCaretPosition(Interface.txtC.getDocument().getLength());
        mong.close();
    }

    public void estacionamento(String car, int cor) { //A classe pilha chama essa função quando é necessário guardar um carro do estacionamento no BD.
        BasicDBObject Document = new BasicDBObject();
        Mongo mong = new Mongo("localhost", 27017);
        BaseDados = mong.getDB("CBTT");
        colecao = BaseDados.getCollection("Estacionamento");

        Document.put("_id", car);
        Document.put("Cor", cor);
        colecao.insert(Document);
        Interface.txtC.append("\n" + dateFormat.format(new Date())); //Insere a data no console.
        Interface.txtC.append("\n" + "entrada no estacionamento gravada com Sucesso no DB."); //Imprime no console.
        Interface.txtC.append("\n");
        Interface.txtC.setCaretPosition(Interface.txtC.getDocument().getLength());
        mong.close();
    }

}
