package br.com.ppaul804.rotinatestquartz;

import br.com.ppaul804.rotinatestquartz.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class RotinaTestQuartzApplicationTests {

	@Autowired
	private BookRepository bookRepository;
	
	@Test
	void contextLoads() throws InterruptedException {
		assertNotNull(bookRepository.getAllBooks());
	}

}
