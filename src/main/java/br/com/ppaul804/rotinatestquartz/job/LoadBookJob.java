package br.com.ppaul804.rotinatestquartz.job;

import br.com.ppaul804.rotinatestquartz.model.Book;
import br.com.ppaul804.rotinatestquartz.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

@Slf4j
@Component
public class LoadBookJob implements Job {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        int booksCounter = bookRepository.getBooksCount() + 1;
        log.info("Adding book number {} ", booksCounter);
        bookRepository.addBook(new Book(
                UUID.randomUUID(),
                "name" + booksCounter,
                "description" + booksCounter,
                "author" + booksCounter,
                BigDecimal.valueOf(booksCounter + 100L)));
    }
}
