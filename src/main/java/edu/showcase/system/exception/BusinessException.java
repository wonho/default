package edu.showcase.system.exception;

public class BusinessException extends MessageException {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;

	/**
	 * 프로퍼티 파일의 키를 지정한다.
	 * <p>
	 * 템플릿 arg를 넣으려면 {@link #BusinessException(String, Object[])} 등의 다른 생성자를 이용하도록 한다.
	 * <p>
	 * <em>받아놓은 Exception이 있으면 반드시 {@link #BusinessException(String, Throwable)}을 이용하도록 한다.
	 * 그래야 원인 추적이 용이하게 된다. (스택트레이스 로그)</em>
	 *
	 * @param propKey
	 */
	public BusinessException(String propKey) {
		super(propKey);
	}

	/**
	 * 프로퍼티 파일의 키, arg를 지정한다.
	 * <p>
	 * <em>주)	  받아놓은 Exception이 있으면 반드시 {@link #BusinessException(String, Object[], Throwable)}을 이용하도록 한다.
	 * 그래야 원인 추적이 용이하게 된다. (스택트레이스 로그)</em>
	 *
	 * @param propKey
	 * @param args
	 */
	public BusinessException(String propKey, Object... args) {
		super(propKey, args);
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
	public BusinessException(String propKey, Throwable t) {
		super(propKey, t);
	}

	/**
	 * 프로퍼티 파일의 키, arg 배열, 내포할 예외를 지정한다.
	 * <p>
	 * 프로퍼티 파일의 템플릿 문자열 처리시 Object[] args가 순서대로 들어가는데 더하여
	 * 마지막 변수로 t.getMessage()를 추가해준다.
	 * <p>
	 * 
	 * @param propKey
	 * @param args
	 * @param t
	 */
	public BusinessException(String propKey, Object[] args, Throwable t) {
		super(propKey, args, t);
	}

	
}
