package com.example.todolist;

import com.example.todolist.entities.ToDoList;
import com.example.todolist.repositories.ToDoListRepository;
import com.example.todolist.services.ToDoListService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class ToDoListApplicationTests {

	//cria o mock do repositório
	@Mock
	private ToDoListRepository repository;

	//injeta o mock do repositório no serviço
	@InjectMocks
	private ToDoListService service;

	@Test
	void shouldCreateToDoList() {
		//criação do mock do toDo
		ToDoList todo = new ToDoList(1L, "Teste", new Date(), new Date(), false);
		when(repository.save(any(ToDoList.class))).thenReturn(todo);

		//inserindo o mock no repositório
		ToDoList result = service.insert(todo);

		//testes
		assertNotNull(result);
		assertEquals(1L, result.getId());
		assertEquals("Teste", result.getDescription());
		assertFalse(result.getIsDone());
		verify(repository, times(1)).save(todo);
	}

}
