package io.explains.myonlymood.service.CRUD.Impl;

import io.explains.myonlymood.service.CRUD.IRestrictCrudService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

public abstract class RestrictCrudServiceImpl <T, ID extends Serializable> implements IRestrictCrudService<T, ID> {

    protected abstract JpaRepository<T, ID> getRepository();

    @Override
    public T save(T entity) {
        return getRepository().save(entity);
    }

    @Override
    public T saveAndFlush(T entity) {
        return getRepository().saveAndFlush(entity);
    }

    @Override
    public void flush() {
        getRepository().flush();
    }

    @Override
    public T findById(ID id) {
        return getRepository().findById(id).orElse(null);
    }

    @Override
    public boolean exists(ID id) {
        return getRepository().existsById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public long count() {
        return getRepository().count();
    }

    @Override
    public void delete(ID id) {
        getRepository().deleteById(id);
    }

}
