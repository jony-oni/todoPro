package org.hjh.todopro.service;

import org.hjh.todopro.dto.PageRequestDTO;
import org.hjh.todopro.dto.PageResponseDTO;
import org.hjh.todopro.dto.TodoDTO;

import java.util.List;

public interface TodoService {
    void register(TodoDTO todoDTO);
    List<TodoDTO> getAll();
    TodoDTO getOne(int tno);
    void remove(Long tno);
    void modify(TodoDTO todoDTO);
    PageResponseDTO<TodoDTO> getList(PageRequestDTO pageRequestDTO);
}
