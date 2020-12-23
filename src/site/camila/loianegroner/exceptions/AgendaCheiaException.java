package site.camila.loianegroner.exceptions;

public class AgendaCheiaException extends Exception {
	
	@Override
	public String getMessage() {
		return "A agenda está cheia!";
	}
	
}