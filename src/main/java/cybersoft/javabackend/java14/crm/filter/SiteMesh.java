package cybersoft.javabackend.java14.crm.filter;

import javax.servlet.annotation.WebFilter;

import com.opensymphony.sitemesh.webapp.SiteMeshFilter;

@WebFilter(filterName = "sitemesh" ,urlPatterns = "/*")
public class SiteMesh extends SiteMeshFilter {

}
