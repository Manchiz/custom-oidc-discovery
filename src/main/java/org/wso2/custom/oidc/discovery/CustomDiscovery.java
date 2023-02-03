package org.wso2.custom.oidc.discovery;

import org.json.simple.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CustomDiscovery extends HttpServlet {

    private static final long serialVersionUID = -7182121722709941646L;

    public void init() throws ServletException {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Set response content type as 'application/json'
        response.setContentType("application/json");
//        JSONObject outputContent = DiscoveryDataHolder.getInstance().getDiscoveryData();
        JSONObject outputContent = DiscoveryDataHolder.getInstance().getDiscoveryData();

        // Get the PrintWriter object from response to write the required json object to the output stream.
        PrintWriter out = response.getWriter();
        out.print(outputContent);
        out.flush();
    }

    public void destroy() {
        // do nothing.
    }
}
