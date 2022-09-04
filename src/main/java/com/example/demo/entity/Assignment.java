package com.example.demo.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity(name = "Assignment")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "assignments")
@ToString(exclude = {"user", "equipment"})
@SQLDelete(sql = "UPDATE Assignments u SET end_date = CURRENT_DATE WHERE id=?")
@Where(clause = "end_date is null")
public class Assignment implements Serializable {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToOne(targetEntity = Equipment.class)
    @JoinColumn(name = "equipment_id", referencedColumnName = "id")
    private Equipment equipment;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "start_date")
    private Date startDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "end_date")
    private Date endDate;


}
