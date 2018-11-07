package questao2;

public abstract class Subject {
	public abstract void addObservador(TimeObserver obs) ;
	public abstract void removeObservador(TimeObserver obs) ;
	public abstract void notificar() ;
}
