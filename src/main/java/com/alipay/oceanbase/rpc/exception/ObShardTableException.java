/*-
 * #%L
 * OBKV Table Client Framework
 * %%
 * Copyright (C) 2021 OceanBase
 * %%
 * OBKV Table Client Framework is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 *          http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND,
 * EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT,
 * MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 * #L%
 */

package com.alipay.oceanbase.rpc.exception;

public class ObShardTableException extends RuntimeException {

    private int errorCode;

    /*
     * Ob shard table exception.
     */
    public ObShardTableException() {
    }

    /*
     * Ob shard table exception.
     */
    public ObShardTableException(int errorCode) {
        this("error code: " + errorCode, errorCode);
    }

    /*
     * Ob shard table exception.
     */
    public ObShardTableException(String message, int errorCode) {
        this(message);
        this.errorCode = errorCode;
    }

    /*
     * Ob shard table exception.
     */
    public ObShardTableException(String message) {
        super(message);
    }

    /*
     * Ob shard table exception.
     */
    public ObShardTableException(String message, Throwable cause) {
        super(message, cause);
    }

    /*
     * Ob shard table exception.
     */
    public ObShardTableException(Throwable cause) {
        super(cause);
    }

    /*
     * Get error code.
     */
    public int getErrorCode() {
        return errorCode;
    }

}
