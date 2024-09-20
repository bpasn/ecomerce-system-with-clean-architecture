package com.app.infrastructure.interfaces;

import jakarta.servlet.Filter;

public interface FilterCustomPublic extends Filter{
    boolean isPublicRouter(String uri);
}
