package io.explains.myonlymood.service;


import io.explains.myonlymood.model.Actives;
import io.explains.myonlymood.repository.ActivesRepository;
import io.explains.myonlymood.service.CRUD.IActivesCrud;
import io.explains.myonlymood.service.CRUD.Impl.RestrictCrudServiceImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ActivesServiceImpl extends RestrictCrudServiceImpl<Actives, Long> implements IActivesCrud {

    private final ActivesRepository repository;

    public ActivesServiceImpl(ActivesRepository repository) {
        this.repository = repository;
    }

    @Override
    protected JpaRepository<Actives, Long> getRepository() {
        return repository;
    }
}
