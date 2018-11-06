package questao2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Cronometro extends Subject{
	private int tempoAtual = 0, tempoLimite; 
	private static Cronometro instancia;
	private ArrayList observadores = new ArrayList<TimeObserver>();
	
	public Cronometro() {
		super();
		this.tempoLimite = 60;
	}

	
	public void contaTempo(){
		tempoAtual++; 
	}
	public int getTempo(){
		return tempoAtual; 
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
	public void addObservador(TimeObserver obs) {
		observadores.add(obs);
	}
	public void removeObservador(TimeObserver obs) {
		observadores.remove(obs);
	}
	
	public void notificar() {
		//observadores.notifyAll();
		for(int i = 0; i < observadores.size(); i++) {
            TimeObserver obs = (TimeObserver) observadores.get(i);
            obs.atualizaTempo(this.tempoAtual);
        }
		
	}
}
