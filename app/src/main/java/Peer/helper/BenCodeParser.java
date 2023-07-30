package Peer.helper;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class BenCodeParser {

//    private static Logger logger = Logger.getLogger(BenCodeParser.class.getName());
    private static void BenCodeParsing(InputStream dotTorrentFile ) throws IOException {
        char firstChar = (char) dotTorrentFile.read();
        if (firstChar != 'd') {
            throw new IOException("Invalid torrent format" + firstChar);
        }

        Map<String,Object> decodedTorrent  = parseDictionary(dotTorrentFile);

    }
    private static Map<String, Object> parseDictionary(InputStream dotTorrentFile) throws IOException {
        HashMap<String, Object> dictionary  = new HashMap<>();
        while(dotTorrentFile.read()!=-1){
            char c = (char) dotTorrentFile.read();
            if(c=='e'){
                break;
            }
            String key = parseString(dotTorrentFile);
            Object val = parseVal(dotTorrentFile);
            dictionary.put(key,val);
        }
       return dictionary;
    }
    private static Object parseVal(InputStream dotTorrentFile) throws IOException {
        char c =(char) dotTorrentFile.read();
        switch (c) {
            case 'd':
                return parseDictionary(dotTorrentFile);
            case 'i':
                return parseInteger(dotTorrentFile);
            case 'l':
                return parseList(dotTorrentFile);
            default:
                if(Character.isDigit(c)){
                    return parseString(dotTorrentFile);
                }
                else{
                    throw new IOException("Invalid BenCoding Format:"+ c);
                }
        }

    }

    private static List<Object> parseList(InputStream dotTorrentFile) throws IOException {
        List<Object> list = new ArrayList<>();
        while(dotTorrentFile.read()!=-1){
            char c =(char) dotTorrentFile.read();
            if(c=='e')break;
            switch(c){
                case 'i':
                    list.add(parseInteger(dotTorrentFile));
                case 'l' :
                    list.add(parseList(dotTorrentFile));
                default:
                    if(Character.isDigit(c)){
                        list.add(parseString(dotTorrentFile));
                    }
                    else{
                        throw new IOException("Invalid BenCoding Format:"+ c);
                    }
            }
        }
        return list;
    }

    private static int parseInteger(InputStream dotTorrentFile) throws IOException{
        StringBuilder sb = new StringBuilder();
        while(dotTorrentFile.read()!=-1){
            char c = (char) dotTorrentFile.read();
            if(c=='e')break;
            sb.append(c);
        }
        byte buff[] = sb.toString().getBytes();
        dotTorrentFile.read(buff);
        return  Integer.parseInt(new String(buff));
     }

    private static String parseString(InputStream dotTorrentFile) throws IOException {
       StringBuilder sb = new StringBuilder();
       while (dotTorrentFile.read()!=-1){
           char c  = (char) dotTorrentFile.read();
           if(c==':')break;
           sb.append(c);
       }
       byte buff [] = sb.toString().getBytes();
       dotTorrentFile.read(buff);
       return new String(buff);
    }

    public static void main(String[] args) throws IOException {
        String s = "Umaangisawonderful coder . He lives in the city scranton which is in state PennySlyVania";
        byte[] byteArray = s.getBytes();
        InputStream inputStream = new ByteArrayInputStream(byteArray);
        inputStream.read(s.substring(0,3).getBytes());
        char c = (char) inputStream.read();
        String res = new String(byteArray);

    }
}

