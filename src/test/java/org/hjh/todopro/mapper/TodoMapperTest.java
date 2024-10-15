package org.hjh.todopro.mapper;


import lombok.extern.log4j.Log4j2;
import org.hjh.todopro.dto.TodoDTO;
import org.hjh.todopro.mapper.TodoMapper;
import org.hjh.todopro.service.TodoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class TodoMapperTest {
    @Autowired(required = false)
    private TodoMapper todoMapper;
    @Autowired(required = false)
    private TodoService todoService;

    @Test
    public void testGetTime(){
        log.info(todoMapper.getTime());
    }
    @Test
    public void testInsert() throws Exception{
        /*TodoVO vo=new TodoVO();
        dto.setTitle("2222");
        dto.setDueDate(LocalDate.now());
        dto.setWriter("hong");
        //todoService.register(dto);
        todoMapper.insert(dto);*/
    }
}
