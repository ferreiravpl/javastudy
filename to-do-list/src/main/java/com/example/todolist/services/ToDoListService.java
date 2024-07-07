package com.example.todolist.services;

import com.example.todolist.entities.ToDoList;
import com.example.todolist.repositories.ToDoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ToDoListService {

    @Autowired
    private ToDoListRepository toDoListRepository;

    public List<ToDoList> findAll() {
        return toDoListRepository.findAll();
    }

    public ToDoList findById(Long id) {
        return toDoListRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("ToDo com o ID " + id + " não encontrado."));
    }

    public ToDoList insert(ToDoList obj) {
        try {
            validateNotNullDescription(obj);
            validateDates(obj);
            return toDoListRepository.save(obj);
        } catch (HttpMessageNotReadableException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteById(Long id) {
        if (!toDoListRepository.existsById(id)) {
            throw new NoSuchElementException("ToDo com o ID " + id + " não encontrado.");
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
            throw new RuntimeException("Data final " + estimatedDate + " anterior à data inicial " + initialDate );
        }
    }

    public void validateNotNullDescription (ToDoList todoDescription) {
        Optional.ofNullable(todoDescription.getDescription()).orElseThrow(() -> new RuntimeException("Descrição não pode ser vazia"));
    }

    public void setConcludedTodoDate (ToDoList todo) {
        if (todo.getIsDone().equals(true)) {
            todo.setConcludedDate(LocalDateTime.now());
        }
    }

}

