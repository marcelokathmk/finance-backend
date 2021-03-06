package pt.com.financebackend.controller;

import org.springframework.web.context.request.RequestContextHolder;
import pt.com.financebackend.model.Header;

public class BaseController {

    protected Header getHeader(String service, String function, String message){
        Header header = new Header();
        header.setFunction(function);
        header.setService(service);
        header.setSession(RequestContextHolder.currentRequestAttributes().getSessionId());
        header.setVersion("1.0");
        header.setMessage(message);
        return header;
    }
}
