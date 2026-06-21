package com.hardik.pollingapp.Repository;

import com.hardik.pollingapp.Model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepository extends JpaRepository<Vote, Long> {
    boolean existsByPollIdAndIpAddress(Long pollId, String ipAddress);
}
