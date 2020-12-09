package com.airticketssales.salesservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;

@SpringBootApplication
@EnableBinding(Processor.class)
public class SalesServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SalesServiceApplication.class, args);
    }

//    @Bean
//    public Source<String> stringSupplier() {
//        return () -> "Hello from Supplier";
//    }
//
//    private static final Logger log = LoggerFactory.getLogger(SalesServiceApplication.class);
//    @Bean
//    public Supplier<String> publishTicketChange() {
//        log.info("supplier hello");
//        return () -> "supplier hello";
//    }
}
