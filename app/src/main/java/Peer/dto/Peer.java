package Peer.dto;

public class Peer {
    String ip;
    int  port;

    boolean isRegistered;

    public Peer(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }
    public Peer(String ip, int port, boolean isRegistered){
        this.ip = ip;
        this.port = port;
        this.isRegistered = isRegistered;
    }
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public boolean isRegistered() {
        return isRegistered;
    }

    public void setRegistered(boolean registered) {
        isRegistered = registered;
    }
}
