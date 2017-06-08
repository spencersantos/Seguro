import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		Conexao conexao = new Conexao();
		EntradaException ler = new EntradaException();
		Scanner lerS = new Scanner(System.in);
		ArrayList<PessoaFisica> cliPf = new ArrayList<PessoaFisica>();
		ArrayList<PessoaJuridica> cliPj = new ArrayList<PessoaJuridica>();
		PessoaFisica pfCliente = new PessoaFisica();
		PessoaJuridica pjCliente = new PessoaJuridica();
		Calculo calculo = new Calculo();
		int op;
		while(true){
			System.out.println("    Seguradora:");
			System.out.println("Escollha a op��o:\n1-Cadastrar Cliente\n2-Cadastrar Contrato");
			System.out.println("3-lista de clientes\n4-Lista de contratos\n5-Cadastro de sinistro");
			System.out.println("6-lista de sinistro\n7-Lista de contrato sem sinistro");
			System.out.println("Qual a op��o? ");
			op=ler.scannerInt();
			
		switch(op)
		{
		case 1:
			
			System.out.println("1-Pessoa Fisica\n2-Pessoa Juridica");
			op=ler.scannerInt();
			if(op==1||op==2){
			if(op==1){
				System.out.println("Nome: ");
				pfCliente.setCliente(lerS.next());
				System.out.println("cpf: ");
				pfCliente.setCpf(ler.scannerInt());
				conexao.guardarClientePf(pfCliente.getCliente(),pfCliente.getCpf());
				pfCliente = new PessoaFisica();
			}
			if(op==2){
				System.out.println("Nome: ");
				pjCliente.setCliente(lerS.next());
				System.out.println("CNPJ: ");
				pjCliente.setCnpj(ler.scannerInt());
				conexao.guardarCliPj(pjCliente.getCliente(), pjCliente.getCnpj());
				pjCliente = new PessoaJuridica();
			}
			}else{
				System.out.println("Valor incorreto.");
				break;
			}break;
		case 2:
			while(true){
			System.out.println("1-Pessoa Fisica\n2-Pessoa Juridica");
			op=ler.scannerInt();
			if(op==1){
				conexao.conexaoLerPf(cliPf);
				System.out.println("Qual o numero do cliente: ");
				op=ler.scannerInt();
				PessoaFisica d = cliPf.get(op);
				if(d.getCliente()!=null){
					System.out.println("Cliente: "+d.getCliente());
					System.out.println("Endere�o:");
					d.setEndereco(lerS.next());
					System.out.println("Valor do Imovel:");
					d.setValorImovel(ler.scannerDouble());
					while(true){
					System.out.println("Area na qual se encontra:\n1-urbana \n2-suburbana \n3-rural.");
					op=ler.scannerInt();
					if(op==1||op==2||op==3){
					d.setAreaImovel(op);	
					break;
					}else{
						System.out.println("Valor incorreto.");
					}
					}
					while(true){
					System.out.println("tipo de residencia? 1-casa ou 2-Apartamento");
					op=ler.scannerInt();
					if(op==1||op==2){
						if(op==1){
					d.setResidencia(true);
					break;}
					else{
						d.setResidencia(false);
						break;}
					}else
						System.out.println("Por Favor digite '1' ou '2'");}
					conexao.guardarcontratoPf(d);
				}break;
			}
			if(op==2){
				conexao.conexaoLerPj(cliPj);
				System.out.println("Qual o numero do cliente: ");
				op=ler.scannerInt();
				PessoaJuridica d = cliPj.get(op);
				if(d.getCliente()!=null){
					System.out.println("Cliente: "+d.getCliente());
					System.out.println("Valor do Imovel:");
					d.setValorImovel(ler.scannerDouble());
					System.out.println("Numero de funcionarios:");
					d.setNumFuncionarios(ler.scannerInt());
					System.out.println("Numero diario de visitas:");
					d.setNumVisitasDiarias(ler.scannerInt());
					while(true){
					System.out.println("Ramo: \n1-com�rcio \n2-ind�stria \n3-agropecu�ria");
					op=ler.scannerInt();
					if(op==1||op==2||op==3){
						d.setRamo(op);
						break;
					}else{
						System.out.println("Valor incorreto.");
					break;}
					
					}	
					conexao.guardarContratoPj(d);
				}break;
				
			}else
				System.out.println("Valor incorreto.");
			}
			break;
			
		
		case 3:
			System.out.println("Tipo de pessoa: 1-f�sica ou 2-Jur�dica");
			op=ler.scannerInt();
			if(op==1||op==2){
				if(op==1){
					cliPf = new ArrayList<>();
					conexao.conexaoLerPf(cliPf);
				if (cliPf.size() == 0) {
					System.out.println("\nN�o existem cadastros !!!\n");
				} else {
					System.out.println("\nLista de Cadastros\n");
					for (int i = 0; i < cliPf.size(); i++) {
						PessoaFisica d = cliPf.get(i);
						System.out.println("Cadastro n�mero: " + i);
						System.out.println("\tNome: " + d.getCliente()+"\n\tcpf: "+d.getCpf());
					}	
					System.out.println("Fim da lista.\n");}
				}
				if(op==2){
					cliPj = new ArrayList<>();
					conexao.conexaoLerPj(cliPj);
					if (cliPj.size() == 0) {
						System.out.println("\nN�o existem cadastros !!!\n");
					} else {
						System.out.println("\nLista de Cadastros\n");
						for (int i = 0; i < cliPj.size(); i++) {
							PessoaJuridica d = cliPj.get(i);
							System.out.println("Cadastro n�mero: " + i);
							System.out.println("\tNome: " + d.getCliente()+"\n\tCnpj: "+d.getCnpj());
							
						}	
						System.out.println("Fim da lista.\n");}
					}
				
				}else
					System.out.println("valor inv�lido.\n");
				
				break;
				
		case 4:
			System.out.println("Listar Contratos:");
			System.out.println("Tipo de pessoa: 1-f�sica ou 2-Jur�dica");
			op=ler.scannerInt();
			if(op==1||op==2){
				if(op==1){
					cliPf = new ArrayList<>();
					conexao.conexaoLerPf(cliPf);
				if (cliPf.size() == 0) {
					System.out.println("\nN�o existem cadastros !!!\n");
				} else {
					System.out.println("\nLista de Cadastros\n");
					for (int i = 0; i < cliPf.size(); i++) {
						PessoaFisica d = cliPf.get(i);
						if(d.getValorImovel()!=0){
						System.out.println("Cadastro n�mero: " + i);
						System.out.println("\tNome: " + d.getCliente());
						System.out.println("\tEndere�o: " + d.getEndereco());
						System.out.println("\tValor do imovel: "+d.getValorImovel());
						System.out.println("\tArea na qual se encontra: ");
						calculo.area(d);
						System.out.println("\ttipo de residencia: ");
						if(d.isResidencia()==true){
							System.out.println("casa");
						}else{
							System.out.println("Apartamento");
						}
					}}
		break;
				}	
	}
				if(op==2){
					cliPj = new ArrayList<>();
					conexao.conexaoLerPj(cliPj);
					if (cliPj.size() == 0) {
						System.out.println("\nN�o existem cadastros !!!\n");
					} else {
						System.out.println("\nLista de Cadastros\n");
						for (int i = 0; i < cliPj.size(); i++) {
							PessoaJuridica d = cliPj.get(i);
							if(d.getValorImovel()!=0){
							System.out.println("Cadastro n�mero: " + i);
							System.out.println("\tNome: " + d.getCliente());
							System.out.println("\tValor do imovel: "+d.getValorImovel());
							System.out.println("\tNumero de Funcionarios: "+d.getNumFuncionarios());
							System.out.println("\tNumero de visitas diarias: "+d.getNumVisitasDiarias());
							System.out.println("\tRamo: ");
							calculo.ramo(d);
						}
						}
				}
			}else{
				System.out.println("Valor invalido.");
			}
			}break;
			
		case 5:
			System.out.println("Cadastro de sinistro:");
			System.out.println("Tipo de pessoa: 1-f�sica ou 2-Jur�dica");
			op=ler.scannerInt();
			if(op==1||op==2){
				
				if(op==1){
					cliPf = new ArrayList<>();
					conexao.conexaoLerPf(cliPf);
					System.out.println("N�mero do cliente:");
					PessoaFisica d = cliPf.get(ler.scannerInt());
					if(d!=null){
					System.out.println("Nome:"+d.getCliente());
					System.out.println("Data:");
					d.setDataSinistro(lerS.next());
					calculo.seguroResidencial(d);
					System.out.println("Valor do Sinistro: "+ d.getSeguro());
					d.setTemSinistro(true);
					conexao.guardarSinistroPf(d);
					}else
						System.out.println("Cliente n�o existente.");
				}
				if(op==2){
					cliPj = new ArrayList<>();
					conexao.conexaoLerPj(cliPj);
					System.out.println("N�mero do cliente:");
					PessoaJuridica d = cliPj.get(ler.scannerInt());
					if(d!=null){
					System.out.println("Nome:"+d.getCliente());
					System.out.println("Data:");
					d.setDataSinistro(lerS.next());
					calculo.seguroEmpresarial(d);
					System.out.println("Valor do Sinistro: "+d.getSeguro());
					d.setTemSinistro(true);
					conexao.guardarSinistroPj(d);
				}else
					System.out.println("Cliente n�o existente.");
				}
		}
			else
				System.out.println("Valor inv�lido");
			break;
		case 6:
			System.out.println("Lista de Sinistro.");
			System.out.println("Tipo de pessoa: 1-f�sica ou 2-Jur�dica");
			op=ler.scannerInt();
			if(op==1||op==2){
				
				if(op==1){
					cliPf = new ArrayList<>();
					conexao.conexaoLerPf(cliPf);
					if (cliPf.size() == 0) {
						System.out.println("\nN�o existem cadastros !!!\n");
					} else {
						for (int i = 0; i < cliPf.size(); i++) {
							PessoaFisica d = cliPf.get(i);
							if(d.isTemSinistro()==true){
							System.out.println("Nome:"+ d.getCliente());
							calculo.seguroResidencial(d);
							System.out.println("Sinistro:"+d.getSeguro());
							System.out.println("data:"+d.getDataSinistro()+"\n");
						}}
					
					}
					
					
				}
				if(op==2){
					cliPj = new ArrayList<>();
					conexao.conexaoLerPj(cliPj);
					if (cliPj.size() == 0) {
						System.out.println("\nN�o existem cadastros !!!\n");
					} else {
						for (int i = 0; i < cliPj.size(); i++) {
							PessoaJuridica d = cliPj.get(i);
							if(d.isTemSinistro()==true){
							System.out.println("Nome:"+ d.getCliente());
							calculo.seguroEmpresarial(d);
							System.out.println("Sinistro: "+d.getSeguro());	
							System.out.println("data:"+d.getDataSinistro()+"\n");
						}}
					
					}
					
					
				}
			}else
				System.out.println("Valor Inv�lido.");
			break;
		case 7:
			System.out.println("Listar Contratos sem sinistro:");
			System.out.println("Tipo de pessoa: 1-f�sica ou 2-Jur�dica");
			op= ler.scannerInt();
			if(op==1||op==2){
				if(op==1){
					cliPf = new ArrayList<>();
					conexao.conexaoLerPf(cliPf);
				if (cliPf.size() == 0) {
					System.out.println("\nN�o existem cadastros !!!\n");
				} else {
					System.out.println("\nLista de Cadastros\n");
					for (int i = 0; i < cliPf.size(); i++) {
						PessoaFisica d = cliPf.get(i);
						if(d.isTemSinistro()==false){
						System.out.println("Cadastro n�mero: " + i);
						System.out.println("\tNome: " + d.getCliente());
						System.out.println("\tEndere�o: " + d.getEndereco());
						System.out.println("\tValor do imovel: "+d.getValorImovel());
						System.out.println("\tArea na qual se encontra: ");
						calculo.area(d);
						System.out.println("\ttipo de residencia: ");
						if(d.isResidencia()==true){
							System.out.println("casa");
						}else{
							System.out.println("Apartamento");
						}
					}}
				}
				break;}
			
				if(op==2){
					cliPj = new ArrayList<>();
					conexao.conexaoLerPj(cliPj);
					if (cliPj.size() == 0) {
						System.out.println("\nN�o existem cadastros !!!\n");
					} else {
						System.out.println("\nLista de Cadastros\n");
						for (int i = 0; i < cliPj.size(); i++) {
							PessoaJuridica d = cliPj.get(i);
							if(d.isTemSinistro()==false){
							System.out.println("Cadastro n�mero: " + i);
							System.out.println("\tNome: " + d.getCliente());
							System.out.println("\tValor do imovel: "+d.getValorImovel());
							System.out.println("\tNumero de Funcionarios: "+d.getNumFuncionarios());
							System.out.println("\tNumero de visitas diarias: "+d.getNumVisitasDiarias());
							System.out.println("\tRamo: ");
							calculo.ramo(d);
							}
						}
						}
					break;
			}else{
				System.out.println("Valor invalido.");
			}
		}
		}
	}
}
}