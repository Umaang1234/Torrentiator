package Peer.controller;

import Peer.dto.Peer;
import Peer.service.PeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PeerController {
    @Autowired
    private PeerService peerService;
    @PostMapping("/sendFirstInfo")
    private void sendFirstInfo(@RequestBody Peer peer){
       peerService.sendPeerFirstInfo(peer);
    }
}
