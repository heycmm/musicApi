package cn.com.req;

import java.io.Flushable;
import java.io.IOException;

public abstract class FlushOperation<V> extends Operation<V> {

    private final Flushable flushable;

    /**
     * Create flush operation
     *
     * @param flushable
     */
    protected FlushOperation(final Flushable flushable) {
        this.flushable = flushable;
    }

    @Override
    protected void done() throws IOException {
        flushable.flush();
    }

}
