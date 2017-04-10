
public class Cliente {

	private String Cliente;
	private double ValorImovel;
	private double seguro;
	private String dataSinistro;
	private boolean TemSinistro;
	
	
	public boolean isTemSinistro() {
		return TemSinistro;
	}
	public void setTemSinistro(boolean temSinistro) {
		TemSinistro = temSinistro;
	}
	public String getDataSinistro() {
		return dataSinistro;
	}
	public void setDataSinistro(String dataSinistro) {
		this.dataSinistro = dataSinistro;
	}
	public double getSeguro() {
		return seguro;
	}
	public void setSeguro(double seguro) {
		this.seguro = seguro;
	}
	public String getCliente() {
		return Cliente;
	}
	public void setCliente(String cliente) {
		Cliente = cliente;
	}
	public double getValorImovel() {
		return ValorImovel;
	}
	public void setValorImovel(double valorImovel) {
		ValorImovel = valorImovel;
	}
	
	
	
}
