package questao1;

import questao2.Subject;

public class Cronometro extends Subject{
	private int tempoAtual = 0, tempoLimite; 
	private static Cronometro instancia;
	
	public Cronometro() {
		super();
		this.tempoLimite = 60;
	}

	
	public void contaTempo(){
		tempoAtual++; 
	}
	
	public int getTempoLimite() {
		return tempoLimite;
	}


	public static Cronometro getCronometro() {
		if(instancia == null) {
			instancia = new Cronometro();
		}
		return instancia;
	}
	
}
