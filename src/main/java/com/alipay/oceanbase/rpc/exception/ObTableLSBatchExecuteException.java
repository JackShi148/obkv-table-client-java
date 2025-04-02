package com.alipay.oceanbase.rpc.exception;

import com.alipay.oceanbase.rpc.location.model.partition.ObPair;
import com.alipay.oceanbase.rpc.protocol.payload.impl.execute.ObTableSingleOp;
import com.alipay.oceanbase.rpc.table.ObTableParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.alipay.oceanbase.rpc.protocol.payload.Constants.INVALID_LS_ID;

public class ObTableLSBatchExecuteException extends ObTableException {
    // List { (lsId1 -> List { (index1, fail op1), (index2, fail op2) ... } ) ... }
    private List<ObPair<Long, List<ObPair<Integer, ObTableSingleOp>>>> failOperations = new ArrayList<>();
    // lsId -> exception
    private Map<Long, Throwable> lsExceptionMap = new HashMap<>();

    public void addOperations(Long lsId, Map<Long, ObPair<ObTableParam, List<ObPair<Integer, ObTableSingleOp>>>> tabletOps) {
        List<ObPair<Integer, ObTableSingleOp>> operations = new ArrayList<>();
        for (Map.Entry<Long, ObPair<ObTableParam, List<ObPair<Integer, ObTableSingleOp>>>> entry : tabletOps.entrySet()) {
            operations.addAll(entry.getValue().getRight());
        }
        failOperations.add(new ObPair<>(lsId, operations));
    }

    public void addException(Long lsId, Throwable throwable) {
        lsExceptionMap.put(lsId, throwable);
    }

    public List<ObPair<Long, List<ObPair<Integer, ObTableSingleOp>>>> getFailOperations() {
        return failOperations;
    }

    public Map<Long, Throwable> getLsExceptionMap() {
        return lsExceptionMap;
    }

    public boolean isEmpty() {
        return failOperations.isEmpty() && lsExceptionMap.isEmpty();
    }
    /*
     * Ob table ls batch execute exception.
     */
    public ObTableLSBatchExecuteException() {
    }

    /*
     * Ob table ls batch execute exception with error code.
     */
    public ObTableLSBatchExecuteException(int errorCode) {
        super(errorCode);
    }

    /*
     * Ob table ls batch execute exception with message and error code.
     */
    public ObTableLSBatchExecuteException(String message, int errorCode) {
        super(message, errorCode);
    }

    /*
     * Ob table ls batch execute exception with message.
     */
    public ObTableLSBatchExecuteException(String message) {
        super(message);
    }

    /*
     * Ob table ls batch execute exception with message and cause.
     */
    public ObTableLSBatchExecuteException(String message, Throwable cause) {
        super(message, cause);
    }

    /*
     * Ob table ls batch execute exception with cause.
     */
    public ObTableLSBatchExecuteException(Throwable cause) {
        super(cause);
    }
}
