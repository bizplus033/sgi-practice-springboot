package com.bizplus.sgipractice.systemcode.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "system_code")
@Getter
@NoArgsConstructor
public class SystemCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code_name")
    private String codeName;
}
