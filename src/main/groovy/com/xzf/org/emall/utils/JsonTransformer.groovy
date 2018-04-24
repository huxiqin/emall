package com.xzf.org.emall.utils

import spark.ResponseTransformer


class JsonTransformer implements ResponseTransformer {

    @Override
    public String render(Object model) {
        return JsonUtils.toJson(model)
    }

}