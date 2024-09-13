public class Candidato {
	private int numero;
	private String nome;
	private String municipio;
	private int votos;

	public Candidato(int numero, String nome, String municipio) {
		this.numero = numero;
		this.nome = nome;
		this.municipio = municipio;
		this.votos = 0;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public int getVotos() {
		return votos;
	}

	public void setVotos(int votos) {
		this.votos = votos;
	}

	public void adicionarVotos(int votos) {
		this.votos += votos;
	}

	@Override
	public String toString() {
		return numero + "," + nome + "," + municipio + "," + votos;
	}
}
