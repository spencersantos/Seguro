
public class PessoaFisica extends Cliente {
	
	private String endereco;
	//Residencia true=Casa, false=Apartamento	
	private boolean Residencia;
	//Areas 1-Urbana,2-SubUrbana,3-Rural
	private int areaImovel;
	private long cpf;
	
	
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public boolean isResidencia() {
		return Residencia;
	}
	public void setResidencia(boolean residencia) {
		Residencia = residencia;
	}
	public int getAreaImovel() {
		return areaImovel;
	}
	public void setAreaImovel(int areaImovel) {
		this.areaImovel = areaImovel;
	}
	public long getCpf() {
		return cpf;
	}
	public void setCpf(long cpf) {
		this.cpf = cpf;
	}

}
