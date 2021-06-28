package com.nagaty.neotask.repositories;

import com.nagaty.neotask.models.Watch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WatchRepository extends JpaRepository<Watch, Integer> {
    // since we know watchID is unique at the DB level it is safe to assume the
    // the result will always be 0 or 1 element
    List<Watch> findByWatchID(String watchID);
}
