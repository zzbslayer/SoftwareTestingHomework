package com.testing.geohash.Dao;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.testing.geohash.Config.CONSTANT;
import com.testing.geohash.Domain.StoreEntity;
import com.testing.geohash.Utility.Network.HttpRequest;
import com.testing.geohash.Utility.Network.JsonHelper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StoreDao implements DaoInterface<Long, StoreEntity> {
    public StoreEntity getById(Long id){
        String url = CONSTANT.RMP_STORE_API + String.valueOf(id);
        String data = HttpRequest.request(HttpRequest.METHOD_GET, url);
        System.out.println("[StoreDao.getById]: " + data);
        if (data.equals(CONSTANT.NULL_VALUE))
            return null;
        return JsonHelper.jsonStringToObject(data, StoreEntity.class);
    }

    public List<StoreEntity> getAll() {
        String url = CONSTANT.RMP_STORE_API;
        String data = HttpRequest.request(HttpRequest.METHOD_GET, url);
        System.out.println("[StoreDao.getAll]: " + data);
        if (data.equals(CONSTANT.NULL_VALUE))
            return new ArrayList<>();

        /*
        Extract
            { "Store": [{...},{...}] }
        to
            [{...},{...}]
         */
        JSONArray json = JSONObject.parseObject(data).getJSONArray("Store");
        return JsonHelper.jsonStringToList(json.toString(), StoreEntity.class);
    }
}
