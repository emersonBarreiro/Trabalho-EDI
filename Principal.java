package principal;

import java.util.Scanner;

import estruturas.Instrumento;
import estruturas.Lista;
import estruturas.Pilha;

public class Principal {

	public static Scanner teclado = new Scanner(System.in);
	public static Scanner op = new Scanner(System.in);
	static Pilha<Integer> pilhaentradas = new Pilha<Integer>();
	static Pilha<Integer> pilhasaidas = new Pilha<Integer>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Lista lista = new Lista();
		lista.qtd = 0;
		int opcao = 0;
		
		do {
			System.out.println("1- Cadastrar Instrumento: ");
			System.out.println("2- Mostrar instrumentos cadastradados: ");
			System.out.println("3- Pesquisar um item");
			System.out.println("4- Alterar informações");
			System.out.println("5- Vender um instrumento");
			System.out.println("6 - Adicionar um instrumento ao estoque");
			System.out.println("7- Sair \n");
			opcao = op.nextInt();
			 
			
			switch(opcao) {
			case 1:
				lista.cadastrar(lista);
				break;
				
			case 2:
				lista.listar(lista);
				break;
				
			case 3:
				Instrumento aux = lista.pesquisar(lista);
				if(aux==null) {
					System.out.println("Instrumento não encontrado!\n");
				}else{
					System.out.println("Instrumento encontrado, seguem informações:\n"
							+ "\nNome: " + aux.nome 
							+ "\nValor: "+ aux.valor
							+ "\nQuantidade: "+ aux.quantidade);
				}
				break;
			case 4:
				lista.alterarInfo(lista);
				break;
			case 5:
				int venda;
				venda = lista.Venda(lista);
				break;
			case 6:
				int entrada;
				entrada = lista.entrada(lista);
				break;
			case 7:
				System.out.println("Saindo do sistema...");
				break;
			default:
				System.out.println("Digite uma operação válida!");
				break;
				
			}
		}while(opcao!=6);
			
		
	}
	
	
}
