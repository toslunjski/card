package com.ts.cardapp.web.controller;

import com.ts.cardapp.api.message.request.CreateCandidateRequest;
import com.ts.cardapp.api.message.response.CreateCandidateResponse;
import com.ts.cardapp.api.message.response.DeleteCandidateResponse;
import com.ts.cardapp.api.message.response.GetCandidateResponse;
import com.ts.cardapp.core.peer.CandidatePeer;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Tomislav Slunjski
 * @since 18.1
 */
@RestController
@RequestMapping ("/cardapp")
public class CardApplicationController
{

    private CandidatePeer candidatePeer;

    public CardApplicationController(final CandidatePeer candidatePeer)
    {
        this.candidatePeer = candidatePeer;
    }

    @PostMapping ("/candidate")
    public @ResponseBody CreateCandidateResponse createCandidate(
        @RequestParam (required = true) String name,
        @RequestParam (required = true) String surname,
        @RequestParam (required = true) long oib)
    {return candidatePeer.createCandidate(CreateCandidateRequest.from(name, surname, oib));}

    @GetMapping ("/candidate/{oib}")
    public @ResponseBody GetCandidateResponse getCandidate(final @PathVariable ("oib") long oib)
    {
        return candidatePeer.getCandidate(oib);
    }

    @DeleteMapping ("/candidate/{oib}")
    public @ResponseBody DeleteCandidateResponse deleteCandidate(final @PathVariable ("oib") long oib)
    {
        return candidatePeer.deleteCandidate(oib);
    }
}