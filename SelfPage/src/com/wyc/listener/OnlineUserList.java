package com.wyc.listener;

import java.util.Set;
import java.util.TreeSet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class OnlineUserList
 *
 */
@WebListener
public class OnlineUserList implements HttpSessionAttributeListener, HttpSessionListener, ServletContextListener {
	private ServletContext app = null;

    public OnlineUserList() {
        // TODO Auto-generated constructor stub
    }

    public void sessionCreated(HttpSessionEvent paramHttpSessionEvent)  { 
         // TODO Auto-generated method stub
    }

    public void sessionDestroyed(HttpSessionEvent paramHttpSessionEvent)  { 
    	 Set all = (Set) this.app.getAttribute("online");
    	 if (all.size()>0) {
         all.remove(paramHttpSessionEvent.getSession().getAttribute("userid"));
    	 }
         this.app.setAttribute("online", all);
    }

    public void contextDestroyed(ServletContextEvent paramServletContextEvent)  { 
         // TODO Auto-generated method stub
    }

    public void attributeAdded(HttpSessionBindingEvent paramHttpSessionBindingEvent)  { 
         Set all = (Set) this.app.getAttribute("online");
         all.add(paramHttpSessionBindingEvent.getValue());
         this.app.setAttribute("online", all);
         }

    public void attributeRemoved(HttpSessionBindingEvent paramHttpSessionBindingEvent)  { 
    	 Set all = (Set) this.app.getAttribute("online");
         all.remove(paramHttpSessionBindingEvent.getValue());
         this.app.setAttribute("online", all);
    }

    public void attributeReplaced(HttpSessionBindingEvent paramHttpSessionBindingEvent)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent paramServletContextEvent)  { 
    	this.app = paramServletContextEvent.getServletContext();
    	this.app.setAttribute("online", new TreeSet());
    }
	
}
