package com.losnarghileros.smarthack2018.repository;

import com.losnarghileros.smarthack2018.entities.Room;
import com.losnarghileros.smarthack2018.entities.enums.RoomType;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

public class RoomSpecifications {
    public static Specification<Room> findBy(String name, Long capacity, RoomType type, Long floor) {
        return new Specification<Room>() {
            @Override
            public Predicate toPredicate(Root<Room> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {

                final List<Predicate> predicateList = new ArrayList<>();

                if (name != null && !name.isEmpty()) {
                    predicateList.add(cb.like(cb.upper(root.get("name")), '%' + name.toUpperCase() + '%'));
                }

                if (capacity != null) {
                    predicateList.add(cb.greaterThanOrEqualTo(root.get("capacity"), capacity));
                }

                if (type != null) {
                    predicateList.add(cb.equal(root.get("type"), type));
                }

                if (floor != null) {
                    predicateList.add(cb.equal(root.get("floor"), floor));
                }

                return cb.and(predicateList.toArray(new Predicate[predicateList.size()]));
            }
        };
    }
}
