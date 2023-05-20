package com.paintfinder.MiniaturePaint;

import com.paintfinder.MiniaturePaint.controller.InfoPaintController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackageClasses = InfoPaintController.class)
public class MiniaturePaintApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiniaturePaintApplication.class, args);
	}

}
