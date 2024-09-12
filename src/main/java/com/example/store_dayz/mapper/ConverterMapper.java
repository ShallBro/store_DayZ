package com.example.store_dayz.mapper;

import com.example.store_dayz.entity.GenericGroup;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ConverterMapper {

  private final List<GenericMapper> mappers;

  public GenericMapper toDto(GenericGroup mapper){
    return null;
  }

}
