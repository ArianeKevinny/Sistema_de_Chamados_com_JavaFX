package application;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Adm {
	
	public ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	public ArrayList<Suporte> osCabinhaDoTI = new ArrayList<Suporte>();
	public ArrayList<Solicitacao> solicitacoes = new ArrayList<Solicitacao>();
	
	Scanner ler = new Scanner(System.in);
	

	String usuario = "adminstrador";
	String senha = "senhateste";
	
	boolean permicaoAcessoAdm = true;
	boolean permicaoAcessoSuporte = true;
	boolean permicaoAcessoCliente = true; 
	
		void cadastrarCliente(){
			
			Cliente cliente = new Cliente();
			
			System.out.println("------Cadastrando Um Novo Cliente -------");
			System.out.println("Usu�rio: ");
			cliente.usuario = ler.nextLine();
			cliente.usuario.toUpperCase();
			System.out.println("Senha: ");
			cliente.senha = ler.nextLine();
			cliente.senha.toUpperCase();
			System.out.println("Setor: ");
			cliente.setor = ler.nextLine();
			cliente.setor.toUpperCase();
			cliente.permicaoAcessoCliente = true;
			
			if(clientes.contains(cliente)) {
				System.out.println("ATEN��O - CLIENTE J� CADASTRADO!");
			}else {
				clientes.add(cliente);
				System.out.println("Novo Cliente Cadastrado com sucesso");
			}		
			
		}
		
		void cadastroSuporte(){
			
			Suporte cabinhaDoTI = new Suporte();
			
			System.out.println("------Cadastrando Um Novo Suporte -------");
			System.out.println("Usu�rio: ");
			cabinhaDoTI.usuario = ler.nextLine();
			cabinhaDoTI.usuario.toUpperCase();
			System.out.println("Senha: ");
			cabinhaDoTI.senha = ler.nextLine();
			cabinhaDoTI.senha.toUpperCase();
			cabinhaDoTI.permicaoAcessoSuporte = true;
			
			if(osCabinhaDoTI.contains(cabinhaDoTI)) {
				System.out.println("ATEN��O - SUPORTE J� CADASTRADO!");
			}else {
				osCabinhaDoTI.add(cabinhaDoTI);
				System.out.println("Novo Cliente Cadastrado com sucesso");
			}

			
		}
		
		void atualizaSuporte(int index){
			
	
			
			System.out.println("------Informa��es Atuais -------");
			System.out.println("Usu�rio: " + osCabinhaDoTI.get(index).usuario);
			System.out.println("Senha: " + osCabinhaDoTI.get(index).senha);

			
			System.out.println("------Atualize As informa��es -------");
			System.out.println("Usu�rio: ");
			osCabinhaDoTI.get(index).usuario = ler.nextLine();
			osCabinhaDoTI.get(index).usuario.toUpperCase();
			System.out.println("Senha: ");
			osCabinhaDoTI.get(index).senha = ler.nextLine();
			osCabinhaDoTI.get(index).senha.toUpperCase();
			
		}
		
		void atualizaCliente(int index){
			
	
			
			System.out.println("------Informa��es Atuais -------");
			System.out.println("Usu�rio: " + clientes.get(index).usuario);
			System.out.println("Senha: " + clientes.get(index).senha);

			
			System.out.println("------Atualize As informa��es -------");
			System.out.println("Usu�rio: ");
			clientes.get(index).usuario = ler.nextLine();
			clientes.get(index).usuario.toUpperCase();
			System.out.println("Senha: ");
			clientes.get(index).senha = ler.nextLine();
			clientes.get(index).senha.toUpperCase();
			
		}
		
		void cadastroSolicitacao(Cliente cliente) {
			
			Solicitacao nova = new Solicitacao();
			System.out.println("------Cadastrando Um Novo Chamado Para o Suporte-------");
			System.out.println("Nome do chamado: ");
			nova.nome = ler.nextLine();
			nova.nome.toUpperCase();
			System.out.println("Setor do chamado: ");
			nova.setor = ler.nextLine();
			nova.setor.toUpperCase();
			System.out.println("Comant�rio: ");
			nova.comentario = ler.nextLine();
			nova.comentario.toUpperCase();
			
			boolean cont = true;
			
			do{
				System.out.println("Prioridade do Chamado: (Insira 1, 2 ou 3)");
				System.out.println("1 - M�nima");
				System.out.println("2 - M�dia");
				System.out.println("3 - M�xima");
				int opcao = ler.nextInt();
				
				switch( opcao )
				{
				    case 1:
				            nova.prioridadeMinima = true;
				            nova.prioridadeMedia = false;
				            nova.prioridadeMaxima = false;
				            cont = false; 
				            break;
				    
				    case 2:
				            nova.prioridadeMinima = false;
				            nova.prioridadeMedia = true;
				            nova.prioridadeMaxima = false;
				            cont = false; 
				            break;
				    
				    case 3:
				    		nova.prioridadeMinima = false;
				    		nova.prioridadeMedia = false;
				    		nova.prioridadeMaxima = true;
				            cont = false; 
				            break;
				    
				    default:
						System.out.println("Valor Invalido! Tente Novamente");
				}
				
				}while (cont);
			
			nova.responsavel = cliente;

			nova.dataAbertura = new Date();
			
			solicitacoes.add(nova);
			
			System.out.println("Sua Solicita��o est� aberta, aguardando o contato do suporte!");
			
			cliente.quantSolcitacoes++;
		}
		
		void acompanhamentoSolicacao(Cliente responsavel) {
			
			System.out.println("Deseja ver as solicita��es...");
			System.out.println("1 - Abertas");
			System.out.println("2 - Fechadas ");
			System.out.println("3 - Todas");
			int opcao = ler.nextInt();
			boolean cont = true;
			
			for (int i = 0; i < solicitacoes.size(); i++) {
				if(solicitacoes.get(i).responsavel == responsavel) {
					switch( opcao )
					{
					    case 1:
							if(solicitacoes.get(i).dataFinzalizacao == null) {
								
								System.out.println("----------------------------------------------------------------");
								System.out.println("Nome do chamado: " + solicitacoes.get(i).nome);
								System.out.println("Setor do chamado: " + solicitacoes.get(i).setor);
								System.out.println("Coment�rio: " + solicitacoes.get(i).comentario);
								System.out.println("Criador: " + solicitacoes.get(i).responsavel);
								System.out.println("Data de Abertura: " + solicitacoes.get(i).dataAbertura);
								System.out.println("Ultima Atualiza��o: " + solicitacoes.get(i).dataUltimaAtualizacao);
								System.out.println("----------------------------------------------------------------");
								
							}
					            cont = false; 
					            break;
					    
					    case 2:
					    		if(solicitacoes.get(i).dataFinzalizacao == null) {
								
								System.out.println("----------------------------------------------------------------");
								System.out.println("Nome do chamado: " + solicitacoes.get(i).nome);
								System.out.println("Setor do chamado: " + solicitacoes.get(i).setor);
								System.out.println("Coment�rio: " + solicitacoes.get(i).comentario);
								System.out.println("Criador: " + solicitacoes.get(i).responsavel);
								System.out.println("Data de Abertura: " + solicitacoes.get(i).dataAbertura);
								System.out.println("Ultima Atualiza��o: " + solicitacoes.get(i).dataUltimaAtualizacao);
								System.out.println("Finalizado em: " + solicitacoes.get(i).dataFinzalizacao);
								System.out.println("----------------------------------------------------------------");
								
							}
					            cont = false; 
					            break;
					    
					    case 3:
						    
					    		System.out.println("----------------------------------------------------------------");
								System.out.println("Nome do chamado: " + solicitacoes.get(i).nome);
								System.out.println("Setor do chamado: " + solicitacoes.get(i).setor);
								System.out.println("Coment�rio: " + solicitacoes.get(i).comentario);
								System.out.println("Criador: " + solicitacoes.get(i).responsavel);
								System.out.println("Data de Abertura: " + solicitacoes.get(i).dataAbertura);
								System.out.println("Ultima Atualiza��o: " + solicitacoes.get(i).dataUltimaAtualizacao);
								System.out.println("Finalizado em: " + solicitacoes.get(i).dataFinzalizacao);
								System.out.println("----------------------------------------------------------------");
							
					            cont = false; 
					            break;
					    
					    default:
							System.out.println("Valor Invalido! Tente Novamente");
					
					}while (cont);
					}
			}
		
		}
		
		void atualizarSolicitacao() {
			
			System.out.println("-----------MOSTRANDO TODAS OS CHAMADOS ABERTOS----------");
			for (int i = 0; i < solicitacoes.size(); i++) {
				if(solicitacoes.get(i).dataFinzalizacao == null) {								
					System.out.println("----------------------------------------------------------------");
					System.out.println("Nome do chamado: " + solicitacoes.get(i).nome);
					System.out.println("Setor do chamado: " + solicitacoes.get(i).setor);
					System.out.println("Coment�rio: " + solicitacoes.get(i).comentario);
					System.out.println("Criador: " + solicitacoes.get(i).responsavel);
					System.out.println("Data de Abertura: " + solicitacoes.get(i).dataAbertura);
					System.out.println("Ultima Atualiza��o: " + solicitacoes.get(i).dataUltimaAtualizacao);
					System.out.println("ID do Chamado: " + i);
					System.out.println("----------------------------------------------------------------");
								
				}
			}
			
			System.out.println("> QUAL O ID DO CHAMADO QUE IR� ATUALIZAR? ");	
			int id = ler.nextInt();
			
			System.out.println("----------------------------------------------------------------");
			System.out.println("Nome do chamado: " + solicitacoes.get(id).nome);
			System.out.println("Setor do chamado: " + solicitacoes.get(id).setor);
			System.out.println("Coment�rio: " + solicitacoes.get(id).comentario);
			System.out.println("Criador: " + solicitacoes.get(id).responsavel);
			System.out.println("Data de Abertura: " + solicitacoes.get(id).dataAbertura);
			System.out.println("Ultima Atualiza��o: " + solicitacoes.get(id).dataUltimaAtualizacao);
			System.out.println("ID do Chamado: " + id);
			System.out.println("----------------------------------------------------------------");
			
			boolean parar = false;
			
			do{
				System.out.println("Chamado Solucionado? S/N");
				String opc = ler.nextLine();
				opc.toUpperCase();
				
				switch(opc) {
						case "S":					
							System.out.println("------Atualizando o Chamado Escolido-------");
							System.out.println("Adcione Um Coment�rio: ");
							solicitacoes.get(id).comentario = ler.nextLine();
							solicitacoes.get(id).comentario.toUpperCase();
							solicitacoes.get(id).dataUltimaAtualizacao = new Date();
							solicitacoes.get(id).dataFinzalizacao = new Date();
							
							System.out.println("----------------------------------------------------------------");
							System.out.println("Nome do chamado: " + solicitacoes.get(id).nome);
							System.out.println("Setor do chamado: " + solicitacoes.get(id).setor);
							System.out.println("Coment�rio: " + solicitacoes.get(id).comentario);
							System.out.println("Criador: " + solicitacoes.get(id).responsavel);
							System.out.println("Data de Abertura: " + solicitacoes.get(id).dataAbertura);
							System.out.println("Ultima Atualiza��o: " + solicitacoes.get(id).dataUltimaAtualizacao);
							System.out.println("Fechamento do Chamado: " + solicitacoes.get(id).dataFinzalizacao);
							System.out.println("ID do Chamado: " + id);
							System.out.println("----------------------------------------------------------------");
							
							parar = true;
							break;
													
						case "N":
							System.out.println("------Atualizando o Chamado Escolido-------");
							System.out.println("Adcione Um Coment�rio: ");
							solicitacoes.get(id).comentario = ler.nextLine();
							solicitacoes.get(id).comentario.toUpperCase();
							solicitacoes.get(id).dataUltimaAtualizacao = new Date();
							
							System.out.println("----------------------------------------------------------------");
							System.out.println("Nome do chamado: " + solicitacoes.get(id).nome);
							System.out.println("Setor do chamado: " + solicitacoes.get(id).setor);
							System.out.println("Coment�rio: " + solicitacoes.get(id).comentario);
							System.out.println("Criador: " + solicitacoes.get(id).responsavel);
							System.out.println("Data de Abertura: " + solicitacoes.get(id).dataAbertura);
							System.out.println("Ultima Atualiza��o: " + solicitacoes.get(id).dataUltimaAtualizacao);
							System.out.println("ID do Chamado: " + id);
							System.out.println("----------------------------------------------------------------");
			
							parar = false;
							break;
							
						default:
							System.out.println("Insira a letra correta!");
			}
		
		}while(parar);
			
		}
	
}