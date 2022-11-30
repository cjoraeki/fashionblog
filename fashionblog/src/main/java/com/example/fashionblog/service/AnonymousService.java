package com.example.fashionblog.service;

import com.example.fashionblog.dto.AnonymousDto;
import com.example.fashionblog.entity.Anonymous;

public interface AnonymousService {

    Anonymous anonComment(AnonymousDto anonymousDto);
}
