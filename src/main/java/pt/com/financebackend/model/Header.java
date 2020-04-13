package pt.com.financebackend.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Header {

    private String service;

    private String function;

    private String version;

    private String session;

    private String message;
}
