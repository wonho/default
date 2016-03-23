package edu.showcase.system.exception;

public class MessageException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	private Object[] args = null;

	public Object[] getArgs() {
		return args;
	}
	
	/**
	 * 프로퍼티 파일의 키를 지정한다.
	 * <p>
	 * 템플릿 arg를 넣으려면 {@link #BusinessException(String, Object[])} 등의 다른 생성자를 이용하도록 한다.
	 * 
	 * @param propKey
	 */
	public MessageException(String propKey) {
		super(propKey);
	}

	/**
	 * 프로퍼티 파일의 키, arg를 지정한다.
	 * <p>
	 * 
	 * @param propKey
	 * @param args
	 */
	public MessageException(String propKey, Object[] args) {
		super(propKey);
		this.args = args;
	}
	
	/**
	 * 프로퍼티 파일의 키와 내포할 예외를 지정한다.
	 * <p>
	 * 프로퍼티 파일의 템플릿 문자열 처리시 첫번째(그리고 단 하나의) arg는 t.getMessage()가 된다.
	 * <p>
	 * 템플릿 arg를 추가로 넣으려면 {@link #BusinessException(String, Object[], Throwable)} 등의 다른 생성자를 이용하도록 한다.
	 * 
	 * @param propKey
	 * @param t
	 */
	public MessageException(String propKey, Throwable t) {
		super(propKey, t);
		this.args = new Object[]{t.getMessage()};
	}
	
	/**
	 * 프로퍼티 파일의 키, arg 배열, 내포할 예외를 지정한다.
	 * <p>
	 * 프로퍼티 파일의 템플릿 문자열 처리시 Object[] args가 순서대로 들어가는데 더하여 
	 * 마지막 arg로 t.getMessage()를 추가해준다.
	 * @param propKey
	 * @param args
	 * @param t
	 */
	public MessageException(String propKey, Object[] args, Throwable t) {
		super(propKey, t);
		
		this.args = new Object[args.length + 1];
		System.arraycopy(args, 0, this.args, 0, args.length);
		this.args[args.length] = t.getMessage();
	}
}
