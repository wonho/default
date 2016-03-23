package edu.showcase.system.exception;

public class MessageException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	private Object[] args = null;

	public Object[] getArgs() {
		return args;
	}
	
	/**
	 * ������Ƽ ������ Ű�� �����Ѵ�.
	 * <p>
	 * ���ø� arg�� �������� {@link #BusinessException(String, Object[])} ���� �ٸ� �����ڸ� �̿��ϵ��� �Ѵ�.
	 * 
	 * @param propKey
	 */
	public MessageException(String propKey) {
		super(propKey);
	}

	/**
	 * ������Ƽ ������ Ű, arg�� �����Ѵ�.
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
	 * ������Ƽ ������ Ű�� ������ ���ܸ� �����Ѵ�.
	 * <p>
	 * ������Ƽ ������ ���ø� ���ڿ� ó���� ù��°(�׸��� �� �ϳ���) arg�� t.getMessage()�� �ȴ�.
	 * <p>
	 * ���ø� arg�� �߰��� �������� {@link #BusinessException(String, Object[], Throwable)} ���� �ٸ� �����ڸ� �̿��ϵ��� �Ѵ�.
	 * 
	 * @param propKey
	 * @param t
	 */
	public MessageException(String propKey, Throwable t) {
		super(propKey, t);
		this.args = new Object[]{t.getMessage()};
	}
	
	/**
	 * ������Ƽ ������ Ű, arg �迭, ������ ���ܸ� �����Ѵ�.
	 * <p>
	 * ������Ƽ ������ ���ø� ���ڿ� ó���� Object[] args�� ������� ���µ� ���Ͽ� 
	 * ������ arg�� t.getMessage()�� �߰����ش�.
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
