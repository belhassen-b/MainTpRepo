
    package com.example.tprevision13062023.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

    @Data
    @Entity
    @AllArgsConstructor
    @NoArgsConstructor
    public class Utilisateur {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Enumerated(EnumType.STRING)
        private Role role;

        private String username;

        private String password;
    }


