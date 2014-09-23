package com.jd.jdda_collector.common;

/**
 * Created with IntelliJ IDEA.
 * User: tibelf
 * Date: 14-9-16
 * Time: 上午10:06
 * To change this template use File | Settings | File Templates.
 */
public class PropertyException extends RuntimeException{

    public PropertyException(String message, Throwable cause) {
        super(message, cause);
    }

    public PropertyException(String message) {
        super(message);
    }

    public PropertyException(Throwable cause) {
        super(cause);
    }
}
