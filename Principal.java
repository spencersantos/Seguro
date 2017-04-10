import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		Scanner ler= new Scanner(System.in);
		ArrayList<PessoaFisica> cliPf = new ArrayList<PessoaFisica>();
		ArrayList<PessoaJuridica> cliPj = new ArrayList<PessoaJuridica>();
		PessoaFisica pfCliente = new PessoaFisica();
		PessoaJuridica pjCliente = new PessoaJuridica();
		Calculo calculo = new Calculo();
		int op;
		while(true){
			System.out.println("    Seguradora:");
			System.out.println("Escollha a opção:\n1-Cadastrar Cliente\n2-Cadastrar Contrato");
			System.out.println("3-lista de clientes\n4-Lista de contratos\n5-Cadastro de sinistro");
			System.out.println("6-lista de sinistro\n7-Lista de contrato sem sinistro");
			System.out.println("Qual a opção? ");
			op=ler.nextInt();
			
		switch(op)
		{
		case 1:
			System.out.println("1-Pessoa Fisica\n2-Pessoa Juridica");
			op=ler.nextInt();
			if(op==1||op==2){
			if(op==1){
				System.out.println("Nome: ");
				pfCliente.setCliente(ler.next());
				cliPf.add(pfCliente);
				pfCliente = new PessoaFisica();
			}
			if(op==2){
				System.out.println("Nome: ");
				pjCliente.setCliente(ler.next());
				cliPj.add(pjCliente);
				pjCliente = new PessoaJuridica();
			}
			}else{
				System.out.println("Valor incorreto.");
				break;
			}break;
		case 2:
			System.out.println("1-Pessoa Fisica\n2-Pessoa Juridica");
			op=ler.nextInt();
			if(op==1){
				System.out.println("Qual o numero do cliente: ");
				op=ler.nextInt();
				PessoaFisica d = cliPf.get(op);
				if(d.getCliente()!=null){
					System.out.println("Cliente: "+d.getCliente());
					System.out.println("Endereço:");
					d.setEndereco(ler.next());
					System.out.println("Valor do Imovel:");
					d.setValorImovel(ler.nextDouble());
					while(true){
					System.out.println("Area na qual se encontra:\n1-urbana \n2-suburbana \n3-rural.");
					op=ler.nextInt();
					if(op==1||op==2||op==3){
					d.setAreaImovel(op);	
					break;
					}else{
						System.out.println("Valor incorreto.");
					}
					}
					System.out.println("tipo de residencia é casa? 1-sim ou 2-Apartamento");
					op=ler.nextInt();
					if(op==1){
					d.setResidencia(true);
					}else{
						d.setResidencia(false);
					}
				}break;
			}
			if(op==2){
				System.out.println("Qual o numero do cliente: ");
				op=ler.nextInt();
				PessoaJuridica d = cliPj.get(op);
				if(d.getCliente()!=null){
					System.out.println("Cliente: "+d.getCliente());
					System.out.println("Valor do Imovel:");
					d.setValorImovel(ler.nextDouble());
					System.out.println("Numero de funcionarios:");
					d.setNumFuncionarios(ler.nextInt());
					System.out.println("Numero diario de visitas:");
					d.setNumVisitasDiarias(ler.nextInt());
					while(true){
					System.out.println("Ramo: \n1-comércio \n2-indústria \n3-agropecuária");
					op=ler.nextInt();
					if(op==1||op==2||op==3){
						d.setRamo(op);
						break;
					}else{
						System.out.println("Valor incorreto.");
					break;}
					
					}	
				}break;
				
			}
			
		
		case 3:
			System.out.println("Tipo de pessoa: 1-física ou 2-Jurídica");
			op=ler.nextInt();
			if(op==1||op==2){
				if(op==1){
				if (cliPf.size() == 0) {
					System.out.println("\nNão existem cadastros !!!\n");
				} else {
					System.out.println("\nLista de Cadastros\n");
					for (int i = 0; i < cliPf.size(); i++) {
						PessoaFisica d = cliPf.get(i);
						System.out.println("Cadastro número: " + i);
						System.out.println("\tNome: " + d.getCliente());
					}	
					System.out.println("Fim da lista.\n");}
				}
				if(op==2){
					if (cliPj.size() == 0) {
						System.out.println("\nNão existem cadastros !!!\n");
					} else {
						System.out.println("\nLista de Cadastros\n");
						for (int i = 0; i < cliPj.size(); i++) {
							PessoaJuridica d = cliPj.get(i);
							System.out.println("Cadastro número: " + i);
							System.out.println("\tNome: " + d.getCliente());
							
						}	
						System.out.println("Fim da lista.\n");}
					}
				
				}else
					System.out.println("valor inválido.\n");
				
				break;
				
		case 4:
			System.out.println("Listar Contratos:");
			System.out.println("Tipo de pessoa: 1-física ou 2-Jurídica");
			op=ler.nextInt();
			if(op==1||op==2){
				if(op==1){
				if (cliPf.size() == 0) {
					System.out.println("\nNão existem cadastros !!!\n");
				} else {
					System.out.println("\nLista de Cadastros\n");
					for (int i = 0; i < cliPf.size(); i++) {
						PessoaFisica d = cliPf.get(i);
						System.out.println("Cadastro número: " + i);
						System.out.println("\tNome: " + d.getCliente());
						System.out.println("\tEndereço: " + d.getEndereco());
						System.out.println("\tValor do imovel: "+d.getValorImovel());
						System.out.println("\tArea na qual se encontra: ");
						calculo.Area(d);
						System.out.println("\ttipo de residencia: ");
						if(d.isResidencia()==true){
							System.out.println("casa");
						}else{
							System.out.println("Apartamento");
						}
					}
		break;
				}	
	}
				if(op==2){
					if (cliPj.size() == 0) {
						System.out.println("\nNão existem cadastros !!!\n");
					} else {
						System.out.println("\nLista de Cadastros\n");
						for (int i = 0; i < cliPj.size(); i++) {
							PessoaJuridica d = cliPj.get(i);
							System.out.println("Cadastro número: " + i);
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
			}break;
			
		case 5:
			System.out.println("Cadastro de sinistro:");
			System.out.println("Tipo de pessoa: 1-física ou 2-Jurídica");
			op=ler.nextInt();
			if(op==1||op==2){
				
				if(op==1){
					System.out.println("Número do cliente:");
					PessoaFisica d = cliPf.get(ler.nextInt());
					System.out.println("Nome:"+d.getCliente());
					System.out.println("Data:");
					d.setDataSinistro(ler.next());
					calculo.SeguroResidencial(d);
					System.out.println("Valor do Sinistro: "+ d.getSeguro());
					d.setTemSinistro(true);
				}
				if(op==2){
					System.out.println("Número do cliente:");
					PessoaJuridica d = cliPj.get(ler.nextInt());
					System.out.println("Nome:"+d.getCliente());
					System.out.println("Data:");
					d.setDataSinistro(ler.next());
					calculo.SeguroEmpresarial(d);
					System.out.println("Valor do Sinistro: "+d.getSeguro());
					d.setTemSinistro(true);
				}
		}
			else
				System.out.println("Valor inválido");
			break;
		case 6:
			System.out.println("Lista de Sinistro.");
			System.out.println("Tipo de pessoa: 1-física ou 2-Jurídica");
			op=ler.nextInt();
			if(op==1||op==2){
				
				if(op==1){
					if (cliPf.size() == 0) {
						System.out.println("\nNão existem cadastros !!!\n");
					} else {
						for (int i = 0; i < cliPf.size(); i++) {
							PessoaFisica d = cliPf.get(i);
							if(d.isTemSinistro()==true){
							System.out.println("Nome:"+ d.getCliente());
							calculo.SeguroResidencial(d);
							System.out.println("Sinistro:"+d.getSeguro());
							System.out.println("data:"+d.getDataSinistro()+"\n");
						}}
					
					}
					
					
				}
				if(op==2){
					if (cliPj.size() == 0) {
						System.out.println("\nNão existem cadastros !!!\n");
					} else {
						for (int i = 0; i < cliPj.size(); i++) {
							PessoaJuridica d = cliPj.get(i);
							if(d.isTemSinistro()==true){
							System.out.println("Nome:"+ d.getCliente());
							calculo.SeguroEmpresarial(d);
							System.out.println("Sinistro: "+d.getSeguro());	
							System.out.println("data:"+d.getDataSinistro()+"\n");
						}}
					
					}
					
					
				}
			}else
				System.out.println("Valor Inválido.");
			break;
		case 7:
			System.out.println("Listar Contratos sem sinistro:");
			System.out.println("Tipo de pessoa: 1-física ou 2-Jurídica");
			op=ler.nextInt();
			if(op==1||op==2){
				if(op==1){
				if (cliPf.size() == 0) {
					System.out.println("\nNão existem cadastros !!!\n");
				} else {
					System.out.println("\nLista de Cadastros\n");
					for (int i = 0; i < cliPf.size(); i++) {
						PessoaFisica d = cliPf.get(i);
						if(d.isTemSinistro()==false){
						System.out.println("Cadastro número: " + i);
						System.out.println("\tNome: " + d.getCliente());
						System.out.println("\tEndereço: " + d.getEndereco());
						System.out.println("\tValor do imovel: "+d.getValorImovel());
						System.out.println("\tArea na qual se encontra: ");
						calculo.Area(d);
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
					if (cliPj.size() == 0) {
						System.out.println("\nNão existem cadastros !!!\n");
					} else {
						System.out.println("\nLista de Cadastros\n");
						for (int i = 0; i < cliPj.size(); i++) {
							PessoaJuridica d = cliPj.get(i);
							if(d.isTemSinistro()==false){
							System.out.println("Cadastro número: " + i);
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