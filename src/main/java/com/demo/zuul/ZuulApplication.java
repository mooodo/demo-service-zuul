/* 
 * Created by 2019年1月31日
 */
package com.demo.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * The applicaton for the api gateway.
 * @author fangang
 */
@SpringBootApplication
@EnableZuulProxy
public class ZuulApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(ZuulApplication.class, args);
	}

}
