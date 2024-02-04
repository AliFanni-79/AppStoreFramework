package model;

import lombok.Builder;

import java.io.Serializable;
@Builder
public class Packet implements Serializable  {
    public static final String PAGE = "000", FILE = "001", REVIEW = "010", SEARCH = "011",
            SIGN_IN = "100", SIGN_UP = "101", LIBRARY = "110", ERROR = "111";
    public String aim;
    public String errorDescription;
    public App[] apps;
    public Object file;
}
