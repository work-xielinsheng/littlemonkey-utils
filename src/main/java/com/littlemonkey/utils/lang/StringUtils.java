package com.littlemonkey.utils.lang;

import com.google.common.base.Joiner;
import com.littlemonkey.utils.base.Constants;
import com.littlemonkey.utils.collect.Collections3;

import java.util.Map;


/**
 * <p>string 工具类</p>
 *
 * @author xiangjun.xls
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils {

    /**
     * <p>将map里面key-value使用特定的符号连接成字符串</p>
     *
     * @param map
     * @param separator         每对键值的连接符号
     * @param keyValueSeparator key-value的连接符号
     * @return
     */
    public static String join(Map map, final String separator, final String keyValueSeparator) {
        if (Collections3.isEmpty(map)) {
            return Constants.BLANK;
        }
        return Joiner.on(separator).withKeyValueSeparator(keyValueSeparator).join(map);
    }
}
