package com.testing.geohash.Service;

import com.testing.geohash.Dao.StoreDao;
import com.testing.geohash.Domain.AddressEntity;
import com.testing.geohash.Domain.StoreEntity;
import com.testing.geohash.Utility.Geography.Geohash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StoreService{
    @Autowired
    StoreDao storeDao;


    public List<StoreEntity> getAll() {
        return storeDao.getAll();
    }

    public List<StoreEntity> getNearby(double longitude, double latitude) {
        String base = Geohash.geohash(longitude, latitude, Geohash.DEFAULT_LENGTH);
        List<StoreEntity> stores = getAll();
        List<StoreEntity> res =
                stores
                        .stream()
                        .filter((e) ->{
                            AddressEntity addressEntity = e.getAddress();
                            if (addressEntity == null)
                                return false;
                            return Geohash.match(base, addressEntity.getGeohash(), Geohash.DEFAULT_MATCH_LENGTH);
                        })
                        .sorted((a, b) -> {
                            double a_distance = storeDistance(longitude, latitude, a);
                            double b_distance = storeDistance(longitude, latitude, b);
                            if (a_distance < b_distance)
                                return -1;
                            else
                                return 1;
                        })
                        .collect(Collectors.toList());
        return res;
    }

    private static double storeDistance(double x1, double y1, StoreEntity s){
        return distance(x1, y1, s.getAddress().getLongitude(), s.getAddress().getLatitude());
    }
    private static double distance(double x1, double y1, double x2, double y2){
        return Math.sqrt(Math.pow((x1- x2), 2) + Math.pow(y1-y2, 2));
    }
}
