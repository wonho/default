package edu.showcase.system.dao;

import java.util.List;
import java.util.Map;

public interface CommonDao {

	/**
	 * <pre>
	 * �ܰ� ��ȸ(int) ������ �����Ѵ�.
	 * </pre>
	 *
	 * @param statementId MyBatis namespace + statementId
	 * @param parameter �Է� parameter
	 * @return ��ȸ�� ������
	 */
	Integer queryForInt(String statementId, Object parameter);

	/**
	 * <pre>
	 * �ܰ� ��ȸ(long) ������ �����Ѵ�.
	 * </pre>
	 *
	 * @param statementId MyBatis namespace + statementId
	 * @param parameter �Է� parameter
	 * @return ��ȸ�� ������
	 */
	Long queryForLong(String statementId, Object parameter);

	/**
	 * <pre>
	 * �ܰ� ��ȸ ������ �����Ѵ�.
	 * </pre>
	 *
	 * @param <T> generic type class
	 * @param statementId MyBatis namespace + statementId
	 * @param parameter �Է� parameter
	 * @param clazz generic type class
	 * @return ��ȸ�� ������ (�ܰ�) or null
	 */
	<T> T queryForObject(String statementId, Object parameter, Class<T> clazz);

	/**
	 * <pre>
	 * �ܰ� ��ȸ ������ �����Ѵ�.
	 * </pre>
	 *
	 * @param statementId MyBatis namespace + statementId
	 * @param parameter �Է� parameter
	 * @return ��ȸ�� ������ (�ܰ�) or null
	 */
	Object queryForObject(String statementId, Object parameter);

	/**
	 * <pre>
	 * �ܰ� ��ȸ ������ �����Ѵ�.
	 * </pre>
	 *
	 * @param statementId MyBatis namespace + statementId
	 * @param mapKey resultMap key
	 * @param parameter �Է� parameter
	 * @return ��ȸ�� ������ (�ܰ�) or null
	 */
	Map<?, ?> queryForMap(String statementId, String mapKey, Object parameter);

	/**
	 * <pre>
	 * �ٰ� ��ȸ ������ �����Ѵ�.
	 * </pre>
	 *
	 * @param <T> generic type class
	 * @param statementId MyBatis namespace + statementId
	 * @param parameter �Է� parameter
	 * @param clazz generic type class
	 * @return ��ȸ�� ������ (0�� �̻�)
	 */
	<T> List<T> queryForList(String statementId, Object parameter, Class<T> clazz);

	/**
	 * <pre>
	 * �ٰ� ��ȸ ������ �����Ѵ�.
	 * </pre>
	 *
	 * @param statementId MyBatis namespace + statementId
	 * @param parameter �Է� parameter
	 * @return ��ȸ�� ������ (0�� �̻�)
	 */
	List<?> queryForList(String statementId, Object parameter);

	/**
	 * <pre>
	 * �ٰ� ��ȸ ������ �����Ѵ�.
	 * </pre>
	 *
	 * @param statementId MyBatis namespace + statementId
	 * @param parameter �Է� parameter
	 * @param rowHandler ResultSet�� �����ϱ� ���� row mapper
	 */
	<T> List<T> queryForList(String statementId, Object parameter, int skipRows, int maxRows, Class<T> clazz);

	/**
	 *
	 * <pre>
	 *  �ٰ���ȸ ������ �����ϸ�, ��ȸ�� �� �����Ϳ� ���� �߰� ���� ����� �����Ѵ�.
	 * </pre>
	 *
	 * @param statementId MyBatis namespace + statementId
	 * @param parameter �Է� parameter
	 * @param streamHandler ��ȸ�� �࿡ ���� �߰�����
	 */
//	<T> void queryWithResultHandler(String statementId, Object parameter, StreamHandler<T> streamHandler);

	/**
	 * <pre>
	 * ���� ������ �����Ѵ�.
	 * </pre>
	 *
	 * @param statementId MyBatis namespace + statementId
	 * @param parameter �Է� parameter
	 * @return null or inline query result
	 */
	Integer update(String statementId, Object parameter);

	/**
	 *
	 * <pre>
	 * ���� ���� �� ���� ��/�� �����Ϳ� ���� �α� �۾��� �����Ѵ�.
	 * </pre>
	 *
	 * @param selectStatementId
	 * @param updateStatementId
	 * @param parameter
	 * @return
	 */
	Integer updateWithLogging(String selectStatementId, String updateStatementId, Object parameter);

	/**
	 * <pre>
	 * �Է� ������ �����Ѵ�.
	 * </pre>
	 *
	 * @param statementId MyBatis namespace + statementId
	 * @param parameter �Է� parameter
	 * @return affected row count
	 */
	Object insert(String statementId, Object parameter);

	/**
	 * <pre>
	 * ���� ������ �����Ѵ�.
	 * </pre>
	 *
	 * @param statementId MyBatis namespace + statementId
	 * @param parameter �Է� parameter
	 * @return affected row count
	 */
	Integer delete(String statementId, Object parameter);

	/**
	 *
	 * <pre>
	 * ���� ���� �� ���� ��/�� �����Ϳ� ���� �α� �۾��� �����Ѵ�.
	 * </pre>
	 *
	 * @param selectStatementId
	 * @param deleteStatementId
	 * @param parameter
	 * @return
	 */
	Integer deleteWithLogging(String selectStatementId, String deleteStatementId, Object parameter);

}

