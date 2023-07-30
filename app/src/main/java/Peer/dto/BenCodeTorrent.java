package Peer.dto;

public class BenCodeTorrent {
    String announce_url;
    BenCodeInfo info;

    public BenCodeTorrent(String announce_url, BenCodeInfo info) {
        this.announce_url = announce_url;
        this.info = info;
    }

    public String getAnnounce_url() {
        return announce_url;
    }

    public void setAnnounce_url(String announce_url) {
        this.announce_url = announce_url;
    }

    public BenCodeInfo getInfo() {
        return info;
    }

    public void setInfo(BenCodeInfo info) {
        this.info = info;
    }
}
