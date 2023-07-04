package com.example.demo_rest.service;


import com.example.demo_rest.entity.ListTodoItem;
import com.example.demo_rest.repository.ListTodoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListTodoItemService {

    @Autowired
    private ListTodoItemRepository listTodoItemRepository;
    public ListTodoItem createListTodoItem(ListTodoItem listTodoItem) {
       return listTodoItemRepository.save(listTodoItem);
    }

    public boolean isEmpty() {
        return listTodoItemRepository.count() == 0;
    }

    public List<ListTodoItem> getAll() {
        return  listTodoItemRepository.findAll();
    }


}