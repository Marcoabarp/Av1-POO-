import java.util.ArrayList;
public class Candidatura {
	private ArrayList<Candidato> candidatos;

	public Candidatura() {
		this.candidatos = new ArrayList<>();
	}

	public boolean cC(Candidato c) {
		for (Candidato candidato : candidatos) {
			if (candidato.getNumero() == c.getNumero() && candidato.getMunicipio().equals(c.getMunicipio())) {
				return false;
			}
		}
		candidatos.add(c);
		return true;
	}

	public Candidato cC(int numero, String municipio) {
		for (Candidato candidato : candidatos) {
			if (candidato.getNumero() == numero && candidato.getMunicipio().equals(municipio)) {
				return candidato;
			}
		}
		return null;
	}

	public ArrayList<Candidato> getCandidatos() {
		return candidatos;
	}

	public Candidato PMV() {
		Candidato pmv = new Candidato(0, "", "");
		for (Candidato candidato : candidatos) {
			if (candidato.getNumero() < 100) {
				if (candidato.getVotos() > pmv.getVotos()) {
					pmv = candidato;
				}
			}
		}
		return pmv;
	}

	public Candidato VMV() {
			Candidato vmv = new Candidato(0, "", "");
			for (Candidato candidato : candidatos) {
				if (candidato.getNumero() > 100){
					if(candidato.getVotos() > vmv.getVotos()){
						vmv = candidato;
					}
				}
			}
		return vmv;
	}
}