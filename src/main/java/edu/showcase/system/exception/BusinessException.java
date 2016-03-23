package edu.showcase.system.exception;

public class BusinessException extends MessageException {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;

	/**
	 * ������Ƽ ������ Ű�� �����Ѵ�.
	 * <p>
	 * ���ø� arg�� �������� {@link #BusinessException(String, Object[])} ���� �ٸ� �����ڸ� �̿��ϵ��� �Ѵ�.
	 * <p>
	 * <em>�޾Ƴ��� Exception�� ������ �ݵ�� {@link #BusinessException(String, Throwable)}�� �̿��ϵ��� �Ѵ�.
	 * �׷��� ���� ������ �����ϰ� �ȴ�. (����Ʈ���̽� �α�)</em>
	 *
	 * @param propKey
	 */
	public BusinessException(String propKey) {
		super(propKey);
	}

	/**
	 * ������Ƽ ������ Ű, arg�� �����Ѵ�.
	 * <p>
	 * <em>��)	  �޾Ƴ��� Exception�� ������ �ݵ�� {@link #BusinessException(String, Object[], Throwable)}�� �̿��ϵ��� �Ѵ�.
	 * �׷��� ���� ������ �����ϰ� �ȴ�. (����Ʈ���̽� �α�)</em>
	 *
	 * @param propKey
	 * @param args
	 */
	public BusinessException(String propKey, Object... args) {
		super(propKey, args);
	}

	/**
	 * ������Ƽ ������ Ű�� ������ ���ܸ� �����Ѵ�.
	 * <p>
	 * ������Ƽ ������ ���ø� ���ڿ� ó���� ù��°(�׸��� �� �ϳ���) arg�� t.getMessage()�� �ȴ�.
	 * <p>
	 * ���ø� arg�� �߰��� �������� {@link #BusinessException(String, Object[], Throwable)} ���� �ٸ� �����ڸ� �̿��ϵ��� �Ѵ�.
	 *
	 * @param propKey
	 * @param t
	 */
	public BusinessException(String propKey, Throwable t) {
		super(propKey, t);
	}

	/**
	 * ������Ƽ ������ Ű, arg �迭, ������ ���ܸ� �����Ѵ�.
	 * <p>
	 * ������Ƽ ������ ���ø� ���ڿ� ó���� Object[] args�� ������� ���µ� ���Ͽ�
	 * ������ ������ t.getMessage()�� �߰����ش�.
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
