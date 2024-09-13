import java.util.ArrayList;
public class CadastroPartido {
	private ArrayList<Partido> partidos;

	public CadastroPartido() {
		this.partidos = new ArrayList<>();
	}

	public boolean cP(Partido p) {
		for (Partido partido : partidos) {
			if (partido.getNumero() == p.getNumero()) {
				return false;
			}
		}
		partidos.add(p);
		return true;
	}

	public Partido cP(String nome) {
		for (Partido partido : partidos) {
			if (partido.getNome().equals(nome)) {
				return partido;
			}
		}
		return null;
	}

	public Partido cPPC (int numero){
		String num1 = Integer.toString(numero).substring(0,2);
		for (Partido partido : partidos) {
			if (Integer.toString(partido.getNumero()).equals(num1)) {
				return partido;
			}
		}
        return null;
    }

	public Partido PCMCs() {
		Partido partidoComMaisCandidatos = null;
		int maxCandidatos = 0;

		for (Partido partido : partidos) {
			int numeroCandidatos = partido.getNumeroCandidatos();
			if (numeroCandidatos > maxCandidatos) {
				maxCandidatos = numeroCandidatos;
				partidoComMaisCandidatos = partido;
			}
		}
		return partidoComMaisCandidatos;
	}

	public Partido cP(int numero) {
		for (Partido partido : partidos) {
			if (partido.getNumero() == numero) {
				return partido;
			}
		}
		return null;
	}

	public ArrayList<Partido> getPartidos() {
		return partidos;
	}

	public Partido getPartidoComMaisCandidatos() {
        return null;
    }
}