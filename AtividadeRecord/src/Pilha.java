public class Pilha<T>{

    private int topo;//responsável por acompanhar o topo da pilha e ajudar no gerenciamento.
    private T[] elementos;//trata-se da variável responsável por guardar os elementos que serão do tipo genérico.

    public Pilha(int capacidade){//nossa capacidade será informada pelo usuário no main.
        this.topo = -1; //aqui estamos fornecendo um valor para topo, -1 representa que esta vazio.
        this.elementos = (T[]) new Object[capacidade];//aqui estamos instanciando um vetor para a pilha.

    }

    //criada a pilha, vamos começar a criação dos módulos.


    public boolean isFull(){//responsável por identificar se a pilha esta cheia
        return this.elementos.length-1 == this.topo;//retornamos quando o tamanho de elementos -1 for igual a topo, variável que acompanha a quantidade de dados.

    }

    public boolean push (T elemento){// resposável por inserir um dado dentro da pilha
        if(!this.isFull()){//se a pilha não estiver cheia, ou tambem, se a função isFull retornar false, avançamos.
            this.topo++;//incrementamos o topo primeiro.
            this.elementos[topo] = elemento;//incrementamos o elemento na nova posição do topo.
            return true;
        }

        return false;
    }

    private void resize(){//responsável por aumentar a capacidade da pilha caso sua capacidade se exceda.
        T[] novo = (T[]) new Object[this.elementos.length * 2];

        for(int i = 0; i < this.elementos.length; i++){
            novo[i] = this.elementos[i];
        }

        this.elementos = novo;
    }

    public boolean isEmpty(){
        //responsável por verificar se a pilha esta vazia.
        return this.topo == -1;//-1 é a posição que representa o vazio.
    }

    public T pop(){
        if(!isEmpty()){
            //responsável por remover um dado.
            T removido = this.elementos[this.topo];// primeiro passamos o elemento e sua posição para outra variável nomeada removido.
            this.topo--;//e só então decrementamos o topo. O dado não é removido de imediato, mas sua posição pode sofrer uma substituição.
            return removido;
        }

        return null; //aqui não retornamos nada. Retornamos algo nulo.
    }

    public T peek(){
        //mostra ao usuário o valor contido no topo da pilha.
        if(!isEmpty())// se não estiver vazia.
            return this.elementos[this.topo];//retornamos o elemento contido no topo.
        else
            return null;//se não, retornamos algo nulo, retornamos o nada.
    }

    @Override//polimorfismo de sobrescrita, vamos sobrescrever um método. Garante que o metodo chamado será decidido pelo tipo de objeto e não por sua referência.
    public String toString (){//toString serve para retornar os dados de modo organizado.
        //essa função mostra todos os dados contidos na pilha
        StringBuilder pilha = new StringBuilder("Topo\n");
        for(int i = this.topo; i>=0; i--)
            pilha.append(this.elementos[i]+"\n");

        pilha.append("____\n");
        return pilha.toString();
    }
}

