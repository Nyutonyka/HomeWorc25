package com.homework.homeWork11;

import lombok.*;
import lombok.experimental.Accessors;

//@Data содержит в себе: @Getter @Setter @EqualsAndHashCode @ToString
// и конструктор по умолчанию
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Accessors(chain = true)
public class Student {
    private long id;
    private String name;
    @EqualsAndHashCode.Exclude
    private String lastName;
    @ToString.Exclude
    private int age;
}
