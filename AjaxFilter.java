import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "AjaxFilter", urlPatterns = { "*" })
public class AjaxFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
			ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session = httpRequest.getSession(false);
		String ajaxRequest = httpRequest.getHeader("x-requested-with");
		try {
			if (session == null && "XMLHttpRequest".equalsIgnoreCase(ajaxRequest)) {
				System.out.println("sessão expirada com ajax");
				httpResponse.sendError(403);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			chain.doFilter(request, response);
		} catch (Exception e) {
		}
	}

}
