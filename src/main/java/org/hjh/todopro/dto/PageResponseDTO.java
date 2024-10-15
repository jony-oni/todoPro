package org.hjh.todopro.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.cache.interceptor.CacheOperation;

import java.util.List;

@Getter
@ToString
public class PageResponseDTO<E> {
    private int page;
    private int size;
    private int total;
    //시작 페이지 번호
    private int start;
    //끝 페이지 번호
    private int end;
    //이전 페이지의 존재 여부
    private boolean prev;
    //다음 페이지의 존재 여부
    private boolean next;
    private List<E> dtoList;

    @Builder(builderMethodName = "withAll")
    public PageResponseDTO(PageRequestDTO pageRequestDTO,
                           List<E> dtoList,int total) {
        this.page = pageRequestDTO.getPage();
        this.size = pageRequestDTO.getSize();
        this.total = total;
        this.dtoList = dtoList;

        this.end=(int)(Math.ceil((double) this.page/this.size))*this.size;
        this.start = this.end-(this.size-1);
        int last=(int)(Math.ceil((double) total/this.size));
        this.end= end > last? last: end;
        this.prev=this.start >1;
        this.next=total > this.end * this.size;


    }


}
