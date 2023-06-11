package com.pk.rentflat.utils;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.io.Serializable;
import java.util.List;
import java.util.function.Function;

import static java.util.Collections.emptyList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PageDto<T> implements Serializable {

    private List<T> content;
    private Long totalElements;
    private Integer totalPages;
    private Integer pageNumber;
    private Integer pageSize;

    public static <T> PageDto<T> withSinglePageContent(List<T> content) {
        return new PageDto<>(content, (long) content.size(), 1, 0, content.size());
    }

    public static <T> PageDto<T> empty() {
        return new PageDto<>(emptyList(), 0L, 0, 0, 0);
    }


    public static <T, R> PageDto<R> map(Page<T> page, Function<T, R> mapper) {
        PageDto<R> result = new PageDto<>();
        result.content = page.getContent().stream().map(mapper).toList();
        result.totalElements = page.getTotalElements();
        result.totalPages = page.getTotalPages();
        result.pageNumber = page.getNumber();
        result.pageSize = page.getSize();
        return result;
    }

    public static <T, R> PageDto<R> map(List<T> list, Function<T, R> mapper){
        PageDto<R> result = new PageDto<>();
        result.content = list.stream().map(mapper).toList();
        return result;
    }

    public PageDto(Page<T> page) {
        this.content = page.getContent();
        this.totalElements = page.getTotalElements();
        this.totalPages = page.getTotalPages();
        this.pageNumber = page.getNumber();
        this.pageSize = page.getSize();
    }

}
