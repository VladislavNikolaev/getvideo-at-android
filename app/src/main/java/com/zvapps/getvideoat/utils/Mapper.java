package com.zvapps.getvideoat.utils;

import android.support.annotation.NonNull;

import com.zvapps.getvideoat.data.model.VideoLinksDto;
import com.zvapps.getvideoat.ui.model.VideoLinksVo;

/**
 * Created by Vladislav Nikolaev on 11.05.2017.
 */

public class Mapper {

    public static VideoLinksVo toVideoLinksVo(@NonNull VideoLinksDto dto) {
        return new VideoLinksVo();
    }
}
