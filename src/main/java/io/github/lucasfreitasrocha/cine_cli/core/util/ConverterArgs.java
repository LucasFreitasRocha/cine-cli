package io.github.lucasfreitasrocha.cine_cli.core.util;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConverterArgs {

    public static Map<String, String> parseArgs(List<String> args) {
        return args.stream()
                .filter(arg -> arg.contains("="))
                .map(arg -> arg.split("=", 2))
                .collect(Collectors.toMap(
                        arr -> arr[0],
                        arr -> arr[1]
                ));
    }
}
