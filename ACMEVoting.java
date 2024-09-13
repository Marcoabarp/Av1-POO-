import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.Scanner;
public class ACMEVoting {
	private Candidatura candidatura = new Candidatura();
	private CadastroPartido cadastroPartido = new CadastroPartido();
	private Scanner entrada = new Scanner(System.in);  //
	private PrintStream saidaPadrao = System.out;   //
	private final String nomeArquivoEntrada = "input.txt";  //
	private final String nomeArquivoSaida = "output.txt";
	public ACMEVoting() {
		redirecionaEntrada();
		redirecionaSaida();
	}

	public void executar() {
		cP();
		cC();
		cV();
		mDP();
		mDC();
		mVP();
		mPCMC();
		mMV();
	}

	private void cV() {
		while (true) {
			int numero = Integer.parseInt(entrada.nextLine());
			if (numero == -1) break;
			else{
				String municipio = entrada.nextLine();
				int votos = Integer.parseInt(entrada.nextLine());

				if (candidatura.cC(numero, municipio) !=null ){
					candidatura.cC(numero, municipio).setVotos(votos);
					System.out.println("3:" + numero + "," + municipio + "," + votos);
				}
			}

		}
	}
	private void cP() {
		while (true) {
			int numero = entrada.nextInt();
			entrada.nextLine();
			if (numero == -1) break;
			String nome = entrada.nextLine();
			Partido partido = new Partido(numero, nome);

			if (cadastroPartido.cP(partido)) {
				System.out.println("1:" + numero + "," + nome);
			}
		}
	}
	private void mDP() {
		try {
			int numero = entrada.nextInt();
			entrada.nextLine();
			Partido partido = cadastroPartido.cP(numero);
			if (partido != null) {
				System.out.println("4:" + partido.getNumero() + "," + partido.getNome());
			} else {
				System.out.println("4:Nenhum partido encontrado.");
			}
		} catch (Exception e) {
			System.out.println("Erro ao mostrar dados do partido: " + e.getMessage());
		}
	}
	private void cC() {
		while (true) {
			int numero = Integer.parseInt(entrada.nextLine());
			if (numero == -1){ break;}
			else{
				String nome = entrada.nextLine();
				String municipio = entrada.nextLine();
				Candidato candidato = new Candidato(numero, nome, municipio);

				if(cadastroPartido.cPPC(numero) !=null ) {
					if (candidatura.cC(candidato)) {
						cadastroPartido.cPPC(numero).aC(candidato);
						System.out.println("2:" + numero + "," + nome + "," + municipio);
					}

				}
			}
		}
	}
	private void mVP() {
		try {
			String nomePartido = entrada.nextLine();
			Partido partido = cadastroPartido.cP(nomePartido);
			if (partido != null) {
				for (Candidato candidato : partido.getCandidatos()) {
					if (candidato.getNumero() < 100) {
						System.out.println("6:" + partido.getNome() + "," + candidato.getNumero() + "," + candidato.getNome() + "," + candidato.getMunicipio() + "," + candidato.getVotos());
					}
				}
			} else {
				System.out.println("6:Nenhum partido encontrado.");
			}
		} catch (Exception e) {
			System.out.println("Erro ao mostrar votos de prefeitos: " + e.getMessage());
		}
	}
	private void mDC() {
		try {
			int numero = entrada.nextInt();
			entrada.nextLine();
			String municipio = entrada.nextLine();
			Candidato candidato = candidatura.cC(numero, municipio);
			if (candidato != null) {
				System.out.println("5:" + candidato.getNumero() + "," + candidato.getNome() + "," + candidato.getMunicipio() + "," + candidato.getVotos());
			} else {
				System.out.println("5:Nenhum candidato encontrado.");
			}
		} catch (Exception e) {
			System.out.println("Erro ao mostrar dados do candidato: " + e.getMessage());
		}
	}
	private void mPCMC() {
		try {
			Partido partido = cadastroPartido.PCMCs();
			if (partido != null) {
				System.out.println("7:" + partido.getNumero() + "," + partido.getNome() + "," + partido.getNumeroCandidatos());
			} else {
				System.out.println("7:Nenhum partido com candidatos.");
			}
		} catch (Exception e) {
			System.out.println("Erro ao mostrar partido com mais candidatos: " + e.getMessage());
		}
	}

	private void mMV() {
		try {
			if (!candidatura.getCandidatos().isEmpty()) {
				Candidato pmv = candidatura.PMV();
				Candidato vmv = candidatura.VMV();

				if (pmv.getVotos() != 0) {
					System.out.println("8:" + pmv.getNumero() + "," + pmv.getNome() + "," + pmv.getMunicipio() + "," + pmv.getVotos());
				}
				if (vmv.getVotos() != 0) {
					System.out.println("8:" + vmv.getNumero() + "," + vmv.getNome() + "," + vmv.getMunicipio() + "," + vmv.getVotos());
				}
			} else {
				System.out.println("8:Nenhum candidato encontrado.");
			}
		} catch (Exception e) {
			System.out.println("Erro ao mostrar partido com mais candidatos: " + e.getMessage());
		}

}


	private void redirecionaEntrada() {
		try {
			BufferedReader streamEntrada = new BufferedReader(new FileReader(nomeArquivoEntrada));
			entrada = new Scanner(streamEntrada);   // Usa como entrada um arquivo
		} catch (Exception e) {
			System.out.println(e);
		}
		Locale.setDefault(Locale.ENGLISH);
		entrada.useLocale(Locale.ENGLISH);
	}


	private void redirecionaSaida() {
		try {
			PrintStream streamSaida = new PrintStream(new File(nomeArquivoSaida), Charset.forName("UTF-8"));
			System.setOut(streamSaida);
		} catch (Exception e) {
			System.out.println(e);
		}
		Locale.setDefault(Locale.ENGLISH);
	}

	// Restaura Entrada padrao para o teclado
	// Chame este metodo para retornar a leitura de dados para o teclado
	private void restauraEntrada() {
		entrada = new Scanner(System.in);
	}

	// Restaura Saida padrao para a tela (terminal)
	// Chame este metodo para retornar a escrita de dados para a tela
	private void restauraSaida() {
		System.setOut(saidaPadrao);
	}

}