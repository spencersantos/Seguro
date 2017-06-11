import java.util.ArrayList;
import java.util.Scanner;

public class Cadastros {

	// Chama a classe responsavel pelo acesso ao banco.
	Conexao conexao = new Conexao();
	// Chama a classe responsavel por tratar grande parte das exceções.
	EntradaException ler = new EntradaException();
	Scanner lerS = new Scanner(System.in);
	ArrayList<PessoaFisica> cliPf = new ArrayList<PessoaFisica>();
	ArrayList<PessoaJuridica> cliPj = new ArrayList<PessoaJuridica>();
	PessoaFisica pfCliente = new PessoaFisica();
	PessoaJuridica pjCliente = new PessoaJuridica();
	// Classe com os metodos necessarios para calculos do programa.
	Calculo calculo = new Calculo();
	int op;
	boolean b = true;

	// Método responsavel por fazer o cadastro do nome e do cpf(cnpj) do
	// cliente, caso ja exista o cpf(cnpj) uma mensagem informará.
	public void cadastroPf() {
		while (b) {
			System.out.println("1-Pessoa Fisica\n2-Pessoa Juridica");
			op = ler.scannerInt();
			if (op == 1 || op == 2) {
				if (op == 1) {
					System.out.println("Nome: ");
					pfCliente.setCliente(lerS.next());
					System.out.println("cpf: ");
					pfCliente.setCpf(ler.scannerLong());
					conexao.guardarClientePf(pfCliente.getCliente(), pfCliente.getCpf());
					pfCliente = new PessoaFisica();
				}
				if (op == 2) {
					System.out.println("Nome: ");
					pjCliente.setCliente(lerS.next());
					System.out.println("CNPJ: ");
					pjCliente.setCnpj(ler.scannerLong());
					conexao.guardarCliPj(pjCliente.getCliente(), pjCliente.getCnpj());
					pjCliente = new PessoaJuridica();
				}
			} else {
				System.out.println("Valor incorreto.");

			}
			b = false;
		}

	}

	/*
	 * Método responsavel por cadastrar(ou atualizar) contrato dos clinetes,
	 * sendo nescessario primeiro o cliente ter o nome e cpf(ou cnpj)
	 * cadastrados.
	 */
	public void cadastroContrato() {
		while (true) {
			System.out.println("1-Pessoa Fisica\n2-Pessoa Juridica");
			op = ler.scannerInt();
			if (op == 1) {
				cliPf = new ArrayList<>();
				conexao.conexaoLerPf(cliPf);
				System.out.println("Qual o numero do cliente: ");
				op = ler.scannerInt();
				if (op >= cliPf.size()) {
					System.out.println("\nIndice invalido !!!\n");
				} else {
					PessoaFisica d = cliPf.get(op);
					if (d.getCliente() != null) {
						System.out.println("Cliente: " + d.getCliente());
						System.out.println("Endereço:");
						d.setEndereco(lerS.next());
						System.out.println("Valor do Imovel:");
						d.setValorImovel(ler.scannerDouble());
						while (true) {
							System.out.println("Area na qual se encontra:\n1-urbana \n2-suburbana \n3-rural.");
							op = ler.scannerInt();
							if (op == 1 || op == 2 || op == 3) {
								d.setAreaImovel(op);
								break;
							} else {
								System.out.println("Valor incorreto.");
							}
						}
						while (true) {
							System.out.println("tipo de residencia? 1-casa ou 2-Apartamento");
							op = ler.scannerInt();
							if (op == 1 || op == 2) {
								if (op == 1) {
									d.setResidencia(true);
									break;
								} else {
									d.setResidencia(false);
									break;
								}
							} else
								System.out.println("Por Favor digite '1' ou '2'");
						}
						conexao.guardarcontratoPf(d);
					}
				}
				break;
			}
			if (op == 2) {
				conexao.conexaoLerPj(cliPj);
				System.out.println("Qual o numero do cliente: ");
				op = ler.scannerInt();
				if (op >= cliPj.size()) {
					System.out.println("\nIndice invalido !!!\n");
				} else {
					PessoaJuridica d = cliPj.get(op);
					if (d.getCliente() != null) {
						System.out.println("Cliente: " + d.getCliente());
						System.out.println("Valor do Imovel:");
						d.setValorImovel(ler.scannerDouble());
						System.out.println("Numero de funcionarios:");
						d.setNumFuncionarios(ler.scannerInt());
						System.out.println("Numero diario de visitas:");
						d.setNumVisitasDiarias(ler.scannerInt());
						while (true) {
							System.out.println("Ramo: \n1-comércio \n2-indústria \n3-agropecuária");
							op = ler.scannerInt();
							if (op == 1 || op == 2 || op == 3) {
								d.setRamo(op);
								break;
							} else {
								System.out.println("Valor incorreto.");
								break;
							}

						}
						conexao.guardarContratoPj(d);
					}
				}
				break;

			} else
				System.out.println("Valor incorreto.");
		}
	}

