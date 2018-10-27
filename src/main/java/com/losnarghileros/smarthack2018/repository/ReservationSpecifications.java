package com.losnarghileros.smarthack2018.repository;

import com.losnarghileros.smarthack2018.entities.Reservation;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ReservationSpecifications {

    public static Specification<Reservation> findBy(String param) {
        return new Specification<Reservation>() {
            @Override
            public Predicate toPredicate(Root<Reservation> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
                final List<Predicate> predicateList = new ArrayList<>();

                return cb.and(predicateList.toArray(new Predicate[predicateList.size()]));
            }
        };
    }
}
