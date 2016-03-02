package edu.showcase.system.dao;

import java.util.List;
import java.util.Map;

public interface CommonDao {

	/**
	 * <pre>
	 * 단건 조회(int) 연산을 수행한다.
	 * </pre>
	 *
	 * @param statementId MyBatis namespace + statementId
	 * @param parameter 입력 parameter
	 * @return 조회된 데이터
	 */
	Integer queryForInt(String statementId, Object parameter);

	/**
	 * <pre>
	 * 단건 조회(long) 연산을 수행한다.
	 * </pre>
	 *
	 * @param statementId MyBatis namespace + statementId
	 * @param parameter 입력 parameter
	 * @return 조회된 데이터
	 */
	Long queryForLong(String statementId, Object parameter);

	/**
	 * <pre>
	 * 단건 조회 연산을 수행한다.
	 * </pre>
	 *
	 * @param <T> generic type class
	 * @param statementId MyBatis namespace + statementId
	 * @param parameter 입력 parameter
	 * @param clazz generic type class
	 * @return 조회된 데이터 (단건) or null
	 */
	<T> T queryForObject(String statementId, Object parameter, Class<T> clazz);

	/**
	 * <pre>
	 * 단건 조회 연산을 수행한다.
	 * </pre>
	 *
	 * @param statementId MyBatis namespace + statementId
	 * @param parameter 입력 parameter
	 * @return 조회된 데이터 (단건) or null
	 */
	Object queryForObject(String statementId, Object parameter);

	/**
	 * <pre>
	 * 단건 조회 연산을 수행한다.
	 * </pre>
	 *
	 * @param statementId MyBatis namespace + statementId
	 * @param mapKey resultMap key
	 * @param parameter 입력 parameter
	 * @return 조회된 데이터 (단건) or null
	 */
	Map<?, ?> queryForMap(String statementId, String mapKey, Object parameter);

	/**
	 * <pre>
	 * 다건 조회 연산을 수행한다.
	 * </pre>
	 *
	 * @param <T> generic type class
	 * @param statementId MyBatis namespace + statementId
	 * @param parameter 입력 parameter
	 * @param clazz generic type class
	 * @return 조회된 데이터 (0건 이상)
	 */
	<T> List<T> queryForList(String statementId, Object parameter, Class<T> clazz);

	/**
	 * <pre>
	 * 다건 조회 연산을 수행한다.
	 * </pre>
	 *
	 * @param statementId MyBatis namespace + statementId
	 * @param parameter 입력 parameter
	 * @return 조회된 데이터 (0건 이상)
	 */
	List<?> queryForList(String statementId, Object parameter);

	/**
	 * <pre>
	 * 다건 조회 연산을 수행한다.
	 * </pre>
	 *
	 * @param statementId MyBatis namespace + statementId
	 * @param parameter 입력 parameter
	 * @param rowHandler ResultSet을 가공하기 위한 row mapper
	 */
	<T> List<T> queryForList(String statementId, Object parameter, int skipRows, int maxRows, Class<T> clazz);

	/**
	 *
	 * <pre>
	 *  다건조회 연산을 수행하며, 조회된 각 데이터에 대한 추가 연산 기능을 제공한다.
	 * </pre>
	 *
	 * @param statementId MyBatis namespace + statementId
	 * @param parameter 입력 parameter
	 * @param streamHandler 조회된 행에 대한 추가연산
	 */
//	<T> void queryWithResultHandler(String statementId, Object parameter, StreamHandler<T> streamHandler);

	/**
	 * <pre>
	 * 수정 연산을 수행한다.
	 * </pre>
	 *
	 * @param statementId MyBatis namespace + statementId
	 * @param parameter 입력 parameter
	 * @return null or inline query result
	 */
	Integer update(String statementId, Object parameter);

	/**
	 *
	 * <pre>
	 * 수정 연산 및 변경 전/후 데이터에 대한 로깅 작업을 수행한다.
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
	 * 입력 연산을 수행한다.
	 * </pre>
	 *
	 * @param statementId MyBatis namespace + statementId
	 * @param parameter 입력 parameter
	 * @return affected row count
	 */
	Object insert(String statementId, Object parameter);

	/**
	 * <pre>
	 * 삭제 연산을 수행한다.
	 * </pre>
	 *
	 * @param statementId MyBatis namespace + statementId
	 * @param parameter 입력 parameter
	 * @return affected row count
	 */
	Integer delete(String statementId, Object parameter);

	/**
	 *
	 * <pre>
	 * 삭제 연산 및 변경 전/후 데이터에 대한 로깅 작업을 수행한다.
	 * </pre>
	 *
	 * @param selectStatementId
	 * @param deleteStatementId
	 * @param parameter
	 * @return
	 */
	Integer deleteWithLogging(String selectStatementId, String deleteStatementId, Object parameter);

}

