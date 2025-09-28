package io.github.lucasfreitasrocha.cine_cli.core.domain;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record EpisodeDomain (
        @JsonAlias("Title") String title,
        @JsonAlias("Season") Integer season,
        @JsonAlias("Episode") Integer episode,
        @JsonAlias("imdbRating") String rating,
        @JsonAlias("Released") String releaseDate

) {
}
