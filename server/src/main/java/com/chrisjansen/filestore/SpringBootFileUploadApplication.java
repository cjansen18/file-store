package com.chrisjansen.filestore;

import javax.annotation.Resource;

import com.chrisjansen.filestore.storage.StorageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootFileUploadApplication implements CommandLineRunner {

	@Resource
    StorageService storageService;

	@Value("${delete.on.startup}")
	boolean deleteOnStartupFlag;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootFileUploadApplication.class, args);
	}

	@Override
	public void run(String... arg) throws Exception {
		if(deleteOnStartupFlag)
			storageService.deleteAll();
//		storageService.init();
	}
}
