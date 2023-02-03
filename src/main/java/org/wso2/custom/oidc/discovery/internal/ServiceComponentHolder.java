package org.wso2.custom.oidc.discovery.internal;

import org.osgi.service.http.HttpService;
import org.wso2.carbon.identity.oauth.OAuthAdminServiceImpl;
import org.wso2.carbon.user.core.service.RealmService;


public class ServiceComponentHolder {

//    private static ServiceComponentHolder instance = new ServiceComponentHolder();

    private static volatile ServiceComponentHolder dataHolder = null;
    private HttpService httpService;

    private ServiceComponentHolder() {
    }


    public static ServiceComponentHolder getInstance() {
        if (dataHolder == null) {
            synchronized (ServiceComponentHolder.class) {
                if (dataHolder == null) {
                    dataHolder = new ServiceComponentHolder();
                }
            }
        }
        return dataHolder;
    }

    /**
     * Get http service.
     *
     * @return http service
     */
    public HttpService getHttpService() {
        return httpService;
    }

//    private OAuthAdminServiceImpl oauthAdminService;
//
//    private RealmService realmService;
//
//    public static ServiceComponentHolder getInstance() {
//
//        return instance;
//    }
//
//
//    public RealmService getRealmService() {
//
//        return realmService;
//    }
//
//    public void setRealmService(RealmService realmService) {
//
//        this.realmService = realmService;
//    }
//
//    public OAuthAdminServiceImpl getOAuthAdminService() {
//
//        return oauthAdminService;
//    }
//
//    public void setOAuthAdminService(OAuthAdminServiceImpl oauthAdminService) {
//
//        this.oauthAdminService = oauthAdminService;
//    }
}
