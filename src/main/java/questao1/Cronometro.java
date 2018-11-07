package questao1;

import questao2.Subject;
import questao2.TimeObserver;

public class Cronometro{
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
