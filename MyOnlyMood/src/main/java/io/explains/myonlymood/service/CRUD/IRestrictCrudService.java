package io.explains.myonlymood.service.CRUD;

import java.io.Serializable;

public interface IRestrictCrudService <T, ID extends Serializable>{

    T save(T entity);

    T saveAndFlush(T entity);

    void flush();

    T findById(ID id);

    boolean exists(ID id);

    long count();

    void delete(ID id);

}
