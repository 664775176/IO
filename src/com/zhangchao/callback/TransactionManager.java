package com.zhangchao.callback;

import org.springframework.lang.Nullable;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.support.TransactionCallback;

/**
 * @author Charsel zhang
 * @version 0.0.1
 * @classNane:TransactionManager
 * @description: TODO
 * @date 2019/6/22 15:21
 */
public interface TransactionManager {
    @Nullable
    <T> T execute(@Nullable TransactionDefinition definition, TransactionCallback<T> callback) throws TransactionException;
}
