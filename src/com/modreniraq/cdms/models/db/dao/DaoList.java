package com.modreniraq.cdms.models.db.dao;

import java.util.List;

public interface DaoList<T> {

    public List<T> loadAll() throws Exception;

    public int insert(T t) throws Exception;

    public int update(T t) throws Exception;

    public int delete(T t) throws Exception;

    public T getData(T t) throws Exception;

    public T getDataById(int id) throws Exception;
}
