package com.demo.bookapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.time.LocalTime;

@Service
public class ScheduleTasks {
    Logger logger = LoggerFactory.getLogger(ScheduleTasks.class);

    @Autowired
    BookService bookService;

    // Runs every 5 seconds
    @Scheduled(fixedRate = 5000)
    public void runTask() {
        logger.info("Task executed at: " + LocalTime.now());
        bookService.hello();
        System.out.println("Task executed at: " + LocalTime.now());
    }

}
