package com.example.tp1spring.service.impl;

import com.example.tp1spring.entity.Category;
import com.example.tp1spring.entity.Priority;
import com.example.tp1spring.entity.Todo;
import com.example.tp1spring.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements com.example.tp1spring.service.ITodoService {

    private TodoRepository _todoRepository;

//    @Autowired
//    private ServiceHibernate serviceHibernate;
//    private final Session session;

//    public TodoServiceImpl(ServiceHibernate serviceHibernate) {
//        this.serviceHibernate = serviceHibernate;
//        session = this.serviceHibernate.getSession();
//    }

    public TodoServiceImpl(TodoRepository todoRepository) {
        _todoRepository = todoRepository;
    }


    @Override
    public boolean create(Todo t) {
//        session.beginTransaction();
//        session.save(t);
//        session.getTransaction().commit();
//        session.close();
        _todoRepository.save(t);
        return t.getId()>0;
    }


    @Override
    public boolean update(Todo t) {
//        session.beginTransaction();
//        session.update(t);
//        session.getTransaction().commit();
        _todoRepository.save(t);
        return true;
    }

    @Override
    public boolean delete(Todo t) {
//        session.beginTransaction();
//        session.delete(t);
//        session.getTransaction().commit();
        _todoRepository.delete(t);
        return true;
    }

    @Override
    public Todo findById(int id) {
//        Todo todo = null;
//        todo = (Todo) session.get(Todo.class, id);
        return _todoRepository.findById(id).get();
    }

    @Override
    public List<Todo> findAll() {
//        Query<Todo> todoQuery = session.createQuery("from Todo");
//        return todoQuery.list();
        return (List<Todo>) _todoRepository.findAll();
    }

    @Override
    public List<Category> findAllCategoryList() {
        return null;
    }

    @Override
    public List<Priority> findAllPriorityList() {
        return null;
    }

    @Override
    public Category findAllCategory() {
        return null;
    }

    @Override
    public Priority findAllPriority() {
        return null;
    }

//    @Override
//    public Category findAllCategory() {
////        List<Category> categoryList;
////        categoryList = session.createQuery("select distinct category from Todo").list();
////        return categoryList;
//    }

//    @Override
//    public Object findAllPriority() {
//        List<String> priorityList;
//        priorityList = session.createQuery("select distinct priority from Todo").list();
//        return priorityList;
//    }

}
