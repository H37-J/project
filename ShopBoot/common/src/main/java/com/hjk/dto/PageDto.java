package com.hjk.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

@NoArgsConstructor
@Getter
public class PageDto<T> {

    private final static int VIEWPAGESIZE=10;
    private int startPage;
    private int endPage;
    private int totalPages;
    private List<T> contents;
    private int nowPage;

    private PageDto(int startPage, int endPage, int totalPages, List<T> contents,int nowPage) {
        this.startPage = startPage;
        this.endPage = endPage;
        this.totalPages = totalPages;
        this.contents = contents;
        this.nowPage=nowPage;
   
    }

    public static <G,T> PageDto<T> of(Page<G>  entities,List<T> contents){
        int totalPages=entities.getTotalPages();
        int nowPage=entities.getPageable().getPageNumber()+1; //ex) 13->14 page
        int startPage = (nowPage%VIEWPAGESIZE)==0 ? VIEWPAGESIZE * (nowPage / VIEWPAGESIZE-1)+1 : VIEWPAGESIZE * (nowPage / VIEWPAGESIZE)+1;
        int endPage = startPage + VIEWPAGESIZE - 1;
                                                                                                                                                

        return new PageDto<>(startPage == 0 ? 1 : startPage, Math.min(endPage, totalPages), totalPages, contents,nowPage);
    }
}
