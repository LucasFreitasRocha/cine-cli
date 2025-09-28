package io.github.lucasfreitasrocha.cine_cli.entrypoint.cli;

import io.github.lucasfreitasrocha.cine_cli.core.domain.SearchSerieDomain;
import io.github.lucasfreitasrocha.cine_cli.core.service.SeriesService;
import io.github.lucasfreitasrocha.cine_cli.core.util.ConverterArgs;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service

public class CommandLine {
    private final SeriesService service;

    public CommandLine(SeriesService service) {
        this.service = service;
    }

    public void command(List<String> args) {
        Map<String, String> map = ConverterArgs.parseArgs(args);
        if (map.isEmpty()) {
            System.out.println("No command provided");
            return;
        }
        if (!map.containsKey("title")) {
            System.out.println("Invalid command");
            return;
        }
        service.getSeriesInfo(SearchSerieDomain.builder().title( map.get("title")).build());
    }
}
