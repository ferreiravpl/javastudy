package com.example.todolist.services;

import com.example.todolist.entities.ToDoList;
import com.example.todolist.repositories.ToDoListRepository;
import com.example.todolist.services.exceptions.ToDoInvalidDateException;
import com.example.todolist.services.exceptions.ToDoInvalidJsonException;
import com.example.todolist.services.exceptions.ToDoNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static java.lang.Boolean.TRUE;

@Service
public class ToDoListService {

    @Autowired
    private ToDoListRepository toDoListRepository;

    public List<ToDoList> findAll() {
        return toDoListRepository.findAll();
    }

    public ToDoList findById(Long id) {
        return toDoListRepository.findById(id)
                .orElseThrow(() -> new ToDoNotFoundException("ToDo com o ID " + id + " não encontrado."));
    }

    public ToDoList insert(ToDoList obj) {
            validateNotNullDescription(obj);
            validateDates(obj);
            return toDoListRepository.save(obj);
    }

    public void deleteById(Long id) {
        if (!toDoListRepository.existsById(id)) {
            throw new ToDoNotFoundException("ToDo com o ID " + id + " não encontrado.");
        }
        toDoListRepository.deleteById(id);
    }

    public ToDoList update(Long id, ToDoList updatedToDo) {
        ToDoList currentToDo = findById(id);
        updateToDoDetails(currentToDo, updatedToDo);
        return toDoListRepository.save(currentToDo);
    }

    public void updateToDoDetails(ToDoList currentToDo, ToDoList updatedToDo) {
        currentToDo.setDescription(updatedToDo.getDescription());
        currentToDo.setInitialDate(updatedToDo.getInitialDate());
        currentToDo.setEstimatedDate(updatedToDo.getEstimatedDate());
        currentToDo.setIsDone(updatedToDo.getIsDone());
        setConcludedTodoDate(currentToDo);
    }

    public void validateDates (ToDoList todo) {
        Date estimatedDate = todo.getEstimatedDate();
        Date initialDate = todo.getInitialDate();

        if (estimatedDate.before(initialDate)) {
            throw new ToDoInvalidDateException("Data estimada de finalização da tarefa " + estimatedDate + " anterior à data inicial " + initialDate );
        }
    }

    public void validateNotNullDescription (ToDoList todoDescription) {
        Optional.ofNullable(todoDescription.getDescription())
                .filter(description -> !description.trim().isEmpty())
                .orElseThrow(() -> new ToDoInvalidJsonException("Descrição não pode ser vazia ou nula!"));
    }

    public void setConcludedTodoDate (ToDoList todo) {
        if (TRUE.equals(todo.getIsDone())) {
            todo.setConcludedDate(LocalDateTime.now());
        }
    }

}

