package questao2;

public class TimeObserverImpl extends TimeObserver{
	
	public void atualizaTempo(int tempo) {
		this.tempoAtual = tempo;
		
	}
	public TimeObserverImpl(Subject subject) {
		this.subject = subject;
	}

	
}
