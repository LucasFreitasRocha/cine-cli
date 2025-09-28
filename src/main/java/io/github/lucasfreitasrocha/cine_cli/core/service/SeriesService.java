package io.github.lucasfreitasrocha.cine_cli.core.service;

import io.github.lucasfreitasrocha.cine_cli.core.domain.SearchSerieDomain;
import io.github.lucasfreitasrocha.cine_cli.core.domain.SerieDomain;
import io.github.lucasfreitasrocha.cine_cli.core.gateway.ApiMovieGateway;
import io.github.lucasfreitasrocha.cine_cli.core.util.ConverterJson;
import org.springframework.stereotype.Service;

import static java.lang.IO.println;

@Service
public class SeriesService {
    private final ApiMovieGateway apiMovieGateway;
    private final ConverterJson converterJson = new ConverterJson();
    public SeriesService(ApiMovieGateway apiMovieGateway) {
        this.apiMovieGateway = apiMovieGateway;
    }
    public void getSeriesInfo(SearchSerieDomain searchSerieDomain) {

       var json = apiMovieGateway.getApiData("?t=" + searchSerieDomain.getTitle().replaceAll(" ", "+"));
       println(json);
       println(converterJson.fromStringJson(json, SerieDomain.class));
    }


}
