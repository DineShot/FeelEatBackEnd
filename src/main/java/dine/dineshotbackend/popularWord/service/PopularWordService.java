package dine.dineshotbackend.popularWord.service;

import dine.dineshotbackend.popularWord.repository.PopularWordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PopularWordService {
    private final PopularWordRepository popularWordRepository;
}
