package Peer.dto;

public class BenCodeInfo {
    String pieces;
    int piece_length;
    int length;
    String name;

    public BenCodeInfo(String pieces, int piece_length, int length, String name) {
        this.pieces = pieces;
        this.piece_length = piece_length;
        this.length = length;
        this.name = name;
    }

    public String getPieces() {
        return pieces;
    }

    public void setPieces(String pieces) {
        this.pieces = pieces;
    }

    public int getPiece_length() {
        return piece_length;
    }

    public void setPiece_length(int piece_length) {
        this.piece_length = piece_length;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
