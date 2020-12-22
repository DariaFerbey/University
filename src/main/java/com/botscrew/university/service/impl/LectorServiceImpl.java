package com.botscrew.university.service.impl;

import com.botscrew.university.model.Lector;
import com.botscrew.university.repository.LectorRepository;
import com.botscrew.university.service.LectorService;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class LectorServiceImpl implements LectorService {

    private LectorRepository lectorRepository;

    public LectorServiceImpl(LectorRepository lectorRepository) {
        this.lectorRepository = lectorRepository;
    }

    @Override
    public String globalSearchByTemplate(String template) {
        return String.valueOf(lectorRepository.globalSearchByTemplate(template));
//        return lectorRepository.getLectors().stream().map(Lector::getName).filter(l->l.contains(template)).collect(Collectors.joining(" "));

    }


}
