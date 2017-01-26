package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author marcella
 */
public interface IController {
    
    
    public String execute(HttpServletRequest request, HttpServletResponse response);
    
}
