package io.github.lucasfreitasrocha.cine_cli.core.domain;


public class SearchSerieDomain {
    private String title;
    private Integer season;
    private Integer episode;

    public SearchSerieDomain(String title, Integer season, Integer episode) {
        this.title = title;
        this.season = season;
        this.episode = episode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getSeason() {
        return season;
    }

    public void setSeason(Integer season) {
        this.season = season;
    }

    public Integer getEpisode() {
        return episode;
    }

    public void setEpisode(Integer episode) {
        this.episode = episode;
    }

    public static SearchSerieDomainBuilder builder() {
        return new SearchSerieDomainBuilder();
    }


    public static class SearchSerieDomainBuilder {
        private String title;
        private Integer season;
        private Integer episode;

        public SearchSerieDomainBuilder title(String title) {
            this.title = title;
            return this;
        }

        public SearchSerieDomainBuilder season(Integer season) {
            this.season = season;
            return this;
        }

        public SearchSerieDomainBuilder episode(Integer episode) {
            this.episode = episode;
            return this;
        }

        public SearchSerieDomain build() {
            return new SearchSerieDomain(this.title, this.season, this.episode);
        }
    }

}
