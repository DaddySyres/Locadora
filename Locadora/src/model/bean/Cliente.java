package model.bean;

public class Cliente {
	
	private int cId;
	private String cNome;
	private String cCPF;
	private String cEmail;
	private String cTelefone;
	private String cEndereco;
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public String getcNome() {
		return cNome;
	}
	public void setcNome(String cNome) {
		this.cNome = cNome;
	}
	public String getcCPF() {
		return cCPF;
	}
	public void setcCPF(String cCPF) {
		this.cCPF = cCPF;
	}
	public String getcEmail() {
		return cEmail;
	}
	public void setcEmail(String cEmail) {
		this.cEmail = cEmail;
	}
	public String getcTelefone() {
		return cTelefone;
	}
	public void setcTelefone(String cTelefone) {
		this.cTelefone = cTelefone;
	}
	public String getcEndereco() {
		return cEndereco;
	}
	public void setcEndereco(String cEndereco) {
		this.cEndereco = cEndereco;
	}
	
	
}