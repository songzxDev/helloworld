/**
* @Title: WorkflowManagementBizI.java
* @Package cn.songzx.helloworld.workflow.biz
* @Description: TODO(用一句话描述该文件做什么)
* @author Songzx songzx_2326@163.com
* @date 2017年10月19日 上午9:39:49
* @version V1.0
*/
package cn.songzx.helloworld.workflow.biz;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import org.activiti.engine.event.EventLogEntry;
import org.activiti.engine.impl.cmd.CustomSqlExecution;
import org.activiti.engine.impl.interceptor.Command;
import org.activiti.engine.impl.interceptor.CommandConfig;
import org.activiti.engine.management.TableMetaData;
import org.activiti.engine.management.TablePage;
import org.activiti.engine.management.TablePageQuery;
import org.activiti.engine.runtime.JobQuery;

/**
 * @ClassName: WorkflowManagementBizI
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Songzx songzx_2326@163.com
 * @date 2017年10月19日 上午9:39:49
 *
 */
public interface WorkflowManagementBizI {
	/**
	 * Get the mapping containing {table name, row count} entries of the
	 * Activiti database schema.
	 */
	Map<String, Long> getTableCount();

	/**
	 * Gets the table name (including any configured prefix) for an Activiti
	 * entity like Task, Execution or the like.
	 */
	String getTableName(Class<?> activitiEntityClass);

	/**
	 * Gets the metadata (column names, column types, etc.) of a certain table.
	 * Returns null when no table exists with the given name.
	 */
	TableMetaData getTableMetaData(String tableName);

	/**
	 * Creates a {@link TablePageQuery} that can be used to fetch
	 * {@link TablePage} containing specific sections of table row data.
	 */
	TablePageQuery createTablePageQuery();

	/**
	 * Returns a new JobQuery implementation, that can be used to dynamically
	 * query the jobs.
	 */
	JobQuery createJobQuery();

	/**
	 * Forced synchronous execution of a job (eg. for administation or testing)
	 * The job will be executed, even if the process definition and/or the
	 * process instance is in suspended state.
	 *
	 * @param jobId
	 *            id of the job to execute, cannot be null.
	 * @throws ActivitiObjectNotFoundException
	 *             when there is no job with the given id.
	 */
	void executeJob(String jobId);

	/**
	 * Delete the job with the provided id.
	 *
	 * @param jobId
	 *            id of the job to execute, cannot be null.
	 * @throws ActivitiObjectNotFoundException
	 *             when there is no job with the given id.
	 */
	void deleteJob(String jobId);

	/**
	 * Sets the number of retries that a job has left.
	 *
	 * Whenever the JobExecutor fails to execute a job, this value is
	 * decremented. When it hits zero, the job is supposed to be dead and not
	 * retried again. In that case, this method can be used to increase the
	 * number of retries.
	 *
	 * @param jobId
	 *            id of the job to modify, cannot be null.
	 * @param retries
	 *            number of retries.
	 */
	void setJobRetries(String jobId, int retries);

	/**
	 * Returns the full stacktrace of the exception that occurs when the job
	 * with the given id was last executed. Returns null when the job has no
	 * exception stacktrace.
	 *
	 * @param jobId
	 *            id of the job, cannot be null.
	 * @throws ActivitiObjectNotFoundException
	 *             when no job exists with the given id.
	 */
	String getJobExceptionStacktrace(String jobId);

	/** get the list of properties. */
	Map<String, String> getProperties();

	/**
	 * programmatic schema update on a given connection returning feedback about
	 * what happened
	 */
	String databaseSchemaUpgrade(Connection connection, String catalog, String schema);

	/**
	 * Executes a given command with the default {@link CommandConfig}.
	 *
	 * @param command
	 *            the command, cannot be null.
	 * @return the result of command execution
	 */
	<T> T executeCommand(Command<T> command);

	/**
	 * Executes a given command with the specified {@link CommandConfig}.
	 *
	 * @param config
	 *            the command execution configuration, cannot be null.
	 * @param command
	 *            the command, cannot be null.
	 * @return the result of command execution
	 */
	<T> T executeCommand(CommandConfig config, Command<T> command);

	/**
	 * [EXPERIMENTAL]
	 *
	 * Executes the sql contained in the {@link CustomSqlExecution} parameter.
	 */
	<MapperType, ResultType> ResultType executeCustomSql(CustomSqlExecution<MapperType, ResultType> customSqlExecution);

	/**
	 * [EXPERIMENTAL]
	 *
	 * Returns a list of event log entries, describing everything the engine has
	 * processed. Note that the event logging must specifically must be enabled
	 * in the process engine configuration.
	 *
	 * Passing null as arguments will effectively fetch ALL event log entries.
	 * Be careful, as this list might be huge!
	 */
	List<EventLogEntry> getEventLogEntries(Long startLogNr, Long pageSize);

	/**
	 * [EXPERIMENTAL]
	 *
	 * Returns a list of event log entries for a specific process instance id.
	 * Note that the event logging must specifically must be enabled in the
	 * process engine configuration.
	 *
	 * Passing null as arguments will effectively fetch ALL event log entries.
	 * Be careful, as this list might be huge!
	 */
	List<EventLogEntry> getEventLogEntriesByProcessInstanceId(String processInstanceId);

	/**
	 * Delete a EventLogEntry. Typically only used in testing, as deleting log
	 * entries defeats the whole purpose of keeping a log.
	 */
	void deleteEventLogEntry(long logNr);
}
