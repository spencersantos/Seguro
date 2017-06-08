
public class Calculo {
	
	public void seguroResidencial(PessoaFisica pessoa){
		
		pessoa.setSeguro(pessoa.getValorImovel()*0.02);
		if(pessoa.getAreaImovel()==1){
			pessoa.setSeguro(pessoa.getSeguro()+(pessoa.getValorImovel()*0.01));
		}if(pessoa.getAreaImovel()==2){
			pessoa.setSeguro(pessoa.getSeguro()+(pessoa.getValorImovel()*0.005));
		}if(pessoa.isResidencia()==true){
			pessoa.setSeguro(pessoa.getSeguro()+(pessoa.getValorImovel()*0.005));
		}
		
	}
	//Metodo para calcular o seguro Empresarial
	public void seguroEmpresarial(PessoaJuridica pessoa){
		
		pessoa.setSeguro(pessoa.getValorImovel()*0.04);
		//acrescenta 0.2% a cada 10 funcionarios
		pessoa.setSeguro(pessoa.getSeguro()+((pessoa.getNumFuncionarios()/10)*(pessoa.getValorImovel()*0.002)));
		//acrescenta 0.3% a cada 200funcionarios
		pessoa.setSeguro(pessoa.getSeguro()+((pessoa.getNumVisitasDiarias()/200)*(pessoa.getValorImovel()*0.003)));
		//acrescenta 1% se industria
		if(pessoa.getRamo()==2){
			pessoa.setSeguro(pessoa.getSeguro()+(pessoa.getValorImovel()*0.01));
		}
		//acrescenta 0.5% secomercio
		if(pessoa.getRamo()==1){
			pessoa.setSeguro(pessoa.getSeguro()+(pessoa.getValorImovel()*0.005));
		}
	}

	public void ramo(PessoaJuridica pessoa){
		if(pessoa.getRamo()==1)
			System.out.println("Comercio");
		if(pessoa.getRamo()==2)
			System.out.println("Industria");
		if(pessoa.getRamo()==3)
			System.out.println("Agropecuaria");
	}
	public void area(PessoaFisica pessoa){
		if(pessoa.getAreaImovel()==1)
			System.out.println("Urbana");
		if(pessoa.getAreaImovel()==2)
			System.out.println("SubUrbana");
		if(pessoa.getAreaImovel()==3)
			System.out.println("Rural");
	}


}
