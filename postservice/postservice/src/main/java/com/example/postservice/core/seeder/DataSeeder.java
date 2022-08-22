package com.example.postservice.core.seeder;

import com.example.postservice.core.dao.PostDAO;
import com.example.postservice.core.dto.PostDTO;
import com.example.postservice.core.mapper.PostMapper;
import com.example.postservice.web.vo.request.PostCreatedRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataSeeder {
    @Autowired
    private PostDAO postDAO;

    @Bean
    CommandLineRunner postSeederRunning() {
        List<PostCreatedRequest> postCreatedRequests = new ArrayList<>();
        postCreatedRequests.add(new PostCreatedRequest("post_title", "description", 2));
        for (int i = 0; i < 10; i++) {
            postCreatedRequests.add(new PostCreatedRequest(
                    "Post" + i,

                    "Description" + i,
                    i + 1
            ));
        }
        List<PostDTO> postDTOS = PostMapper.INSTANCE.fromListPostCreated(postCreatedRequests);
        return args -> {
            for (PostDTO post : postDTOS) {
                postDAO.insert(post);
            }
        };
    }
}