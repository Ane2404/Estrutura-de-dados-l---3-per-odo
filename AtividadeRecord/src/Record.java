import java.time.LocalDate;

public class Record {

    private String nome;
    private double tempo;
    private LocalDate dataRecord;

    //vamos começar com nosso construtor que é responsável por criar o objeto dentro da nossa classe, instanciando a mesma.
    public Record (String nome, double tempo, LocalDate dataRecord){// o construtor precisa conter o mesmo nome da classe.
        this.nome = nome;
        this.tempo = tempo;
        this.dataRecord = dataRecord;
    }

    //a partir daqui estamos iniciando os getters que são métodos publicos que permitem a leitura segura de valores privados dentro de uma classe, valores de instância.
    public String getNome(){
        return nome;
    }
    public double getTempo(){
        return tempo;
    }
    public LocalDate getDataRecord(){
        return dataRecord;
    }//aqui finalizamos os getters

    @Override//estamos sobrescrevendo um método
    public String toString(){//metodo toString converte objetos em uma representação de string
        return " Record\n" + "Nome do Recordista: " + nome + " Tempo record: " + tempo + " Data do record: " + dataRecord;
    }

}



