package kopo.poly.cotroller;

import com.sun.javafx.fxml.builder.URLBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.annotation.HttpConstraint;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

@Slf4j
@RestController

public class ApiController {
    @GetMapping(value = "/api")
    public String callApi() throws IOException {
        log.info(this.getClass().getName() + ".callApi Start!!");

        StringBuilder urlbuilder = new StringBuilder("http://apis.data.go.kr/B553530/TRANSPORTATION/ELECTRIC_CHARGING");
        urlbuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8")+ "=" +"FEJxD0aebVL%2FrlICHbaQtFwgZHDMm7xSvslVLeoZRinjhxJ%2F7%2B97QvovsNiBy5BuhaoqLZCkwXx6S07GUhH5Dg%3D%3D");
        urlbuilder.append("&" + URLEncoder.encode("pageNo","UTF-8")+"="+URLEncoder.encode("1","UTF-8"));
        urlbuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8")+"="+URLEncoder.encode("10","UTF-8"));
        urlbuilder.append("&" + URLEncoder.encode("apiType","UTF-8")+"="+URLEncoder.encode("json","UTF-8"));
        urlbuilder.append("&"+URLEncoder.encode("q1","UTF-8")+"="+URLEncoder.encode("울산광역시","UTF-8"));
        urlbuilder.append("&"+URLEncoder.encode("q2","UTF-8")+"="+URLEncoder.encode("중구","UTF-8"));
        URL url = new URL(urlbuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type","application/json");
        System.out.println("Response code: "+conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode()<=300){
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        }else{
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while((line = rd.readLine())!= null){
            sb.append(line);
        }
        rd.close();
        conn.disconnect();

        log.info(this.getClass().getName()+".callApi end!");
        log.info(sb.toString());

        return sb.toString();
    }
}
