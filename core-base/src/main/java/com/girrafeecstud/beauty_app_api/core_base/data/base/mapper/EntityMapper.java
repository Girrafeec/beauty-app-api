package com.girrafeecstud.beauty_app_api.core_base.data.base.mapper;

public interface EntityMapper<E,D> {

    public D mapFromEntity(E type);

    public E mapToEntity(D type);

}
