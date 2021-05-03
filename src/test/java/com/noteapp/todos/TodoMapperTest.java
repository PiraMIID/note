package com.noteapp.todos;

import com.noteapp.user.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TodoMapperTest {
    @Test
    public void testToEntity() {
        Todo actualToEntityResult = TodoMapper.toEntity(new TodoDto());
        assertFalse(actualToEntityResult.isDone());
        assertNull(actualToEntityResult.getValue());
        assertNull(actualToEntityResult.getUser());
        assertNull(actualToEntityResult.getName());
    }

    @Test
    public void testToEntity2() {
        TodoDto todoDto = new TodoDto();
        todoDto.setId(123L);
        Todo actualToEntityResult = TodoMapper.toEntity(todoDto);
        assertFalse(actualToEntityResult.isDone());
        assertNull(actualToEntityResult.getValue());
        assertNull(actualToEntityResult.getUser());
        assertNull(actualToEntityResult.getName());
    }

    @Test
    public void testToEntity3() {
        TodoDto todoDto = new TodoDto();
        todoDto.setDone(true);
        Todo actualToEntityResult = TodoMapper.toEntity(todoDto);
        assertTrue(actualToEntityResult.isDone());
        assertNull(actualToEntityResult.getValue());
        assertNull(actualToEntityResult.getUser());
        assertNull(actualToEntityResult.getName());
    }

    @Test
    public void testToDto() {
        User user = new User();
        user.setPassword("iloveyou");
        user.setRole("Role");
        user.setUsername("janedoe");
        user.setId(123L);

        Todo todo = new Todo();
        todo.setValue("42");
        todo.setUser(user);
        todo.setId(123L);
        todo.setName("Name");
        todo.setDone(true);
        TodoDto actualToDtoResult = TodoMapper.toDto(todo);
        assertEquals(123L, actualToDtoResult.getId().longValue());
        assertTrue(actualToDtoResult.isDone());
        assertEquals("42", actualToDtoResult.getValue());
        assertSame(user, actualToDtoResult.getUser());
        assertEquals("Name", actualToDtoResult.getName());
    }

    @Test
    public void testToDto2() {
        User user = new User();
        user.setPassword("iloveyou");
        user.setRole("Role");
        user.setUsername("janedoe");
        user.setId(123L);

        Todo todo = new Todo();
        todo.setValue("42");
        todo.setUser(user);
        todo.setId(123L);
        todo.setName("Name");
        todo.setDone(false);
        TodoDto actualToDtoResult = TodoMapper.toDto(todo);
        assertEquals(123L, actualToDtoResult.getId().longValue());
        assertFalse(actualToDtoResult.isDone());
        assertEquals("42", actualToDtoResult.getValue());
        assertSame(user, actualToDtoResult.getUser());
        assertEquals("Name", actualToDtoResult.getName());
    }
}
