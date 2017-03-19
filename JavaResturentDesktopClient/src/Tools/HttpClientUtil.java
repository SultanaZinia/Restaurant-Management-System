/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;
import Tools.Constant;
import Bean.KeyValuePair;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;


/**
 *
 * @author zinia
 */
public class HttpClientUtil {
    private static HttpClientUtil httpClientUtil;

    public HttpClientUtil getInstance() {
        httpClientUtil = new HttpClientUtil();
        return httpClientUtil;
    }

    private HttpClientUtil() {
    }

    /*
     * Get request method
     */
    public static String getRequest(List<KeyValuePair> paramList) {
        HttpClient client = new DefaultHttpClient();
        String paramStr = Utils.getParamsURL(paramList);

        HttpGet request = new HttpGet(Constant.SERVER_URL + Constant.LOGIN_SERVLET + paramStr);
        System.out.println("$Total Request URL:"+Constant.SERVER_URL + Constant.LOGIN_SERVLET + paramStr);
        HttpResponse response;
        StringBuilder sb = new StringBuilder();
        try {
            response = client.execute(request);
            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

            String line = "";
            while ((line = rd.readLine()) != null) {
                System.out.println("#" + response.getStatusLine());
                sb.append(line);
            }
        } catch (IOException ex) {
            Logger.getLogger(HttpClientUtil.class.getName()).log(Level.SEVERE, null, ex);
        }

        return sb.toString();
    }

    /*
     * Post request method
     */
    public static String postRequest(List<NameValuePair> paramsList) {
        HttpClient client = new DefaultHttpClient();
        HttpPost post=null;
        String requestedServlet=ServletRequest.getServletRequest();
        StringBuilder sb = new StringBuilder();
        if (requestedServlet.equals(Constant.LOGIN_SERVLET)) {

            try {
                post = new HttpPost(Constant.SERVER_URL + Constant.LOGIN_SERVLET);
                post.setEntity(new UrlEncodedFormEntity(paramsList));
            } catch (UnsupportedEncodingException ex) {
                ex.printStackTrace();
            }
        } else if (requestedServlet.equals(Constant.BILLING_SERVLET)) {
            post = new HttpPost(Constant.SERVER_URL + Constant.BILLING_SERVLET);
            try {
                post.setEntity(new UrlEncodedFormEntity(paramsList));
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(HttpClientUtil.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         else if (requestedServlet.equals(Constant.FOOD_LIST_SERVLET)) {
            post = new HttpPost(Constant.SERVER_URL + Constant.FOOD_LIST_SERVLET);
            try {
                post.setEntity(new UrlEncodedFormEntity(paramsList));
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(HttpClientUtil.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         else  {
            post = new HttpPost(Constant.SERVER_URL + Constant.EMPLOYEE_SERVLET);
            try {
                post.setEntity(new UrlEncodedFormEntity(paramsList));
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(HttpClientUtil.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {

            HttpResponse response = client.execute(post);
            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

            String line = "";
            while ((line = rd.readLine()) != null) {
                System.out.println(line);
                sb.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        //}
        return sb.toString();
    }
    
    
}
