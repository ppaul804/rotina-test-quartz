package br.com.ppaul804.rotinatestquartz;

import org.springframework.boot.Banner.Mode;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class RotinaTestQuartzApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(RotinaTestQuartzApplication.class).bannerMode(Mode.OFF).run(args);
	}

}
