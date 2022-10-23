package com.girrafeecstud.beauty_app_webapp.base_core.data.base.mapper;

public interface EntityMapper<E,D> {

    public D mapFromEntity(E type);

    public E mapToEntity(D type);

}
