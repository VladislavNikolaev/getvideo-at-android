package com.zvapps.getvideoat.data.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.auto.value.AutoValue;

/**
 * Created by Vladislav Nikolaev on 21.05.2017.
 */

@AutoValue
@JsonPropertyOrder({
        FormatDto.FIELD_URL,
        FormatDto.FIELD_QUALITY,
        FormatDto.FIELD_FORMAT,
        FormatDto.FIELD_FILENAME
})
public abstract class FormatDto {

    static final String FIELD_URL = "url";
    static final String FIELD_QUALITY = "quality";
    static final String FIELD_FORMAT = "format";
    static final String FIELD_FILENAME = "filename";

    @JsonProperty(FIELD_URL)
    public abstract String url();

    @JsonProperty(FIELD_QUALITY)
    public abstract String quality();

    @JsonProperty(FIELD_FORMAT)
    public abstract String format();

    @JsonProperty(FIELD_FILENAME)
    public abstract String filename();

    @JsonCreator
    public static FormatDto create(@JsonProperty(FIELD_URL) String url,
                                   @JsonProperty(FIELD_QUALITY) String quality,
                                   @JsonProperty(FIELD_FORMAT) String format,
                                   @JsonProperty(FIELD_FILENAME) String filename) {
        return builder()
                .url(url)
                .quality(quality)
                .format(format)
                .filename(filename)
                .build();
    }

    public static Builder builder() {
        return new AutoValue_FormatDto.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder url(String url);

        public abstract Builder quality(String quality);

        public abstract Builder format(String format);

        public abstract Builder filename(String filename);

        public abstract FormatDto build();
    }
}
