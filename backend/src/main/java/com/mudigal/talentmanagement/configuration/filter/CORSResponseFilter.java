package com.mudigal.talentmanagement.configuration.filter;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/***********************************
*
* @author Vijayendra Mudigal
* @contact vijayendrap@gmail.com
*
**********************************/

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CORSResponseFilter implements Filter {

	@Override
	public void init(FilterConfig arg0) {
	}

	private final List<String> allowedOrigins = Arrays.asList("http://localhost:4200", "http://localhost:8082");

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {

		HttpServletResponse response = (HttpServletResponse) resp;

		String origin = ((HttpServletRequest) req).getHeader("Origin");
		response.setHeader("Access-Control-Allow-Origin",
				allowedOrigins.contains(origin) ? origin : "localhost:4200");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, HEAD");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");

		chain.doFilter(req, resp);
	}

	@Override
	public void destroy() {
	}

}