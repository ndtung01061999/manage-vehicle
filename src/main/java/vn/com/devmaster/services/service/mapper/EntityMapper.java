package vn.com.devmaster.services.service.mapper;

import java.util.Collection;

public interface EntityMapper<D, E> {
    D toDto(E entity);
    E toEntity(D dto);
    Collection<D> toDto(Collection<E> entity);
    Collection<E> toEntity(Collection<D> dto);
}
