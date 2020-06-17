package cn.com.req;



import cn.com.exception.RequestException;

import java.io.IOException;
import java.util.concurrent.Callable;

public abstract class Operation<V> implements Callable<V> {

    /**
     * Run operation
     *
     * @return result
     * @throws RequestException
     * @throws IOException
     */
    protected abstract V run() throws RequestException, IOException;

    /**
     * Operation complete callback
     *
     * @throws IOException
     */
    protected abstract void done() throws IOException;

    public V call() throws RequestException {
        boolean thrown = false;
        try {
            return run();
        } catch (RequestException e) {
            thrown = true;
            throw e;
        } catch (IOException e) {
            thrown = true;
            throw new RequestException(e);
        } finally {
            try {
                done();
            } catch (IOException e) {
                if (!thrown)
                    throw new RequestException(e);
            }
        }
    }

}
