package com.inetBanking.Utilities;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Readconfig {
    Properties pro;

    public Readconfig() {
        File src = new File("/Users/siddu/IdeaProjects/Bankingproject/Configration/config.properties");

        try {
            FileInputStream fis = new FileInputStream(src);
            pro = new Properties();
            pro.load(fis);
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    public String getUsername() {
        String username = pro.getProperty("username");
        return username;
    }

    public String getPassword() {
        String password = pro.getProperty("password");
        return password;
    }

    public String getApplicationURL() {
        String url = pro.getProperty("baseURL");
        return url;
    }

    public String getChromepath() {
        String chromepath = pro.getProperty("chromepath");
        return chromepath;
    }

    public String getFirefoxPath() {
        String chromepath = pro.getProperty("firfoxpath");
        return chromepath;
    }
}
