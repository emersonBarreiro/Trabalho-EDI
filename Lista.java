package estruturas;

import java.util.Scanner;

public class Lista {
	
	public static Scanner teclado = new Scanner(System.in);
	public static Scanner op = new Scanner(System.in);
	
	public Instrumento primeiro;
	public Instrumento ultimo;
	public int qtd;
	
	public int tamanho() {
		
		return this.qtd;
	}
	
	public Instrumento pesquisar(Lista lista) {
		System.out.println("Pesquisar: ");
		String teste = teclado.next();
		Instrumento aux = lista.primeiro;
		while(aux!=null && !aux.nome.equals(teste)) {
			aux = aux.proximo;
		}
		if(aux==null) {
			return null;
			//System.out.println("Elemento nao encontrado");
		}else {
			return aux;
		/*System.out.println("Elemento encontrado. Seguem informações:" + 
		"\nNome:"+aux.nome +
		"\nValor: "+ aux.valor +
		"\nQuantidade em estoque: " + aux.quantidade);*/
		}
	}
	
	//Método para listar instrumentos cadastrados
	public void listar(Lista lista) {
		Instrumento aux = lista.primeiro;
		if(aux == null) {
			System.out.println("ESTOQUE VAZIO!Cadastre um item!!!");
		}else {
			while (aux!=null) {
				System.out.println("Nome do produto: " + aux.nome + "/Quantidade em estoque: " + aux.quantidade + "/Valor: " + aux.valor);
				aux = aux.proximo;
			}
		}
	}
	
	
	//Método para cadastrar instrumentos
	public void cadastrar(Lista lista) {
		int a = 0;
		do {
		Instrumento novoObj = new Instrumento();
		Instrumento objAux = new Instrumento();
		
		
		//Lista sem nenhum elemento
		if(lista.qtd == 0) {
			System.out.print("Informe o Instrumento que será atualizado no estoque: ");
			novoObj.nome = teclado.next();
			
			System.out.println("Informe a quantidade: ");
			novoObj.quantidade = teclado.nextInt();
			
			System.out.println("Informe o valor: ");
			novoObj.valor = teclado.nextDouble();
			
			System.out.print("Deseja continuar a cadastrar? 1 - NAO ; Qualquer numero para 'SIM'");
			a = op.nextInt();
			
			novoObj.proximo=null;
			
			lista.primeiro = novoObj;
			lista.ultimo = novoObj;
			lista.qtd++;
			
			
		}
		//Lista com elementos
		else {
			
			objAux = lista.primeiro;
			
			while(objAux.proximo!=null) {
				objAux = objAux.proximo;
			}
			System.out.print("Informe o Instrumento que será atualizado no estoque: ");
			novoObj.nome = teclado.next();
			
			System.out.println("Informe a quantidade: ");
			novoObj.quantidade = teclado.nextInt();
			
			System.out.println("Informe o valor: ");
			novoObj.valor = teclado.nextDouble();
			
			System.out.print("Deseja continuar a cadastrar? 1 - 'NAO' ; Qualquer numero para 'SIM'");
			a = op.nextInt();
			novoObj.proximo=null;
			
			objAux.proximo = novoObj;
			
			lista.ultimo = novoObj;
			lista.qtd++;
		}
		}while(a != 1);
	}
	public void alterarInfo(Lista lista) {
		Instrumento aux = this.pesquisar(lista);
		if(aux==null) {
			System.out.println("Elemento não encontrado!");
		}else {
			System.out.println("O que deseja alterar? 1-nome/2-valor/3-quantidade: ");
			int opcao=op.nextInt();
			switch(opcao) {
			case 1:{
				System.out.println("Digite o novo nome: ");
				aux.setNome(teclado.next());
			}
			break;
			
			case 2:{
				System.out.println("Digite o novo valor: ");
				aux.setValor(teclado.nextDouble());
			}
			break;
			
			case 3:{
				System.out.println("Digite a nova quantidade: ");
				aux.setQuantidade(teclado.nextInt());
			}
			break;
				
			default:
				System.out.println("Alteração cancelada!");
			break;
			}
		}
		
	}
	public int Venda(Lista lista) {
		Instrumento aux = this.pesquisar(lista);
		int qtdAtual, novaQtd, qtdVenda;
		if(aux==null) {
			System.out.println("Elemento não encontrado!");
			return 0;
		}else {
			qtdAtual = aux.getQuantidade();
			System.out.println("Digite a quantidade vendida: ");
			qtdVenda = teclado.nextInt();
			novaQtd = qtdAtual - qtdVenda;
			if(novaQtd < 0) {
				System.out.println("Impossível vender quantidade maior do que a disponível em estoque!");
				return 0;
			}else {
				aux.setQuantidade(novaQtd);
				return qtdVenda;
			}
		}

	}

	public int entrada(Lista lista) {
		Instrumento aux = this.pesquisar(lista);
		int qtdAtual, novaQtd, qtdEntrada;
		if(aux==null) {
			System.out.println("Elemento não encontrado!");
			return 0;
		}else {
			qtdAtual = aux.getQuantidade();
			System.out.println("Digite a quantidade a inserir no estoque: ");
			qtdEntrada = teclado.nextInt();
			novaQtd = qtdAtual + teclado.nextInt();
			aux.setQuantidade(novaQtd);
		}
		return qtdEntrada;
	}

}
