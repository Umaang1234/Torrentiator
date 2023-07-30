package Peer.service;

import Peer.dto.Peer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

@Service
public class PeerService {
    private final RestTemplate restTemplate;
    private static final Logger logger = Logger.getLogger(PeerService.class.getName());
    @Autowired
    public PeerService(RestTemplate restTemplate){
        this.restTemplate =  restTemplate;
    }
   public void sendPeerFirstInfo(Peer peer){
        HttpHeaders headers =new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Peer> entity = new HttpEntity<>(peer,headers);
        String trackerUrl = "http://localhost:8080";
        ResponseEntity<String> response = restTemplate.exchange(trackerUrl, HttpMethod.POST, entity,String.class );
        if(response.getStatusCode().is2xxSuccessful()){
            peer.setRegistered(true);
        }
        else{
            logger.info("Peer is not able to register");
            peer.setRegistered(false);
        }
   }

}
