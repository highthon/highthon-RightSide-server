package com.example.rightside.domain.post.presentation.dto;

import com.example.rightside.domain.post.service.AddJoinService;
import com.example.rightside.domain.post.service.DeleteJoinService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class JoinController {
    private final AddJoinService addJoinService;
    private final DeleteJoinService deleteJoinService;

    @PostMapping("/join/{post-id}")
    public void addJoin(@PathVariable("post-id") Long id) {
        addJoinService.execute(id);
    }

    @DeleteMapping("/join/{post-id}")
    public void deleteJoin(@PathVariable("post-id") Long id) {
        deleteJoinService.execute(id);
    }
}
