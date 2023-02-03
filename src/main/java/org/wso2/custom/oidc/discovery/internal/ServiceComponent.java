package org.wso2.custom.oidc.discovery.internal;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.equinox.http.helper.ContextPathServletAdaptor;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.http.NamespaceException;
import org.wso2.carbon.identity.application.authentication.framework.ApplicationAuthenticator;
import org.wso2.carbon.identity.oauth.OAuthAdminServiceImpl;
import org.wso2.carbon.user.core.service.RealmService;
import org.wso2.custom.oidc.discovery.CustomDiscovery;
import org.wso2.custom.oidc.discovery.CustomDiscoveryConstants;


import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.util.Hashtable;


//@Component(
//        name = "org.wso2.custom.scope.validator",
//        immediate = true
//)

public class ServiceComponent {



    private static final Log log = LogFactory.getLog(ServiceComponent.class);

    /**
     * Activate service.
     *
     * @param componentContext component context
     */
    protected void activate(ComponentContext componentContext) {
        CustomDiscovery authenticator = new CustomDiscovery();
        Hashtable<String, String> props = new Hashtable<>();
        componentContext.getBundleContext()
                .registerService(ApplicationAuthenticator.class.getName(), authenticator, props);
        Servlet servlet = new ContextPathServletAdaptor(
                new CustomDiscovery(), CustomDiscoveryConstants.SERVLET_URL);
        try {
            ServiceComponentHolder.getInstance().getHttpService()
                    .registerServlet(CustomDiscoveryConstants.SERVLET_URL, servlet, null, null);
            log.info("X509 Certificate Servlet activated successfully..");
        } catch (NamespaceException | ServletException e) {
            throw new RuntimeException("Error when registering X509 Certificate Servlet via the HttpService.", e);
        }
    }


//    private static Log log = LogFactory.getLog(ServiceComponent.class);
//
//    private static RealmService realmService;
//
//    @Reference(
//            name = "user.realmservice.default",
//            service = org.wso2.carbon.user.core.service.RealmService.class,
//            cardinality = ReferenceCardinality.MANDATORY,
//            policy = ReferencePolicy.DYNAMIC,
//            unbind = "unsetRealmService"
//    )
//    protected void setRealmService(RealmService realmService) {
//        if (log.isDebugEnabled()) {
//            log.debug("Setting the Realm Service");
//        }
//        ServiceComponentHolder.getInstance().setRealmService(realmService);
//    }
//
//    protected void unsetRealmService(RealmService realmService) {
//        if (log.isDebugEnabled()) {
//            log.debug("UnSetting the Realm Service");
//        }
//        ServiceComponentHolder.getInstance().setRealmService(null);
//    }
//
//    @Reference(
//            name = "user.oauthadminservice.default",
//            service = org.wso2.carbon.identity.oauth.OAuthAdminServiceImpl.class,
//            cardinality = ReferenceCardinality.MANDATORY,
//            policy = ReferencePolicy.DYNAMIC,
//            unbind = "unsetOAuthAdminService"
//    )
//    protected void setOAuthAdminService(OAuthAdminServiceImpl oAuthAdminService) {
//        if (log.isDebugEnabled()) {
//            log.debug("Setting the oAuthAdminService Service");
//        }
//        ServiceComponentHolder.getInstance().setOAuthAdminService(oAuthAdminService);
//    }
//
//    protected void unsetOAuthAdminService(OAuthAdminServiceImpl oAuthAdminService) {
//        if (log.isDebugEnabled()) {
//            log.debug("UnSetting the oAuthAdminService Service");
//        }
//        ServiceComponentHolder.getInstance().setOAuthAdminService(null);
//    }
}
