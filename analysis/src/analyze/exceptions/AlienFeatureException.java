package analyze.exceptions;

public class AlienFeatureException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String tokenName;
	
	public AlienFeatureException(String details, String tokenName){
		super(details);
		this.tokenName = tokenName;
	}
	
	public String getTokenName(){
		return tokenName;
	}

}
