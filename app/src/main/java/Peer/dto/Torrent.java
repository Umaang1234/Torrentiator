package Peer.dto;

public class Torrent {
    String trackerUrl;
    byte InfoHash[];
    byte[][] PieceHashes;
    int piece_len;
    int file_len;
    String fileName;

}

