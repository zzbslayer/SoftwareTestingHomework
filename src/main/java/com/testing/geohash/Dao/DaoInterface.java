package com.testing.geohash.Dao;

import java.util.List;

public interface DaoInterface<K, T> {
    T getById(K id);
    List<T> getAll();
}
