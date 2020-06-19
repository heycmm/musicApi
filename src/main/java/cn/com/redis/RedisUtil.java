package cn.com.redis;

import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import java.util.Map;

/**
 * lettuce redis 工具
 * @author：czx.me 2020/6/19
 */

public class RedisUtil {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(RedisUtil.class);

    private static class Helper {
        static RedisClient redisClient;
        static StatefulRedisConnection<String, String> connection;

        static {
            redisClient = RedisClient.create("redis://@127.0.0.1:6379");
            connection = redisClient.connect();
            log.info("==> Connected to Redis");
            Runtime.getRuntime().addShutdownHook(new Thread() {
                public void run() {
                    if (connection != null) {
                        connection.close();
                    }
                    if (redisClient != null) {
                        redisClient.shutdown();
                    }
                }
            });
        }

    }

    /**
     * 设置缓存
     * @param key 键
     * @param value 值
     * @return 返回
     */
    public static boolean set(String key, Map<String, String> value) {
        try {
            String hmset = Helper.connection.sync().hmset(key, value);
            log.info(hmset);
            return true;
        } catch (Exception e) {
            log.error(key, e);
            return false;
        }

    }

    /**
     * 缓存获取
     *
     * @param key 键
     * @return 值
     */
    public static Map<String, String> get(String key) {
        return key == null ? null : Helper.connection.sync().hgetall(key);
    }

    /**
     * 删除
     * @param key 键
     * @return 是否成功
     */
    public static boolean del(String key) {
        try {
            Long hdel = Helper.connection.sync().del(key);
            log.info(String.valueOf(hdel));
            return true;
        } catch (Exception e) {
            log.error(key, e);
            return false;
        }

    }

    private RedisUtil() {

    }

}
