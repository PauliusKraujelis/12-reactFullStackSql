package lt.ReactFullStackSqlexceptions;

public class ClientNotFoundException extends IllegalArgumentException{


	/**
	 * 
	 * 
	 */
	private static final long serialVersionUID = 7340871370480424085L;

	public ClientNotFoundException(String msg) {
		super(msg);
	}
}
