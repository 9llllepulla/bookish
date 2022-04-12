package com.gllllepulla.service;

import java.util.Optional;
import java.util.Set;

public interface EditorService<T> {

    Optional<T> edit(T t);

    T create(T t);

    void deleteByIds(Set<Long> ids);

}
