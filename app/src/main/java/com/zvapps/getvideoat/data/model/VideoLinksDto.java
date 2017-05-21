package com.zvapps.getvideoat.data.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.auto.value.AutoValue;

import java.util.List;

/**
 * Created by Vladislav Nikolaev on 11.05.2017.
 */

@AutoValue
@JsonPropertyOrder({
        VideoLinksDto.FIELD_DURATION,
        VideoLinksDto.FIELD_THUMBNAIL,
        VideoLinksDto.FIELD_AUDIO_FORMATS,
        VideoLinksDto.FIELD_VIDEO_FORMATS,
        VideoLinksDto.FIELD_TITLE,
})
public abstract class VideoLinksDto {

    static final String FIELD_DURATION = "duration";
    static final String FIELD_THUMBNAIL = "thumbnail";
    static final String FIELD_AUDIO_FORMATS = "audio_formats";
    static final String FIELD_VIDEO_FORMATS = "video_formats";
    static final String FIELD_TITLE = "title";

    @JsonProperty(FIELD_DURATION)
    public abstract String duration();

    @JsonProperty(FIELD_THUMBNAIL)
    public abstract String thumbnail();

    @JsonProperty(FIELD_AUDIO_FORMATS)
    public abstract List<FormatDto> audioFormats();

    @JsonProperty(FIELD_VIDEO_FORMATS)
    public abstract List<FormatDto> videoFormats();

    @JsonProperty(FIELD_TITLE)
    public abstract String title();

    @JsonCreator
    public static VideoLinksDto create(
            @JsonProperty(FIELD_DURATION) String duration,
            @JsonProperty(FIELD_THUMBNAIL) String thumbnail,
            @JsonProperty(FIELD_AUDIO_FORMATS) List<FormatDto> audioFormats,
            @JsonProperty(FIELD_VIDEO_FORMATS) List<FormatDto> videoFormats,
            @JsonProperty(FIELD_TITLE) String title) {
        return builder()
                .duration(duration)
                .thumbnail(thumbnail)
                .audioFormats(audioFormats)
                .videoFormats(videoFormats)
                .title(title)
                .build();
    }

    public static Builder builder() {
        return new AutoValue_VideoLinksDto.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder duration(String duration);

        public abstract Builder thumbnail(String thumbnail);

        public abstract Builder audioFormats(List<FormatDto> audioFormats);

        public abstract Builder videoFormats(List<FormatDto> videoFormats);

        public abstract Builder title(String title);

        public abstract VideoLinksDto build();
    }
}
