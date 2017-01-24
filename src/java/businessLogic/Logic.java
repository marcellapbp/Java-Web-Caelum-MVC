package businessLogic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author marcella
 */
public interface Logic {
    
    public String execute(HttpServletRequest request, HttpServletResponse response);
    
}
