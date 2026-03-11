import java.util.Scanner;
import java.time.LocalDate;

public class App {

    static Scanner scanner = new Scanner(System.in);

    private static int menu() {
        System.out.println("\n Menu Recorde ");
        System.out.println("1. Inserir Recorde - Push");
        System.out.println("2. Remover Recorde - Pop");
        System.out.println("3. Mostrar topo - Peek");
        System.out.println("4. Mostrar Recordes");
        System.out.println("0. Sair");
        System.out.printf("Digite a opção desejada:" );
        return scanner.nextInt();
    }

    public static void main(String[] args) throws Exception {

        System.out.println("Informe a capacidade da pilha:");
        int tamanho = scanner.nextInt();
        Pilha<Record> minhaPilha = new Pilha<>(tamanho);
        int opcao = 0;

        do {
            opcao = menu();
            switch(opcao){
                case 1:
                    scanner.nextLine();
                    System.out.println("Nome do recordista:");
                    String nome = scanner.nextLine();
                    System.out.println("Tempo do recorde:");
                    double tempo = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("Data do recorde (XXXX/XX/XX):");
                    String dataRecord = scanner.nextLine();
                    LocalDate data = LocalDate.parse(dataRecord);
                    Record novo = new Record(nome, tempo, data);
                    Record topo = minhaPilha.peek();
                    if(topo == null || tempo < topo.getTempo()){
                        minhaPilha.push(novo);
                        System.out.println("Recorde alocado!");
                    }else{
                        System.out.println("Tempo não é menor que o record atual");
                    }
                    break;
                case 2:
                    Record removido = minhaPilha.pop();
                    if(removido != null)
                        System.out.println("Record removido:\n" + removido);
                    else
                        System.out.println("Pilha vazia!");
                    break;
                case 3:
                    Record topoAtual = minhaPilha.peek();
                    if(topoAtual != null)
                        System.out.println("Topo da pilha:\n" + topoAtual);
                    else
                        System.out.println("Pilha vazia!");
                    break;
                case 4:
                    System.out.println(minhaPilha.toString());
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
            }
        } while (opcao!=0);
    }
}

