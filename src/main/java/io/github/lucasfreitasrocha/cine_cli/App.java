package io.github.lucasfreitasrocha.cine_cli;

import io.github.lucasfreitasrocha.cine_cli.entrypoint.cli.CommandLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class App implements CommandLineRunner {
    @Autowired
    private ApplicationContext context;
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        CommandLine commandLine = context.getBean(CommandLine.class);
        commandLine.command(List.of(args));
    }



}
