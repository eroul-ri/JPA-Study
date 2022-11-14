package styd.jpa.proj.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor @ToString
public class PostMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    private LocalDateTime createdAt;

    @Column(length = 150, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT",nullable = false)
    private String contents;

    @Column(nullable = false)
    private String createdId;

    @Builder
    public PostMaster(String title, String contents, String createdId) {
        this.title = title;
        this.contents = contents;
        this.createdId = createdId;
    }
}
