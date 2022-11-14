package styd.jpa.proj;


import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import styd.jpa.proj.entity.PostMaster;
import styd.jpa.proj.entity.PostMasterRepository;

import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class PostRepositoryTest {

    @Autowired
    private PostMasterRepository postMasterRepository;


    @After
    public void cleanup() {
        postMasterRepository.deleteAll();
    }

    @Test
    public void savePostThen() {
        String title = "POST 등록해보기.";
        String contents = "POST 내용 등록해보기.";
        String createdId = "eroul-ri";
        postMasterRepository.save(PostMaster.builder()
                                .title(title)
                                .contents(contents)
                                .createdId(createdId)
                                .build());

        List<PostMaster> postMasters = postMasterRepository.findAll();
        log.info(" #### posts : {}", postMasters);
    }
}
