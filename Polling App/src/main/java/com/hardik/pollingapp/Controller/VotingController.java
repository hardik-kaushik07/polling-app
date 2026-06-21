package com.hardik.pollingapp.Controller;

import com.hardik.pollingapp.Model.Poll;
import com.hardik.pollingapp.Service.VottingService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class VotingController {


    @Autowired
    private VottingService service;


    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping("/poll")
    public List<Poll> getAllPoles(){
        return service.getAllPolls();
    }


    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/polls")
    public Poll createVote(@RequestBody Poll poll){
        return service.createVote(poll);
    }



    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping("/poll/{id}")
    public ResponseEntity<Poll> getById(@PathVariable Long id){
        Poll poll = service.getById(id);
        if(poll!=null){
            return new ResponseEntity<>(poll, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @PostMapping("/vote/{pollId}/{optionIndex}")
    public String vote(@PathVariable Long pollId, @PathVariable int optionIndex, HttpServletRequest request){
        service.vote(pollId, optionIndex, request);
        return "Voted Successfully";
    }


    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
         Poll poll = service.getById(id);
         if(poll!=null){
             service.deleteById(id);
             return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
         }
        else{
            return new ResponseEntity<>("Deletion Failed", HttpStatus.NOT_FOUND);
         }
    }
}
