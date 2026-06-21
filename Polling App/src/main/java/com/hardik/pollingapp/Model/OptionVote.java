package com.hardik.pollingapp.Model;


import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
public class OptionVote {

    private String optionText;
    private Long voteCount = (long) 0L;

}