	/*
	 * Método responsavel por exibir todos os clientes cadastrados no banco de
	 * dados, exibe o nome e cpf(cnpj).
	 */
	public void listarClientes() {
		
			System.out.println("Tipo de pessoa: 1-física ou 2-Jurídica");
			op = ler.scannerInt();
			if (op == 1 || op == 2) {
				if (op == 1) {
					cliPf = new ArrayList<>();
					conexao.conexaoLerPf(cliPf);
					if (cliPf.size() == 0) {
						System.out.println("\nNão existem cadastros !!!\n");
					} else {
						System.out.println("\nLista de Cadastros\n");
						for (int i = 0; i < cliPf.size(); i++) {
							PessoaFisica d = cliPf.get(i);
							System.out.println("Cadastro número: " + i);
							System.out.println("\tNome: " + d.getCliente() + "\n\tcpf: " + d.getCpf());
						}
						System.out.println("Fim da lista.\n");
					}
				}
				if (op == 2) {
					cliPj = new ArrayList<>();
					conexao.conexaoLerPj(cliPj);
					if (cliPj.size() == 0) {
						System.out.println("\nNão existem cadastros!!!\n");
					} else {
						System.out.println("\nLista de Cadastros\n");
						for (int i = 0; i < cliPj.size(); i++) {
							PessoaJuridica d = cliPj.get(i);
							System.out.println("Cadastro número: " + i);
							System.out.println("\tNome: " + d.getCliente() + "\n\tCnpj: " + d.getCnpj());

						}
						System.out.println("Fim da lista.\n");
					}
				}

			} else
				System.out.println("valor inválido.\n");
		

		
	}

	/*
	 * Método responsavel por listar os cliente cadastrados que possuem
	 * contrato. exibi todos os dados cadastrados no cadastro de cliente e no
	 * cadastro de contrato.
	 */
	public void listarContratos() {

		System.out.println("Listar Contratos:");
		System.out.println("Tipo de pessoa: 1-física ou 2-Jurídica");
		op = ler.scannerInt();
		if (op == 1 || op == 2) {
			if (op == 1) {
				cliPf = new ArrayList<>();
				conexao.conexaoLerPf(cliPf);
				if (cliPf.size() == 0) {
					System.out.println("\nNão existem cadastros !!!\n");
				} else {
					System.out.println("\nLista de Cadastros\n");
					for (int i = 0; i < cliPf.size(); i++) {
						PessoaFisica d = cliPf.get(i);
						if (d.getValorImovel() != 0) {
							System.out.println("Cadastro número: " + i);
							System.out.println("\tNome: " + d.getCliente());
							System.out.println("\tEndereço: " + d.getEndereco());
							System.out.println("\tValor do imovel: " + d.getValorImovel());
							System.out.print("\tArea na qual se encontra: ");
							calculo.area(d);
							System.out.print("\ttipo de residencia: ");
							if (d.isResidencia() == true) {
								System.out.println("casa");
							} else {
								System.out.println("Apartamento");
							}
						}
					}

				}
			}
			if (op == 2) {
				cliPj = new ArrayList<>();
				conexao.conexaoLerPj(cliPj);
				if (cliPj.size() == 0) {
					System.out.println("\nNão existem cadastros !!!\n");
				} else {
					System.out.println("\nLista de Cadastros\n");
					for (int i = 0; i < cliPj.size(); i++) {
						PessoaJuridica d = cliPj.get(i);
						if (d.getValorImovel() != 0) {
							System.out.println("Cadastro número: " + i);
							System.out.println("\tNome: " + d.getCliente());
							System.out.println("\tValor do imovel: " + d.getValorImovel());
							System.out.println("\tNumero de Funcionarios: " + d.getNumFuncionarios());
							System.out.println("\tNumero de visitas diarias: " + d.getNumVisitasDiarias());
							System.out.print("\tRamo: ");
							calculo.ramo(d);
						}
					}
				}
			}
		} else {
			System.out.println("Valor invalido.");
		}
	}

