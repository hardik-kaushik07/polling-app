package com.hardik.pollingapp.Repository;

import com.hardik.pollingapp.Model.Poll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VotingRepository extends JpaRepository<Poll, Long>{
}
