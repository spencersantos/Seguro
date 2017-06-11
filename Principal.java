public class Principal {

	public static void main(String[] args) {

		EntradaException ler = new EntradaException();
		int opc;
		Cadastros cadastro = new Cadastros();
		boolean b1=true;
		while (b1) {
			System.out.println("    Seguradora:");
			System.out.println("Escolha a opção:\n1-Cadastrar Cliente\n2-Cadastrar Contrato");
			System.out.println("3-Lista de clientes\n4-Lista de contratos\n5-Cadastro de sinistro");
			System.out.println("6-Lista de sinistro\n7-Lista de contrato sem sinistro\n8- Sair");
			System.out.println("Qual a opção? ");
			opc = ler.scannerInt();
			
			switch (opc) {
			case 1:
				cadastro.cadastroPf();
				break;
			case 2:
				cadastro.cadastroContrato();
				break;

			case 3:
				cadastro.listarClientes();
				break;

			case 4:
				cadastro.listarContratos();
				break;

			case 5:
				cadastro.cadastroSinistro();
				break;
			case 6:
				cadastro.exibeSinistro();
				break;
			case 7:
				cadastro.exibirSemSinistro();
				break;
			case 8:
				b1=false;
				break;
			}
		}
	}
}