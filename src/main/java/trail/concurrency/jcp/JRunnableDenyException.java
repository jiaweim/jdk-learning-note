package trail.concurrency.jcp;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 25 Oct 2019, 10:39 AM
 */
public class JRunnableDenyException extends RuntimeException
{
    public JRunnableDenyException(String message)
    {
        super(message);
    }
}
