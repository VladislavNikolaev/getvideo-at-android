package com.zvapps.getvideoat.utils;

import android.support.annotation.NonNull;

import com.annimon.stream.Collectors;
import com.annimon.stream.Stream;
import com.zvapps.getvideoat.data.model.FormatDto;
import com.zvapps.getvideoat.data.model.VideoLinksDto;
import com.zvapps.getvideoat.ui.model.FormatVo;
import com.zvapps.getvideoat.ui.model.VideoLinksVo;

import java.util.List;

/**
 * Created by Vladislav Nikolaev on 11.05.2017.
 */

public class Mapper {

    @NonNull
    public static VideoLinksVo toVideoLinksVo(@NonNull String sourceVideoUrl,
                                              @NonNull VideoLinksDto dto) {
        VideoLinksVo vo = new VideoLinksVo(sourceVideoUrl);

        List<FormatVo> audioFormats = Stream.of(dto.audioFormats())
                .map(Mapper::toFormatVo)
                .collect(Collectors.toList());

        List<FormatVo> videoFormats = Stream.of(dto.videoFormats())
                .map(Mapper::toFormatVo)
                .collect(Collectors.toList());

        vo.setAudioFormats(audioFormats);
        vo.setVideoFormats(videoFormats);
        vo.setDuration(dto.duration());
        vo.setThumbnail(dto.thumbnail());
        vo.setTitle(dto.title());
        return vo;
    }

    @NonNull
    private static FormatVo toFormatVo(@NonNull FormatDto dto) {
        return new FormatVo(dto.url(), dto.quality(), dto.format(), dto.filename());
    }
}
