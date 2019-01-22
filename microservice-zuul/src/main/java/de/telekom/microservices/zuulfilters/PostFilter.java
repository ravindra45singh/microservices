package de.telekom.microservices.zuulfilters;

import com.netflix.zuul.ZuulFilter;

public class PostFilter extends ZuulFilter {
	
	@Override
	  public String filterType() {
	    return "post";
	  }
	 
	  @Override
	  public int filterOrder() {
	    return 0;
	  }
	 
	  @Override
	  public boolean shouldFilter() {
	    return true;
	  }
	 
	  @Override
	  public Object run() {
	   System.out.println("Inside Response Filter");
	 
	    return null;
	  }
}
