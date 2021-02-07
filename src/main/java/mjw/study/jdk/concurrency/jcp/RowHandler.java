package mjw.study.jdk.concurrency.jcp;

import java.sql.ResultSet;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 24 Oct 2019, 9:24 AM
 */
public interface RowHandler<T>
{
    T handle(ResultSet resultSet);
}