	/*
	 * Método que realiza o cadastro de sinistro de cliente fisico e juridico.
	 */
	public void cadastroSinistro() {
		
			System.out.println("Cadastro de sinistro:");
			System.out.println("Tipo de pessoa: 1-física ou 2-Jurídica");
			op = ler.scannerInt();
			if (op == 1 || op == 2) {

				if (op == 1) {
					int a;
					cliPf = new ArrayList<>();
					conexao.conexaoLerPf(cliPf);
					System.out.println("Número do cliente:");
					a = ler.scannerInt();
					if (a >= cliPf.size()) {
						System.out.println("\nIndice invalido !!!\n");
					} else {
						PessoaFisica d = cliPf.get(a);
						if (d != null) {
							System.out.println("Nome:" + d.getCliente());
							System.out.println("Data:");
							d.setDataSinistro(lerS.next());
							calculo.seguroResidencial(d);
							System.out.println("Valor do Sinistro: " + d.getSeguro());
							d.setTemSinistro(true);
							conexao.guardarSinistroPf(d);
							
						} else
							System.out.println("Cliente não existente.");
					}
				}
				if (op == 2) {
					cliPj = new ArrayList<>();
					conexao.conexaoLerPj(cliPj);
					System.out.println("Número do cliente:");
					op = ler.scannerInt();
					if (op >= cliPj.size()) {
						System.out.println("\nIndice invalido !!!\n");
					} else {
						PessoaJuridica d = cliPj.get(op);
						if (d != null) {
							System.out.println("Nome:" + d.getCliente());
							System.out.println("Data:");
							d.setDataSinistro(lerS.next());
							calculo.seguroEmpresarial(d);
							System.out.println("Valor do Sinistro: " + d.getSeguro());
							d.setTemSinistro(true);
							conexao.guardarSinistroPj(d);
						} else
							System.out.println("Cliente não existente.");
					}
				}
			} else
				System.out.println("Valor inválido");

		
	}
	/*
	 * Método exibi todos os clientes que possuem contrato e sinistro.
	 */

	public void exibeSinistro() {

		System.out.println("Lista de Sinistro.");
		System.out.println("Tipo de pessoa: 1-física ou 2-Jurídica");
		op = ler.scannerInt();
		if (op == 1 || op == 2) {

			if (op == 1) {
				cliPf = new ArrayList<>();
				conexao.conexaoLerPf(cliPf);
				if (cliPf.size() == 0) {
					System.out.println("\nNão existem cadastros !!!\n");
				} else {
					for (int i = 0; i < cliPf.size(); i++) {
						PessoaFisica d = cliPf.get(i);
						if (d.isTemSinistro() == true) {
							System.out.println("Nome:" + d.getCliente());
							calculo.seguroResidencial(d);
							System.out.println("Sinistro:" + d.getSeguro());
							System.out.println("data:" + d.getDataSinistro() + "\n");
						}
					}

				}

			}
			if (op == 2) {
				cliPj = new ArrayList<>();
				conexao.conexaoLerPj(cliPj);
				if (cliPj.size() == 0) {
					System.out.println("\nNão existem cadastros !!!\n");
				} else {
					for (int i = 0; i < cliPj.size(); i++) {
						PessoaJuridica d = cliPj.get(i);
						if (d.isTemSinistro() == true) {
							System.out.println("Nome:" + d.getCliente());
							calculo.seguroEmpresarial(d);
							System.out.println("Sinistro: " + d.getSeguro());
							System.out.println("data:" + d.getDataSinistro() + "\n");
						}
					}

				}

			}
		} else
			System.out.println("Valor Inválido.");

	}
	/*
	 * Método que lista todos os clientes que possuem contrato, porém não
	 * possuem sinistro.
	 */

	public void exibirSemSinistro() {

		System.out.println("Listar Contratos sem sinistro:");
		System.out.println("Tipo de pessoa: 1-física ou 2-Jurídica");
		op = ler.scannerInt();
		if (op == 1 || op == 2) {
			if (op == 1) {
				cliPf = new ArrayList<>();
				conexao.conexaoLerPf(cliPf);
				if (cliPf.size() == 0) {
					System.out.println("\nNão existem cadastros !!!\n");
				} else {
					System.out.println("\nLista de Cadastros\n");
					for (int i = 0; i < cliPf.size(); i++) {
						PessoaFisica d = cliPf.get(i);
						if (d.isTemSinistro() == false) {
							System.out.println("Cadastro número: " + i);
							System.out.println("\tNome: " + d.getCliente());
							System.out.println("\tEndereço: " + d.getEndereco());
							System.out.println("\tValor do imovel: " + d.getValorImovel());
							System.out.println("\tArea na qual se encontra: ");
							calculo.area(d);
							
						}
					}
				}
			}

			if (op == 2) {
				cliPj = new ArrayList<>();
				conexao.conexaoLerPj(cliPj);
				if (cliPj.size() == 0) {
					System.out.println("\nNão existem cadastros !!!\n");
				} else {
					System.out.println("\nLista de Cadastros\n");
					for (int i = 0; i < cliPj.size(); i++) {
						PessoaJuridica d = cliPj.get(i);
						if (d.isTemSinistro() == false) {
							System.out.println("Cadastro número: " + i);
							System.out.println("\tNome: " + d.getCliente());
							System.out.println("\tValor do imovel: " + d.getValorImovel());
							System.out.println("\tNumero de Funcionarios: " + d.getNumFuncionarios());
							System.out.println("\tNumero de visitas diarias: " + d.getNumVisitasDiarias());
							System.out.println("\tRamo: ");
							calculo.ramo(d);
						}
					}
				}

			} 
			}else {
				System.out.println("Valor invalido.");

		}
	}
}