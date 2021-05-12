package com.helthplus.springbootstarter.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpStatus;
import org.springframework.web.filter.GenericFilterBean;

import com.helthplus.springbootstarter.common.Constant;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class AuthFilter extends  GenericFilterBean{

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
		HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
		
		String authHeader = httpRequest.getHeader("Authorization");
		//String Referer = httpRequest.getHeader("Referer");
		if(authHeader != null){
			String[] authHeaderArr = authHeader.split("Bearer");
			if(authHeaderArr.length > 1 && authHeaderArr[1] != null){
				String token = authHeaderArr[1];
				try {
					Claims claims = Jwts.parser().setSigningKey(Constant.API_SECRET_KEY)
							.parseClaimsJws(token).getBody();
					httpRequest.setAttribute("email", claims.get("email").toString());
					
				} catch (Exception e) {
					httpResponse.sendError(org.springframework.http.HttpStatus.FORBIDDEN.value(),"invalid/expired token");
					return;
				}
			}else{
				httpResponse.sendError(org.springframework.http.HttpStatus.FORBIDDEN.value(),"Authorization token must be Bearer [token]");
				return;
			}
		}else{
			httpResponse.sendError(org.springframework.http.HttpStatus.FORBIDDEN.value(),"Authorization token must be provided");
			return;

		}
		filterChain.doFilter(servletRequest, servletResponse);
		
	}

}
