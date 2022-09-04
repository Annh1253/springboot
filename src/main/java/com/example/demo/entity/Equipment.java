package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "Equipment")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "equipments")
@ToString(exclude = "user, category")
@SQLDelete(sql = "UPDATE equipments u SET delete_at = CURRENT_DATE WHERE id=?")
@Where(clause = "delete_at is null")
public class Equipment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", unique = true)
    @NotBlank(message = "Name is required")
    @Length(min = 2, message = "Name need to be at least 2 letters")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToOne(targetEntity = User.class, cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(name = "delete_at")
    private Date deleteAt;

    @OneToOne(mappedBy = "equipment")
    private Assignment assignment;

    @ManyToOne(targetEntity = Category.class)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;
}
