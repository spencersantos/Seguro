
public class PessoaJuridica extends Cliente {
	
	private int NumFuncionarios;
	private int NumVisitasDiarias;
	//Ramo 1-Comercio,2-Industria,3-Agropecuaria	
	private int ramo;
	
	
	public int getNumFuncionarios() {
		return NumFuncionarios;
	}
	public void setNumFuncionarios(int numFuncionarios) {
		NumFuncionarios = numFuncionarios;
	}
	public int getNumVisitasDiarias() {
		return NumVisitasDiarias;
	}
	public void setNumVisitasDiarias(int numVisitasDiarias) {
		NumVisitasDiarias = numVisitasDiarias;
	}
	public int getRamo() {
		return ramo;
	}
	public void setRamo(int ramo) {
		this.ramo = ramo;
	}

}
