package org.example.dao;


import lombok.Data;

@Data
public class DepartmentDAO {

        private Long id;
        private String name;

        public void setId(Long id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }
}
