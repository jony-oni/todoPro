package org.hjh.todopro.mapper;

import org.hjh.todopro.dto.PageRequestDTO;
import org.hjh.todopro.dto.TodoDTO;
import org.hjh.todopro.vo.TodoVO;

import java.util.List;

public interface TodoMapper {
    String getTime();
    void insert(TodoVO todoVO);
    List<TodoVO> getList();
    TodoVO selectOne(int tno);
    void delete(Long tno);
    void update(TodoVO todoVO);
    List<TodoVO> selectList (PageRequestDTO pageRequestDTO);
    int getCount(PageRequestDTO pageRequestDTO);

}
