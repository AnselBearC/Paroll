/**
 * 功能描述:封装API的错误码 <br>
 * 〈$〉
 * <p>
 * $
 *
 * @return:$
 * @since: 1.0.0
 * @Author:Ansel
 * @Date: 2020/5/22$ 上午 10:52$
 */

package com.ansel.payroll.common.api;

public interface IErrorCode {
    long getCode();

    String getMessage();
}
