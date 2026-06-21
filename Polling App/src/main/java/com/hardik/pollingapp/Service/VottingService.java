package com.hardik.pollingapp.Service;

import com.hardik.pollingapp.Model.OptionVote;
import com.hardik.pollingapp.Model.Poll;
import com.hardik.pollingapp.Model.Vote;
import com.hardik.pollingapp.Repository.VoteRepository;
import com.hardik.pollingapp.Repository.VotingRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class VottingService {

    @Autowired
    private VotingRepository repo;

    @Autowired
    private VoteRepository voteRepository;


    public List<Poll> getAllPolls(){
        return repo.findAll();
    }

    public Poll createVote(Poll poll) {
        return repo.save(poll);
    }

    public Poll getById(Long id) {
        return repo.findById(id).orElseThrow(()-> new RuntimeException("Poll not found."));
    }

    public void vote(Long pollId, int optionIndex, HttpServletRequest request) {


        String ip = request.getRemoteAddr();


        boolean alreadyVoted = voteRepository
                .existsByPollIdAndIpAddress(pollId, ip);

        if (alreadyVoted) {
            throw new RuntimeException("You already voted!");
        }
        Poll poll = repo.findById(pollId)
                .orElseThrow(()-> new RuntimeException("Poll ID Not Found"));


       List<OptionVote> options =  poll.getOptions();
        if(optionIndex<0 || optionIndex>=options.size()){
            throw new IllegalArgumentException("OptionId is not valid");
        }
        OptionVote selectOption = options.get(optionIndex);
        selectOption.setVoteCount(selectOption.getVoteCount()+1);

        repo.save(poll);

//         Save vote record
        Vote vote = new Vote();
        vote.setPollId(pollId);
        vote.setIpAddress(ip);

        voteRepository.save(vote);
    }

    public void deleteById(Long id) {
             repo.deleteById(id);
    }
}
