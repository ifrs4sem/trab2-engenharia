package questao2;

public abstract class TimeObserver {
	protected int tempoAtual;
	protected Subject subject;
	public abstract void atualizaTempo(int tempo);
}
