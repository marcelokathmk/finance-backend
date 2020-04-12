package pt.com.financebackend.model;

import lombok.Data;

@Data
public class Header {

    private String service;

    private String function;

    private String version;

    private String session;
}
